# 4.1 - Character sheet et turnaround d'Obo

## Durée estimée

10h

## Objectif d'apprentissage

Établir la character sheet définitive de Monsieur Obo : palette de 16 couleurs verrouillée, turnaround 4 directions (front, back, left, right), proportions et silhouette de référence.

## Théorie

Le character sheet est le document de référence pour toutes les animations à venir. Sans sheet, tu auras des incohérences entre l'idle et le walk, entre la vue de face et la vue de dos. Avec sheet, tu fixes les proportions et les couleurs une fois pour toutes.

**Contenu d'un character sheet pour Monsieur Obo.**

1. **Palette définitive**, 16 couleurs, organisée en ramps avec hue shifting. Chaque couleur a un nom et un index (ex : `skin-shadow`, `cape-mid`, `metal-light`).
2. **Turnaround 4 directions** : Obo de face, de dos, de profil gauche, de profil droit. Tous statiques, en pose neutre, à la même taille (48x48).
3. **Schéma proportions** : ratio tête / corps / jambes annoté sur le sprite de face.
4. **Closeup tête** : tête zoomée 4x avec annotation des features (yeux, nez, bouche, accessoire).
5. **Notes texte** : description du character, statut, ce qui le distingue.

**Décisions à prendre maintenant et à figer.**

- Hauteur du character (en pixels) : recommandé 36-40 pixels sur 48 de canvas, laissant 4-6 pixels de marge en haut et 2-4 en bas
- Direction de la lumière : haut gauche
- Couleur d'outline : sombre coloré (par exemple violet-bleu sombre, pas noir pur)
- Style des yeux : pixels (1, 2, 4) ou trait
- Présence d'une cape ou non
- Arme visible sur le character au repos ou non

Toutes ces décisions sont à reporter dans le character sheet.

**Pourquoi 4 directions et pas 8.**

8 directions (front, back, left, right + 4 diagonales) demande 4 sprites de plus. Pour un roguelike narratif top-down, 4 directions suffisent. Si le GDD impose 8, tu refais ce sheet en 8 directions au lieu de 4.

**Ratio palette.**

Pour Obo, on s'attend à environ :

- 4 couleurs peau (visage, mains)
- 4 couleurs vêtement principal (le manteau / la robe / la tenue)
- 3 couleurs accessoire (chapeau, ceinture, accessoire signature)
- 2 couleurs accent (yeux, détails)
- 2 couleurs neutres (outline, blanc cassé)
- 1 couleur réservée (ombre projetée au sol, ou cape, ou détail)

Total : 16 exact.

**Workflow recommandé.**

1. Lis le GDD d'Obo une dernière fois. Note les éléments visuels clés.
2. Cherche 5-10 références visuelles : sprites GBC existants, illustrations Studio Ghibli, photos de personnages similaires
3. Construis la palette dans Aseprite, 16 slots remplis avec hue shifting visible
4. Dessine la silhouette de face (32-40 pixels de haut sur 48 de canvas), itère 5-10 fois
5. Une fois la silhouette de face validée, fais le shading complet (face)
6. Reproduis en 3/4 gauche, 3/4 droit, dos. Proportions strictement identiques.
7. Annote le schéma proportions sur un layer séparé
8. Exporte les 4 vues sur une planche horizontale (192x48)

## Démonstration

- Chaîne AdamCYounis, "How to Design Pixel Art Characters" (rechercher). Vidéo de référence sur le design char et le turnaround.
- Chaîne MortMort, "Designing Pixel Art Characters" (rechercher).
- Référence sprite : turnaround de Pokemon Gold/Silver (GBC, look proche de notre cible) ; Castlevania Aria of Sorrow (GBA, niveau de détail similaire) ; Stardew Valley.
- Jeu de référence pour Obo : si tu as des screenshots de jeu inspirants pour le ton (Children of Morta, Death's Door, Hyper Light Drifter pour le minimalisme), garde-les en référence visuelle.

## Exercice pratique

Document complet, plusieurs fichiers.

1. `palette.aseprite` : un canvas 16x16 avec les 16 couleurs en damier, chacune nommée dans la palette Aseprite (double-clic sur slot, Name)
2. `front.aseprite` : Obo vu de face, 48x48, statique, neutre, palette appliquée
3. `back.aseprite` : Obo vu de dos
4. `left.aseprite` : Obo vu de profil gauche (3/4)
5. `right.aseprite` : Obo vu de profil droit (3/4)
6. `turnaround.aseprite` : composition horizontale 192x48 avec les 4 vues alignées
7. `notes.md` : description écrite du character (1 page max), liste des 16 couleurs avec rôle, ratio de hauteur (en pixels), direction de lumière, choix d'outline

## Critère de validation binaire

OUI si :

- Les 7 fichiers sont produits
- La palette contient exactement 16 couleurs nommées
- Les 4 vues respectent strictement la palette (mode Indexed, aucune dérogation)
- La hauteur du character est identique sur les 4 vues (vérifiable au pixel près)
- La silhouette est lisible sur chacune des 4 vues (test blackout)
- Le turnaround composite (192x48) aligne les 4 vues à la même hauteur (axe horizontal commun)
- Le hue shifting est visible sur au moins 3 des 5 ramps (peau, vêtement, accessoire)
- `notes.md` contient les éléments demandés

NON sinon.

## Livrables

```
assets/phase-4/lesson-1-turnaround/
  palette.aseprite
  front.aseprite
  back.aseprite
  left.aseprite
  right.aseprite
  turnaround.aseprite
  turnaround.png
  turnaround-x4.png
  notes.md
```
