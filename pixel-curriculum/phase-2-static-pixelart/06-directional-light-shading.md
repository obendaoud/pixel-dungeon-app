# 2.6 - Lumière directionnelle et shading

## Durée estimée

8h

## Objectif d'apprentissage

Appliquer une lumière directionnelle cohérente sur un sprite, avec ombre, mid-tone, base, highlight, et accents.

## Théorie

Le shading en pixel art repose sur trois questions à se poser pour chaque pixel :

1. D'où vient la lumière ?
2. Quelle est la forme du volume sous-jacent ?
3. Quel matériau est-ce ?

**1. Direction de la lumière.** Tu choisis une direction et tu la respectes pour tout le sprite. Convention pixel art classique : lumière en haut à gauche (10h ou 11h sur l'horloge). Avantages : couvert par la majorité des tutoriels, lecture naturelle pour un occidental (lecture de gauche à droite). Tu peux choisir autre chose, mais sois cohérent.

Une fois la direction choisie, applique :

- Surfaces orientées vers la lumière : highlight (couleur la plus claire de la ramp)
- Surfaces parallèles à la lumière : couleur de base (mid)
- Surfaces opposées à la lumière : ombre (couleur foncée)
- Surfaces complètement à l'opposé : ombre profonde (la couleur la plus sombre)

**2. Niveaux de shading.** Dans une ramp de 4 ou 5 couleurs, tu utilises typiquement :

- 1 couleur d'ombre profonde (rare, accents)
- 1 couleur d'ombre principale (occupy 30-40% de la zone)
- 1 couleur de base (occupy 30-40% de la zone)
- 1 couleur de highlight (occupy 15-25% de la zone)
- 1 couleur d'accent / specular (occupy 5% maximum, un ou deux pixels)

Si une couleur de la ramp occupe 0% de la zone, peut-être que ta ramp est trop riche pour le sprite, ou que tu n'utilises pas tout son potentiel.

**3. Matériaux.** L'application varie selon la matière (couvert en leçon 2.8) :

- Mat (peau, tissu non brillant) : transitions douces, peu de specular, ombres larges
- Brillant (métal poli) : transitions fortes, specular punchy, ombres dures
- Translucide (eau, verre) : transitions moyennes, specular blanc franc

**Outline.** Le contour. Trois écoles :

- **Outline noir uniforme** : style cartoon, GBA / GBC, lisible. Tu mets du noir partout autour de la silhouette.
- **Outline coloré** : tu utilises la couleur la plus sombre de la ramp pour le contour (ex : violet sombre au lieu de noir). Plus subtil, plus pro.
- **Outline sélectif** : noir uniquement sur les zones d'ombre, omis sur les zones de lumière (selout, "selective outline"). Plus avancé, donne du dynamisme.

Pour Monsieur Obo, on adoptera l'**outline coloré sombre** (violet sombre ou brun sombre selon la zone). Le noir pur serait trop dur sur la palette GBC étendue.

**Anti-aliasing manuel (AA).** Sur les diagonales d'un contour, tu places un pixel d'une couleur intermédiaire pour adoucir. Exemple : contour noir, base mid-tone : tu places un pixel d'ombre sombre entre les deux sur les diagonales. Effet : la ligne paraît plus lisse à 100%.

**Selout.** Variante d'AA où l'outline disparaît sur les zones très lumineuses. Tu le remplaces par du highlight. Effet : la silhouette "respire" du côté de la lumière.

**Erreurs typiques :**

- Lumière incohérente : la moitié du sprite est éclairée à gauche, l'autre à droite
- Pas de specular du tout : le sprite paraît plat, plastique
- Trop de specular partout : le sprite paraît mouillé ou en plastique brillant
- Outline noir pur sur palette douce : le contraste casse le sprite
- Banding : ombre en bande horizontale uniforme entre base et highlight

## Démonstration

- Chaîne MortMort, "Pixel Art Shading Tutorial" (rechercher). Démo de l'application d'une lumière directionnelle.
- Chaîne AdamCYounis, "How I Light Pixel Art" (rechercher exact). Approche pro.
- Chaîne Brandon James Greer, "Pixel Art Tutorial - Shading" (rechercher).
- Chaîne Pixel Pete, "Light and Shadow in Pixel Art" (rechercher).

## Exercice pratique

Sur un canvas 64x64, mode Indexed avec une palette de 6 couleurs (1 outline foncé + 1 ramp de 5 couleurs pour le matériau) :

1. Dessine une boule en 32x32 (sphère vue de face) en haut gauche, lumière en haut gauche
2. Dessine la même boule en 32x32 en haut droite, lumière en haut droite (même palette, juste l'orientation change)
3. En bas gauche, dessine un cube isométrique 32x32 avec 3 faces visibles, lumière en haut gauche
4. En bas droite, dessine la même boule mais en matériau "métal poli" : transitions fortes, specular blanc franc

Vérifie : pour les 3 versions de la boule (1, 2, 4), l'outline coloré est utilisé (pas de noir pur sauf si la palette le contient explicitement). Pour le cube (3), les 3 faces ont 3 couleurs distinctes correspondant à leur orientation.

## Critère de validation binaire

OUI si :

- Le canvas fait 64x64
- Mode Indexed, palette de 6 couleurs maximum
- Les 4 zones de 32x32 contiennent les 4 sprites attendus
- Chaque sprite utilise au minimum 4 niveaux de la palette (ombre, base, highlight, et l'outline si compté)
- La direction de lumière est cohérente sur chaque sprite individuellement (la lumière en haut gauche éclaire la zone haut gauche)
- Le cube isométrique a 3 faces clairement distinctes, chacune avec une couleur différente
- Aucun banding visible (pas de bande d'ombre horizontale uniforme)

NON sinon.

## Livrables

```
assets/phase-2/lesson-6-shading/
  source.aseprite
  export.png
  export-x4.png
```
