# 3.1 - Vue d'ensemble des 12 principes

## Durée estimée

4h

## Objectif d'apprentissage

Citer les 12 principes de l'animation Disney, comprendre leur intention, et savoir lequel est le plus pertinent dans une situation donnée.

## Théorie

Les 12 principes ont été codifiés par Frank Thomas et Ollie Johnston (deux des "Nine Old Men" de Disney) dans "The Illusion of Life" (1981). Ils ne sont pas un dogme, ce sont des outils. La plupart s'appliquent au pixel art tels quels, certains nécessitent une adaptation.

**Les 12 principes :**

**1. Squash and Stretch.** Une matière vivante se déforme. Une balle écrasée à l'impact, étirée en vol. La déformation conserve le volume (si on aplatit, on élargit en compensation). Donne le poids et la flexibilité.

**2. Anticipation.** Avant un mouvement, le corps prépare. Tu te baisses avant de sauter. Tu armes le bras avant de frapper. L'anticipation prévient le spectateur et donne de la lisibilité.

**3. Staging.** La mise en scène. Une pose claire, lisible, qui communique l'intention sans ambiguïté. Inspiré du théâtre.

**4. Straight Ahead Action vs Pose to Pose.** Deux méthodes. Straight ahead : tu animes frame par frame du début à la fin, organique mais imprévisible. Pose to pose : tu poses les key frames d'abord, puis tu fais les inbetweens, contrôlé mais parfois rigide. Le hybride est la norme : key frames + ajout straight ahead pour les détails (cape, cheveux).

**5. Follow Through and Overlapping Action.** Quand le corps s'arrête, les éléments mous (cheveux, vêtements, queue) continuent. Quand le corps bouge, ces éléments suivent avec un retard. Donne de la fluidité et de l'organicité.

**6. Slow In and Slow Out.** Un mouvement naturel n'a pas une vitesse constante. Il accélère depuis l'arrêt (slow in), atteint une vitesse, puis ralentit avant l'arrêt (slow out). Concrètement en animation : plus de frames aux extrêmes (début / fin) et moins au milieu pour un mouvement avec slow in / slow out.

**7. Arcs.** Les mouvements naturels suivent des arcs, pas des lignes droites. Un bras qui balance, une main qui frappe : tout suit une courbe. Tu visualises l'arc (path of motion) et tu places tes inbetweens sur cet arc.

**8. Secondary Action.** Une action principale plus une action secondaire qui la complète. Marcher (primaire) + balancer les bras (secondaire) + remuer la tête au rythme (tertiaire). Le secondaire enrichit le primaire sans le perturber.

**9. Timing.** Le nombre de frames qu'un mouvement prend. 4 frames pour un mouvement explosif, 12 frames pour un geste lent. Le timing détermine le poids et l'urgence.

**10. Exaggeration.** Pour qu'un mouvement lise, on l'exagère. Le visage déformé en peur, le bras tendu plus loin que l'anatomie le permet. Sans exagération en dessin animé, les mouvements paraissent timides.

**11. Solid Drawing.** Le dessin doit avoir du volume, du poids, de la perspective. Pas plat. En pixel art, ce principe se transpose en "le sprite doit avoir un volume crédible" (cf phase 2).

**12. Appeal.** Le character doit être attirant à l'oeil. Pas forcément beau au sens conventionnel : intéressant. Une silhouette unique, une attitude qui parle. C'est l'aboutissement de tous les autres.

**Application au pixel art.** Tous les 12 s'appliquent. En basse résolution, certains demandent de l'exagération supplémentaire (squash and stretch doit être plus marqué pour être lisible à 32x32). D'autres deviennent contraints (les arcs sont approximés en clusters de pixels qui suivent une courbe).

**Pour cette leçon, pas d'exercice complexe.** Le but est de connaître les 12 par coeur et de pouvoir en citer 5 pertinents pour une situation donnée.

## Démonstration

- Chaîne AlanBeckerTutorials, série complète "12 Principles of Animation" (12 vidéos, une par principe). Référence absolue, 5 minutes par vidéo, démonstrations animées. À regarder dans l'ordre, intégralement.
- Livre "The Illusion of Life" de Frank Thomas et Ollie Johnston (Disney). Original, à consulter au moins en partie.
- Chaîne Aaron Blaise, "Animation Basics" (rechercher). Animateur Disney expérimenté, cours sur les principes.

## Exercice pratique

Cet exercice est un mini-quiz, pas un sprite.

1. Crée un fichier `notes.md` dans le dossier livrable
2. Pour chaque principe (1 à 12), écris :
   - Le nom du principe en anglais
   - Une définition en 1 phrase de toi
   - Un exemple concret en pixel art (ex : "squash and stretch sur la queue d'un slime quand il bondit")
3. Sauve et commit
4. Le contrôle se fait par questions orales : Claude te demandera 5 principes au hasard, tu donnes nom et exemple sans relire les notes

## Critère de validation binaire

OUI si :

- Le fichier `notes.md` contient les 12 principes dans l'ordre, avec définition et exemple pour chacun
- Tu peux répondre à 5 questions au hasard de Claude (ex : "donne-moi le nom et un exemple du principe d'anticipation") sans relire les notes
- Tu cites correctement au moins 4 des 5 demandés

NON sinon.

## Livrables

```
assets/phase-3/lesson-1-twelve-principles/
  notes.md
```
