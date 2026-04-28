# 3.5 - Follow through et overlapping action

## Durée estimée

6h

## Objectif d'apprentissage

Animer des éléments secondaires (cape, cheveux, queue) qui suivent le mouvement principal avec un retard, donnant fluidité et organicité.

## Théorie

Quand un corps en mouvement s'arrête, les parties molles (vêtements, cheveux, peau, accessoires) continuent par inertie. Quand un corps démarre, ces mêmes parties retardent. Ce double phénomène est ce qu'on appelle follow through (suite du mouvement après l'arrêt) et overlapping action (mouvement décalé entre parties qui ne s'arrêtent pas en même temps).

**Follow through.**

Tu cours, tu t'arrêtes brutalement. Tes cheveux continuent vers l'avant pendant 2-3 frames avant de retomber. Ton manteau idem. Sans ce détail, l'arrêt paraît rigide, robotique.

Application pixel art : sur la frame d'arrêt et 1-2 frames après, tu décales légèrement les éléments mous dans la direction du mouvement précédent. Puis ils reviennent à la position de repos en 2-3 frames.

**Overlapping action.**

Pendant un mouvement, toutes les parties du corps ne bougent pas en synchronisation parfaite. Quand tu lances le bras, l'épaule bouge avant, le coude suit, le poignet ensuite, la main en dernier. Chaque articulation a un léger décalage temporel.

Ce décalage crée un effet de fouet ("whip") qui rend le mouvement vivant. Sans, le bras paraît rigide comme un bâton.

**Application au combat anime (préparation phase 5).**

Dans une animation de coup de poing à 24 fps :

- Frame 0 : position de départ
- Frame 2 : épaule commence à avancer, bras encore en arrière
- Frame 4 : coude avance, poignet et main encore en retard
- Frame 6 : tout est aligné, point d'impact
- Frame 8 : main qui a continué, en dépassement (follow through)
- Frame 10 : retour vers la position de garde

L'effet de fouet vient du décalage progressif. Si tu animes l'épaule, le coude, le poignet et la main en simultané, tu n'as pas l'effet.

**Cape, cheveux, queue.**

Une cape suit le corps avec un délai et une amplitude amplifiée :

- Le corps se penche en avant, la cape se penche en avant **après** (1-2 frames de retard)
- L'amplitude du mouvement de la cape est plus grande que celle du corps (la cape bouge plus loin)
- La cape revient à la position de repos avec un léger ballottement (2-3 oscillations qui s'amortissent)

Pour un personnage à cape (Monsieur Obo si tu lui donnes une cape), tu animes la cape sur un layer séparé, avec son propre rythme.

**Layered animation.**

Tu sépares les éléments en layers indépendants :

- `body` : tronc, jambes, bras
- `hair` : cheveux
- `cape` : cape, manteau
- `accessory` : épée, sac, ceinture

Tu peux animer chaque layer à son propre rythme. Le body en walk cycle 8 frames, la cape avec un overlap de 2 frames de retard sur le body. Aseprite permet de manipuler les layers indépendamment dans la timeline.

**Erreurs typiques.**

- Tout bouge en même temps : effet rigide, robotique
- Cape qui suit le corps en synchro parfaite (amplitude identique, pas de retard) : paraît collée
- Follow through trop long : la cape "flotte" dans le vide pendant 6 frames après l'arrêt
- Pas de pondération : tout est animé avec la même amplitude, alors qu'en réalité les extrémités bougent plus que les points d'attache

## Démonstration

- Chaîne AlanBeckerTutorials, "12 Principles of Animation" épisode 5 (Follow Through and Overlapping Action). Démonstration claire avec une fille à queue de cheval.
- Chaîne MortMort, "Pixel Art Animation - Cape and Hair" (rechercher). Application pixel art.
- Chaîne AdamCYounis, "How I Animate Capes" (rechercher).
- Chaîne HYUN's dojo, animation de combat avec capes et cheveux dynamiques (rechercher).

## Exercice pratique

Sur un canvas 64x64, mode Indexed avec palette 8 couleurs, anime un personnage simple 32px qui se déplace de gauche à droite et s'arrête sec. Le personnage a une cape (rectangle de 4-6 pixels qui pend dans le dos).

12 frames :

- Frame 1-2 : départ depuis position arrêtée à gauche, cape qui commence à se soulever en arrière
- Frame 3-7 : course vers la droite, cape qui flotte horizontalement vers l'arrière
- Frame 8 : arrêt brutal au centre droite, corps figé
- Frame 9-11 : cape qui continue vers l'avant (follow through), passe au-dessus du corps, retombe
- Frame 12 : cape qui revient en position de repos, légèrement balancée

Layers :

- `body` : le personnage
- `cape` : la cape, animée séparément avec retard

Vérifie : sur la frame 8 (arrêt), la cape doit être encore dirigée vers l'avant (overlap visible). Frame 9, elle est plus loin vers l'avant que sur la frame 8. Elle ne s'arrête qu'à la frame 11.

## Critère de validation binaire

OUI si :

- Le canvas fait 64x64
- L'animation contient 12 frames
- 2 layers existent : `body` et `cape`
- Sur la frame 8 (arrêt du body), la cape est encore en mouvement (position différente de la position de repos)
- Sur les frames 9-11, la cape continue vers l'avant après que le body soit immobile
- Sur la frame 12, la cape est revenue ou presque à sa position de repos
- L'amplitude du mouvement de la cape est supérieure à celle du body sur les frames de course
- Mode Indexed, palette 8 couleurs maximum

NON sinon.

## Livrables

```
assets/phase-3/lesson-5-follow-through/
  source.aseprite
  cape.gif
  spritesheet.png
  spritesheet.json
```
