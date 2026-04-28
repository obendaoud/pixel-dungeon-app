# 2.2 - Anti-jaggies et lignes propres

## Durée estimée

6h

## Objectif d'apprentissage

Tracer des lignes droites, courbes et diagonales sans jaggies (escaliers irréguliers) ni pixels orphelins.

## Théorie

Une ligne en pixel art n'est pas une ligne géométrique : c'est une succession de segments de pixels. La qualité de la ligne se juge à la régularité de ces segments.

**Jaggies.** Les jaggies (de "jagged", déchiqueté) sont les irrégularités visuelles dans une ligne diagonale ou courbe. Quand une diagonale passe de 2 pixels par segment à 3 puis à 1, elle crée un effet d'escalier irrégulier, désagréable à l'oeil.

**Règle d'or pour les diagonales.** Pour une ligne droite diagonale, la longueur des segments doit être constante. Une 1:1 (45°) a 1 pixel par "marche". Une 1:2 a 2 pixels horizontaux par 1 vertical. Une 2:1 inverse. Tu vises toujours un ratio constant : 1:2, 1:3, 1:4, 1:1.

**Pixels orphelins (single pixels).** Un pixel isolé qui ne touche aucun pixel de la même couleur (sauf en diagonale). Visuellement, ça crée un point qui sort du flow. Sauf intention claire (étoile, point lumineux), tu les évites.

**Pixel doubles (corners).** Sur une ligne diagonale 1:1, tu as parfois deux pixels qui se touchent par un coin alors qu'ils devraient former une marche unique. Le mode `Pixel Perfect` du Pencil Aseprite supprime ça automatiquement. Si tu dessines sans Pixel Perfect, tu as à corriger à la main.

**Anti-aliasing manuel (AA).** En pixel art, l'anti-aliasing n'est PAS un filtre logiciel : c'est une technique manuelle où tu places des pixels d'une couleur intermédiaire le long d'une diagonale pour adoucir l'escalier. C'est l'art de la "ligne lisse à basse résolution". Voir leçon 2.6 et 2.9 pour l'application.

**Méthode pour une diagonale propre :**

1. Trace au Line tool (L) avec Shift maintenu si tu veux contraindre
2. Si Pixel Perfect est ON, le résultat est généralement bon
3. Sinon, observe : compte les pixels par marche. Tous identiques ? Si non, corrige
4. Évite les marches de 1, 2, 1, 2, 3 : c'est sale. Vise 2, 2, 2, 2, 2 ou 3, 3, 3, 3.

**Méthode pour une courbe propre :**

Une courbe en pixel art s'analyse comme une succession de segments diagonaux et droits. Une courbe propre suit ce pattern :

- 4 pixels horizontaux
- 3 pixels horizontaux
- 2 pixels horizontaux
- 1 pixel horizontal
- 1 pixel vertical
- 1 pixel horizontal
- 2 pixels verticaux
- 3 pixels verticaux

Le segment se rétrécit progressivement, on a un point de bascule (pixel unique du milieu), puis le segment s'étend en vertical. C'est ce qu'on appelle la "courbe parfaite" ou "perfect curve" en pixel art.

Pas de saut d'unité. Pas de 4, 2, 3 dans la même courbe : ça ferait un creux ou une bosse visible.

**Outils Aseprite.**

- Pencil avec Pixel Perfect activé : ligne propre par défaut
- Line (L) avec Shift : segments droits ou 45° précis
- Mark perfect curves (option de la communauté Aseprite, plugin) : optionnel

**Erreurs typiques :**

- Pixel Perfect désactivé sans le savoir
- Diagonale tracée à main levée sans relever : les marches sont irrégulières
- Trop de pixels orphelins le long d'un contour
- Courbe qui change de rythme au milieu

## Démonstration

- Chaîne MortMort, "How to Draw Pixel Art Lines" (rechercher exact). Observe la démo de la courbe parfaite et la correction manuelle de jaggies.
- Chaîne Pixel Pete, "Pixel Art Tutorial - Drawing Lines and Curves" (rechercher).
- Chaîne Brandon James Greer, "Pixel Art Fundamentals" (série, rechercher la vidéo sur les lignes).

## Exercice pratique

Sur un canvas 64x64, divisé en 4 zones de 32x32, dessine au Pencil avec Pixel Perfect ON :

1. Zone haut gauche : 3 diagonales propres (1:1, 1:2, 1:3), chacune sur toute la largeur de la zone
2. Zone haut droite : 3 courbes parfaites (quart de cercle, trois rayons différents)
3. Zone bas gauche : un cercle complet (pas une ellipse Aseprite, dessine-le à la main au pencil) de diamètre 24 pixels
4. Zone bas droite : un trait ondulé (sinusoïdal) qui traverse la zone, sans jaggies, sans pixel orphelin

Vérifie : zoome à 800%. Tu ne dois voir aucun pixel doublé en coin sur les diagonales. Aucune marche irrégulière sur les courbes. Aucun pixel orphelin sur l'ondulation.

## Critère de validation binaire

OUI si :

- Les 4 zones du canvas 64x64 sont remplies comme spécifié
- Sur les 3 diagonales (zone 1), le ratio est constant (vérification manuelle au comptage)
- Les 3 courbes (zone 2) suivent le pattern "rétrécissement progressif puis extension" sans saut d'unité
- Le cercle (zone 3) est symétrique sur l'axe vertical et horizontal (tolérance 0 pixel)
- L'ondulation (zone 4) ne contient aucun pixel orphelin
- Le sprite est en mode Indexed, palette à 1 couleur

NON sinon.

## Livrables

```
assets/phase-2/lesson-2-jaggies/
  source.aseprite
  export.png
  export-x4.png
```
