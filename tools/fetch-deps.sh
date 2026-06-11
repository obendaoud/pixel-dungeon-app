#!/usr/bin/env bash
# Populates libs/ with the compile-time dependencies described in docs/BUILD.md:
#  - android.jar        (Android API 28 platform stub, compile-only)
#  - floatmath-stub.jar (restores android.util.FloatMath methods removed in modern APIs)
#  - pd-classes.jar     (upstream watabou/PD-classes compiled from source)
# Run once before `gradle compileJava`.
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
LIBS="$ROOT/libs"
WORK="$(mktemp -d)"
trap 'rm -rf "$WORK"' EXIT

mkdir -p "$LIBS"

# 1. android.jar (API 28)
if [ ! -f "$LIBS/android.jar" ]; then
	echo ">> Fetching android.jar (API 28)..."
	curl -sLf -o "$LIBS/android.jar" \
		https://github.com/Sable/android-platforms/raw/master/android-28/android.jar
fi

# 2. FloatMath shim
if [ ! -f "$LIBS/floatmath-stub.jar" ]; then
	echo ">> Building FloatMath shim..."
	mkdir -p "$WORK/stub-src/android/util" "$WORK/stub-cls"
	cat > "$WORK/stub-src/android/util/FloatMath.java" <<'EOF'
package android.util;
public class FloatMath {
	public static float sqrt(float x)  { return (float) Math.sqrt(x); }
	public static float sin(float x)   { return (float) Math.sin(x); }
	public static float cos(float x)   { return (float) Math.cos(x); }
	public static float floor(float x) { return (float) Math.floor(x); }
	public static float ceil(float x)  { return (float) Math.ceil(x); }
}
EOF
	javac -d "$WORK/stub-cls" "$WORK/stub-src/android/util/FloatMath.java"
	jar cf "$LIBS/floatmath-stub.jar" -C "$WORK/stub-cls" .
fi

# 3. PD-classes
if [ ! -f "$LIBS/pd-classes.jar" ]; then
	echo ">> Cloning and compiling watabou/PD-classes..."
	git clone --quiet --depth 1 https://github.com/watabou/PD-classes.git "$WORK/PD-classes"
	mkdir -p "$WORK/pd-out"
	( cd "$WORK/PD-classes" && javac -nowarn -source 8 -target 8 -d "$WORK/pd-out" \
		-cp "$LIBS/floatmath-stub.jar:$LIBS/android.jar" \
		$(find com -name '*.java') )
	jar cf "$LIBS/pd-classes.jar" -C "$WORK/pd-out" .
fi

echo ">> Done. libs/ contains:"
ls -lh "$LIBS"
