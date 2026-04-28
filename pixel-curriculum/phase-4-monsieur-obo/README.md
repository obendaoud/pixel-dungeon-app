# Phase 4 : Production Monsieur Obo

## Durée estimée

12 à 16 semaines à 7h par semaine. Environ 100 à 130h de pratique.

## Prérequis

- Phases 1, 2 et 3 entièrement validées dans `PROGRESS.md`
- Game Design Document de Monsieur Obo disponible (description du character, des ennemis, du monde)
- Godot 4 installé, projet du jeu initialisé

## Objectifs de sortie

À la fin de la phase, le jeu Monsieur Obo a :

- Un sprite character Obo animé (idle, walk, interact) intégré dans Godot
- 3 ennemis animés (idle, attack, hit) intégrés
- 2 NPC statiques avec idle subtil intégrés
- Un tileset complet pour au moins une zone du jeu
- Des items (potions, clés, parchemins) en sprites
- Un workflow d'export Aseprite vers Godot fluide et reproductible

## Décisions techniques figées (rappel)

- Sprites character : 48x48
- Palette : 16 couleurs maximum, GBC étendu, construite par toi en début de phase
- Animations à 8-12 fps
- Mode Indexed strict, palette verrouillée
- Lumière directionnelle haut gauche, cohérente sur tous les sprites
- Plugin Aseprite Wizard pour Godot 4 utilisé pour l'import

## Liste des leçons

| # | Titre | Durée |
|---|-------|-------|
| 4.1 | Character sheet et turnaround d'Obo | 10h |
| 4.2 | Idle Obo 48x48 | 8h |
| 4.3 | Walk cycle Obo 4 directions | 16h |
| 4.4 | Animations utilitaires (interagir, ramasser, parler) | 12h |
| 4.5 | Sprites ennemis (3 types) | 20h |
| 4.6 | Sprites NPC (2 types) | 10h |
| 4.7 | Tilesets environnement | 16h |
| 4.8 | Items et objets | 8h |
| 4.9 | Intégration Godot 4 (AnimatedSprite2D, AnimationPlayer, plugin Aseprite Wizard) | 10h |

Total : environ 110h.

## Critère de sortie de phase

Le jeu Monsieur Obo, lancé depuis Godot, montre :

- Le character Obo qui idle, marche dans 4 directions, et interagit avec un objet
- Au moins 1 ennemi qui idle et attaque
- Au moins 1 NPC qui idle
- Une zone du tileset utilisée pour la map
- 3 items visibles dans le HUD ou sur le sol

Tous les sprites respectent strictement la palette de 16 couleurs définie en début de phase. Aucun sprite avec couleur hors palette.

Si une de ces conditions n'est pas remplie, refais les leçons concernées avant de prétendre avoir validé la phase.
