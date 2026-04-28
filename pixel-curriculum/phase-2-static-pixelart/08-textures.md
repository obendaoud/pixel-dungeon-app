# 2.8 - Textures (bois, métal, tissu, pierre)

## Durée estimée

10h

## Objectif d'apprentissage

Représenter visuellement 4 matériaux différents (bois, métal, tissu, pierre) avec un vocabulaire de pixels distinct pour chacun.

## Théorie

En pixel art, chaque matériau a une "signature" graphique : un pattern de pixels spécifique qui le rend reconnaissable. À 32x32 ou 48x48, tu n'as pas la place de représenter la microstructure réelle d'un matériau ; tu utilises un raccourci visuel reconnaissable.

**Bois.**

- Lignes de fibre verticales ou horizontales (selon l'orientation de la planche), 1 à 2 pixels d'épaisseur
- Noeuds : clusters circulaires de 2 à 4 pixels d'une couleur plus sombre
- Couleur dominante : brun chaud (hue 25-40°), saturation moyenne
- Highlights : un fil de pixels clairs le long de la fibre
- Ombres : entre les fibres, ombre fine

Ne pas faire : surface uniforme avec un highlight central. Ça paraît plastique, pas bois.

**Métal.**

Trois variantes :

- Métal mat (fer brut) : ramp serrée en luminosité, peu de specular, ombres douces
- Métal poli (acier, chrome) : contraste fort, specular punchy, transitions dures
- Métal doré : mêmes règles que poli mais avec hue jaune chaud (hue 40-50°), saturation plus haute

Signature du métal poli : un specular très lumineux (presque blanc) sur un fond de ramp sombre. Transition rapide. Reflected light forte de l'autre côté.

Anti-pattern : le "métal" qui paraît en plastique. Cause : transitions trop douces, pas assez de contraste.

**Tissu.**

Tissu lisse (drap, soie) : transitions douces, plis indiqués par des bandes parallèles d'ombre / lumière. Pas de texture surfacique.

Tissu rugueux (laine, lin) : grain visible, dithering ordonné, granulosité douce, peu de specular.

Plis : un pli est un changement local de direction de surface. Tu indiques par une bande d'ombre / une bande de lumière qui suit le pli. Pour Monsieur Obo, les plis sont simplifiés (1 ou 2 plis principaux par vêtement).

**Pierre.**

- Surface rugueuse : dithering volontaire ou clusters irréguliers, jamais de surface lisse uniforme
- Variation locale de couleur : 2 à 3 nuances de la même ramp en clusters de 3-5 pixels
- Fissures : trait fin de la couleur la plus sombre, 1 pixel d'épaisseur, irrégulier
- Mousse / lichen : optionnel, ajout d'une couleur verte désaturée en accent ponctuel

**Pour les 4 matériaux : règle commune.**

Tu ne dessines pas la "matière" pixel par pixel. Tu dessines :

1. Le volume (forme, lumière directionnelle, comme leçon 2.7)
2. La signature de matière (les éléments distinctifs ci-dessus, par-dessus le volume)

Volume d'abord, signature ensuite. Si tu fais l'inverse, le volume ne lit plus.

**Dithering.**

Le dithering est l'alternance de pixels de deux couleurs voisines (souvent en damier ou en pattern régulier) pour simuler une couleur intermédiaire. Trois usages :

- Transition entre deux niveaux d'une ramp (pour adoucir une bande)
- Texture (granit, pierre, peau d'orange)
- Effet stylistique (rétro, look NES)

Pattern courants :

- 50/50 damier : pour transition pure
- 25/75 : un pixel sur quatre est de la couleur secondaire
- 12.5/87.5 : un pixel sur huit, presque imperceptible, "noise" subtil

Aseprite : tu peux activer un brush dithered (Edit > Preferences ou via plugin), mais le contrôle manuel est plus précis.

## Démonstration

- Chaîne MortMort, "Pixel Art Tutorial - Materials" ou "How to Draw Pixel Art Wood / Metal / Stone" (rechercher). Démo des 4 matériaux.
- Chaîne Pedro Medeiros (Saint11), "Pixel Art Tutorials" (twitter et patreon, rechercher "Saint11 metal" ou "Saint11 wood"). Référence absolue sur les matériaux pixel art.
- Chaîne Brandon James Greer, "Pixel Art - Materials and Textures" (rechercher).
- Chaîne Pixel Pete, "Drawing Materials in Pixel Art" (rechercher).

## Exercice pratique

Sur un canvas 128x32, divisé en 4 cases de 32x32, dessine :

1. Case 1 : une planche de bois (verticale ou horizontale)
2. Case 2 : un bouclier en métal poli (forme circulaire)
3. Case 3 : un bout de tissu drapé (carré avec 2 plis)
4. Case 4 : un bloc de pierre rugueuse

Palette : 16 couleurs maximum (tu peux réutiliser ta palette Sweetie 16 ou construire une palette dédiée).

Chaque sprite doit avoir un volume convaincant (lumière en haut gauche) ET la signature de son matériau.

## Critère de validation binaire

OUI si :

- Le canvas fait 128x32 pixels
- 4 zones distinctes représentent les 4 matériaux
- Mode Indexed, palette de 16 couleurs maximum
- Le bois (case 1) a au moins 1 noeud visible et des fibres parallèles
- Le métal poli (case 2) a un specular d'au moins 2 pixels et un contraste fort entre les niveaux
- Le tissu (case 3) a au moins 1 pli avec une bande d'ombre et une bande de lumière
- La pierre (case 4) a une variation locale de couleur (clusters irréguliers de 2-3 nuances) ou du dithering volontaire
- Les 4 sprites ont une lumière directionnelle cohérente (haut gauche)

NON sinon.

## Livrables

```
assets/phase-2/lesson-8-textures/
  source.aseprite
  export.png
  export-x4.png
```
