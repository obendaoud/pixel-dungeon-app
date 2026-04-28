# 1.4 - Frames, timeline, onion skin

## Durée estimée

3h

## Objectif d'apprentissage

Créer une animation simple sur la timeline Aseprite, manipuler les frames, et utiliser onion skin pour assurer la continuité entre frames.

## Théorie

L'animation Aseprite repose sur trois concepts : la **frame**, le **cel**, et le **layer**. Une frame est une colonne de la timeline (un instant t). Un layer est une ligne. Un cel est l'intersection : le contenu d'un layer à une frame donnée.

Quand tu ajoutes une frame, par défaut Aseprite duplique le contenu de la frame précédente (paramètre par défaut : `New Frame` duplique). Pour une frame vide, utilise `New Empty Frame`.

**Timeline.** Affichée en bas (Window > Timeline ou Tab). Lignes = layers, colonnes = frames. Tu cliques une cellule pour activer ce cel. Tu peux glisser des cels entre frames pour réorganiser.

**Tags.** Une plage de frames nommée. Très utile pour les spritesheets : tu crées un tag `idle` (frames 1-4), `walk` (frames 5-12), etc. Aseprite exporte les tags en métadonnées JSON, Godot les lit pour créer des animations nommées automatiquement.

**Frame duration.** Chaque frame a une durée individuelle en ms. Modifiable par clic droit sur la frame > Properties > Frame Duration. Une animation à 12 fps a des frames de ~83ms, à 24 fps ~42ms, à 60 fps ~17ms. En pixel art, on travaille souvent en 8 à 12 fps.

**Loop animation.** Touche Enter ou bouton Play en bas. Tu peux régler le loop : Once, Loop, Ping-Pong (aller-retour, rare).

**Onion skin.** Affichage en transparence des frames adjacentes (Tools > Onion Skin ou bouton dédié). Tu vois la frame n-1 et n+1 par-dessus la frame courante. Indispensable pour assurer la continuité entre deux poses. Réglages :

- Frames before : combien de frames avant
- Frames after : combien de frames après
- Opacity : transparence (souvent 50%)
- Color tint : couleur teintée pour distinguer past / future (typiquement rouge passé, vert futur)

**Linked cels.** Si tu veux qu'un layer reste identique sur plusieurs frames (ex : un fond statique), tu lies les cels. Clic droit > Link Cels. Modifier un cel modifie tous les liés.

**Continuous mode.** Quand tu dessines sur la frame N et que tu veux que le pixel apparaisse aussi sur la frame N+1, tu peux activer Continuous (clic droit sur le layer). Risqué : tu écrases vite par mégarde.

**Workflow standard pour une animation à 4 frames :**

1. Crée la frame 1, dessine la pose A
2. Crée la frame 4 (manquante), dessine la pose D (fin)
3. Active onion skin
4. Crée les frames 2 et 3 (entre A et D), dessine les poses intermédiaires en t'aidant de l'onion skin
5. Tag toute la séquence

C'est ce qu'on appelle "key frames first, in-between after". Tu vois ça plus en détail en phase 3.

## Démonstration

- Chaîne MortMort, "Aseprite Tutorial - Animation Basics" (rechercher). Observe : ajout de frame, navigation entre frames, activation onion skin.
- Chaîne AlanBeckerTutorials, "12 Principles of Animation" épisode 3 (Timing) pour comprendre le concept de frame avant le pixel art.
- Chaîne AdamCYounis, "Aseprite for Animation" (rechercher exact). Couvre tags, durée par frame, export.

## Exercice pratique

Construis un sprite 32x32, 4 frames, qui montre un point qui se déplace en losange.

1. Frame 1 : un pixel rouge en (16, 4) - haut
2. Frame 2 : un pixel rouge en (28, 16) - droite
3. Frame 3 : un pixel rouge en (16, 28) - bas
4. Frame 4 : un pixel rouge en (4, 16) - gauche

Active onion skin avec 1 frame avant et 1 frame après pendant que tu travailles.

Tag les 4 frames avec le nom `diamond_loop`. Frame duration : 250ms par frame (donc 4 fps). Loop activé.

Lance la lecture (Enter) et vérifie que le point fait bien un mouvement en losange en boucle.

## Critère de validation binaire

OUI si :

- Le canvas fait 32x32 pixels
- L'animation contient exactement 4 frames
- Chaque frame contient exactement 1 pixel rouge à la position attendue (tolérance : 0 pixel d'écart)
- Un tag nommé `diamond_loop` couvre les 4 frames
- La durée de chaque frame est de 250ms
- À la lecture, l'animation tourne en boucle sans saccade

NON sinon.

## Livrables

```
assets/phase-1/lesson-4-timeline/
  source.aseprite
  export.png             (export première frame)
  export-x4.png
  diamond.gif            (export GIF de l'animation)
```
