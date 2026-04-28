# 3.3 - Timing et spacing

## Durée estimée

6h

## Objectif d'apprentissage

Comprendre la différence entre timing (combien de frames) et spacing (espacement entre frames), et savoir manipuler les deux pour communiquer le poids et l'urgence d'un mouvement.

## Théorie

Timing et spacing sont les deux variables qui contrôlent comment un mouvement est ressenti. Beaucoup de débutants confondent. Distinction stricte :

- **Timing** : combien de frames un mouvement prend. Mesuré en frames ou en millisecondes.
- **Spacing** : où sont placées les frames les unes par rapport aux autres. Distance entre deux frames consécutives.

Tu peux avoir deux animations avec le même timing (12 frames chacune) mais un spacing différent (l'une à vitesse constante, l'autre avec slow in / slow out). Le résultat est totalement différent à l'oeil.

**Timing : règles de base.**

À 12 fps (animation pixel art classique) :

- 1 frame : flash, presque imperceptible (un impact frame, un effet)
- 2-4 frames : très rapide (un coup de poing, un saut)
- 6-8 frames : rapide (un geste de bras, un pas)
- 10-12 frames : modéré (un walk cycle complet, un demi-saut)
- 15-24 frames : lent (un soupir, une transition d'ambiance)
- 30+ frames : très lent (idle, paysage qui défile)

Plus le mouvement est lourd / important, plus tu donnes de frames pour qu'il "respire".

**Spacing : règles de base.**

Sur un mouvement à vitesse constante, les frames sont équidistantes. Un objet qui parcourt 24 pixels en 12 frames à vitesse constante avance de 2 pixels par frame.

Sur un mouvement avec slow in (départ lent, fin rapide), les premières frames sont espacées de 1 pixel, puis 2, puis 3, puis 4. Inversement pour slow out.

Sur un mouvement avec slow in ET slow out (la majorité des mouvements naturels), tu as une cloche : peu d'espacement aux extrêmes, beaucoup au milieu. C'est ce qu'on appelle ease in / ease out.

**Charts.** En animation traditionnelle, tu dessine un "timing chart" : une ligne qui représente le mouvement, avec des marques pour chaque frame. La densité des marques montre le spacing. Outil mental ou tu peux le dessiner sur un layer Aseprite séparé en référence.

**Exemple : un personnage qui lève le bras.**

- Frame 1 : bras le long du corps (pose de départ)
- Frame 8 : bras en l'air (pose finale)

Avec spacing constant (frames 2, 3, 4, 5, 6, 7 équidistantes) : le bras monte mécaniquement, robotique.

Avec slow in / slow out : frames 2, 3 très proches de la pose 1 (départ lent), frames 4, 5 très espacées (vitesse pic au milieu), frames 6, 7 proches de la pose 8 (arrivée lente). Mouvement organique, vivant.

**Holds.** Une frame "tenue" plusieurs fois (durée prolongée). Tu peux avoir une frame pose qui dure 5x une frame de transition. Crée une pause, un beat. Très utile pour la lisibilité d'une action.

**Anticipation et timing.** Une bonne anticipation prend généralement 2 à 4 frames. Le mouvement principal qui suit prend 2 à 6 frames. Le hold final (après l'action) peut durer plusieurs frames pour laisser le spectateur enregistrer.

**Hit stop.** Spécifique au combat. Un "hit stop" est un hold de 2-3 frames sur la frame d'impact d'un coup. Tu freezes l'image au moment où le coup connecte. Donne un feedback visuel et tactile. Tu vois ça en phase 5.

**Erreurs typiques.**

- Spacing constant partout : animation mécanique, sans poids
- Trop peu de frames pour le mouvement : saute (snappy mais lit mal)
- Trop de frames : animation lourde, lente, ennuyeuse
- Pas de hold sur les poses clés : le spectateur n'a pas le temps de lire
- Hold trop long : animation paraît saccadée

## Démonstration

- Chaîne AlanBeckerTutorials, "12 Principles of Animation" épisodes 6 (Slow In Slow Out) et 9 (Timing). Indispensables.
- Chaîne MortMort, "Pixel Art Animation - Timing" (rechercher). Application pixel art.
- Chaîne AdamCYounis, "Animation Timing" (rechercher). Approche pro.
- Chaîne Toyoxi, démonstrations diverses sur Twitter / YouTube de timing variable.

## Exercice pratique

Sur un canvas 64x32 (rectangle horizontal), mode Indexed avec une palette de 4 couleurs, produis 3 versions d'une même animation : un carré 8x8 qui se déplace de gauche à droite sur 48 pixels en 12 frames.

Version A (`linear.aseprite`) : spacing constant, 4 pixels par frame en moyenne.

Version B (`ease-in-out.aseprite`) : spacing en cloche, 1, 2, 4, 5, 6, 6, 6, 6, 5, 4, 2, 1 pixels par frame (la somme fait 48).

Version C (`ease-out.aseprite`) : spacing décroissant, 8, 7, 6, 5, 5, 4, 4, 3, 2, 2, 1, 1 pixels par frame (la somme fait 48). Représente un objet lancé qui ralentit avec friction.

Frame duration : 80ms par frame partout.

À la lecture, tu dois ressentir clairement la différence de "feel" entre les 3.

## Critère de validation binaire

OUI si :

- 3 fichiers `.aseprite` distincts existent
- Chaque fichier fait 64x32, 12 frames, palette 4 couleurs
- Le carré démarre à la même position (par exemple x=4) et finit à la même position (par exemple x=52) dans les 3 versions
- La somme des spacings de chaque version fait bien 48
- La version A a un spacing constant (pas plus de 1 pixel d'écart entre les frames)
- La version B a un spacing en cloche : la frame milieu (5 ou 6) doit avoir le plus grand pas, les frames extrêmes le plus petit
- La version C a un spacing strictement décroissant
- À la lecture, les 3 versions paraissent visiblement différentes

NON sinon.

## Livrables

```
assets/phase-3/lesson-3-timing-spacing/
  linear.aseprite
  ease-in-out.aseprite
  ease-out.aseprite
  linear.gif
  ease-in-out.gif
  ease-out.gif
```
