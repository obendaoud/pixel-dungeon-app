# 3.8 - Run cycle 8 frames

## Durée estimée

12h

## Objectif d'apprentissage

Animer un run cycle 8 frames qui se distingue clairement du walk : pose plus penchée, amplitude plus large, suspension visible.

## Théorie

Un run n'est pas un walk plus rapide. C'est un mouvement physiquement différent. La distinction clé : pendant un walk, au moins un pied touche toujours le sol. Pendant un run, il y a un moment où **les deux pieds sont en l'air** (suspension).

**Différences walk / run.**

| Caractéristique | Walk | Run |
|-----------------|------|-----|
| Contact sol | Toujours 1 pied min | Phase de suspension (0 pied) |
| Buste | Légèrement penché vers l'avant | Penché plus fort vers l'avant |
| Amplitude bras | Modérée | Large, pliés à 90° |
| Amplitude jambes | Moyenne | Large, genou avant levé haut |
| Hanches | Oscillation 2px | Oscillation 3-4px |
| Tête | Stable | Plus mobile, accompagne le mouvement |

**Les 4 poses clés du run cycle.**

1. **Contact (gauche)** : le pied gauche touche le sol, jambe droite levée loin derrière. Bras opposés écartés.
2. **Recoil (gauche)** : compression, hanches au plus bas, jambe droite qui passe.
3. **Passing / Suspension** : LES DEUX PIEDS EN L'AIR. Hanches au plus haut. C'est la frame qui définit "run vs walk".
4. **High-point** : juste avant le contact suivant, jambe droite tendue vers l'avant.

Puis symétrique pour l'autre jambe (frames 5-8).

**Frame de suspension.**

Critique. Sur cette frame, le character est en l'air, jambes croisées au passage, hanches au plus haut, buste très penché, bras au point neutre. C'est cette frame qui fait que le run lit comme un run.

Si tu omets la suspension (les pieds restent au contact), tu obtiens un walk rapide, pas un run.

**Hauteur de la jambe avant.**

Au contact, le pied avant n'est pas au sol "naturellement" : il vient d'être levé haut, genou à 70-90°, et il s'apprête à toucher. Tu vois souvent le talon en premier en réalité, mais en pixel art à 32-48 pixels c'est souvent simplifié en un contact pied plat.

**Amplitude des bras en run.**

Bras pliés à 90°, balancement large (presque verticale au pic du mouvement). En run sprint, les bras peuvent monter jusqu'au menton (avant) et descendre jusqu'à la hanche (arrière). Plus c'est ample, plus le run paraît énergique.

**Hair / cape en run.**

Plus important qu'en walk. Les cheveux et la cape doivent se balancer fortement. Une cape qui ne bouge pas pendant un run paraît collée. Tu animes la cape sur un layer séparé avec une amplitude 1.5-2x celle du body.

**Timing du run.**

Plus rapide que le walk. À 12 fps, un run cycle de 8 frames dure aussi 0.67s, mais comme il couvre plus de distance "virtuelle" (ou en jeu, le sprite se déplace plus vite), il paraît plus dynamique.

Frame duration typique : 60-70ms (vs 80-90ms pour un walk).

**Erreurs typiques.**

- Pas de frame de suspension : le run paraît être un walk rapide
- Buste droit comme en walk : il n'a pas l'air de courir, juste de marcher vite
- Bras tendus : perte de l'effet "pliés à 90°"
- Pas de variation par rapport au walk : tu refais le walk au lieu de réinventer la mécanique

## Démonstration

- Chaîne AlanBeckerTutorials, "How to Animate a Run Cycle" (rechercher). Démonstration didactique.
- Chaîne MortMort, "Pixel Art Run Cycle" (rechercher). Application pixel.
- Chaîne Pixel Pete, "Run Cycle Tutorial" (rechercher).
- Chaîne HYUN's dojo, exemples de run cycles dynamiques (rechercher "HYUN run cycle pixel art"). Très utile pour la phase 5.
- Référence sprite : Persona 5, Pixel Art Academy, Octopath Traveler. Beaucoup de runs anime / shonen-flavored.

## Exercice pratique

Reprends le character de la leçon 3.7 (ou crée-en un similaire). Anime un run cycle 8 frames in-place.

Étapes :

1. Dessine la frame 1 (contact gauche, jambe avant levée haut, buste penché en avant)
2. Dessine la frame 3 (suspension : LES DEUX PIEDS EN L'AIR, hanches au plus haut)
3. Dessine la frame 5 (contact droite, miroir de frame 1)
4. Dessine la frame 7 (suspension droite, miroir de frame 3)
5. Place les inbetweens 2, 4, 6, 8 avec onion skin
6. Vérifie : sur frames 3 et 7, les deux pieds sont en l'air visiblement (genou plié pour la jambe avant, jambe arrière étirée)
7. Anime la cape ou les cheveux sur un layer séparé avec amplitude 1.5-2x celle du body
8. Tag `run`, frame duration 65ms, loop activé

## Critère de validation binaire

OUI si :

- Le canvas fait 48x48
- L'animation contient exactement 8 frames
- Mode Indexed, palette 16 couleurs maximum
- Sur la frame 3 ET la frame 7, les deux pieds du character sont au-dessus du niveau du sol (suspension visible)
- Le buste est plus penché vers l'avant que dans le walk cycle de la leçon 3.7 (vérifiable en comparant les deux fichiers)
- Les bras sont pliés à environ 90° et leur amplitude est plus large que dans le walk
- L'oscillation verticale des hanches est de 3-4 pixels d'amplitude (vs 2 dans le walk)
- Si présence de cape ou cheveux : amplitude au moins 1.5x celle du walk
- Le tag `run` couvre les 8 frames
- Le loop est parfait

NON sinon.

## Livrables

```
assets/phase-3/lesson-8-run-cycle/
  source.aseprite
  run.gif
  spritesheet.png
  spritesheet.json
  walk-vs-run.png         (planche comparative côte à côte des deux cycles)
```
