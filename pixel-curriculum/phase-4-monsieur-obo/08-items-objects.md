# 4.8 - Items et objets

## Durée estimée

8h

## Objectif d'apprentissage

Concevoir et produire 12 sprites d'items pour le jeu Monsieur Obo : potions, clés, parchemins, armes, accessoires.

## Théorie

Les items sont les éléments interactifs du jeu : ce qu'Obo ramasse, achète, utilise. Selon le GDD, tu auras des dizaines à des centaines d'items. Pour cette leçon, on en produit 12 représentatifs des grandes catégories.

**Tailles standard.**

- Items au sol (à ramasser) : 16x16 (alignés avec le tileset)
- Items en inventaire / HUD : 16x16 ou 24x24 selon le UI
- Items "scaled" pour tooltip ou détail : x4 ou x8 du sprite original

Pour cette leçon, on produit chaque item en 16x16, et on stocke les versions x4 pour LinkedIn et tooltip.

**12 items recommandés.**

Couvrir 4 catégories :

**Consommables (4)** :
- Potion de soin (rouge)
- Potion de mana (bleu)
- Pain (jaune doré)
- Champignon (rose / violet)

**Quêtes / clés (3)** :
- Clé en métal
- Parchemin enroulé
- Cristal mystique

**Armes / outils (3)** :
- Épée courte
- Bâton magique
- Dague

**Accessoires (2)** :
- Anneau
- Amulette

**Lecture des items à 16x16.**

À cette taille, chaque pixel compte beaucoup. Pour qu'un item soit lisible :

- Silhouette claire d'abord (test blackout transposé : tu reconnais l'item à sa silhouette ?)
- Couleur signature qui distingue immédiatement (potion = rouge, mana = bleu, clé = doré)
- Specular ponctuel (1 pixel) pour donner du polish
- Outline coloré sombre, pas noir pur (cohérence avec le character)

**Animation.**

Les items au sol peuvent avoir une mini-animation "shimmer" : 4 frames de scintillement, loop, pour attirer l'attention du joueur.

- Frame 1 : item neutre
- Frame 2 : item avec un specular plus fort (1-2 pixels lumineux ajoutés)
- Frame 3 : item neutre
- Frame 4 : item avec un specular différent (autre position)

Optionnel pour cette leçon. Si tu veux gagner du temps, fais juste des sprites statiques. Si tu veux du polish, ajoute le shimmer aux 4 items consommables au moins.

**Items vs UI.**

Les sprites ici sont les sprites d'items "in world" (au sol, ou en main). Le UI inventaire / HUD est un autre sujet (icônes UI, hors scope de cette leçon). Tu peux réutiliser les mêmes sprites pour le HUD si l'échelle correspond.

## Démonstration

- Chaîne MortMort, "Pixel Art Items Tutorial" et "How to Draw Pixel Art Potion" (rechercher).
- Chaîne Pedro Medeiros / Saint11, "Pixel Art Tutorials" sur les objets et propriétés visuelles (rechercher "Saint11 items").
- Référence sprite : sprites d'items de Stardew Valley, Hades, Risk of Rain 2 (2D), Hollow Knight (2D vectoriel mais inspiration).

## Exercice pratique

1. Crée un canvas `items-sheet.aseprite` 192x32 (12 items 16x16 organisés en 12 colonnes x 1 ligne, ou 6x2)
2. Dessine les 12 items selon la liste
3. Pour chaque item, vérifie le test silhouette : reconnaissable au premier coup d'oeil
4. Optionnel : anime au moins 2 items (parmi les 4 consommables) avec un shimmer 4 frames. Fichiers séparés `potion-health.aseprite`, `potion-mana.aseprite` avec tag `shimmer` et loop.
5. Exporte la sheet en PNG + un PNG x8 (96 pixels par item zoomé)

## Critère de validation binaire

OUI si :

- Le fichier `items-sheet.aseprite` contient 12 items 16x16 reconnaissables
- Mode Indexed, palette identique à la sheet (16 couleurs)
- Test silhouette blackout : Claude doit pouvoir identifier au minimum 10 items sur 12 à partir de la silhouette uniquement
- Chaque item a son outline coloré (pas noir pur, sauf si la palette le contient explicitement)
- Au moins 1 item dans chaque catégorie (consommable, quête, arme, accessoire) est présent
- Le PNG zoom x8 est lisible et utilisable pour tooltip / LinkedIn

NON sinon.

## Livrables

```
assets/phase-4/lesson-8-items/
  items-sheet.aseprite
  items-sheet.png
  items-sheet-x8.png
  potion-health.aseprite       (optionnel, animation shimmer)
  potion-mana.aseprite         (optionnel, animation shimmer)
  items-doc.md                 (liste des items, catégorie, et signature visuelle)
```
