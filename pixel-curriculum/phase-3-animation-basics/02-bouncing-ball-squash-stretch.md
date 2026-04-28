# 3.2 - Bouncing ball : squash and stretch

## Durée estimée

6h

## Objectif d'apprentissage

Animer un bouncing ball en pixel art avec squash and stretch convaincant et timing correct, exercice canonique de l'animation.

## Théorie

Le bouncing ball est l'exercice fondateur de l'animation. Il intègre 4 des 12 principes : squash and stretch, timing, slow in / slow out, et arcs. Si tu sais animer une balle propre, tu as les bases. Tous les animateurs Disney commencent par là.

**Anatomie d'un bounce.**

Phase 1 : la balle est en hauteur, en chute. Étirée verticalement (stretch). Les frames se rapprochent à l'approche du sol (slow in inverse, c'est-à-dire accélération).

Phase 2 : la balle touche le sol. Pic d'écrasement (squash). Frame d'impact, la plus écrasée. C'est typiquement 1 frame, parfois 2.

Phase 3 : la balle rebondit. Re-étirée vers le haut. Les frames sont rapprochées au début (vitesse haute), puis s'espacent (slow out vers le sommet).

Phase 4 : sommet de la trajectoire. Balle ronde ou légèrement étirée. C'est le moment où elle "respire". Slow in (frames espacées au sommet, signal de pause).

Phase 5 : retombée, etc.

**Conservation du volume.** Quand la balle s'écrase de 50% en hauteur, elle s'étend de ~20-30% en largeur. Pas de balle qui rétrécit en volume total (sauf si c'est un ballon qui se dégonfle). Tu peux compter les pixels à chaque frame pour vérifier que le total reste à peu près constant.

**Spacing.** Espacement entre frames consécutives. Mouvement rapide = grand spacing, frames espacées. Mouvement lent = petit spacing, frames rapprochées. Tu module le spacing tout au long de la trajectoire pour reproduire l'accélération / décélération.

**Arc.** La trajectoire d'une balle est une parabole, pas une ligne. Tu trace l'arc en pointillé sur ton fichier de référence, et tu places les frames le long de cet arc.

**Timing recommandé pour un bounce simple.**

À 12 fps, un bounce complet (chute + impact + rebond) prend typiquement 12-20 frames. Pour cette leçon on vise 12 frames.

Distribution :

- 4 frames : chute (du sommet au sol), accélération
- 1 frame : impact, squash maximal
- 5 frames : rebond (du sol au sommet), décélération
- 2 frames : pause au sommet, slow in

Adaptable. Plus la balle est lourde (boule de bowling), plus elle "tombe vite" et "rebondit peu". Plus elle est légère (ballon), plus elle "flotte au sommet".

**Outils Aseprite.**

- Onion skin avec 1 frame avant et 1 frame après pour visualiser le spacing
- Frame duration variable : tu peux modifier la durée de chaque frame individuellement dans Properties
- Loop activé pour voir le bounce répéter

**Erreurs typiques.**

- Pas de squash / stretch : la balle paraît rigide
- Squash sur 5 frames consécutives : le squash doit être instantané (1-2 frames maximum)
- Spacing constant : la balle paraît être à vitesse constante, pas naturelle
- Arc oublié : la balle se déplace en ligne droite, pas en parabole
- Volume non conservé : la balle "rétrécit" entre certaines frames

## Démonstration

- Chaîne AlanBeckerTutorials, "12 Principles of Animation" épisode 1 (Squash and Stretch). Démo bouncing ball animée, indispensable.
- Chaîne MortMort, "Pixel Art Animation - Bouncing Ball" (rechercher). Application pixel art directe.
- Chaîne AdamCYounis, "Animation Tutorial - Bouncing Ball" (rechercher). Approche pixel.
- Chaîne Pixel Pete, "Animating a Ball in Pixel Art" (rechercher).

## Exercice pratique

Sur un canvas 64x64, mode Indexed avec palette de 4 couleurs (1 outline + 3 niveaux pour la balle), produis un bouncing ball 12 frames :

1. Crée la frame 1 (sommet, balle étirée légèrement vers le haut)
2. Crée la frame 6 (impact, balle écrasée au sol)
3. Crée la frame 12 (retour au sommet, identique à frame 1 pour le loop)
4. Place les inbetweens (2-5 et 7-11) en utilisant onion skin
5. Frame duration : variable
   - frames de chute (1-5) : durée plus courte vers la fin (accélération)
   - frame d'impact (6) : 80ms
   - frames de rebond (7-11) : durée croissante (décélération)
   - frame sommet (12) : 200ms (pause)
6. Tag les 12 frames `bounce`
7. Loop activé, vérifie que ça boucle proprement

Variante d'entraînement (pas livrable) : refais un deuxième bounce avec la même balle mais en "lourd" (boule de bowling) : moins de hauteur de rebond, plus de squash, retour plus rapide.

## Critère de validation binaire

OUI si :

- Le canvas fait 64x64
- L'animation contient exactement 12 frames
- Mode Indexed, palette de 4 couleurs maximum
- La frame d'impact (6) a une balle visiblement plus large que haute (squash)
- La frame de chute juste avant impact (5) a une balle visiblement étirée verticalement (stretch)
- Le spacing varie : la distance pixel entre frame 1 et 2 doit être plus petite qu'entre frame 4 et 5 (slow out depuis le sommet)
- La frame 12 est identique à la frame 1 (loop parfait)
- À la lecture, tu perçois clairement l'accélération à la chute et la décélération à la montée
- Aucun pixel orphelin, palette stricte respectée

NON sinon.

## Livrables

```
assets/phase-3/lesson-2-bouncing-ball/
  source.aseprite
  bounce.gif
  spritesheet.png        (export horizontal strip 12 frames)
  spritesheet.json
```
