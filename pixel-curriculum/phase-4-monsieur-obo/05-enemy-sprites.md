# 4.5 - Sprites ennemis (3 types)

## Durée estimée

20h

## Objectif d'apprentissage

Concevoir et animer 3 ennemis distincts pour Monsieur Obo, chacun avec idle, attack, hit, et death.

## Théorie

Un roguelike a besoin d'ennemis variés pour éviter la répétition. 3 types d'ennemis dans cette leçon, chacun avec une silhouette et un comportement visuel distincts.

**Choix des 3 archétypes.**

Tu choisis selon le GDD d'Obo. Suggestion canonique :

1. **Ennemi rapide / faible** : forme petite, mouvement vif, attaque rapide. Ex : rat, gobelin, lutin.
2. **Ennemi moyen / équilibré** : taille humaine, mouvement modéré, attaque moyenne. Ex : zombie, garde, voleur.
3. **Ennemi lourd / fort** : grande silhouette, mouvement lent, attaque lourde. Ex : ogre, golem, monstre.

Les 3 doivent être visuellement distinguables au premier coup d'oeil par leur silhouette (test blackout).

**Tailles.**

- Ennemi rapide : 32x32 (plus petit qu'Obo, semble vif)
- Ennemi moyen : 48x48 (même taille qu'Obo)
- Ennemi lourd : 64x64 (plus grand qu'Obo, intimidant)

Note : 64x64 est plus grand que la cible Obo, mais autorisé pour des ennemis "boss-like". Si tu préfères rester strict 48x48 maximum, l'ennemi lourd est juste 48x48 mais plus dense en silhouette (plus large, plus volumineux).

**Animations par ennemi.**

Pour chaque ennemi, 4 animations minimum :

1. `idle` : 4-6 frames, loop. Respiration ou oscillation subtile.
2. `attack` : 6-8 frames, one-shot. Anticipation + action + recovery.
3. `hit` : 2-3 frames, one-shot. Brève reaction à un coup encaissé (souvent un flash blanc + recul d'1 pixel).
4. `death` : 4-6 frames, one-shot. Effondrement, dissolution, ou animation de mort selon le style.

Soit 16-24 frames par ennemi, 48-72 frames totales pour les 3.

**Walk pour les ennemis.**

Optionnel à ce stade. Si tes ennemis se déplacent en jeu, anime un walk simplifié 4 frames (in-place, plus simple qu'Obo). Pour cette leçon on se concentre sur idle / attack / hit / death.

**Palette des ennemis.**

Tu peux utiliser la même palette de 16 couleurs qu'Obo, ou créer des sous-palettes par ennemi. Recommandation : palette commune pour les 3 ennemis (tu utilises 12-14 des 16 couleurs d'Obo, plus 2-4 couleurs spécifiques aux ennemis pour différencier visuellement, par exemple un rouge sang pour le hit feedback).

Pour la cohérence visuelle du jeu, **garde la même palette de 16 que Obo** dans 90% des cas. Tu peux switcher 1-2 slots pour des accents de couleur ennemi (ex : remplacer la couleur "vert végétation" par un "rouge sang" si pas pertinent pour les ennemis).

**Hit feedback : flash blanc.**

Convention en pixel art : sur la frame 1 ou 2 du `hit`, l'ennemi apparaît tout blanc (silhouette pleine remplie de la couleur la plus claire de la palette, souvent blanc cassé). C'est un "flash" qui dure 1 frame, communique le coup encaissé visuellement. Tu peux soit :

- Dessiner la frame en blanc plein
- Utiliser un shader Godot pour le flash (préférable pour la maintenabilité)

Pour cette leçon, on dessine la frame blanche dans Aseprite. En Godot tu pourras remplacer par un shader plus tard.

**Death animation.**

Quelques styles classiques :

- Effondrement vertical : l'ennemi s'aplatit en 4-5 frames
- Disparition par dissolve : pixels qui s'effacent un par un
- Explosion en particules (4 frames de "puff")
- Style cartoon : l'ennemi tourne sur lui-même puis disparaît

Choisis le style qui correspond au ton du jeu (narratif → effondrement, action → explosion).

## Démonstration

- Chaîne MortMort, "Pixel Art Enemy Design" et "Pixel Art Enemy Animation" (rechercher).
- Chaîne AdamCYounis, "How to Design Pixel Art Enemies" (rechercher).
- Référence sprite : Hyper Light Drifter (ennemis variés et lisibles), Death's Door (ennemis avec personnalités fortes), Dead Cells (ennemis très lisibles à distance).
- Référence VFX hit : dans n'importe quel jeu pixel art moderne, regarder les frames de hit (Hollow Knight bien que vectoriel, Celeste, Hades 2D moments).

## Exercice pratique

Pour les 3 ennemis :

1. Conçois la character sheet de chaque ennemi (silhouette, palette utilisée, taille). Documente dans un `enemies-sheet.aseprite` qui montre les 3 silhouettes côte à côte.
2. Anime les 4 animations par ennemi (idle, attack, hit, death). Fichier consolidé par ennemi : `enemy-fast.aseprite`, `enemy-mid.aseprite`, `enemy-heavy.aseprite`. Tags : `idle`, `attack`, `hit`, `death`.
3. Exporte chaque ennemi en spritesheet + JSON.

## Critère de validation binaire

OUI si :

- 3 ennemis sont produits, chacun visuellement distinct (test silhouette blackout : on identifie l'archétype rapide / moyen / lourd au premier regard)
- Chacun a 4 animations (`idle`, `attack`, `hit`, `death`) avec tags Aseprite
- L'`idle` est en loop, les 3 autres sont one-shot
- Le `hit` contient au moins 1 frame de flash blanc (silhouette quasi entièrement remplie de la couleur la plus claire de la palette)
- L'`attack` a une anticipation visible avant l'action
- Le `death` produit un effondrement ou disparition lisible (le character n'est plus à sa position d'origine ou plus visible à la dernière frame)
- Mode Indexed, palette identique à celle d'Obo (avec éventuellement 1-2 slots échangés)
- Les 3 spritesheets et JSON sont produits

NON sinon.

## Livrables

```
assets/phase-4/lesson-5-enemies/
  enemies-sheet.aseprite
  enemies-sheet.png
  enemy-fast.aseprite
  enemy-fast.png
  enemy-fast.json
  enemy-mid.aseprite
  enemy-mid.png
  enemy-mid.json
  enemy-heavy.aseprite
  enemy-heavy.png
  enemy-heavy.json
  enemy-fast-attack.gif
  enemy-mid-attack.gif
  enemy-heavy-attack.gif
```
