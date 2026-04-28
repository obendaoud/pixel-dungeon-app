# 2.7 - Volume sur primitives (cube, sphère, cylindre)

## Durée estimée

8h

## Objectif d'apprentissage

Rendre en pixel art les 3 primitives géométriques de base (cube, sphère, cylindre) avec un volume convaincant et une lumière cohérente.

## Théorie

Tout objet complexe peut se décomposer en primitives. Un personnage = sphère (tête) + cylindre (cou, bras, jambes) + cube ou sphère (torse). Un casque = sphère + cube. Une épée = cube allongé + cylindre (manche). Si tu sais peindre les 3 primitives, tu sais peindre 80% des objets.

**Le cube.**

Un cube a typiquement 3 faces visibles en projection isométrique ou 3/4. Trois orientations, donc trois niveaux de lumière :

- Face supérieure : highlight
- Face frontale (vers le spectateur) : base
- Face latérale opposée à la lumière : ombre

En perspective frontale (cube vu droit), tu ne vois qu'une face : tu n'as pas de volume sans contour ou sans dégradé. Préfère le 3/4.

**La sphère.**

La sphère est définie par sa courbure continue. Le shading suit le **terminator**, la ligne où l'ombre commence. Cette ligne n'est pas droite : c'est une courbe qui suit la sphère. En pixel art à basse résolution, tu approxime par des clusters concentriques.

Structure typique d'une sphère 32x32 avec 4 niveaux de couleur :

- Cluster lumière : 25% de la surface, en haut gauche (si lumière en haut gauche)
- Cluster mid : 30% de la surface, formant une bande courbée
- Cluster ombre : 30% de la surface, en bas droite
- Cluster ombre profonde / occlusion : 15% de la surface, juste avant le bord en bas droite
- Specular (1 ou 2 pixels) : un point lumineux dans le cluster lumière

Important : sur une sphère, l'**ombre projetée** sur le sol et l'**ombre forme** sur la sphère sont deux choses différentes. Souvent on dessine seulement l'ombre forme (sur la sphère elle-même) si la sphère est isolée.

**Reflected light.** Un détail subtil : dans la zone d'ombre profonde, près du bord opposé à la lumière, on remet un peu de mid (un cluster de "lumière reflétée" qui simule la lumière indirecte rebondie sur l'environnement). Ça empêche la sphère d'avoir l'air "écrasée" du côté ombre.

**Le cylindre.**

Vertical ou horizontal, le cylindre se shading en bandes verticales (ou horizontales selon l'orientation). Plus simple que la sphère car la courbure est sur un seul axe.

Structure typique d'un cylindre vertical 16x32 :

- Bande highlight : 4-6 pixels de large, vers la lumière
- Bande base : 6-8 pixels
- Bande ombre : 4-6 pixels
- Bande ombre profonde : 2-3 pixels
- Reflected light : 1-2 pixels juste avant le bord opposé

Les extrémités (haut et bas) ont une ellipse pour montrer la circularité. Si le haut est éclairé, l'ellipse du haut est claire à plate, l'ellipse du bas est sombre.

**Outline du cylindre.** Tu peux omettre l'outline sur les côtés courbes pour laisser la transition de couleur définir la silhouette. Effet plus doux. Pour Monsieur Obo on garde l'outline.

**Itération.** Aucune primitive n'est bonne au premier jet. Tu dessines une sphère, tu compares à une référence (photo de boule de billard, dessin classique), tu corriges. 5 à 10 itérations par primitive est normal en début d'apprentissage.

## Démonstration

- Chaîne MortMort, "Pixel Art Tutorial - Shading Spheres and Cubes" (rechercher). Démo des 3 primitives.
- Chaîne AdamCYounis, "Pixel Art Class - Form" (rechercher). Théorie de la forme appliquée au pixel art.
- Chaîne Brandon James Greer, "Pixel Art - Forms" (rechercher).
- Référence externe utile : illustrations classiques de primitives en peinture (Andrew Loomis, "Drawing the Head and Hands" pour la sphère). Pas pixel mais le principe transfère.

## Exercice pratique

Sur un canvas 96x96, divisé en 9 cases de 32x32 :

| Cube 32x32 | Sphère 32x32 | Cylindre vertical 32x32 |
| Cube 32x32 (lumière différente) | Sphère 32x32 (lumière différente) | Cylindre horizontal 32x32 |
| Cube avec texture mat | Sphère avec specular fort (boule de billard) | Cylindre métal poli |

Palette : 5 couleurs (1 outline + ramp de 4 couleurs).

Lumière : pour la première ligne, en haut gauche. Pour la deuxième ligne, en haut droite. Pour la troisième ligne, libre, mais cohérent par sprite.

## Critère de validation binaire

OUI si :

- Le canvas fait 96x96 pixels
- 9 sprites sont visibles, chacun dans sa case 32x32
- Mode Indexed, palette de 5 couleurs maximum
- Sur chaque sprite, on identifie au minimum 3 niveaux de lumière distincts (ombre, base, highlight)
- Les sphères ont une indication de reflected light dans la zone d'ombre profonde (un cluster de mid réintroduit près du bord opposé à la lumière)
- Les cylindres ont des ellipses aux extrémités cohérentes avec la direction de lumière
- Aucun banding visible sur les sphères (pas de bande horizontale uniforme entre les niveaux)

NON sinon.

## Livrables

```
assets/phase-2/lesson-7-volume/
  source.aseprite
  export.png
  export-x4.png
```
