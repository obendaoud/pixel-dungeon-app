# 1.5 - Palettes et gestion des couleurs

## Durée estimée

3h

## Objectif d'apprentissage

Créer, importer et verrouiller une palette dans Aseprite, et comprendre la différence entre mode RGB et mode Indexed.

## Théorie

En pixel art, la palette est une décision artistique. Plus tu as peu de couleurs, plus chaque couleur compte. Les contraintes typiques :

- 1-bit (2 couleurs) : noir et blanc, ultra contraint
- 4 couleurs : palette Game Boy classique (4 nuances de vert ou de gris)
- 16 couleurs : palette GBC étendue (notre cible pour Monsieur Obo)
- 32 à 64 couleurs : palettes modernes (Pico-8 a 16, Endesga 32 et 64 sont des standards)

**Mode Indexed vs RGB.** Aseprite a deux modes principaux :

- **RGB** : tu peux utiliser n'importe quelle couleur. La palette n'est qu'une suggestion.
- **Indexed** : chaque pixel pointe vers un index dans la palette. Si tu changes l'index 5, tous les pixels qui utilisent l'index 5 changent. Si tu essaies de dessiner avec une couleur hors palette, Aseprite refuse ou la mappe à la plus proche.

Pour le pixel art à palette stricte, tu travailles en **Indexed**. C'est le mode imposé pour Monsieur Obo en phase 4.

Sprite > Color Mode > Indexed pour convertir un sprite RGB en Indexed.

**Création d'une palette.**

1. Window > Palette ou icône palette dans la barre supérieure
2. Clic droit dans la palette > New Palette ou Open Palette
3. Drag des slots pour réorganiser
4. Double-clic sur un slot pour éditer la couleur (en HSV ou HSL ou RGB)

Tu peux importer une palette `.gpl`, `.aseprite-palette`, `.png` (chaque pixel devient une couleur), ou `.hex` (liste de codes hex).

**Lospec.com** est la base de données mondiale de palettes pixel art. Tu télécharges une palette en `.gpl` ou `.hex`, tu l'importes dans Aseprite. Pour Monsieur Obo, on utilisera une palette GBC custom de 16 couleurs (à construire en phase 2).

**Palette Lock (verrouillage).** En mode Indexed, c'est implicite : tu ne peux pas dessiner hors palette. En mode RGB, il faut activer une option dans le panneau Palette. Pour cette leçon, on travaille directement en Indexed.

**Édition d'une couleur.** Double-clic sur le slot. La modification s'applique à tous les pixels qui utilisaient cet index. Très puissant pour expérimenter une variation d'ambiance (palette day / night).

**HSV / HSB.** Hue Saturation Value (ou Brightness). C'est le système le plus intuitif pour le pixel art :

- Hue : la teinte (rouge, vert, bleu)
- Saturation : la pureté (gris à pur)
- Value : la luminosité (noir à blanc)

Le hue shifting (leçon 2.5) consiste à décaler la teinte (Hue) en même temps que la luminosité (Value). C'est ce qui donne du caractère aux palettes pixel art professionnelles.

**Ramps (rampes de couleur).** Une ramp est une suite ordonnée de couleurs qui va du foncé au clair pour une même "famille" (ex : rouge sombre, rouge moyen, rouge clair, blanc cassé). On dispose les ramps en colonnes dans la palette. Tu travailleras tes propres ramps en leçon 2.5.

**Couleur transparente.** Le slot 0 de la palette en mode Indexed est par défaut la couleur transparente. Aseprite l'affiche en damier gris.

## Démonstration

- Chaîne MortMort, "Aseprite Tutorial - Palette" (rechercher). Observe la création d'une palette de 8 couleurs et le passage RGB / Indexed.
- Chaîne Brandon James Greer, "How to Choose Colors for Pixel Art" (rechercher exact). Théorie palette appliquée. Observe la construction d'une ramp.
- Site Lospec.com (lospec.com/palette-list). Parcours, identifie les palettes "Pico-8", "Endesga 32", "Sweetie 16", "Game Boy". Télécharge "Game Boy" en `.gpl`.

## Exercice pratique

1. Télécharge la palette "Game Boy" sur Lospec (4 couleurs vertes)
2. Crée un canvas 32x32 en mode Indexed
3. Importe la palette téléchargée
4. Dessine une silhouette d'arbre simple en utilisant les 4 couleurs : tronc, feuillage sombre, feuillage moyen, feuillage clair
5. Sauve, puis crée une copie : `source-night.aseprite`
6. Sur la copie : édite la palette pour la transformer en version "nuit" : remplace les 4 verts par 4 bleus / violets équivalents en termes de luminosité
7. Tu obtiens deux versions du même sprite (jour / nuit) sans avoir redessiné un seul pixel

## Critère de validation binaire

OUI si :

- Les deux fichiers `.aseprite` existent
- Les deux fichiers sont en mode Indexed
- Le fichier `source.aseprite` a une palette de 4 couleurs vertes (palette Game Boy)
- Le fichier `source-night.aseprite` a une palette de 4 couleurs bleues / violettes
- Les deux sprites ont exactement la même structure de pixels (même silhouette, mêmes index utilisés, seules les couleurs des index ont changé)
- Aucune couleur hors palette n'apparaît dans aucun des deux fichiers

NON sinon.

## Livrables

```
assets/phase-1/lesson-5-palettes/
  source.aseprite
  source-night.aseprite
  export-day.png
  export-day-x4.png
  export-night.png
  export-night-x4.png
```
