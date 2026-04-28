# 1.6 - Export PNG et spritesheet pour Godot

## Durée estimée

2h

## Objectif d'apprentissage

Exporter un sprite Aseprite en PNG simple et en spritesheet (PNG + JSON), et importer correctement le résultat dans Godot 4 via AnimatedSprite2D.

## Théorie

Aseprite produit deux types d'exports utiles :

**1. Export PNG simple.** File > Export Sprite Sheet ou File > Export As. Tu obtiens un PNG d'une frame ou de toutes les frames empilées. Suffit pour un sprite statique.

**2. Spritesheet + JSON.** L'export complet pour un moteur de jeu. Tu obtiens un PNG qui contient toutes les frames côte à côte (ou en grille), et un fichier JSON qui décrit la position de chaque frame, les tags, les durées.

**Paramètres d'export importants** dans File > Export Sprite Sheet :

- **Layout** : choisis entre `Horizontal Strip`, `Vertical Strip`, `Rows`, `Columns`, `Packed`. Pour Godot 4, `Horizontal Strip` est le plus simple.
- **Frames** : choisis `All Frames` ou un tag spécifique
- **Border padding** : 0 pour Godot AnimatedSprite2D, sinon 1 ou 2 si tu veux éviter le bleed entre frames (utile pour les tilesets, pas pour les sprites)
- **Trim Sprite** : désactivé. Sinon Aseprite recadre chaque frame, ce qui casse l'animation si la silhouette change de taille.
- **Output** : coche `Output File` (le PNG) et `JSON Data`. Pour le JSON, choisis `Hash` (objet par frame) ou `Array` (array). Godot accepte les deux mais `Array` est plus simple à parcourir.
- **Meta** : coche `Tags` pour exporter les tags d'animation, `Layers` si tu as des layers multiples à conserver, `Slices` si tu utilises les slices.

**Convention de nommage.**

Pour Monsieur Obo, on adopte le format suivant :

- Source : `obo_idle.aseprite`
- Spritesheet : `obo_idle.png`
- JSON : `obo_idle.json`

Une animation = un fichier `.aseprite`. Si tu as plusieurs animations dans le même fichier (idle + walk + attack), tu utilises les **tags** et tu exportes un seul spritesheet avec les tags conservés dans le JSON.

**Import dans Godot 4.**

Deux approches :

**A. AnimatedSprite2D + SpriteFrames** (simple, recommandé pour démarrer)

1. Dans Godot, glisse le PNG dans le projet
2. Dans le panneau Import, configure : Filter = OFF (pixel art), Mipmaps = OFF
3. Crée une scène avec un nœud AnimatedSprite2D
4. Dans l'Inspector, clique sur le champ Sprite Frames > New SpriteFrames
5. Édite > "From Spritesheet" > sélectionne le PNG > définis horizontal frames / vertical frames
6. Crée des animations nommées (idle, walk) et assigne les frames

**B. Import via plugin Aseprite Wizard** (recommandé à terme)

Le plugin "Aseprite Wizard" pour Godot 4 lit directement le `.aseprite` (ou le PNG + JSON exporté) et génère automatiquement les SpriteFrames avec les tags comme animations. À installer en phase 4.

**Filter = OFF.** Critique pour le pixel art : sans ça, Godot lisse les pixels et tu obtiens un sprite flou. Project Settings > Rendering > Textures > Default Texture Filter = `Nearest`.

**Snap pixel.** Project Settings > Rendering > 2D > Snap 2D Transforms To Pixel = ON. Évite les sprites qui clignotent en demi-pixel.

## Démonstration

- Chaîne Aseprite officielle, "Sprite Sheet Export" (rechercher). Observe les options Layout, Trim, Output.
- Chaîne GDQuest ou HeartBeast, "Godot 4 Aseprite Pixel Art Setup" (rechercher exact, plusieurs vidéos disponibles). Observe Filter = Nearest, Snap pixel, et l'import du spritesheet.
- Documentation officielle Godot : `docs.godotengine.org` > AnimatedSprite2D.

## Exercice pratique

1. Reprends ton fichier de la leçon 1.4 (`diamond_loop`) ou crée un sprite 32x32 avec 4 frames d'une animation simple
2. Exporte en File > Export Sprite Sheet :
   - Layout : Horizontal Strip
   - Border padding : 0
   - Output File : `diamond.png`
   - JSON Data : Array, fichier `diamond.json`
   - Tags : coché
3. Vérifie le PNG : doit faire 128x32 pixels (4 frames de 32x32 alignées)
4. Vérifie le JSON : doit contenir un array `frames`, chaque entrée avec `frame: {x, y, w, h}` et `duration`. Le tag `diamond_loop` doit apparaître dans `meta.frameTags`.
5. Crée un mini-projet Godot 4 (s'il n'existe pas déjà). Active Filter = Nearest, Snap pixel. Importe `diamond.png`, crée un AnimatedSprite2D, configure les frames depuis le spritesheet, crée une animation `diamond_loop` avec les 4 frames à 4 fps. Lance la scène : le pixel rouge doit faire son losange en boucle.
6. Capture une vidéo de 5 secondes du résultat dans Godot (`diamond_godot.mp4`).

## Critère de validation binaire

OUI si :

- `diamond.png` fait exactement 128x32 pixels
- `diamond.json` contient un array `frames` de longueur 4
- Le JSON contient un tag `diamond_loop` couvrant les 4 frames
- Dans Godot, l'AnimatedSprite2D joue l'animation en boucle sans pixel flou
- Le projet Godot a Default Texture Filter = Nearest et Snap 2D Transforms To Pixel = ON
- La vidéo `diamond_godot.mp4` montre l'animation pendant au moins 5 secondes

NON sinon.

## Livrables

```
assets/phase-1/lesson-6-export/
  source.aseprite
  diamond.png
  diamond.json
  diamond_godot.mp4
  godot_settings_screenshot.png   (capture des Project Settings montrant Nearest + Snap pixel)
```
