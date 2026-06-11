# Rapport de dérive d'API : src/ vs noosa-gdx

Mesuré en compilant `:core` contre `:noosa-gdx` (vendoré depuis Shattered
Pixel Dungeon, libGDX 1.14.0) au lieu de `pd-classes.jar`.

Résultat : **~200 erreurs dans 43 fichiers** (cap javac atteint, le total
réel est probablement un peu au-dessus). Quatre chantiers concentrent tout :

| Chantier | Symboles disparus | Erreurs | Fichiers types |
|----------|-------------------|---------|----------------|
| Rendu texte | `BitmapTextMultiline` | ~60 | scenes/, windows/ |
| Boutons UI | `com.watabou.noosa.ui.Button` (API changée) | ~58 | windows/, ui/ |
| Input | `TouchArea`, `Touchscreen.Touch`, `Keys` | ~40 | CellSelector, scenes/ |
| Divers | `Gradient`, `SystemTime`, `Highlighter`, `SparseArray.delete(int)` | ~12 | utils, effects |

## Correspondances cibles (API Shattered)

- `BitmapTextMultiline` -> `RenderedTextBlock` (freetype) ou re-vendorer
  l'ancien BitmapTextMultiline par-dessus le BitmapText conservé
- `Touchscreen.Touch` / `TouchArea` -> `PointerEvent` / `PointerArea`
  (package `com.watabou.input` réécrit)
- `noosa.ui.Button` -> existe encore mais signatures changées
  (`onPointerDown` etc. au lieu de `onTouchDown`)
- `Keys` -> `KeyEvent` / `KeyBindings`

## Stratégie recommandée (W2 suite)

Deux options par chantier :

1. **Adapter le jeu** (43 fichiers, surtout UI/scenes) à l'API moderne.
   Propre, aligne sur Shattered, prépare W5.
2. **Shim de compat** : réintroduire dans noosa-gdx des classes pont
   (`BitmapTextMultiline`, `TouchArea`, ancien `Button`) implémentées sur
   la nouvelle API. Moins de fichiers touchés côté jeu, mais de la dette.

Recommandation : option 1 pour input et boutons (le shim serait fragile),
option 2 possible pour `BitmapTextMultiline` (purement du rendu).

Estimation : 1 à 2 semaines de travail manuel, testable incrémentalement
fichier par fichier en re-pointant `:core` sur `:noosa-gdx`.

## Reproduire la mesure

```bash
# dans core/build.gradle, remplacer les deps par :
#   implementation project(':noosa-gdx')
#   compileOnly files('../libs/floatmath-stub.jar')
#   compileOnly files('../libs/android.jar')
gradle :core:compileJava 2>&1 | grep -c "error:"
```
