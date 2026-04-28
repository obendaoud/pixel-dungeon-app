# 5.8 - VFX d'impact (shockwave, particles, dust)

## Durée estimée

24h

## Objectif d'apprentissage

Animer 3 types de VFX d'impact distincts : shockwave radial, particles éclat, dust expansion, qui complètent les coups en pixel art combat anime.

## Théorie

Les VFX (visual effects) d'impact sont des effets qui apparaissent **au point de contact** d'un coup. Indépendants du sprite character, ils s'animent sur leur propre timeline, souvent intégrés en jeu via un système de particules ou un sprite VFX overlay.

**Shockwave radial.**

Un cercle (ou anneau) qui s'expand depuis le point d'impact. Animation type 4-8 frames :

- Frame 1 : un seul pixel ou cluster de 2-3 pixels au point d'impact
- Frame 2 : cercle de rayon 4 pixels, épaisseur 1-2 pixels
- Frame 3 : cercle de rayon 8 pixels, épaisseur 1-2 pixels
- Frame 4 : cercle de rayon 12 pixels, épaisseur 1-2 pixels, plus translucide (couleur plus claire de la ramp)
- Frame 5 : cercle de rayon 16 pixels, presque transparent
- Frame 6 : cercle disparu

Couleur : typiquement blanc ou jaune sur fond sombre, ou couleur signature du coup. Le cercle peut être plein ou en pointillé pour un effet plus stylisé.

À 24 fps, 6 frames = 250ms. La shockwave dure le temps du hit stop + un peu après.

**Particles éclat.**

Des fragments / pixels qui jaillissent du point d'impact dans plusieurs directions. Animation type 6-10 frames :

- Frame 1 : 8-12 pixels regroupés au point d'impact, prêts à partir
- Frame 2 : pixels dispersés à 3-5 pixels du point d'impact, dans 8-12 directions différentes
- Frame 3 : pixels dispersés à 6-10 pixels du point, certains commencent à tomber (gravité)
- Frame 4 : pixels à 10-15 pixels, trajectoires en arc (chute)
- Frame 5-6 : pixels qui finissent de tomber, certains au sol
- Frame 7-8 : pixels qui disparaissent (couleur qui fade)

Couleur : selon le matériau impacté (rouge / blanc pour chair, gris pour métal, bois pour bois). Pour un coup de poing dans la chair, blanc cassé + rouge / orange.

**Dust expansion.**

Un nuage de poussière qui s'expand depuis le point d'impact (souvent au sol). Animation type 6-8 frames :

- Frame 1 : petit cluster de 4-6 pixels gris au point d'impact
- Frame 2 : cluster qui s'expand, 8-10 pixels, plus large que haut
- Frame 3 : cluster encore plus large, 12-14 pixels, commence à monter (vertical)
- Frame 4 : nuage qui s'élève, 16x10 pixels en forme de champignon
- Frame 5 : nuage large mais translucide
- Frame 6 : nuage qui se dissipe, pixels éparpillés
- Frame 7-8 : disparition

Couleur : ramp de gris et beige, plus claire au centre (intensité), plus sombre en bordure.

**Combinaison.**

Pour un coup vraiment impactant, tu combines les 3 :

- Shockwave : circulaire, lit comme "onde de choc"
- Particles : multidirectionnel, lit comme "éclat / dégâts"
- Dust : vertical, lit comme "poussière soulevée"

Les 3 partent du même point au même moment (au moment de l'impact), mais ont des animations distinctes (durées, directions, couleurs).

**Layered animation pour les VFX.**

Chaque VFX sur un layer séparé. Tu peux les activer / désactiver indépendamment pour tester. En jeu (Godot), chaque VFX peut être un sprite séparé instancié au point d'impact.

**Frame timing des VFX.**

Les VFX commencent à la frame d'impact (white flash) et durent souvent plus longtemps que le hit stop : ils continuent pendant la phase de recovery du coup. Cela donne une "traînée d'effet" qui prolonge l'impression d'impact.

## Démonstration

- Chaîne PixelOverload, "VFX in Pixel Art" et "Particle Effects" (rechercher).
- Chaîne HYUN's dojo, "Impact VFX" (rechercher).
- Chaîne Toyoxi, posts de shockwaves et particles (rechercher).
- Chaîne BrandonJamesGreer, "Pixel Art FX Tutorial" si disponible (rechercher).
- Référence visuelle : observer les frames d'impact de Hades 2D (très bien fait), Hollow Knight (vectoriel mais référence stylistique), Dead Cells, et toute super move de KOF XIII.
- Sprites pro : Vanillaware games (Dragon's Crown, Odin Sphere) pour leurs VFX très soignés en sprite art.

## Exercice pratique

Produis 3 VFX standalone, chacun sur son propre fichier 64x64 pour une réutilisation facile :

1. `vfx-shockwave.aseprite` : shockwave 6 frames, 24 fps, palette 8 couleurs (blanc, gris clair, gris moyen, gris sombre + 4 accents)
2. `vfx-particles.aseprite` : particles éclat 8 frames, 24 fps, palette 10 couleurs (rouge / orange / blanc + dégradés)
3. `vfx-dust.aseprite` : dust expansion 7 frames, 24 fps, palette 6 couleurs (beige / gris)

Pour chacun, exporte en spritesheet horizontal + JSON.

Bonus : produis une version `vfx-combined.aseprite` qui montre les 3 VFX joués en simultané sur un canvas 96x96, prêt à être posé "par-dessus" un point d'impact.

## Critère de validation binaire

OUI si :

- 3 fichiers `.aseprite` produits, chacun 64x64
- `vfx-shockwave.aseprite` : 6 frames, le cercle s'expand entre frame 1 (rayon ~2) et frame 5 (rayon ~16-20)
- `vfx-particles.aseprite` : 8 frames, au minimum 8 particles distinctes éparpillées dans 8 directions différentes à la frame 3
- `vfx-dust.aseprite` : 7 frames, le nuage s'élève visiblement entre frame 1 (au sol) et frame 5 (au-dessus)
- Mode Indexed pour les 3 fichiers
- Chaque VFX a son spritesheet et son JSON exportés
- Optionnel : `vfx-combined.aseprite` montre les 3 VFX simultanément sur 96x96

NON sinon.

## Livrables

```
assets/phase-5/lesson-8-vfx/
  vfx-shockwave.aseprite
  vfx-shockwave.png
  vfx-shockwave.json
  vfx-particles.aseprite
  vfx-particles.png
  vfx-particles.json
  vfx-dust.aseprite
  vfx-dust.png
  vfx-dust.json
  vfx-combined.aseprite     (optionnel)
  vfx-combined.gif          (optionnel)
  shockwave.gif
  particles.gif
  dust.gif
```
