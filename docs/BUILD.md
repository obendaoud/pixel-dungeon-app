# Building locally

The original Pixel Dungeon project predates Gradle and ships without a build
script. This document captures a verified compile-only pipeline against the
upstream `watabou/PD-classes` library, useful for reviewing code changes
without setting up a full Android SDK.

This is **not** a way to ship an APK. It only verifies that the Java source
resolves cleanly against the real Watabou library. For an actual playable
build, you still need the Android SDK and an Android build system.

## Prerequisites

- JDK 8 or later (verified on OpenJDK 21)
- Internet access (to fetch PD-classes and a stub `android.jar`)
- About 70 MB of disk for the downloaded jars

## One-shot script

```bash
WORK=/tmp/pd-compile
mkdir -p "$WORK" && cd "$WORK"

# 1. Fetch a stub android.jar (Android API 28, includes javax.microedition GL stubs)
curl -sLfO https://github.com/Sable/android-platforms/raw/master/android-28/android.jar

# 2. Compensate for android.util.FloatMath being an empty class in newer API jars
mkdir -p stubs/android/util
cat > stubs/android/util/FloatMath.java <<'EOF'
package android.util;
public class FloatMath {
  public static float sqrt(float x) { return (float)Math.sqrt(x); }
  public static float sin (float x) { return (float)Math.sin (x); }
  public static float cos (float x) { return (float)Math.cos (x); }
  public static float floor(float x) { return (float)Math.floor(x); }
  public static float ceil (float x) { return (float)Math.ceil (x); }
}
EOF
mkdir -p stub-cls
javac -d stub-cls stubs/android/util/FloatMath.java
jar cf floatmath-stub.jar -C stub-cls .

# 3. Fetch and compile PD-classes
git clone --depth 1 https://github.com/watabou/PD-classes.git
mkdir -p pd-classes-out
cd PD-classes
javac -source 8 -target 8 -d ../pd-classes-out \
  -cp ../floatmath-stub.jar:../android.jar \
  $(find com -name '*.java')
cd ..
jar cf pd-classes.jar -C pd-classes-out .

# 4. Compile the game source from the repo (run this from the repo root)
mkdir -p "$WORK"/game-out
javac -source 8 -target 8 -d "$WORK"/game-out \
  -cp "$WORK"/floatmath-stub.jar:"$WORK"/pd-classes.jar:"$WORK"/android.jar \
  $(find src -name '*.java')
```

Expected: zero errors, four legacy `-source/-target 8` warnings, around 963
`.class` files produced.

## Classpath order matters

`floatmath-stub.jar` must come **before** `android.jar` in the classpath. The
upstream `android.jar` from API 28 still has a class entry for `FloatMath`,
but every method has been removed and the stub re-introduces them. If the
stub jar appears after `android.jar`, its `FloatMath` is shadowed and the
compile fails with `cannot find symbol: method sqrt(float)`.

## Pre-existing portability fix

Compiling under Java 8 requires three one-line edits in the original Pixel
Dungeon source:

- `src/com/watabou/pixeldungeon/items/Heap.java:373`
- `src/com/watabou/pixeldungeon/levels/RegularLevel.java:682`
- `src/com/watabou/pixeldungeon/actors/mobs/Mimic.java:67`

Each of these reads a `Collection<Bundlable>` from a `Bundle` and casts it to
`Collection<? extends Item>` (or `Collection<? extends Room>`) via a single
generic cast. Strict Java 8 generics reject this. The fix is to insert a raw
intermediate cast:

```diff
- items = new LinkedList<Item>( (Collection<? extends Item>) bundle.getCollection( ITEMS ) );
+ items = new LinkedList<Item>( (Collection<? extends Item>) (Collection) bundle.getCollection( ITEMS ) );
```

These edits are already on `master`.

## What this verifies

This compile path proves that every `.java` file in `src/` resolves against
the real `com.watabou.noosa` / `com.watabou.utils` API surface, including
all of the 100-floor expansion: the `Zones` registry, the 40 new level
classes, the 31 new mob classes, the new boss arena base, and the run-ending
`TheArchitect`.

## What this does not do

- No `.dex` is produced, so no `.apk`.
- The `android.jar` is a compile-only stub; running the bytecode against the
  real Android runtime still requires a full SDK setup.
- The `FloatMath` shim replaces a deprecated Android utility; the original
  Pixel Dungeon ran against pre-Android-23 runtimes where the real class
  exists. Modern Android needs a small source-level patch instead, which is
  out of scope here.
