# 5.1 - Anatomie shonen et proportions

## Durée estimée

16h

## Objectif d'apprentissage

Comprendre et appliquer les proportions stylisées du shonen (JJK, Demon Slayer, Bleach) en pixel art 128x128.

## Théorie

Le shonen (manga / anime pour adolescents masculins) a un style anatomique reconnaissable : proportions exagérées, musculature stylisée, postures dynamiques. Ce n'est pas l'anatomie réelle, c'est une convention visuelle qui communique force et mouvement.

**Proportions canoniques shonen.**

- Hauteur totale : 7-8 têtes (vs 6-7 en réalité, vs 5-6 en chibi)
- Épaules larges (1.5-2x la largeur de la tête pour un héros masculin)
- Taille fine (1x la largeur de la tête)
- Hanches étroites (1.2x la largeur de la tête pour un homme)
- Jambes longues (4 têtes de longueur, vs 3.5 en réalité)
- Mains grandes (presque la taille du visage)
- Pieds grands (presque la taille de la tête)

À 128x128 pixels, un character de 7 têtes = tête de ~16 pixels de haut, total 112 pixels. Ça laisse 16 pixels de marge.

**Squelette simplifié.**

Tu dessines avant tout le squelette / stick figure :

- Crâne (cercle 16x16)
- Cou (1-2 pixels)
- Cage thoracique (rectangle 20x24)
- Bassin (trapèze 16x12)
- Bras : épaule + coude + poignet + main, 4 segments
- Jambes : hanche + genou + cheville + pied, 4 segments

Une fois le squelette posé, tu ajoutes la masse (forme générale du corps), puis les détails (vêtements, cheveux, accessoires).

**Musculature stylisée.**

Le shonen exagère les groupes musculaires lisibles :

- Pectoraux : deux blocs définis, séparés par un creux central
- Épaules / deltoïdes : sphères au sommet du bras
- Biceps : blocs gonflés au-dessus du coude (visibles surtout en action)
- Abdominaux : 4-6 blocs visibles sur le ventre (en pose action torse nu)
- Quadriceps : masse au-dessus du genou
- Mollets : masse en arrière de la jambe inférieure

À 128x128, tu n'as pas la résolution pour détailler chaque muscle. Tu suggères la masse générale par 2-3 niveaux de shading.

**Genres et styles.**

- Héros principal masculin : 7-8 têtes, musclé, mâchoire carrée
- Antagoniste imposant : 8+ têtes, masse exagérée
- Héros secondaire / personnage girl : 6-7 têtes, plus fin
- Comic relief : 5-6 têtes, proportions exagérées

Pour cette leçon, on travaille un héros principal masculin classique. Tu pourras décliner après.

**Pose statique vs pose dynamique.**

Cette leçon est la **pose statique**. Pas de combat encore, juste un character qui se tient debout, les bras le long du corps ou en garde. La pose dynamique est la leçon suivante (5.2).

**Lumière en combat anime.**

La direction de lumière en combat anime est moins systématique qu'en pixel art game classique. Souvent :

- Light ambiante haute (lumière du soleil au-dessus, ou du ciel)
- Specular fort sur les zones d'impact ou les surfaces métalliques
- Backlight (rim light) sur la silhouette pour la détacher du fond

Pour cette leçon, on garde une lumière directionnelle haut gauche classique. L'éclairage dramatique vient en leçon 5.5 (impact frames) et 5.7 (effets cinétiques).

**Palette élargie.**

À 128x128, on s'autorise jusqu'à 32-48 couleurs. Tu construis une palette en 5-7 ramps :

- 1 ramp peau (5 couleurs)
- 1 ramp cheveux (4 couleurs)
- 1-2 ramps vêtements (4-5 couleurs chacune)
- 1 ramp métal (3-4 couleurs si arme)
- 1 ramp accent (2-3 couleurs pour highlights spéciaux)
- 2-3 couleurs neutres

Total : 24-30 couleurs en moyenne. Beaucoup plus de marge qu'en GBC étendu.

## Démonstration

- Livre "Force: Dynamic Life Drawing" de Mike Mattesi (anatomie de mouvement). Pas pixel mais base théorique.
- Chaîne Sinix Design, "Anatomy for Artists" series (rechercher). Théorie générale.
- Chaîne HYUN's dojo, "Pixel Art Shonen Character" (rechercher). Application pixel art directe au shonen.
- Chaîne Toyoxi, démos pixel art combat (rechercher "Toyoxi pixel art").
- Référence visuelle : observer des frames statiques de JJK (Yuji Itadori, Gojo), Demon Slayer (Tanjiro), Bleach (Ichigo) au ralenti pour étudier proportions et musculature stylisée.
- Sprites professionnels : KOF XIII characters, Garou Mark of the Wolves characters, Skullgirls (vectoriel mais frames anime claires).

## Exercice pratique

Dessine 1 character shonen en pose statique, 128x128 :

1. Conçois ton character (peut être Obo en version "combat" si tu veux faire le pont avec la phase 4, ou un nouveau character entièrement)
2. Construis la palette (32-48 couleurs en ramps)
3. Trace le squelette / stick figure 7-8 têtes
4. Pose la silhouette pleine (test blackout)
5. Ajoute les masses musculaires (pectoraux, épaules, etc.)
6. Shading complet (lumière haut gauche)
7. Détails : visage, cheveux, vêtement, arme si présente

## Critère de validation binaire

OUI si :

- Le canvas fait 128x128
- Mode Indexed, palette 32-48 couleurs
- Le character a une hauteur de 7-8 têtes mesurable au pixel près (annoter sur un layer séparé)
- Les épaules sont 1.5-2x la largeur de la tête (mesurable)
- La silhouette passe le test blackout (lecture < 3 secondes par observateur tiers)
- Au moins 5 ramps distinctes sont visibles dans la palette, avec hue shifting
- Les masses musculaires principales (pecs, deltoïdes, quadriceps) sont identifiables visuellement
- Lumière directionnelle haut gauche cohérente

NON sinon.

## Livrables

```
assets/phase-5/lesson-1-anatomy/
  source.aseprite
  export.png
  export-x4.png
  skeleton-overlay.png       (capture du squelette annoté en surimpression)
  palette.png                (export de la palette utilisée, 32-48 slots)
  notes.md                   (description du character, choix de proportions)
```
