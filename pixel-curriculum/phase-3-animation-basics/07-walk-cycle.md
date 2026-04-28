# 3.7 - Walk cycle 8 frames

## Durée estimée

12h

## Objectif d'apprentissage

Animer un walk cycle 8 frames complet en pixel art, avec les 4 poses canoniques et les inbetweens corrects.

## Théorie

Le walk cycle est la deuxième animation canonique après le bouncing ball. Il intègre presque tous les principes : timing, spacing, anticipation (jambe avant), follow through (cape, cheveux), arcs (mouvement des hanches), squash and stretch (poids sur la jambe d'appui).

**Les 4 poses clés du walk cycle.**

Un walk cycle se construit autour de 4 poses canoniques. Une fois ces 4 poses placées, les 4 inbetweens se déduisent.

1. **Contact (gauche)** : la jambe gauche touche le sol au talon, l'autre est en arrière en l'air. Bras opposé en avant (bras droit avance avec jambe gauche).
2. **Down (gauche)** : tout le poids sur la jambe gauche. Genou plié, hanches au plus bas. C'est le creux du cycle.
3. **Pass (gauche)** : la jambe gauche supporte, l'autre passe à côté. Hanches remontent, en transition.
4. **Up (gauche)** : poussée verticale, jambe gauche tendue, hanches au plus haut. Pic du cycle.
5. **Contact (droite)** : symétrique de 1 mais inversé (jambe droite au sol).
6. **Down (droite)** : symétrique de 2.
7. **Pass (droite)** : symétrique de 3.
8. **Up (droite)** : symétrique de 4.

Note : un walk cycle complet est constitué de DEUX pas (un pas gauche, un pas droit), pas un seul. Si tu n'animes qu'un pas, le character va boiter.

**Mouvement vertical des hanches.**

Au pass / contact, hanches niveau "neutre". Au down, hanches au plus bas (1-2 pixels en dessous). Au up, hanches au plus haut (1-2 pixels au-dessus). Cette oscillation de 2-3 pixels en amplitude est ce qui donne le poids du walk.

**Mouvement des bras.**

Inversé par rapport aux jambes (bras gauche avance avec jambe droite). Amplitude similaire à celle des jambes (un peu plus subtile pour un walk neutre, plus marquée pour un walk déterminé / militaire / fâché).

**Tilt du buste.**

Le buste se penche légèrement vers la jambe d'appui (1-2 pixels). Sur le contact gauche, buste légèrement vers la gauche, etc. Pas obligatoire mais ajoute du naturel.

**Walk personality.**

Le walk neutre (description ci-dessus) est la base. Variations possibles :

- Walk lourd (boss, ennemi imposant) : amplitude verticale réduite, durée allongée, frames plus tenues
- Walk énergique (héros déterminé) : amplitude réduite, vitesse augmentée, bras qui se balancent largement
- Walk furtif (voleur) : pas de mouvement vertical, glisse au sol, légèrement penché en avant
- Walk maladroit / blessé (boitement) : asymétrie volontaire entre jambe gauche et droite

**Timing.**

À 12 fps, un walk cycle de 8 frames dure 8 / 12 = 0.67 secondes. C'est un walk modérément rapide. Pour un walk lent : 12 frames sur 8 frames de timing.

Frame duration : souvent constant (~80ms), ou variable avec les contact frames un peu plus longues (90ms) et les pass plus courtes (70ms).

**Walk cycle : in-place vs traveling.**

- In-place : le character marche sur place, les pieds bougent mais le corps ne se déplace pas. Utilisé en jeu où le déplacement est géré par le moteur (Godot translate le sprite, le walk cycle est juste l'animation).
- Traveling : le character avance dans le canvas. Pour vidéo / GIF de démonstration uniquement.

Pour Monsieur Obo on travaille en in-place (Godot gère le déplacement).

## Démonstration

- Chaîne AlanBeckerTutorials, "How to Animate a Walk Cycle" (rechercher). Référence absolue, démontre les 4 poses clés.
- Chaîne Pixel Pete, "Pixel Art Walk Cycle" (rechercher). Application pixel art directe.
- Chaîne MortMort, "Pixel Art Walk Cycle Tutorial" (rechercher).
- Chaîne AdamCYounis, "How I Animate Walk Cycles" (rechercher).
- Référence vintage : tutoriel de Richard Williams "The Animator's Survival Kit" (livre, chapitre walk cycles). Indispensable si tu veux pousser plus loin.

## Exercice pratique

Sur un canvas 48x48, mode Indexed avec palette 16 couleurs, anime un walk cycle 8 frames in-place d'un personnage humanoïde 32-40 pixels de haut.

Étapes recommandées :

1. Dessine la frame 1 (contact gauche)
2. Dessine la frame 5 (contact droite, miroir de frame 1)
3. Dessine la frame 3 (pass gauche)
4. Dessine la frame 7 (pass droite)
5. Avec onion skin, place les inbetweens : frame 2 (down gauche), frame 4 (up gauche), frame 6 (down droite), frame 8 (up droite)
6. Vérifie l'oscillation des hanches : 2 pixels d'amplitude (1 au-dessus, 1 en-dessous du neutre)
7. Vérifie le mouvement inversé des bras
8. Tag `walk`, frame duration 80ms, loop activé

## Critère de validation binaire

OUI si :

- Le canvas fait 48x48
- L'animation contient exactement 8 frames
- Mode Indexed, palette 16 couleurs maximum
- La frame 1 et la frame 5 sont l'une le miroir de l'autre (jambes inversées) avec exactement la même hauteur de hanches
- Les bras bougent en opposition aux jambes (vérifiable : sur la frame 1, le bras opposé à la jambe avant est en avant)
- L'oscillation verticale des hanches est exactement de 2 pixels d'amplitude entre frames `down` et `up`
- Le tag `walk` couvre les 8 frames
- Le loop est parfait (lecture continue 30s sans à-coup au passage frame 8 -> frame 1)
- Le character maintient sa palette GBC étendue (16 couleurs)

NON sinon.

## Livrables

```
assets/phase-3/lesson-7-walk-cycle/
  source.aseprite
  walk.gif
  spritesheet.png
  spritesheet.json
  notes.md       (description du character animé, choix de personnalité du walk)
```
