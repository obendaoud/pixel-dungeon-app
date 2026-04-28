# 4.7 - Tilesets environnement

## Durée estimée

16h

## Objectif d'apprentissage

Concevoir et produire un tileset complet pour une zone du jeu Monsieur Obo : tiles de sol, murs, transitions, props, et compatibilité avec le système de tileset Godot 4.

## Théorie

Un tileset est un ensemble de tuiles 16x16 ou 24x24 qui s'assemblent pour former l'environnement du jeu. À 48x48 pour le character, le tile à 16x16 implique qu'Obo fait environ 3 tiles de haut. Cohérent avec un look top-down classique.

**Tile size pour Monsieur Obo.**

Recommandation : **16x16**. C'est le standard GBC, et ça donne une bonne densité visuelle. Si tu trouves que c'est trop petit, passe à 24x24.

**Composition d'un tileset minimum.**

Pour une zone du jeu, tu as besoin de :

- Tile de sol primaire : 4-6 variantes (pour casser la répétition)
- Tile de sol secondaire (ex : herbe vs terre, pavé vs sable) : 4-6 variantes
- Tile de transition entre sols (4-8 directions, technique "bitmask")
- Tile de mur : top, bottom, left, right + coins
- Props : 4-8 éléments décoratifs (pierre, plante, bûche, fleur, etc.)
- Détails : 2-4 mini-objets (caillou seul, brindille, herbe haute)

Total minimum : ~30-40 tiles.

**Bitmask et auto-tiling.**

Pour les transitions sol et murs, Godot 4 supporte le auto-tiling avec terrains. Le bitmask classique a 16 ou 47 variantes selon le système (3x3 ou 3x3 with diagonals). À 47 tiles, tu décris toutes les configurations possibles d'un coin de sol entouré de différentes manières.

Pour cette leçon, on commence simple avec un bitmask 3x3 (16 tiles) ou même un système manuel.

**Pavage sans seam.**

Critère absolu : un tile, répété en grille, ne doit pas montrer de "seam" (couture visible aux bords). Test : copie le tile en 4x4 (16 répétitions), regarde à 100%. Tu ne dois voir aucune ligne diagonale ou pattern qui se répète de manière trop visible.

Astuces pour éviter le seam :

- Pas de détail trop fort sur les bords
- Pas d'élément placé juste sur la diagonale du tile
- Variation interne : 4-6 versions du même tile, alternées en jeu (random tile placement par Godot)

**Cohérence palette.**

Strictement la palette de 16 couleurs de la phase. Le tileset utilise les mêmes 16 couleurs qu'Obo et les ennemis. Si tu sens que la palette manque de variations pour la végétation, tu peux switcher 1-2 slots dédiés aux environnements (mais reste à 16 totales).

**Lumière.**

Top-down 2D : pas de lumière directionnelle classique. Les tiles sont éclairés "à plat" (chaque tile est représenté comme s'il était vu depuis dessus). Pas de shadow projetée par les murs (sauf si tu fais un système d'éclairage Godot par-dessus, mais hors scope phase 4).

Cependant, les props verticaux (un arbre, un mur) ont une silhouette frontale (ils ne sont pas vraiment "vus de dessus", c'est une convention). Tu shading leur silhouette comme un sprite normal avec lumière haut gauche.

**Workflow.**

1. Définis la zone du jeu que tu fais (ex : "village paisible", "forêt sombre", "donjon ancien")
2. Choisis 8-12 références visuelles (autres jeux, photos, illustrations)
3. Dessine le tileset tile par tile dans Aseprite. Active la grille 16x16 (View > Grid > Grid Settings).
4. Teste le pavage : copie un tile 4x4, vérifie qu'il pave proprement
5. Construis un mini level mockup en assemblant tes tiles
6. Exporte le tileset en spritesheet 16xN ou comme PNG d'une planche organisée

## Démonstration

- Chaîne MortMort, "Pixel Art Tileset Tutorial" (rechercher). Démo workflow.
- Chaîne AdamCYounis, "How I Make Tilesets" (rechercher). Approche pro.
- Chaîne Pixel Pete, "Pixel Art Tileset" (rechercher).
- Chaîne HeartBeast, "Godot 4 Tileset Workflow" (rechercher). Pour l'intégration Godot.
- Référence sprite : tilesets Stardew Valley (parfaits pour étudier les transitions), Eastward (zones très variées), Hyper Light Drifter (épuré, lisible).

## Exercice pratique

1. Choisis 1 zone du jeu Monsieur Obo (selon GDD ou choix libre si pas spécifié)
2. Conçois un tileset 16x16 contenant minimum :
   - 4 variantes de sol primaire
   - 4 variantes de sol secondaire
   - 8 tiles de transition (bitmask simplifié)
   - 1 tile de mur (top + bottom + left + right + coins, soit 8 tiles)
   - 6 props (pierre, plante, bûche, fleur, caillou, brindille)
3. Organise le tileset dans un PNG `tileset.png` selon une grille structurée (par exemple 16 colonnes par N lignes)
4. Construis un mini level mockup `level-mockup.aseprite` en assemblant les tiles pour montrer une scène 256x192 (donc 16x12 tiles)
5. Documentation : `tileset-doc.md` qui liste chaque tile et son usage

## Critère de validation binaire

OUI si :

- Le tileset contient au minimum 30 tiles distincts de 16x16 chacun
- Mode Indexed, palette identique à la sheet (16 couleurs)
- Au moins 4 variantes de sol primaire
- Au moins 8 tiles de transition / bordure
- Au moins 6 props
- Le mini level mockup 256x192 est lisible et utilise au minimum 80% des tiles du tileset
- Test pavage : un tile primaire répété 4x4 ne montre pas de pattern visible distrayant à 100%
- Le fichier `tileset-doc.md` documente chaque tile

NON sinon.

## Livrables

```
assets/phase-4/lesson-7-tileset/
  tileset.aseprite
  tileset.png
  level-mockup.aseprite
  level-mockup.png
  level-mockup-x4.png
  tileset-doc.md
```
