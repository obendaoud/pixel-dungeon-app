# Roadmap : portage webapp

Porter le jeu (100 étages inclus) dans le navigateur. Route retenue :
**libGDX + gdx-teavm**, la voie prouvée par Shattered Pixel Dungeon (GPLv3,
donc réutilisable par ce projet, lui aussi GPLv3).

## Pourquoi cette route

- Le code de jeu (586+ fichiers) ne touche Android qu'à travers l'API noosa.
  Remplacer le backend de noosa suffit, pas besoin de réécrire le gameplay.
- La réimplémentation de noosa sur libGDX existe déjà dans Shattered Pixel
  Dungeon (package `com.watabou.*`), sous GPLv3.
- gdx-teavm compile le bytecode vers JS/WASM avec assez de réflexion pour le
  système de `Bundle` (les saves instancient les `Bundlable` par réflexion,
  ce qui disqualifie le backend GWT).
- Bonus : la même base donne un build desktop (LWJGL), idéal pour playtester
  les 100 étages sans téléphone.

## Milestones

### W1 — Multi-modules Gradle (1 semaine)

Découper en `:core` (logique de jeu), `:android` (backend legacy),
`:desktop` (LWJGL), `:web` (gdx-teavm). `:core` ne dépend que de l'API noosa.

Critère : `gradle :core:compileJava` passe ; les modules backend sont des
coquilles vides qui compilent.

### W2 — Vendorer noosa-libGDX (2-3 semaines)

Récupérer la réimplémentation `com.watabou.*` de Shattered Pixel Dungeon,
l'adapter aux signatures attendues par notre code (l'API a dérivé : certains
appels diffèrent). Lister les écarts, patcher côté jeu quand c'est plus
simple.

Critère : `:core` compile contre noosa-libGDX au lieu de PD-classes.

### W3 — Purger les imports android.* du code de jeu (1 semaine)

Une dizaine de fichiers importent `android.*` en direct :
`Actor.java` (android.util.SparseArray -> com.watabou.utils.SparseArray),
`PixelDungeon.java` (Activity -> launcher par backend), préférences,
vibreur, etc.

Critère : `grep -r "import android" src/` ne retourne rien dans `:core`.

### W4 — Backend desktop (1 semaine)

Module `:desktop` LWJGL3. Premier build jouable hors Android.

Critère : run 1 -> 100 jouable au clavier/souris sur desktop.

### W5 — Backend web gdx-teavm (2-3 semaines)

Module `:web`. Config TeaVM (metadata de réflexion pour les Bundlable),
saves vers IndexedDB via l'abstraction fichiers, audio WebAudio.

Critère : le jeu tourne dans Chrome/Firefox, une partie se sauvegarde et se
recharge après refresh.

### W6 — Polish web et déploiement (1 semaine)

Loading screen, scaling viewport mobile, déploiement GitHub Pages (dossier
statique), CI de build web.

Critère : URL publique jouable.

## Total estimé

8 à 10 semaines temps plein. Le gros risque est W2 (dérive d'API entre notre
noosa 2012 et celui de Shattered) ; mitigation : patcher côté jeu, qui est
sous notre contrôle.

## État actuel

- [x] Compilation Gradle de l'existant vérifiée (`build.gradle` racine,
      `tools/fetch-deps.sh`, 963 classes, 0 erreur)
- [x] W1 multi-modules (`:core` compile 963 classes, `:android` / `:desktop`
      / `:web` coquilles ; android.jar reste en compileOnly de `:core`,
      dette brûlée en W3)
- [x] W2 noosa-libGDX : vendore depuis Shattered (:noosa-gdx, libGDX
      1.14.0) + bridges de compat (TouchArea, Touchscreen.Touch, Button,
      BitmapTextMultiline, Gradient, SystemTime, Highlighter,
      TextureCache.add). :core compile contre :noosa-gdx, 962 classes,
      0 erreur. Historique de la derive dans docs/API-DRIFT-noosa-gdx.md.
- [x] W3 purge android.* : zero import android dans src/. PixelDungeon
      reecrit en Game(platform) agnostique, IO via FileUtils, prefs via
      GameSettings, GLES20 via Blending, FloatMath via Math, Pixmap au
      lieu de Bitmap (FogOfWar, Halo, ItemSprite). android.jar retire des
      dependances de :core.
- [ ] W4 desktop
- [ ] W5 web
- [ ] W6 déploiement
