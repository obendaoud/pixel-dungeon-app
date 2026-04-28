# 2.3 - Clusters et bruit visuel

## Durée estimée

5h

## Objectif d'apprentissage

Identifier les clusters (groupes de pixels d'une même couleur) et éviter le bruit visuel (pixels isolés et zigzags qui parasitent la lecture).

## Théorie

Un cluster est un groupe de pixels de même couleur connectés (en 4-voisinage : haut, bas, gauche, droite, pas la diagonale). Quand tu peins une zone, tu crées des clusters. La taille, la forme, et la régularité des clusters déterminent la qualité visuelle de la zone.

**Principe : clusters plutôt que pixels isolés.** En basse résolution, l'oeil cherche des formes. Un pixel isolé crée du bruit. Trois pixels en cluster créent une forme. Tu privilégies toujours les clusters de 2 pixels minimum, sauf si l'intention est claire (étoile, point lumineux, détail volontaire).

**Règle des 3 pixels.** En pixel art, on évite les "single pixels" pour les zones d'ombrage, de texture, et de transition. Un pixel d'ombre tout seul au milieu d'une zone claire : suspect. Trois pixels en cluster d'ombre : lisible.

**Banding.** Le banding est un cluster qui forme une bande horizontale ou verticale uniforme entre deux zones de couleur. Visuellement c'est moche : ça crée une "frontière" trop nette qui casse la perception du volume. À éviter, on remplace par des clusters plus organiques (irréguliers) et on fait un dithering ou un AA pour adoucir.

**Bruit (noise).** Un sprite "noisy" a trop de pixels isolés, trop de zigzags, trop de single pixels d'ombre éparpillés. Sensation de "sale", "non terminé". Sauf style volontaire (texture rocheuse), tu évites.

**Quand un single pixel est OK :**

- Intention de point lumineux (étoile, lueur, scintillement)
- Détail très spécifique (pupille d'oeil à 16x16)
- AA (anti-aliasing) sur une diagonale (pixel intermédiaire pour adoucir une marche)
- Texture stylisée (granit, sable)

**Quand un cluster doit être plus gros :**

- Zone d'ombre principale : minimum 3-4 pixels
- Zone de highlight principale : minimum 3-4 pixels
- Forme structurelle (épaule, poitrine, casque) : taille proportionnelle à la lisibilité

**Test visuel.** Zoome à 100% (taille native). Si tu vois des pixels qui "scintillent" ou "papillonnent" à l'oeil, c'est probablement du bruit. Corrige.

**Méthode de correction :**

1. Active Magic Wand (W), clique sur la couleur d'ombre. Tu vois tous les clusters d'ombre en surbrillance.
2. Compte les clusters de moins de 3 pixels. Pour chacun, demande-toi : intention ou bruit ?
3. Si bruit : étends le cluster (ajoute des pixels voisins) ou supprime-le (mappe à la couleur de fond).
4. Refais le test à 100%.

**Outil Aseprite : Despeckle (Filters > Despeckle).** Filtre destructeur qui supprime les single pixels. À utiliser avec prudence. Préfère la correction manuelle.

**Cas particulier : dithering.** Le dithering est un pattern volontaire de pixels alternés (damier, lignes) entre deux couleurs pour simuler une troisième. Ce n'est pas du bruit : c'est une texture intentionnelle. On distingue dithering volontaire (ordonné, régulier) et bruit involontaire (aléatoire, sale). Tu vois le dithering en leçon 2.6 et 2.8.

## Démonstration

- Chaîne MortMort, "Pixel Art Clusters" ou "How to Avoid Pixel Art Mistakes" (rechercher). Observe l'identification des single pixels et leur correction.
- Chaîne Pedro Medeiros (Saint11), "Pixel Art Tutorial" sur Patreon ou Twitter (rechercher "Saint11 pixel art clusters"). Référence sur les clusters.
- Chaîne Brandon James Greer, "Pixel Art - Clean Up" (rechercher).

## Exercice pratique

Sur un canvas 32x32, mode Indexed avec palette de 3 couleurs (clair, moyen, foncé) :

1. Étape 1 : dessine un visage simple (cercle pour la tête, deux yeux, une bouche, un nez) avec beaucoup de pixels isolés (single pixels) éparpillés, sans intention. Sauve sous `version-noisy.aseprite`.
2. Étape 2 : duplique. Sauve sous `version-clean.aseprite`. Sur cette version, supprime ou regroupe tous les single pixels qui ne servent pas (tout sauf : pupilles d'yeux peut-être, point lumineux d'oeil). Aucun cluster d'ombre ou de highlight de moins de 3 pixels.

Compare les deux versions à 100%. La version clean doit être visiblement plus lisible et "propre".

## Critère de validation binaire

OUI si :

- Les deux fichiers existent
- Les deux fichiers ont la même palette de 3 couleurs
- La version `noisy` contient au minimum 10 single pixels visibles à 100%
- La version `clean` ne contient aucun cluster d'ombre ou de highlight de moins de 3 pixels (les pupilles et le point lumineux d'oeil sont autorisés)
- Les deux versions ont la même silhouette extérieure (même contour)
- À 100%, la version clean ne "scintille" pas

NON sinon.

## Livrables

```
assets/phase-2/lesson-3-clusters/
  version-noisy.aseprite
  version-clean.aseprite
  noisy.png
  clean.png
  comparison-x4.png    (les deux côte à côte, agrandi 4x)
```
