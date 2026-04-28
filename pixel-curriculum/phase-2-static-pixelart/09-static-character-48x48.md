# 2.9 - Personnage statique 48x48 GBC étendu

## Durée estimée

10h

## Objectif d'apprentissage

Produire un personnage humanoïde statique 48x48 en palette GBC étendu (16 couleurs), lisible, expressif, qui consolide tous les acquis de la phase 2.

## Théorie

C'est l'examen de fin de phase 2. Tu ne reçois plus d'instructions étape par étape, tu appliques ce que tu as appris. La leçon te rappelle les contraintes et te donne le brief.

**Brief.**

Tu dessines un personnage humanoïde de profil ou de 3/4, en pose statique (idle calme, pas en action). Le format est 48x48 pixels. La palette est de 16 couleurs maximum, organisée en ramps avec hue shifting.

Le personnage doit avoir :

- Une silhouette lisible à 100% de zoom (test silhouette de la leçon 2.1 réussi)
- Une lumière directionnelle cohérente (haut gauche, par convention)
- Au moins 3 matériaux visuellement distincts (peau, tissu, métal ou cuir)
- Un volume crédible (test des primitives de la leçon 2.7 transposé)
- Aucun jaggies, aucun pixel orphelin involontaire (leçons 2.2 et 2.3)

**Étapes recommandées de production.**

1. **Réf et silhouette (2h).** Choisis une référence. Dessine la silhouette pleine en noir, itère 5-10 fois.
2. **Construction de la palette (1h).** 16 couleurs en 3-4 ramps + neutres. Importe ou construis dans Aseprite.
3. **Blocking (2h).** Applique les couleurs de base par zone (peau, vêtement, accessoire). Pas d'ombre ni de highlight encore. Juste les masses.
4. **Volume (3h).** Ajoute ombres et highlights selon la lumière directionnelle. Sphère pour la tête, cylindres pour les membres.
5. **Matériaux et détails (1.5h).** Signature des matériaux (pli de tissu, fibre de cuir, specular de métal). Yeux, bouche, accessoires.
6. **Polish (0.5h).** Vérification anti-jaggies, anti-orphelins, cohérence de palette, test silhouette.

**Anti-pattern : commencer par les détails.** Tu dessines un oeil ultra détaillé avant que la silhouette soit fixée. Tu te retrouves à refaire l'oeil 10 fois. Toujours : silhouette, masses, volume, matériaux, détails.

**Brief libre du character.** Choisis ce que tu veux : un guerrier, un mage, une voyageuse, un marchand, un robot, un démon. Le sujet importe peu. La rigueur d'application des règles, oui.

## Démonstration

- Chaîne AdamCYounis, "How I Make a Pixel Art Character" (rechercher). Vidéo longue, observe le workflow complet (silhouette, masses, shading, détails).
- Chaîne MortMort, "Pixel Art Character Tutorial" (rechercher). Workflow plus rapide.
- Chaîne Pedro Medeiros (Saint11), "Drawing Pixel Art Characters" (rechercher).
- Vidéo de référence à voir : MortMort "How I Made a Pixel Art Character in 1 Hour" (timelapse complet, tu peux suivre les étapes).

## Exercice pratique

1. Définis ton character (1 phrase de description, ex : "voyageur masculin, manteau brun, capuche, sac à dos, épée à la ceinture, profil 3/4 vers la droite")
2. Crée le canvas 48x48, mode Indexed, palette de 16 couleurs construite par toi (ou importée si tu pars de Sweetie 16 ou autre 16 couleurs reconnue)
3. Suis les 6 étapes recommandées
4. Sauve les versions intermédiaires : `step1-silhouette.aseprite`, `step3-blocking.aseprite`, `step5-final.aseprite` (utile pour LinkedIn)
5. Le fichier final est `source.aseprite`

## Critère de validation binaire

OUI si :

- Le canvas fait 48x48
- Mode Indexed, palette de 16 couleurs maximum
- La palette est organisée en ramps identifiables (au moins 3 ramps distinctes par hue, plus des neutres)
- Le hue shifting est visible sur au moins 2 ramps (vérifiable au color picker, hue qui change le long de la ramp)
- La silhouette du character (test blackout) est lisible (Claude joue le rôle d'observateur tiers et doit pouvoir identifier le rôle / type du character en moins de 3 secondes)
- Aucun pixel orphelin involontaire visible à 100%
- 3 matériaux visuellement distincts au minimum
- Une lumière directionnelle cohérente (un seul point de lumière)
- Les 3 fichiers d'étapes intermédiaires sont présents (silhouette, blocking, final)

NON sinon.

## Livrables

```
assets/phase-2/lesson-9-character/
  step1-silhouette.aseprite
  step3-blocking.aseprite
  source.aseprite                  (= step5-final renommé)
  export.png
  export-x4.png
  silhouette.png                    (export silhouette à un seul slot pour test)
  notes.md                          (description du character, palette listée, choix expliqués)
```
