# 2.5 - Hue shifting

## Durée estimée

8h

## Objectif d'apprentissage

Construire des ramps de couleur avec hue shift visible, et comprendre pourquoi les ramps "naïves" (juste plus foncé / plus clair) sont fades.

## Théorie

Une ramp naïve est une suite de couleurs où seule la luminosité (Value) change. Tu prends un rouge, tu en fais une version plus sombre et une plus claire. C'est plat. Ça manque de vie.

Le hue shifting consiste à **décaler la teinte (Hue) le long de la ramp**. Au lieu d'aller de "rouge sombre" à "rouge clair" en ligne droite, tu passes par "rouge sombre violet" (hue décalé vers le bleu) puis "rouge orange" puis "jaune clair" (hue décalé vers le jaune). La ramp devient vivante.

**Pourquoi ça marche.** En peinture traditionnelle, les ombres réelles ont une teinte plus froide (bleue, violette) et les highlights une teinte plus chaude (jaune, orange) à cause de la lumière indirecte et de l'illumination ambiante. Reproduire ça en pixel art donne une sensation de profondeur et de chaleur que la ramp neutre n'a pas.

**Règle de pouce.** Quand tu construis une ramp :

- Du foncé vers le clair : Value augmente (évident)
- Du foncé vers le clair : Hue décale typiquement vers le jaune / chaud (les hauts) et vers le bleu / froid (les bas)
- Du foncé vers le clair : Saturation forme une cloche (basse aux extrêmes, haute au milieu)

**Exemple de ramp peau humaine en hue shifting :**

- Index 1 : violet sombre désaturé (ombre profonde) - hue ~270°, sat 30%, value 25%
- Index 2 : brun rose moyen (ombre) - hue ~10°, sat 50%, value 50%
- Index 3 : peau saturée (couleur de base) - hue ~25°, sat 60%, value 75%
- Index 4 : crème jaune clair (highlight) - hue ~45°, sat 35%, value 95%

Tu remarques : le hue passe de 270° (bleu / violet) à 45° (jaune), traversant le rouge orangé. Le saturation est plus haut au milieu. Le value monte régulièrement.

**Anti-pattern : la ramp grayscale.** Tu prends une couleur, tu fais 4 versions juste avec Value qui change. Résultat fade, sans personnalité. Reconnaissable à l'oeil expérimenté (la palette "respire" pas).

**Combien de degrés de hue shift ?**

- Léger : 10-20° (réaliste, sobre)
- Moyen : 20-40° (style stylisé propre)
- Fort : 40-80° (style cartoonish, anime, JRPG classique)

Pour Monsieur Obo, on vise du **moyen à fort** pour rester dans le ton GBC stylisé.

**Application concrète.** Ouvre la roue chromatique (Color picker en mode HSV / Wheel). Trace ta ramp comme une ligne courbe sur la roue, pas comme un point fixe. C'est cette courbe qui donne le caractère.

**Erreurs typiques.**

- Hue shift dans la mauvaise direction : foncé vers chaud, clair vers froid. Inverse, ça ne marche pas
- Hue shift trop violent : palette psychédélique, illisible
- Hue shift seulement sur la luminosité : tu ne décales pas le hue, tu fais une ramp grayscale
- Pas de variation de saturation : la ramp paraît plastique

## Démonstration

- Chaîne Brandon James Greer, "Hue Shifting in Pixel Art" (rechercher exact). Référence absolue sur le sujet, démo visuelle de ramps avec et sans hue shift.
- Chaîne MortMort, "Color Theory for Pixel Art" (rechercher). Démo pratique.
- Chaîne AdamCYounis, "Pixel Art Class - Color" (rechercher). Plus avancé.
- Vidéo de référence à voir absolument : Brandon James Greer "How to Choose Colors for Pixel Art" (la ramp peau y est démontrée pas-à-pas).

## Exercice pratique

Construis 4 ramps de 5 couleurs chacune avec hue shifting visible :

1. Ramp peau humaine claire
2. Ramp tissu rouge (cape, manteau)
3. Ramp métal acier (épée, casque)
4. Ramp végétation verte (feuillage, mousse)

Pour chaque ramp : crée un canvas 100x20 (5 cases de 20x20), place chaque couleur dans une case, ordre du foncé à gauche au clair à droite.

Sur un canvas séparé, dessine 4 sphères de 24x24 (une par ramp) qui appliquent la ramp en shading. Chaque sphère utilise les 5 couleurs de sa ramp.

Vérifie : si tu désaturai chaque ramp en grayscale (Filters > Convert to Grayscale), les 5 cases doivent former une progression claire de luminosité (du noir au blanc cassé, sans saut). C'est le test que ta ramp tient en luminosité.

## Critère de validation binaire

OUI si :

- 4 ramps de 5 couleurs chacune sont produites, dans un fichier `ramps.aseprite` (4 lignes de 5 cases de 20x20, total 100x80)
- Chaque ramp a un hue shift visible : la teinte du dernier slot est différente d'au moins 30° de celle du premier slot (vérifiable au color picker)
- Le test grayscale réussit : chaque ramp en grayscale forme une progression de luminosité monotone (pas de saut, pas de plateau)
- 4 sphères dans `spheres.aseprite` (canvas 96x24 ou 4 fichiers séparés), chacune utilisant exactement les 5 couleurs de sa ramp
- Aucune couleur hors des 4 ramps dans les sphères

NON sinon.

## Livrables

```
assets/phase-2/lesson-5-hue-shift/
  ramps.aseprite
  ramps.png
  ramps-x4.png
  spheres.aseprite
  spheres.png
  spheres-x4.png
```
