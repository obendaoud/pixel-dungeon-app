# 4.9 - Intégration Godot 4 (AnimatedSprite2D, AnimationPlayer, plugin Aseprite Wizard)

## Durée estimée

10h

## Objectif d'apprentissage

Intégrer tous les sprites Aseprite produits en phase 4 dans le projet Godot 4 de Monsieur Obo, avec un workflow reproductible et industrialisé via le plugin Aseprite Wizard.

## Théorie

C'est l'examen de fin de phase 4. Tu prends tout ce que tu as produit (Obo idle / walk / interact / pickup / talk, 3 ennemis, 2 NPC, tileset, items) et tu l'intègres dans Godot pour produire un build jouable.

**Plugin Aseprite Wizard.**

Plugin tiers Godot 4 qui automatise l'import de fichiers `.aseprite` vers SpriteFrames et AnimationPlayer Godot. Avantages :

- Lit directement le `.aseprite` (pas besoin d'export PNG / JSON manuel)
- Crée automatiquement les animations basées sur les tags
- Détecte les loops vs one-shot via le tag direction Aseprite (`forward`, `pingpong`, `reverse`)
- Met à jour les ressources Godot quand tu modifies le `.aseprite` (re-import auto)

Installation :

1. Dans Godot 4, AssetLib (onglet en haut) > rechercher "Aseprite Wizard" > installer
2. Dans Project > Project Settings > Plugins, active "Aseprite Wizard"
3. Configure le chemin de l'exécutable Aseprite dans Project Settings > Aseprite > Aseprite executable path

**Workflow d'import recommandé.**

1. Range tes `.aseprite` dans `res://art/sprites/` du projet Godot (par catégorie : `obo/`, `enemies/`, `npc/`, `items/`, `tileset/`)
2. Sur un noeud AnimatedSprite2D dans une scène, clic droit > "Import Aseprite" (action ajoutée par le plugin)
3. Sélectionne le `.aseprite` source
4. Le plugin génère un SpriteFrames avec les animations basées sur les tags
5. Configure le looping par animation (loop = true pour idle / walk, false pour attack / hit / death)

**Settings Godot critiques pour pixel art.**

Project Settings :

- `Rendering > Textures > Default Texture Filter` = Nearest (sinon flou)
- `Rendering > 2D > Snap 2D Transforms To Pixel` = ON (sinon clignotement demi-pixel)
- `Display > Window > Stretch > Mode` = `viewport`
- `Display > Window > Stretch > Aspect` = `keep` ou `keep_height` selon ton choix
- Window > Size > Viewport Width / Height : taille native du jeu (par exemple 384x216 = 24x13.5 tiles 16x16, ratio 16:9)

**Scène type pour Obo dans Godot.**

```
Player (CharacterBody2D)
├── AnimatedSprite2D (sprite_frames = obo_sprite_frames)
├── CollisionShape2D
└── (autres composants : Camera2D, scripts)
```

Le SpriteFrames `obo_sprite_frames` regroupe :

- `idle_front`, `idle_back`, `idle_left`, `idle_right` (loop)
- `walk_front`, `walk_back`, `walk_left`, `walk_right` (loop)
- `interact_front`, `interact_back`, `interact_left`, `interact_right` (one-shot)
- `pickup_front`, `pickup_back`, `pickup_left`, `pickup_right` (one-shot)
- `talk` (loop)

Le script du player change l'animation active selon l'input et la direction.

**TileMap pour le tileset.**

Le tileset 16x16 produit en leçon 4.7 s'importe via :

1. Dans Godot, crée un TileSet ressource
2. Ajoute la texture (PNG du tileset)
3. Configure les Atlas (taille de tile 16x16)
4. Sélectionne les tiles, configure les terrains pour le auto-tiling
5. Crée une scène avec un noeud TileMap, assigne le TileSet

**AnimationPlayer vs AnimatedSprite2D.**

- AnimatedSprite2D : pour les sprites simples (un seul sprite qui change de frame). C'est le cas d'Obo, des ennemis, des NPC.
- AnimationPlayer : pour des animations qui combinent plusieurs propriétés (sprite frame + position + rotation + opacity), typiquement des cutscenes ou des effets complexes.

Pour cette leçon, on utilise AnimatedSprite2D pour tout ce qui est character. AnimationPlayer pour les effets si besoin (mais pas obligatoire à ce stade).

**Test final : un build jouable.**

Tu vises un build où :

- Obo se déplace dans 4 directions au clavier (WASD ou flèches)
- L'animation passe de idle à walk selon le mouvement
- Obo peut interact avec un objet (touche E ou similaire) → animation interact joue
- Au moins 1 ennemi est posé dans la scène, en idle
- Au moins 1 NPC est posé, en idle (avec talk possible si tu as le temps)
- La map utilise le tileset
- Au moins 3 items sont visibles dans la scène

## Démonstration

- Documentation officielle plugin Aseprite Wizard : github.com/viniciusgerevini/godot-aseprite-wizard
- Chaîne HeartBeast, "Godot 4 Aseprite Workflow" (rechercher).
- Chaîne GDQuest, tutoriels Godot 4 pixel art (rechercher "GDQuest Godot 4 pixel art").
- Documentation Godot officielle : docs.godotengine.org > AnimatedSprite2D, TileMap, CharacterBody2D.
- Chaîne Pigdev, "Top-down 2D RPG en Godot 4" (rechercher).

## Exercice pratique

1. Configure le projet Godot avec les settings critiques pixel art (Filter Nearest, Snap pixel, etc.)
2. Installe et configure le plugin Aseprite Wizard
3. Range les `.aseprite` dans `res://art/sprites/` selon une structure claire
4. Crée la scène Player avec AnimatedSprite2D et SpriteFrames généré depuis `obo-idle.aseprite`, `obo-walk.aseprite`, `obo-interact.aseprite`, `obo-pickup.aseprite`
5. Écris un script `player.gd` qui change l'animation selon l'input et la direction (idle quand pas d'input, walk_X quand mouvement, interact_X sur appui touche E)
6. Crée le TileMap depuis le tileset
7. Construis une scène mockup `level1.tscn` qui contient :
   - Le TileMap avec une zone visible (256x192 par exemple)
   - Le Player posé au centre
   - 1 ennemi (en AnimatedSprite2D, idle qui loop)
   - 1 NPC (en AnimatedSprite2D, idle qui loop)
   - 3 items posés au sol (Sprite2D simples)
8. Lance la scène. Vérifie que Obo se déplace, change d'animation, et que tout est lisible.
9. Capture une vidéo de 30 secondes du gameplay : `obo-build-demo.mp4`

## Critère de validation binaire

OUI si :

- Le projet Godot a Filter = Nearest et Snap pixel = ON
- Plugin Aseprite Wizard installé et fonctionnel
- Le SpriteFrames de Obo contient au minimum les 13 animations attendues (4 idle + 4 walk + 4 interact + 1 talk)
- La scène `level1.tscn` se lance sans erreur
- Obo se déplace dans 4 directions au clavier
- L'animation d'Obo change de idle à walk_X correctement selon la direction de mouvement
- L'animation interact joue à l'appui sur la touche dédiée
- Au moins 1 ennemi visible et en idle
- Au moins 1 NPC visible et en idle
- Au moins 3 items visibles
- Le TileMap est utilisé pour la map
- Aucun pixel flou (test visuel : zoome au max, pas de blur)
- La vidéo de démo est produite et fait au moins 30 secondes

NON sinon.

## Livrables

```
assets/phase-4/lesson-9-godot/
  obo-build-demo.mp4
  godot-settings-screenshot.png    (capture des Project Settings critiques)
  scene-tree-screenshot.png        (capture de l'arbre de scène level1)
  spriteframes-screenshot.png      (capture du SpriteFrames d'Obo)
  notes.md                         (procédure d'import, problèmes rencontrés, solutions)
```

Le code Godot lui-même reste dans le projet du jeu, pas dans ce repo curriculum. On garde uniquement les preuves d'intégration ici.
