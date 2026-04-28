# 3.6 - Idle animation

## Durée estimée

8h

## Objectif d'apprentissage

Animer un personnage statique qui "respire" : mouvement subtil de 4 à 6 frames qui rend le personnage vivant sans qu'il se déplace.

## Théorie

L'idle est l'animation par défaut d'un personnage : ce qu'il fait quand le joueur ne lui demande rien. Sans idle, le sprite paraît figé, mort. Avec un bon idle, le character a une présence, une personnalité.

**Anatomie d'un idle de base.**

Sur 4 à 6 frames :

- Pose neutre
- Pose étirée (corps légèrement plus haut, inspiration visuelle)
- Pose neutre
- Pose tassée (corps légèrement plus bas, expiration)
- (loop)

Le mouvement vertical typique fait 1 à 2 pixels d'amplitude. Pas plus. Si c'est plus grand, le character paraît sauter sur place.

Frame duration typique : 200-400ms par frame, soit 3-5 fps. Idle est lent par nature.

**Idles plus complexes.**

- Cligner des yeux : 1 frame avec yeux fermés tous les 2-3 secondes
- Respiration : épaules qui montent / descendent
- Cape qui ondule légèrement
- Tête qui regarde autour (rare en pixel art, demande beaucoup de frames)
- Arme qui se balance subtilement

Tu peux empiler plusieurs idles : un idle "respiration" qui boucle constamment, un idle "blink" qui se déclenche aléatoirement, un idle "stretch" qui se déclenche après 5 secondes d'inactivité.

**Pour Monsieur Obo.**

L'idle d'Obo doit être lent, calme, avec un mouvement vertical de 1 pixel et une cape (s'il en a) qui ondule subtilement. Pas d'expression dramatique. Le character est introspectif (roguelike narratif), l'idle doit refléter ça.

**Erreurs typiques.**

- Idle trop ample : character qui paraît sautiller
- Idle trop rapide : character qui tremble
- Idle parfaitement symétrique (frame 1 = frame 3) : trop régulier, mécanique
- Pas de mouvement secondaire : tout le corps bouge en bloc rigide
- Frames non égales en mouvement : oscillation cassée

**Astuce : décalage des éléments secondaires.**

Si le body monte / descend, la cape doit suivre **avec un léger retard**. La frame où le body est au plus haut, la cape est encore en train de monter. Cette désynchronisation donne du naturel.

**Cas particulier : idle "alerte" vs idle "détendu".**

Un character détendu a une idle ample, lente, avec respiration visible. Un character alerte a une idle plus tendue, avec micro-mouvements rapides (oscillations de 1 pixel à fréquence haute). Tu peux avoir les deux pour le même character selon le contexte de jeu (combat = idle alerte, exploration = idle détendu).

**Outils Aseprite.**

- Onion skin : indispensable pour ajuster les amplitudes
- Frame duration variable : tu peux tenir la pose neutre 2x plus longtemps que les poses étirée / tassée pour donner du rythme
- Layers séparés pour body / cape / cheveux

**Loop parfait.**

L'idle boucle indéfiniment. La frame N doit enchaîner sur la frame 1 sans saut visuel. Test : passe en mode loop, lance la lecture, regarde 30 secondes. Si tu vois un "à-coup" au moment du wrap, le loop est cassé.

## Démonstration

- Chaîne MortMort, "Pixel Art Animation - Idle Cycles" ou "How to Animate Idle" (rechercher). Démo basique.
- Chaîne AdamCYounis, "How I Animate Idle Loops" (rechercher). Approche pro.
- Chaîne HeartBeast, "Pixel Art Idle Animation Tutorial" (rechercher). Avec contexte Godot.
- Sprites de référence : Stardew Valley (idles très subtiles), Hyper Light Drifter (idles minimalistes), Celeste (idle de Madeline avec cheveux qui ondulent).

## Exercice pratique

Reprends le character statique 48x48 de la leçon 2.9 (ou crée-en un autre similaire si tu préfères). Anime son idle sur 6 frames :

1. Frame 1-2 : pose neutre (durée 250ms chacune)
2. Frame 3 : pose étirée (corps 1px plus haut, durée 200ms)
3. Frame 4 : pose neutre (durée 200ms)
4. Frame 5 : pose tassée (corps 1px plus bas, durée 200ms)
5. Frame 6 : pose neutre transition (durée 200ms, retour vers frame 1)

Si le character a une cape ou des cheveux : anime-les sur un layer séparé avec un retard d'1 frame par rapport au body.

Tag les frames `idle`. Loop activé.

## Critère de validation binaire

OUI si :

- Le canvas fait 48x48
- L'animation contient exactement 6 frames
- L'amplitude verticale du body entre la pose la plus haute (frame 3) et la pose la plus basse (frame 5) est de 2 pixels exactement (1 pixel au-dessus, 1 pixel en-dessous de la pose neutre)
- Le character a au minimum 16 couleurs (palette GBC étendue conservée)
- Le tag `idle` couvre les 6 frames
- Le loop est parfait (vérification : lecture 30s sans saut visible)
- Si présence d'une cape ou cheveux : leur mouvement a un retard visible d'1 frame par rapport au body

NON sinon.

## Livrables

```
assets/phase-3/lesson-6-idle/
  source.aseprite
  idle.gif
  spritesheet.png
  spritesheet.json
```
