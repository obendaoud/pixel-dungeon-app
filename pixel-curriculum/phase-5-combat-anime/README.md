# Phase 5 : Combat anime

## Durée estimée

24 à 36 semaines à 7h par semaine. Environ 200 à 280h de pratique.

## Prérequis

- Phases 1, 2, 3, 4 entièrement validées dans `PROGRESS.md`
- Fluidité confirmée sur Aseprite (raccourcis, layers, timeline)
- Walk cycle et run cycle déjà animés en phase 3
- Maîtrise de la palette restreinte et du hue shifting
- Idéalement : avoir étudié 5-10 références d'animation shonen au ralenti (JJK, Demon Slayer, KOF XIII, Garou Mark of the Wolves, fights frame-by-frame)

## Objectifs de sortie

À la fin de la phase, tu sais :

- Dessiner une pose dynamique avec line of action lisible
- Animer une anticipation forte (4-8 frames)
- Produire un smear frame qui lit comme un trait de mouvement
- Utiliser les impact frames (white flash, distortion, freeze)
- Implémenter le hit stop dans l'animation
- Dessiner des speed lines et des effets cinétiques
- Animer des VFX d'impact (shockwave, particles, dust)
- Produire un combo de combat de 2 secondes en sprite 96-128 pixels qui lit comme une scène d'anime shonen

## Spécifications techniques

- Sprites : 96x96 à 128x128 (plus large qu'Obo, équivalent KOF XIII / Garou)
- Palette : 32-48 couleurs autorisées (plus large que la GBC étendue)
- Frame rate : 24 fps (animation TV anime classique)
- Animation pas in-place : displacement géré par l'animation (pas seulement le moteur)

## Liste des leçons

| # | Titre | Durée |
|---|-------|-------|
| 5.1 | Anatomie shonen et proportions | 16h |
| 5.2 | Pose dynamique et line of action | 16h |
| 5.3 | Anticipation forte | 20h |
| 5.4 | Smear frames | 24h |
| 5.5 | Impact frames | 20h |
| 5.6 | Hit stop et frame timing | 16h |
| 5.7 | Speed lines et effets cinétiques | 20h |
| 5.8 | VFX d'impact (shockwave, particles, dust) | 24h |
| 5.9 | Combo final 2 secondes en sprite 128x128 | 60h |

Total : environ 215h.

## Critère de sortie de phase

Tu produis un combo de combat de 2 secondes (48 frames à 24 fps) en sprite 128x128, qui contient :

- Une anticipation forte d'au moins 6 frames
- Au minimum 2 smear frames distincts
- Au minimum 1 impact frame avec white flash visible
- Un hit stop de 3-4 frames sur l'impact principal
- Speed lines visibles pendant la phase d'action
- Au moins 1 VFX d'impact (shockwave OU particles OU dust)
- Une lecture qui rappelle l'esthétique shonen / anime, pas un combat plat

Le combo est rendu en GIF + spritesheet + JSON, prêt à être joué dans un moteur ou présenté sur LinkedIn.

Si une de ces conditions n'est pas remplie, refais les leçons concernées avant de prétendre avoir validé.
