# 4.2 - Idle Obo 48x48

## Durée estimée

8h

## Objectif d'apprentissage

Animer l'idle de Monsieur Obo dans les 4 directions, en respectant le character sheet et la palette définitive.

## Théorie

L'idle est l'animation par défaut quand le joueur ne contrôle pas Obo. Vu que le jeu est un roguelike narratif, Obo passe beaucoup de temps idle (lecture de dialogue, exploration calme). L'idle doit donc être convaincant et confortable à regarder en boucle.

**Cahier des charges Obo idle.**

- 4 versions : front, back, left, right
- 6 frames par version
- Frame duration : 200-250ms (lente, calme)
- Mouvement vertical : 1 pixel d'amplitude (subtil)
- Si Obo a une cape : ondulation très légère sur layer séparé
- Si Obo a un chapeau ou élément en hauteur : oscillation décalée d'1 frame par rapport au body
- Loop parfait

**Workflow.**

1. Ouvre le fichier `front.aseprite` de la leçon 4.1, sauve sous `idle-front.aseprite`
2. Ajoute 5 frames (le sprite statique devient frame 1)
3. Définis les 6 frames selon le cycle vu en leçon 3.6 : neutre, neutre, étiré, neutre, tassé, neutre
4. Active onion skin
5. Anime le body (mouvement vertical 1 pixel). Si cape : layer séparé, mouvement avec retard 1 frame
6. Tag `idle_front`
7. Reproduis pour les 3 autres directions : `idle-back`, `idle-left`, `idle-right`. Tag chacun.
8. Bonus : tu peux aussi consolider les 4 idles dans un seul fichier `obo-idle.aseprite` avec 4 tags (`idle_front`, `idle_back`, `idle_left`, `idle_right`) couvrant 6 frames chacun (24 frames totales). C'est ce qui sera importé dans Godot.

**Pourquoi consolider en un seul fichier.**

Le plugin Aseprite Wizard pour Godot lit un seul `.aseprite`, génère un SpriteFrames avec autant d'animations que de tags. Si tu as 4 fichiers séparés, tu as 4 SpriteFrames. Plus pénible à gérer en jeu.

Si tu préfères 4 fichiers séparés en début de phase pour itérer plus librement, soit. Mais à la fin de la phase tu consolides.

**Cohérence entre directions.**

Le cycle d'idle doit avoir le même rythme dans les 4 directions : si la frame `étirée` du front est la frame 3, idem pour back, left, right. Sinon le character paraît bizarre quand le joueur change de direction.

**Couleurs et palette.**

Strictement la palette de 16 couleurs définie en leçon 4.1. Aucune dérogation. Si l'animation t'amène à mélanger des index (ex : tu veux ajouter un highlight aux frames étirées), tu utilises les couleurs existantes, tu n'en ajoutes pas.

**Test final.**

Lance la lecture en boucle pendant 1 minute. Si tu te lasses ou si ça paraît "bizarre" quelque part, c'est que :

- Le cycle n'est pas équilibré (pose étirée trop longue, pose tassée trop courte)
- Le loop a un saut quelque part
- L'amplitude est trop forte (Obo "saute" sur place)
- L'amplitude est trop faible (Obo paraît figé)

## Démonstration

- Voir leçon 3.6 (idle animation, démonstrations déjà listées)
- Référence sprite : Stardew Valley, idles 4 directions du joueur. Excellent exemple de subtilité.
- Référence : Hyper Light Drifter, idle minimaliste.
- Chaîne MortMort, "How to Animate Idle for Top-Down Game" (rechercher).

## Exercice pratique

Reprends le turnaround de la leçon 4.1.

1. Crée 4 fichiers `idle-front.aseprite`, `idle-back.aseprite`, `idle-left.aseprite`, `idle-right.aseprite` à partir des sprites de la leçon 4.1
2. Anime chacun en idle 6 frames selon le brief
3. À la fin, consolide les 4 dans un fichier unique `obo-idle.aseprite` avec 4 tags
4. Exporte le spritesheet horizontal (24 frames de 48x48 = 1152x48 pixels) et le JSON
5. Vérifie le JSON : tu dois avoir 4 entrées dans `meta.frameTags` (idle_front, idle_back, idle_left, idle_right)

## Critère de validation binaire

OUI si :

- Le fichier `obo-idle.aseprite` existe et fait 48x48
- Il contient 24 frames
- Il contient 4 tags : `idle_front` (frames 1-6), `idle_back` (7-12), `idle_left` (13-18), `idle_right` (19-24)
- Mode Indexed, palette 16 couleurs maximum strictement identique au character sheet de la leçon 4.1
- L'amplitude verticale du body est de 2 pixels (1 au-dessus, 1 en-dessous du neutre) sur chacune des 4 directions
- Le loop est parfait sur chacune des 4 directions
- Le rythme du cycle est identique dans les 4 directions (frame étirée = même position dans la séquence)
- Le spritesheet exporté fait 1152x48 pixels
- Le JSON contient les 4 tags listés

NON sinon.

## Livrables

```
assets/phase-4/lesson-2-idle/
  idle-front.aseprite
  idle-back.aseprite
  idle-left.aseprite
  idle-right.aseprite
  obo-idle.aseprite
  obo-idle.png
  obo-idle.json
  idle-front.gif
  idle-back.gif
  idle-left.gif
  idle-right.gif
```
