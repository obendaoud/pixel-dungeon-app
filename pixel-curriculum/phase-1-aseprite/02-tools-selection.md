# 1.2 - Outils de dessin et sélection

## Durée estimée

3h

## Objectif d'apprentissage

Maîtriser les outils Pencil, Line, Rectangle, Ellipse, Contour, Bucket, Magic Wand et le mode Pixel Perfect, et savoir choisir le bon outil selon la situation.

## Théorie

Aseprite a une dizaine d'outils, mais seulement 4 ou 5 sont utilisés en routine. Tu vas les voir tous une fois pour savoir quoi choisir, puis tu te concentreras sur ceux qui comptent.

**Pencil (B).** Le seul outil qui dépose un pixel à la fois. Mode `Pixel Perfect` activé : si tu traces une diagonale, Aseprite supprime automatiquement les doublons aux coins. C'est ce qui donne des lignes propres en pixel art. Tu peux aussi régler la taille du brush, mais en pixel art tu travailles à brush 1 dans 95% des cas. Click droit pour utiliser la couleur secondaire (background color).

**Line (L).** Trace une ligne droite entre deux points. Maintiens Shift pour contraindre à 0°, 45° ou 90°. Très utile pour les contours de bâtiments, les lances, les rayons.

**Rectangle (U) et Filled Rectangle.** Dessine un rectangle vide ou plein. Utile pour blocking out (poser des masses avant de détailler).

**Ellipse (U) et Filled Ellipse.** Dessine une ellipse. En petite résolution (16x16, 32x32) les ellipses Aseprite sont parfois imparfaites, tu retoucheras au pencil.

**Contour (D).** Trace une forme libre fermée. Rare en pixel art moderne, plus utile pour le tracing.

**Bucket (G).** Remplit une zone fermée de la couleur active. Attention au `Contiguous` (cocher Tolerance = 0 et Contiguous activé : ne remplit que les pixels connectés de la couleur cliquée).

**Magic Wand (W).** Sélectionne tous les pixels d'une même couleur (contiguous ou non). Très puissant pour modifier toutes les zones d'une couleur d'un coup.

**Marquee (M).** Sélection rectangulaire. Shift pour ajouter, Alt pour soustraire.

**Lasso (Q).** Sélection libre. Peu précise au pixel, à éviter en travail fin.

**Move (V).** Déplace le contenu de la sélection. Si rien n'est sélectionné, déplace le calque entier.

**Eraser (E).** Efface (rend transparent en RGB, ou met la couleur de background en Indexed).

**Eyedropper (Alt).** Pipette. Le réflexe est `Alt` maintenu, pas la touche `I`. Tu prélèves, tu relâches, tu dessines.

**Pixel Perfect.** À activer dans la barre d'options du Pencil quand tu traces des lignes courbes. À désactiver pour de la peinture pleine de pixels (textures, dithering).

**Tile mode (Wrap).** Dans View > Tiled Mode, active le wrap pour les tilesets. Pas pour cette leçon.

## Démonstration

- Chaîne MortMort, "How to Draw Pixel Art - The Basics" (rechercher exact). Observe l'usage du Pencil au brush 1, le réflexe Alt pour la pipette, et l'usage de Line pour les diagonales propres.
- Chaîne Pixel Pete, "Pixel Art Tutorial - Drawing Lines" (rechercher exact). Tu observes la différence entre une diagonale au Pencil sans Pixel Perfect (escaliers doublés) et avec Pixel Perfect (escaliers propres).

## Exercice pratique

Dans un canvas 64x64 :

1. En haut à gauche : trace 3 lignes droites avec Line (horizontale, verticale, diagonale 45°), 1 pixel d'épaisseur
2. En haut à droite : trace 3 lignes courbes au Pencil avec Pixel Perfect ON
3. En bas à gauche : dessine un cercle vide à l'Ellipse, puis corrige les imperfections au Pencil
4. En bas à droite : dessine un rectangle plein, sélectionne-le avec Magic Wand, change sa couleur via Edit > Replace Color, puis déplace-le avec Move (V)

## Critère de validation binaire

OUI si :

- Le canvas fait 64x64 pixels
- Les 4 zones sont visibles et distinctes
- Les lignes droites de la zone 1 n'ont aucun pixel orphelin
- Les lignes courbes de la zone 2 ont été tracées avec Pixel Perfect ON (vérifiable : pas de double pixel sur les diagonales)
- Le cercle de la zone 3 est symétrique sur l'axe vertical (compté à l'oeil, tolérance 1 pixel)
- Le rectangle de la zone 4 a bien été déplacé (il n'est pas à sa position d'origine)

NON sinon.

## Livrables

```
assets/phase-1/lesson-2-tools/
  source.aseprite
  export.png
  export-x4.png
```
