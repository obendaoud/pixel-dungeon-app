# 5.7 - Speed lines et effets cinétiques

## Durée estimée

20h

## Objectif d'apprentissage

Dessiner des speed lines, motion lines et effets cinétiques (aura de charge, vent, dust trails) qui amplifient la lecture du mouvement.

## Théorie

Les speed lines sont des traits qui suivent la trajectoire d'un objet en mouvement, ou qui rayonnent depuis un point d'intérêt (impact, charge). Elles ont deux fonctions :

1. **Renforcer la perception du mouvement** : un objet rapide accompagné de speed lines paraît plus rapide
2. **Diriger le regard** : les lignes pointent vers ce qui compte (le poing, l'impact, le character)

C'est une technique signature de l'animation manga / anime, transposée en pixel art.

**Types de speed lines.**

1. **Trailing lines** : lignes qui partent de l'arrière de l'objet en mouvement, suggèrent la traînée. Souvent 3-8 lignes parallèles, espacées irrégulièrement.

2. **Radial lines** : lignes qui rayonnent depuis un point central (impact, explosion, charge). Souvent 8-16 lignes équiréparties à 360° ou seulement dans un secteur.

3. **Background speed lines** : sur le fond derrière le character, lignes parallèles qui défilent dans la direction opposée au mouvement, suggérant que le character traverse un environnement à grande vitesse. Convention : fond mono-couleur claire avec lignes sombres. Très anime.

4. **Vibration lines** : petits traits courts autour d'un objet qui tremble (point d'impact, character en charge d'énergie). 4-8 traits courts qui apparaissent / disparaissent.

**Speed lines par frame.**

Les speed lines bougent. Pour qu'elles paraissent dynamiques, tu les dessine sur 2-4 frames consécutives, avec des positions / longueurs / nombres légèrement différents à chaque frame. Effet : "scintillement" qui souligne le mouvement.

Si tu dessines des speed lines identiques sur 4 frames, ça paraît être un fond statique. Si tu varies, ça paraît être une trace dynamique.

**Couleurs des speed lines.**

- Sur fond clair : lignes sombres (noir, gris foncé, ou couleur sombre de la palette)
- Sur fond sombre : lignes claires (blanc cassé, ou couleur claire de la palette)
- Variante stylisée : lignes en couleur signature (rouge / bleu / jaune selon le style ou le pouvoir du character)

**Cluster de pixels comme speed line.**

À basse résolution, une speed line n'est pas toujours un trait fin. Ça peut être un cluster de 3-8 pixels en forme de virgule ou de larme, qui suggère le sens du mouvement.

**Effets cinétiques complémentaires.**

1. **Aura de charge** : autour du character qui s'apprête à un coup ultime. Pixels qui scintillent autour de la silhouette, en couleur signature (jaune / blanc pour énergie pure, bleu pour glaciale, rouge pour rage). Animée sur 4-6 frames en boucle.

2. **Vent** : pendant une charge ou une garde, des traits horizontaux partent du character et flottent vers l'arrière (sens opposé à la direction qu'il regarde). Souvent en couleur fond (suggère le mouvement de l'air invisible).

3. **Dust trail** : sous les pieds quand le character court ou s'arrête brutalement. Petits clusters de pixels qui s'élèvent et fondent en 4-6 frames.

4. **Hair / cape windswept** : les cheveux et la cape qui se redressent dans le sens opposé à un mouvement violent ou à une explosion. Animés sur le layer secondaire.

**Application au combo.**

Pour le combo de fin de phase (leçon 5.9), tu utilises plusieurs effets cinétiques :

- Speed lines pendant le swing du bras (frames 7-9 de l'attaque)
- Aura de charge pendant l'anticipation (frames 1-6)
- Dust trail au démarrage (frame 5-6 quand le character bouge)
- Hair / cape windswept à l'impact (frames 9-12)

Tu n'utilises pas tous les effets en même temps. Tu choisis ce qui sert l'animation.

## Démonstration

- Chaîne PixelOverload, "Speed Lines and Motion Effects" (rechercher).
- Chaîne HYUN's dojo, "Combat FX" et "Anime Effects in Pixel Art" (rechercher).
- Chaîne Toyoxi, posts de speed lines et auras (rechercher Toyoxi).
- Chaîne BlackthornProd, "How to Add Speed Lines to Animation" (rechercher, principalement vector mais transférable).
- Référence visuelle : ralentir n'importe quel coup ultime de JJK ou Demon Slayer pour voir les speed lines + l'aura + les debris.
- Sprites pro : KOF XIII supers, Garou Mark of the Wolves specials, Skullgirls supers.

## Exercice pratique

Reprends `punch-hitstop.aseprite` de la leçon 5.6. Tu vas y intégrer des effets cinétiques.

1. Sauve sous `punch-fx.aseprite`
2. Ajoute un layer `aura` : sur les frames 1-6 (anticipation), dessine une aura de charge autour du character. Pixels scintillants en couleur signature (par exemple jaune doré). Anime l'aura : positions différentes à chaque frame.
3. Ajoute un layer `speed-lines-trail` : sur les frames 7-9 (action / smear), dessine des speed lines qui partent du poing ou du bras. 3-5 lignes courtes, varient entre frame 7 et frame 9.
4. Ajoute un layer `dust` : sur les frames 5-6 (transition anticipation vers action), dessine un cluster de poussière sous les pieds du character (3-5 pixels, en couleur secondaire, qui s'élève sur 2 frames).
5. Ajoute un layer `radial-lines` : sur les frames 9-13 (impact + hit stop), dessine des lignes radiales courtes qui partent du point d'impact. 6-10 lignes en patterns différents sur chaque frame de hit stop.
6. Tag `punch_full_fx`

À la lecture, tu obtiens un coup avec anticipation chargée, action explosive avec smear et speed lines, impact flash, et hit stop avec ondes radiales. Sensation très anime.

## Critère de validation binaire

OUI si :

- Le fichier `punch-fx.aseprite` existe, 128x128, 16 frames (le nombre de frames est inchangé par rapport à la leçon 5.6)
- Mode Indexed, palette 32-48 couleurs
- 4 layers d'effets distincts présents : `aura`, `speed-lines-trail`, `dust`, `radial-lines`
- L'aura est visible sur au moins 4 des frames d'anticipation (1-6)
- Les speed lines de trail sont visibles sur les frames 7-9 et leurs positions varient entre frame 7 et 9
- Le dust est visible sur au moins une des frames 5-6, avec un mouvement vers le haut entre frame 5 et 6
- Les radial lines sont visibles sur au moins 3 des 4 frames de hit stop, avec des configurations différentes (positions / longueurs varient)
- À la lecture, l'animation est visiblement plus "anime / dramatique" que la version sans effets de la leçon 5.6
- Tag `punch_full_fx` présent

NON sinon.

## Livrables

```
assets/phase-5/lesson-7-fx/
  punch-fx.aseprite
  punch_fx.gif
  spritesheet.png
  spritesheet.json
  fx-breakdown.png       (les frames clés annotées avec les effets)
  comparison-no-fx-vs-fx.gif
```
