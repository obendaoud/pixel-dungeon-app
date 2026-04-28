# 5.4 - Smear frames

## Durée estimée

24h

## Objectif d'apprentissage

Dessiner des smear frames qui lisent comme un trait de mouvement, technique signature de l'animation cartoon et anime de combat.

## Théorie

Un smear frame est une frame intermédiaire où un objet en mouvement rapide est représenté **étiré, déformé, ou dédoublé** pour suggérer la trace de son mouvement. C'est l'équivalent dessiné du "motion blur" photographique, mais en plus stylisé.

**Pourquoi.**

À 24 fps, un mouvement très rapide (un coup de poing, un swing d'épée) prend 2-4 frames. Sans smear, le bras "saute" d'une position à l'autre. Avec smear, le mouvement paraît continu et dynamique.

**Types de smear.**

1. **Stretch smear** : l'objet est étiré le long de sa trajectoire. Le bras paraît 2-3x plus long pendant 1 frame.
2. **Multiple smear** (ou "multi-image smear") : l'objet est représenté en 3-5 instances simultanées le long de sa trajectoire, comme une rafale photographique.
3. **Trail smear** : un trait de mouvement (ligne fine, ou cluster diffus) suit la trajectoire de l'objet, en plus de la position actuelle de l'objet.
4. **Shape-replaced smear** : l'objet est temporairement remplacé par sa "trace" (une forme abstraite qui suggère le mouvement, sans le détail du sprite original).

Tu peux combiner les types. Un coup de poing rapide en anime utilise souvent stretch + trail.

**Quand utiliser les smear.**

- Mouvement rapide qui parcourt > 30% de la largeur du sprite en 1 frame
- Action explosive (coup, lancer, projectile)
- Rotation rapide (kick, swing)

Tu n'utilises PAS de smear sur :

- Mouvements lents (walk, idle)
- Mouvements progressifs (anticipation)
- Frames d'impact (qui sont des hits stop, vu en 5.5/5.6)

**Construction d'un smear.**

Méthode pour un stretch smear :

1. Identifie la frame où le mouvement est le plus rapide (au milieu de la trajectoire)
2. Sur cette frame, redessine la partie en mouvement comme une forme étirée le long de la direction du mouvement
3. Garde l'attache (épaule pour un bras) à sa position normale
4. Étire la partie distale (poing) loin dans la direction du mouvement
5. La masse intermédiaire est représentée comme un cluster effilé ou une queue

Le smear ne lit qu'à 1 frame (40ms à 24 fps). Sur une seule frame, tu acceptes une déformation visuelle qui paraîtrait absurde sur 5 frames.

**Smear vs continuité.**

Le défi : le smear doit "lire" entre la frame d'avant (objet à position A) et la frame d'après (objet à position B). C'est la trajectoire entre A et B qui doit ressortir. Si tu fais juste un objet déformé sans rapport avec A et B, le smear paraît erratique.

**Smear en pixel art.**

Trois approches pixel art :

1. **Smear dessiné explicitement** : tu dessines la forme étirée pixel par pixel. Effort élevé, lisibilité maximale.
2. **Trail de pixels** : tu ajoutes derrière l'objet un trail de pixels fading (couleur intermédiaire) qui montre la trajectoire. Plus simple.
3. **Combinaison** : objet en position B + trail derrière + déformation légère. Mix optimal.

**Référence absolue : PixelOverload.**

PixelOverload sur Twitter et YouTube est LA référence pour les smear frames pixel art. Sa série "Smear Frames" décortique les techniques en détail.

## Démonstration

- Chaîne PixelOverload, "Smear Frames in Pixel Art" et autres (rechercher exact). Vidéo de référence absolue. Plusieurs vidéos sur le sujet.
- Chaîne HYUN's dojo, exemples de smear sur ses animations de combat (rechercher "HYUN smear pixel art").
- Chaîne Toyoxi, smear et impact sur Twitter / YouTube (rechercher "Toyoxi smear").
- Chaîne AlanBeckerTutorials, vidéo "Smear Frame" si elle existe (rechercher).
- Référence vidéo : ralentissement de scènes de combat anime (JJK, Demon Slayer) frame par frame pour identifier les smears (généralement 1-2 frames par coup, durée 40ms).
- Sprites pro : KOF XIII et Garou Mark of the Wolves utilisent du smear sur les coups rapides. Étudier les animations en mode "frame skipping" sur YouTube (vidéos de tutoriels).

## Exercice pratique

Reprends l'animation de coup de poing de la leçon 5.3 (12 frames). Tu vas y intégrer 2 smear frames.

1. Sauve le fichier précédent sous `punch-with-smear.aseprite`
2. Identifie les frames où le mouvement est le plus rapide (probablement frames 7 et 8, au milieu de l'extension du bras)
3. Modifie la frame 7 pour qu'elle soit un **stretch smear** : le bras est étiré, la main paraît 2x plus loin que normalement, avec une queue de pixels qui relie l'épaule au poing
4. Modifie la frame 8 pour qu'elle soit un **trail smear** : le bras est à sa position d'extension complète, mais derrière (vers l'arrière de la trajectoire) tu ajoutes un trail de pixels en couleur secondaire qui suggère le mouvement
5. Les autres frames restent inchangées
6. Tag `punch_smear`, durée totale identique à l'original

À la lecture, le coup doit paraître plus rapide et plus explosif que la version sans smear de la leçon 5.3.

Bonus : produis aussi une animation de **kick** (coup de pied tournoyant) 12 frames avec au moins 2 smear frames différents. Fichier `kick-smear.aseprite`.

## Critère de validation binaire

OUI si :

- Le fichier `punch-with-smear.aseprite` existe, 128x128, 12 frames
- Mode Indexed, palette 32-48 couleurs
- La frame 7 montre le bras déformé / étiré sur une longueur > 1.5x la longueur normale du bras
- La frame 8 montre la position d'extension finale + un trail de pixels visible derrière la trajectoire
- À la comparaison avec le `punch.gif` de la leçon 5.3 (sans smear), le `punch_smear.gif` paraît visiblement plus dynamique
- La continuité entre les frames 6, 7, 8, 9 lit naturellement (pas de saut, le smear connecte les positions)
- Optionnel : `kick-smear.aseprite` existe avec au moins 2 smear frames (recommandé pour solidifier l'apprentissage)

NON sinon.

## Livrables

```
assets/phase-5/lesson-4-smear/
  punch-with-smear.aseprite
  punch_smear.gif
  spritesheet.png
  spritesheet.json
  comparison-no-smear-vs-smear.gif    (les deux animations côte à côte ou en boucle alternée)
  smear-frames-isolated.png           (les 2 smear frames isolées, agrandies pour LinkedIn)
  kick-smear.aseprite                 (optionnel)
  kick-smear.gif                      (optionnel)
```
