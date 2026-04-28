# 4.3 - Walk cycle Obo 4 directions

## Durée estimée

16h

## Objectif d'apprentissage

Animer le walk cycle de Monsieur Obo dans les 4 directions, cohérent avec l'idle et la character sheet.

## Théorie

C'est la leçon la plus chronophage de la phase 4. 4 walk cycles à animer en cohérence, chacun de 8 frames, total 32 frames.

**Cahier des charges.**

- 4 walk cycles : front, back, left, right
- 8 frames par cycle (les 4 poses canoniques + 4 inbetweens, vu en leçon 3.7)
- Frame duration : 80ms (12 fps)
- In-place (Godot gère le déplacement réel)
- Mode Indexed, palette identique à la sheet
- Cape ou éléments secondaires animés sur layers séparés
- Loop parfait

**Workflow recommandé.**

1. Anime d'abord le walk **profil** (left ou right). C'est le plus lisible : on voit clairement les jambes et le buste. Tu peux suivre la leçon 3.7 directement.
2. Une fois le profil validé, dérive le **front** : les jambes alternent en avant-arrière mais vues en raccourci. Plus difficile.
3. Dérive le **back** : symétrique du front, vu de dos.
4. Le second profil (right si tu as fait left) est un miroir du premier. Tu peux utiliser Sprite > Flip > Horizontal.

**Différences de difficulté entre les 4 vues.**

- **Profil** : facile, tu vois la mécanique du pas clairement
- **Front / Back** : moyen, le mouvement des jambes est plus subtil (raccourci frontal), tu compenses par un balancement des bras et un mouvement de hanches
- En front et back, on simule souvent un walk simple en alternant juste un mouvement de hanches gauche-droite et un léger up-down du body, plus que les jambes elles-mêmes

**Walk en pixel art top-down.**

À 48x48 vu de face, les jambes ne se distinguent pas toujours bien. Astuce : tu n'animes pas vraiment les jambes, tu animes :

- Le body qui balance gauche-droite de 1-2 pixels
- Le body qui monte-descend de 1 pixel
- Les bras (si visibles) qui se balancent en opposition
- La cape ou le manteau qui ondule

C'est ce qu'on appelle un "walk simplifié" pour top-down. Acceptable et lisible.

**Cohérence avec l'idle.**

La transition entre idle et walk dans Godot doit être douce. Pour ça :

- La pose neutre du walk (frame de pass) doit ressembler à la pose neutre de l'idle
- La hauteur du body est la même au repos
- Le character ne change pas de proportions entre idle et walk

**Vitesse.**

Un walk cycle de 8 frames à 12 fps couvre 0.67s. Si Obo se déplace à 2 pixels/tick et qu'un tick fait 16ms, en 0.67s il avance de 0.67/0.016 * 2 = 84 pixels. C'est beaucoup. Tu ajusteras la vitesse de déplacement Godot pour qu'elle soit en accord avec la cadence des pas (ratio "stride" du walk cycle).

**Layered animation pour la cape.**

Si Obo a une cape, layer séparé `cape`. La cape oscille avec un retard d'1-2 frames sur le body et une amplitude légèrement supérieure. Quand Obo marche vers la droite (right), la cape pend légèrement vers la gauche (résistance de l'air). Idem pour les autres directions.

## Démonstration

- Voir leçon 3.7 (walk cycle, démonstrations déjà listées)
- Référence sprite top-down : Stardew Valley, walk 4 directions ; A Link to the Past (Zelda), walk 4 directions ; Children of Morta.
- Chaîne MortMort, "Top-Down Pixel Art Walk Cycle" (rechercher).
- Chaîne HeartBeast, "Walk Animation in Godot" (rechercher).

## Exercice pratique

1. Anime le walk cycle profil (par exemple `walk-right.aseprite`) en 8 frames, en t'inspirant de la leçon 3.7 mais avec Obo en sprite défini par la character sheet
2. Anime `walk-front.aseprite` (8 frames simplifiées, balance gauche-droite + montée-descente)
3. Anime `walk-back.aseprite` (similaire à front, vu de dos)
4. Mirror le walk profil pour obtenir l'autre profil (`walk-left.aseprite` ou `walk-right.aseprite` selon ce que tu as fait en premier)
5. Vérifie la cohérence des 4 cycles : pose neutre identique, hauteur identique
6. Consolide dans `obo-walk.aseprite` avec 4 tags (`walk_front`, `walk_back`, `walk_left`, `walk_right`), 32 frames totales
7. Exporte le spritesheet (1536x48 pixels) + JSON

## Critère de validation binaire

OUI si :

- Le fichier `obo-walk.aseprite` existe, 48x48, 32 frames
- 4 tags présents : `walk_front` (1-8), `walk_back` (9-16), `walk_left` (17-24), `walk_right` (25-32)
- Mode Indexed, palette 16 couleurs identique à la sheet
- Sur le profil : oscillation hanches 2 pixels d'amplitude, bras en opposition aux jambes, frame 1 et frame 5 sont l'inverse l'une de l'autre
- Sur front et back : mouvement vertical du body 1-2 pixels, balancement latéral 1 pixel
- Pose neutre du walk identique en proportion à la pose neutre de l'idle (même hauteur, même silhouette générale)
- Loop parfait sur les 4 cycles
- Si présence de cape : animée sur layer séparé avec retard d'1 frame visible
- Spritesheet exporté à 1536x48, JSON contient les 4 tags

NON sinon.

## Livrables

```
assets/phase-4/lesson-3-walk/
  walk-front.aseprite
  walk-back.aseprite
  walk-left.aseprite
  walk-right.aseprite
  obo-walk.aseprite
  obo-walk.png
  obo-walk.json
  walk-front.gif
  walk-back.gif
  walk-left.gif
  walk-right.gif
```
