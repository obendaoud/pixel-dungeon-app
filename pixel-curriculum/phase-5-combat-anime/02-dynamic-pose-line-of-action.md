# 5.2 - Pose dynamique et line of action

## Durée estimée

16h

## Objectif d'apprentissage

Concevoir des poses dynamiques en pixel art en utilisant la "line of action" (ligne d'action) pour communiquer mouvement, énergie et intention.

## Théorie

La line of action est la ligne imaginaire qui traverse une figure du sommet de la tête jusqu'aux pieds, et qui résume la direction et l'énergie du mouvement. Une bonne pose dynamique a une line of action clairement courbée : C, S, ou diagonale forte.

**Pose statique vs pose dynamique.**

- Statique : symétrique, debout, ligne droite verticale. Stable mais sans énergie.
- Dynamique : asymétrique, en mouvement, ligne courbe ou diagonale. Énergie, tension, action.

**Les lines of action canoniques.**

1. **C-curve** : courbe simple, du haut au bas, en arc. Pose qui se déploie (saut, étirement, lancer).
2. **S-curve** : courbe en S, double inflexion. Pose élégante, féminine, ou puissante (spin kick, fouet).
3. **Diagonale forte** : ligne presque droite mais inclinée à 30-60°. Pose en charge, en course, ou en attaque frontale.
4. **L** ou **angle dur** : pose abrupte (pause après un coup, pose de garde).

**Construction d'une pose dynamique.**

1. Trace la line of action en premier (1 trait sur un layer guide)
2. Trace le squelette autour de cette ligne, en collant les masses (tête, torse, hanches) le long de la ligne
3. Pose les bras et les jambes dans des directions qui contrastent avec la line of action (pour augmenter la tension)
4. Vérifie l'asymétrie : aucun membre ne doit être dans une position "miroir parfait" d'un autre
5. Ajoute la masse, le shading, les détails

**Contrapposto.**

Le poids du corps repose principalement sur une jambe. L'autre est légèrement décalée, fléchie, en touche au sol mais pas en charge. Les hanches s'inclinent vers la jambe d'appui, les épaules s'inclinent dans le sens opposé. Cette double inclinaison (hanches d'un côté, épaules de l'autre) crée naturellement une S-curve.

C'est la pose statique "non-statique" : le character est immobile, mais sa pose suggère qu'il pourrait bouger.

**Foreshortening.**

Raccourci : un membre dirigé vers ou loin du spectateur paraît plus court. Bras tendu en avant : la main paraît grosse, l'avant-bras court. Au pixel art à 128x128, le foreshortening doit être exagéré : les éléments en avant-plan sont 1.5-2x plus grands que la même taille en plan moyen.

**Exagération.**

Pour qu'une pose dynamique lise en pixel art, tu exagères :

- Si le bras est tendu, il est tendu plus loin que l'anatomie réelle le permet
- Si la jambe est fléchie, le genou est plus haut que l'anatomie réelle
- Si le buste se penche, il se penche plus que l'anatomie réelle

Sans cette exagération, les poses paraissent timides en pixel art à basse résolution.

**Line of action exemples spécifiques.**

- **Pose de garde de combat** : line en S léger, contrapposto, poids sur jambe arrière, bras avant tendu en garde
- **Coup de poing en charge** : diagonale forte, buste penché en avant, bras armé en arrière (anticipation forte vu en 5.3)
- **Saut latéral** : C-curve très prononcé, jambes regroupées, bras déployés
- **Atterrissage explosif** : L inversé, jambes pliées en bas, bras en stabilisation

## Démonstration

- Livre "Force: Dynamic Life Drawing" de Mike Mattesi. Référence absolue sur la line of action.
- Chaîne Sinix Design, "Drawing Force" et "Dynamic Poses" (rechercher).
- Chaîne Proko, "Gesture Drawing" series (rechercher). Théorie de gesture appliquée.
- Chaîne HYUN's dojo, démonstrations pixel art en combat (rechercher "HYUN dynamic pose pixel art").
- Référence visuelle : sprites de KOF XIII (chaque character a 30+ poses dynamiques), Garou Mark of the Wolves, Street Fighter III: Third Strike.
- Frames JJK saison 1 vs saison 2 : study frames à l'arrêt pour observer les lines of action en animation TV anime.

## Exercice pratique

Reprends le character de la leçon 5.1 (statique). Anime-le dans 4 poses dynamiques différentes (frames statiques uniquement, pas d'animation entre les poses).

Pour chaque pose : un fichier `pose-X.aseprite` de 128x128. Le character doit avoir une line of action différente sur chacune des 4 poses :

1. `pose-1-guard.aseprite` : pose de garde de combat (S-curve léger)
2. `pose-2-charge.aseprite` : préparation d'attaque (diagonale forte)
3. `pose-3-jump.aseprite` : en suspension (C-curve)
4. `pose-4-impact.aseprite` : pose au moment d'un impact (L ou angle dur)

Sur un layer guide séparé (pas exporté), trace la line of action en rouge pour chaque pose. Garde ce layer pour la review.

Compose les 4 poses sur un canvas 512x128 : `poses-overview.aseprite`, qui montre les 4 alignées.

## Critère de validation binaire

OUI si :

- 4 fichiers `pose-X.aseprite` produits, 128x128 chacun
- 1 fichier `poses-overview.aseprite` 512x128 produit
- Mode Indexed, palette identique à celle de la leçon 5.1
- Chaque pose a une line of action **visiblement différente** des 3 autres (vérifiable sur le layer guide)
- Aucune des 4 poses n'est symétrique gauche-droite (test : si tu plies l'image en deux à la verticale, les deux moitiés ne se ressemblent pas)
- Au moins 1 pose montre du foreshortening clair (un membre apparaît plus grand qu'il ne le serait en proportion plate)
- Au moins 1 pose montre du contrapposto (hanches d'un côté, épaules de l'autre)
- Les proportions du character (hauteur en têtes, largeur épaules) restent identiques à la leçon 5.1 sur les 4 poses

NON sinon.

## Livrables

```
assets/phase-5/lesson-2-dynamic-pose/
  pose-1-guard.aseprite
  pose-2-charge.aseprite
  pose-3-jump.aseprite
  pose-4-impact.aseprite
  poses-overview.aseprite
  poses-overview.png
  poses-overview-x2.png
  notes.md     (analyse des 4 lines of action)
```
