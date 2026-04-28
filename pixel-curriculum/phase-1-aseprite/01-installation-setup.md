# 1.1 - Installation, configuration, raccourcis essentiels

## Durée estimée

2h

## Objectif d'apprentissage

Configurer Aseprite pour le pixel art moderne et mémoriser les 6 raccourcis qui couvrent 80% du temps de travail.

## Théorie

Aseprite est l'outil standard du pixel art professionnel. Il est payant (~20€), open source, multi-plateforme. La version 1.3+ apporte les Tilesets, le Timeline avancé, les Slices, et un export JSON natif compatible Godot.

Avant de dessiner, il faut configurer trois choses qui te feront perdre du temps si tu les laisses par défaut.

**1. Le canvas et le snap au pixel.** En pixel art, on travaille en taille native (32x32, 48x48, 128x128) puis on zoome à 800% ou 1600% pour éditer. Le canvas doit être small. Le zoom est ton ami. Aseprite a un comportement "Pixel Perfect" sur le pencil : actif, il évite les doublons sur les diagonales. Tu le veux ON par défaut.

**2. Les raccourcis clavier.** Aseprite suit la convention Photoshop par défaut, mais beaucoup de tutoriels utilisent les raccourcis Aseprite natifs. Les 6 raccourcis qui couvrent 80% du temps sont :

- `B` : Pencil (l'outil principal)
- `E` : Eraser
- `G` : Bucket (paint fill)
- `M` : Marquee selection (rectangle)
- `V` : Move
- `Alt` (maintenu) : Eyedropper, prélève la couleur sous le curseur

À ces 6 il faut ajouter trois meta-raccourcis :

- `Ctrl+Z` / `Ctrl+Shift+Z` : Undo / Redo
- `Z` ou molette : Zoom
- `Space` (maintenu) : Pan le canvas

**3. La grille et les guides.** Aseprite affiche une grille au pixel (toujours active visuellement à fort zoom) et une grille personnalisable (View > Grid > Grid Settings). Pour Monsieur Obo en 48x48, tu mets une grille tous les 8 pixels pour t'aider à découper le sprite en zones (tête, torse, jambes).

**Préférences à modifier dès le début.** Edit > Preferences :

- Cursor > Brush type : `Crosshair` ou `Native`, jamais `Square preview` (gêne la lecture du pixel)
- Color > New file color mode : `Indexed` pour les projets à palette stricte, `RGB` sinon
- General > Show menu bar : activé
- Tool > Pixel Perfect : activé par défaut sur le Pencil

Dernier point : Aseprite enregistre dans son format `.aseprite` (ou `.ase`). Tu ne sauves jamais en PNG comme format de travail. Le PNG est uniquement un export. Tu commit dans Git le `.aseprite` (binaire mais petit), accompagné de l'export PNG.

## Démonstration

Vidéo à regarder en intégralité :

- Chaîne MortMort, "Aseprite Tutorial - Beginner's Guide" (rechercher "MortMort Aseprite Beginner Guide" sur YouTube). Observe la disposition des panneaux, le réflexe Alt pour pipette, et la fluidité du switch B / E.

Vidéo complémentaire :

- Chaîne Aseprite officielle, playlist "Aseprite Tutorials". Regarder la première vidéo, "Aseprite Basics".

Ce que tu dois observer :

- Le menu File > New, options Width / Height / Color Mode
- L'ouverture du panneau Color (Window > Color) à droite
- Le passage entre Pencil et Eraser sans la souris (B / E)
- Le pan avec Space + drag souris

## Exercice pratique

1. Installe Aseprite (s'il n'est pas déjà installé) et lance-le
2. Modifie les préférences Cursor, Color, Tool comme indiqué dans la section Théorie
3. Crée un canvas 32x32 en RGB
4. Sans regarder le menu, fais successivement :
   - dessine un trait avec le Pencil (B)
   - efface une partie avec l'Eraser (E)
   - remplis une zone avec le Bucket (G)
   - prélève une couleur avec Alt
   - sélectionne un rectangle avec M et déplace-le avec V
   - zoome puis pan avec Space
5. Sauve le fichier sous `assets/phase-1/lesson-1-installation/source.aseprite`
6. Exporte en PNG taille native (`export.png`) et en PNG zoom 4x (`export-x4.png`)

## Critère de validation binaire

OUI si toutes ces conditions sont remplies :

- Le fichier `source.aseprite` existe à l'emplacement attendu
- Le canvas fait 32x32 pixels exactement
- Le fichier contient au moins une trace de chaque outil (Pencil, Eraser, Bucket)
- Tu peux exécuter la séquence d'outils sans regarder le menu (auto-évaluation, mais Claude posera 3 questions de contrôle au hasard)
- L'export `export-x4.png` fait exactement 128x128

NON sinon.

## Livrables

```
assets/phase-1/lesson-1-installation/
  source.aseprite
  export.png
  export-x4.png
```
