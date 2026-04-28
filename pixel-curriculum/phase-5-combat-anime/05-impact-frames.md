# 5.5 - Impact frames

## Durée estimée

20h

## Objectif d'apprentissage

Dessiner et utiliser les impact frames : white flash, distortion, et silhouette inversée pour communiquer la puissance d'un coup à l'instant du contact.

## Théorie

Une impact frame est une frame spéciale au moment du contact d'un coup. Elle dure 1 à 3 frames (40-120ms à 24 fps), elle est **graphiquement différente** des frames adjacentes, et elle communique l'impact visuellement et tactilement.

**Types d'impact frames.**

1. **White flash** : la frame est entièrement blanche ou presque. La silhouette du character est rempli de la couleur la plus claire de la palette (souvent blanc cassé). Convention universelle pour signifier "ça vient de cogner fort".

2. **Black silhouette** : à l'inverse, la frame est presque entièrement remplie de la couleur la plus sombre (silhouette opposée). Moins courant, mais utilisé en JJK et Demon Slayer pour des coups dramatiques.

3. **Inverted colors** : la palette est inversée pour 1 frame (couleur sombre devient claire et vice-versa). Effet psychédélique, utilisé pour des coups "ultime" ou des transformations.

4. **Distortion / debris** : la silhouette est cassée par des pixels d'éclat (lignes radiales, fragments) qui débordent autour. L'impact "fait éclater" l'image visuellement.

5. **Cut frame** : 1 frame complètement vide ou avec un seul élément abstrait (un trait blanc, un X, une explosion stylisée). Très anime, vu dans Demon Slayer et JJK.

**Quand placer une impact frame.**

À l'instant exact où l'attaque connecte la cible. Pas avant (anticipation), pas pendant (action), juste au moment du contact.

**Combien de frames.**

- Coup léger : 1 frame d'impact (40ms)
- Coup moyen : 2 frames d'impact (80ms, alternance flash + frame normale)
- Coup ultime : 2-3 frames d'impact + cut frame (120ms, dramatique)

**Couplage avec hit stop.**

L'impact frame et le hit stop (leçon 5.6) sont liés mais distincts. L'impact frame est une frame visuellement différente. Le hit stop est un freeze (plusieurs frames identiques tenues plus longtemps). On les combine souvent : 1 frame d'impact (white flash) puis 2-3 frames de hit stop (la pose de contact figée).

**Construction d'une white flash.**

1. Identifie la frame d'impact dans ton animation
2. Duplique cette frame
3. Sur la copie, sélectionne la silhouette entière (Magic Wand, ou Select All puis exclude transparent)
4. Remplis avec la couleur la plus claire de la palette (blanc cassé, pas blanc pur si la palette ne le contient pas)
5. Tu obtiens une silhouette pleine de blanc cassé sur fond transparent
6. Insère cette frame avant la frame de pose d'impact

Tu peux varier : remplir 80% en blanc et garder l'outline en noir pour préserver la lecture de la silhouette. Ou alterner 1 frame full white + 1 frame normale + 1 frame full white pour un effet "strobe".

**VFX combinés.**

L'impact frame est souvent accompagné de :

- Speed lines qui partent du point d'impact (vu en 5.7)
- Shockwave / cercle d'onde de choc (vu en 5.8)
- Particles / debris (vu en 5.8)

Pour cette leçon, on se concentre uniquement sur l'impact frame elle-même. Les VFX additionnels viennent dans les leçons suivantes.

**Erreurs typiques.**

- Trop de white flashes : au bout de 5 dans une seule animation, ça perd son sens. 1-2 par animation maximum.
- White flash trop long (4+ frames) : ça paraît être un bug d'affichage, pas un coup.
- White flash sur un coup faible : exagération mal placée, paraît absurde.
- Pas de pose d'impact identifiable : la flash arrive au mauvais moment, mal couplée à la frame de contact.

## Démonstration

- Chaîne PixelOverload, "Impact Frames in Pixel Art" (rechercher). Référence absolue.
- Chaîne HYUN's dojo, "Combat VFX" et "Impact" (rechercher). Démonstrations.
- Chaîne Toyoxi, posts d'impact frames (rechercher Toyoxi sur Twitter / YouTube).
- Chaîne New Frame Plus, "What Makes Anime Combat Feel Good" ou similaire (rechercher) sur YouTube. Analyse des impact frames en anime.
- Référence visuelle : ralentir des scènes de combat de Demon Slayer, JJK saison 1 et 2, KOF XIII supers. Identifier les impact frames (1-2 frames très différentes des autres).

## Exercice pratique

Reprends ton animation de punch avec smear (leçon 5.4). Ajoute une impact frame.

1. Sauve sous `punch-impact.aseprite`
2. Identifie la frame de contact (frame où le poing connecte) - probablement frame 9
3. Insère une **impact frame** juste avant la frame de contact :
   - Duplique la frame de contact
   - Remplis la silhouette en blanc cassé (couleur la plus claire de la palette)
   - Garde l'outline visible (pas tout blanc)
4. Cette nouvelle frame devient la frame 9, la frame de contact originale devient frame 10. L'animation passe de 12 à 13 frames.
5. Frame duration : la white flash dure 40ms (1 frame), la frame de contact suivante dure 80ms (la pose d'impact reste tenue 2x)
6. Tag `punch_impact`

Bonus : produis une variante `punch-cutframe.aseprite` où l'impact frame est un **cut frame** : une frame avec uniquement un trait blanc large + 2-3 pixels d'éclat radial sur fond noir. Style très anime.

## Critère de validation binaire

OUI si :

- Le fichier `punch-impact.aseprite` existe, 128x128, 13 frames
- Mode Indexed, palette 32-48 couleurs
- La frame 9 (white flash) a la silhouette du character remplie d'une couleur claire (blanc cassé), couvrant >= 80% de la silhouette du character
- L'outline du character reste visible sur la white flash (la silhouette n'est pas un blob blanc informe)
- La frame 9 dure 40ms, la frame 10 dure >= 80ms
- À la lecture, le coup paraît visiblement plus impactant que la version sans flash de la leçon 5.4
- Tag `punch_impact` présent
- Optionnel : `punch-cutframe.aseprite` produit avec un cut frame anime

NON sinon.

## Livrables

```
assets/phase-5/lesson-5-impact/
  punch-impact.aseprite
  punch_impact.gif
  spritesheet.png
  spritesheet.json
  impact-frame-isolated.png         (la white flash isolée + agrandie pour LinkedIn)
  comparison-with-without-flash.gif (côte à côte ou alternance)
  punch-cutframe.aseprite           (optionnel)
  punch_cutframe.gif                (optionnel)
```
