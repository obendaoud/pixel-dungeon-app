# 3.4 - Anticipation

## Durée estimée

6h

## Objectif d'apprentissage

Animer un mouvement avec une anticipation lisible : phase préparatoire qui annonce l'action principale.

## Théorie

L'anticipation est le mouvement opposé à l'action principale, fait juste avant. Tu te baisses avant de sauter (anticipation : compression vers le bas, action : extension vers le haut). Tu armes le bras vers l'arrière avant de frapper (anticipation : recul, action : projection avant).

**Pourquoi.** Trois fonctions :

1. **Lisibilité.** Le spectateur voit que quelque chose va arriver. Sans anticipation, l'action est sèche, soudaine, mal lue.
2. **Crédibilité physique.** Les corps réels accumulent l'énergie avant de la libérer. Pas d'anticipation = action qui paraît téléportée.
3. **Drama.** L'anticipation crée la tension. Plus elle est longue, plus l'action qui suit paraît puissante.

**Règle pour le ratio anticipation / action.**

Action explosive : anticipation longue (4-6 frames), action courte (2-3 frames). C'est l'inverse intuitif. Le coup le plus fort a la plus longue préparation.

Action progressive : anticipation courte (1-2 frames), action longue (8-10 frames). Mouvement doux qui ne nécessite pas de bouchée d'air.

**Exemples.**

- Saut vertical : anticipation = squat (compression genoux). Action = extension verticale + suspension.
- Coup de poing : anticipation = bras qui recule, épaule qui se replie. Action = bras qui s'étend.
- Démarrage de course : anticipation = poids qui se transfère sur la jambe arrière, buste vers l'avant. Action = poussée et premier pas.
- Hit reaction : anticipation = corps qui se contracte. Action = recul violent.

**Anticipation inversée.** Une anticipation peut aussi être au-dessus de la position de repos (un bras qui se lève avant de frapper vers le bas). Ce qui compte : c'est un mouvement opposé à l'action principale.

**Exagération.** En pixel art à basse résolution, l'anticipation doit être PLUS marquée qu'en réalité. Si tu te baises de 10cm en vrai avant un saut, ton sprite doit se baisser de 4-5 pixels (significatif sur 32-48px). Sinon c'est imperceptible.

**Hold sur la frame d'anticipation.** Souvent on tient la frame de pic d'anticipation 2-3 fois plus longtemps que les frames de transition. Effet : le spectateur "voit" la préparation, anticipe l'action.

**Couplage avec l'action.** Anticipation + action forme une unité. Tu n'animes pas les deux séparément. L'arc de mouvement va de la pose anticipée à la pose finale, en passant par la pose de repos. L'anticipation est le point le plus à l'opposé de la pose finale.

**Erreurs typiques.**

- Pas d'anticipation : action sèche
- Anticipation trop courte : non perçue
- Anticipation dans le mauvais sens : tu te penches en avant pour sauter en avant. Mauvais (devrait être en arrière, contre-mouvement)
- Trop d'anticipation : on attend trop longtemps, l'action perd son impact

## Démonstration

- Chaîne AlanBeckerTutorials, "12 Principles of Animation" épisode 2 (Anticipation). Démonstration claire.
- Chaîne MortMort, "Pixel Art Animation - Anticipation" (rechercher). Application pixel art.
- Chaîne Toyoxi, animation de combat sur Twitter / YouTube. Voir spécifiquement les anticipations exagérées (rechercher "Toyoxi animation").
- Exemples shonen : épisode aléatoire de Demon Slayer ou JJK pour observer l'anticipation très exagérée des coups (souvent 6-12 frames, animation TV à 24 fps).

## Exercice pratique

Sur un canvas 48x48, mode Indexed avec palette 8 couleurs, animation de 8 frames, produis un personnage 24px (silhouette simple, stick figure ou bonhomme basique) qui :

1. Frame 1-2 : pose de repos (debout)
2. Frame 3-4 : anticipation (squat, compression)
3. Frame 5 : action (extension verticale, saut)
4. Frame 6-7 : sommet du saut, suspension
5. Frame 8 : retour vers la pose de repos (transition)

Frame duration variable :

- Frame 1 : 200ms (hold de repos)
- Frame 2-3 : 60ms (transition rapide vers l'anticipation)
- Frame 4 : 150ms (hold d'anticipation, le spectateur voit la préparation)
- Frame 5 : 40ms (action explosive, très rapide)
- Frame 6-7 : 80ms chacune
- Frame 8 : 100ms (atterrissage)

Tu obtiens un saut avec anticipation visible et action explosive courte.

## Critère de validation binaire

OUI si :

- Le canvas fait 48x48
- L'animation contient 8 frames
- La frame 4 montre le personnage clairement plus bas et plus compressé que la frame 1 (anticipation visible)
- La frame 5 montre le personnage au-dessus de la position de repos (action vers le haut)
- La frame 6 ou 7 est à la position la plus haute (sommet du saut)
- La frame d'anticipation (4) a une durée >= 2x celle de la frame d'action (5)
- À la lecture, on voit clairement : préparation (compression), action (envol), retour
- Mode Indexed, palette 8 couleurs maximum

NON sinon.

## Livrables

```
assets/phase-3/lesson-4-anticipation/
  source.aseprite
  jump.gif
  spritesheet.png
  spritesheet.json
```
