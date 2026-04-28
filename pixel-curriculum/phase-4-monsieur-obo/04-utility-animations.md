# 4.4 - Animations utilitaires (interagir, ramasser, parler)

## Durée estimée

12h

## Objectif d'apprentissage

Animer les actions utilitaires d'Obo : interagir avec un objet, ramasser un item, parler (head bob ou expression).

## Théorie

Un roguelike narratif a besoin d'animations contextuelles, pas seulement idle / walk. Pour Monsieur Obo :

- **Interact** : Obo se penche ou tend la main vers un objet à activer (porte, levier)
- **Pickup** : Obo ramasse un item au sol, mouvement de baisser-relever
- **Talk** : Obo parle à un NPC (head bob, mouvement de bouche, ou expression statique animée)

Ces animations sont courtes (4-8 frames), ne loopent pas (one-shot), et sont déclenchées par script.

**Animation `interact`.**

6 frames. Obo en pose neutre, tend le bras avant lui pendant 2-3 frames, le retire en 2-3 frames, retour neutre.

- Frame 1 : pose neutre (= idle frame neutre)
- Frame 2-3 : bras qui se tend (anticipation courte + action)
- Frame 4 : pic d'extension (hold, le moment où l'action fait effet en jeu)
- Frame 5-6 : retour à la pose neutre (rétractation du bras)

Frame duration variable :

- Frame 1 : 60ms (transition rapide depuis idle)
- Frame 2-3 : 60-80ms
- Frame 4 : 200ms (hold qui matche le moment du sound effect en jeu)
- Frame 5-6 : 60-80ms

Total : ~580ms, soit environ 0.6s. Sensation rapide et lisible.

Pour les 4 directions, idem.

**Animation `pickup`.**

8 frames. Obo se baisse, ramasse, se relève.

- Frame 1 : neutre
- Frame 2-3 : baisse-toi (anticipation)
- Frame 4 : pic de baisse (hold, item ramassé conceptuellement)
- Frame 5-6 : retour au neutre (relève)
- Frame 7-8 : pause finale (geste de "j'ai l'item")

Frame duration : 70-100ms par frame. Un pickup doit prendre 0.6-1s pour rester crédible.

Pour les 4 directions, idem.

**Animation `talk`.**

Plus subtile. Pour Monsieur Obo, en perspective top-down, on ne voit pas la bouche. Donc le `talk` peut être :

- Un head bob (la tête monte-descend de 1 pixel) sur 4 frames qui loope tant que la conversation est active
- Un léger mouvement épaules qui simule l'expression
- Optionnel : un point d'exclamation ou point d'interrogation qui apparaît au-dessus si emote

Pour cette leçon, on fait un head bob simple, 4 frames, loop activé. Un seul tag suffit (Obo regarde toujours le NPC, on n'a pas besoin de 4 directions pour talk).

**Bonus : `attack` light** (optionnel).

Si Obo a une attaque dans le jeu (selon GDD), tu peux ajouter une animation d'attaque de base ici. 6-8 frames, anticipation + action explosive + recovery. Mais on peut aussi le réserver pour la phase 5.

**Considérations techniques pour Godot.**

Les animations one-shot doivent être configurées avec `loop = false` dans le SpriteFrames Godot. Le plugin Aseprite Wizard lit le tag direction (`forward`, `pingpong`, `reverse`) du tag Aseprite. Pour interact / pickup, tu mets `forward`, et tu marques `loop = false` dans Godot.

## Démonstration

- Chaîne MortMort, "Pixel Art Action Animations" (rechercher).
- Chaîne AdamCYounis, "How to Animate Character Actions" (rechercher).
- Référence sprite : Stardew Valley pour les animations de pickup et tool use ; Eastward (animations contextuelles riches).

## Exercice pratique

1. Anime `interact` 4 directions, 6 frames par direction, fichier consolidé `obo-interact.aseprite` avec tags `interact_front/back/left/right`
2. Anime `pickup` 4 directions, 8 frames par direction, fichier consolidé `obo-pickup.aseprite` avec tags `pickup_front/back/left/right`
3. Anime `talk` direction unique (Obo de face vers le NPC), 4 frames, loop, fichier `obo-talk.aseprite` avec tag `talk`
4. Exporte chaque fichier en spritesheet + JSON
5. Crée un mini-fichier de référence `obo-actions-reference.png` qui montre les 3 actions côte à côte (front uniquement de chaque, pour overview)

## Critère de validation binaire

OUI si :

- 3 fichiers `.aseprite` (interact, pickup, talk) consolidés produits
- `interact` : 24 frames, 4 tags, 48x48
- `pickup` : 32 frames, 4 tags, 48x48
- `talk` : 4 frames, 1 tag `talk`, 48x48, loop
- Mode Indexed, palette 16 couleurs identique à la sheet, sur tous les fichiers
- L'`interact` a une frame de hold (la plus longue duration) au pic du mouvement (frame 4)
- Le `pickup` a Obo visiblement plus bas (au moins 4 pixels) à la frame 4 qu'à la frame 1
- Le `talk` a un head bob de 1 pixel d'amplitude
- Tous les exports JSON contiennent leurs tags respectifs
- Le fichier de référence overview est produit

NON sinon.

## Livrables

```
assets/phase-4/lesson-4-utility/
  obo-interact.aseprite
  obo-interact.png
  obo-interact.json
  obo-pickup.aseprite
  obo-pickup.png
  obo-pickup.json
  obo-talk.aseprite
  obo-talk.png
  obo-talk.json
  obo-actions-reference.png
  interact-front.gif
  pickup-front.gif
  talk.gif
```
