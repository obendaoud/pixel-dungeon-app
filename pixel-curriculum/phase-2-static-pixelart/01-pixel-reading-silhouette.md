# 2.1 - Lecture du pixel et silhouette

## Durée estimée

6h

## Objectif d'apprentissage

Comprendre que le pixel art se juge d'abord à la silhouette (forme noire pleine), et savoir produire des silhouettes lisibles en 16x16, 32x32 et 48x48.

## Théorie

Un sprite raté est presque toujours raté à la silhouette. Avant la couleur, avant le détail, avant l'ombre, il y a la forme.

**Test du blackout.** Prends ton sprite, remplis tout de noir. Tu obtiens une silhouette. Pose-toi la question : sans aucune information de couleur ni de détail, est-ce qu'on lit ce que c'est ? Une silhouette d'épée doit lire comme une épée. Une silhouette de personnage doit avoir une tête, un corps, des bras, des jambes distinguables.

**Pourquoi c'est critique en pixel art.** Tu travailles à très basse résolution. À 32x32 pixels, un personnage humanoïde fait 32 pixels de haut. La tête fait 7-8 pixels, le corps 10, les jambes 10, les pieds 5. Si la silhouette n'est pas lisible, aucun shading ne sauvera le sprite. À 48x48 (Monsieur Obo), tu as plus de marge mais le principe reste : silhouette d'abord.

**Règles de silhouette lisible :**

1. **Asymétrie.** Une silhouette parfaitement symétrique est moins lisible qu'une silhouette qui penche, qui a un bras plus haut, une arme d'un côté. Le contrapposto (poids sur une jambe) suffit pour casser la symétrie sans déformer.

2. **Contour brisé.** Si tu peux entourer ta silhouette d'un cercle parfait, c'est probablement raté. Une silhouette intéressante a des bosses, des creux, des extensions.

3. **Échelle des éléments.** En basse résolution, tu dois exagérer. La tête doit être plus grosse que dans la réalité (proportions chibi). Le casque doit déborder. L'arme doit être visible en silhouette.

4. **Lecture en 1 seconde.** Si après 1 seconde de regard, tu ne sais pas ce que c'est, la silhouette est ratée.

**Méthode de construction.**

1. Choisis une référence (photo, dessin, autre sprite). Affiche-la à côté.
2. Crée un canvas à la taille cible. Dessine la silhouette pleine en noir, sans aucun détail intérieur.
3. Itère 5 à 10 fois. Efface, recommence. Une silhouette n'est jamais bonne au premier jet.
4. Test de lecture : ferme les yeux 5 secondes, ouvre, regarde. Tu vois ce que c'est ? Si non, refais.
5. Demande un avis externe (forum, discord). Si la personne ne reconnaît pas en moins de 3 secondes, la silhouette est trop ambiguë.

**Erreurs typiques de débutant :**

- Silhouette trop fine : le personnage est tout maigre, illisible à distance
- Silhouette en T : symétrique, statique, sans personnalité
- Détails ajoutés trop tôt : tu détailles avant que la masse soit bonne
- Pieds collés : on ne distingue pas les deux jambes
- Tête trop petite : à 32x32, une tête de 5 pixels est illisible

**Outils Aseprite utiles.**

- Layer "blackout" : duplique ton sprite, applique Filters > Outline > Solid Fill ou simplement Edit > Replace Color > tout en noir
- Mode Indexed avec palette à 1 couleur (noir) pour forcer la lecture silhouette
- Vue à 100% (zoom 1x) pour vérifier la lisibilité à taille native

## Démonstration

- Chaîne MortMort, "Pixel Art Silhouette" (rechercher exact). Observe le test du blackout, l'itération sur la silhouette, la réécriture multiple.
- Chaîne AdamCYounis, "Insignia Devlog" épisodes où il dessine des characters (rechercher "AdamCYounis Insignia character"). Observe son obsession pour la silhouette.
- Chaîne Pixel Pete, "Drawing Characters in Pixel Art" (rechercher exact).

## Exercice pratique

Produis 5 silhouettes de personnages différents en 32x32, toutes en mode Indexed avec une palette à 1 couleur (noir pur), fond transparent.

Liste imposée :

1. Un guerrier avec épée
2. Un mage avec bâton
3. Un voleur avec capuche
4. Un archer avec arc
5. Un nain avec hache double

Critère interne : sans légende, un observateur tiers doit pouvoir associer chaque silhouette à son rôle.

Produis aussi une planche horizontale 160x32 qui les regroupe (l'une à côté de l'autre), pour comparer.

## Critère de validation binaire

OUI si :

- 5 fichiers `.aseprite` 32x32 produits
- Tous les fichiers en mode Indexed, palette à 1 seule couleur (noir)
- Aucun pixel non-noir et non-transparent dans les fichiers
- La planche 160x32 contient les 5 silhouettes alignées avec 0 pixel d'espacement
- Tu peux décrire en 1 mot par silhouette ce que c'est, et un observateur externe (Claude jouera ce rôle, en se basant sur la silhouette seule sans ton commentaire) doit deviner correctement au moins 4 sur 5

NON sinon.

## Livrables

```
assets/phase-2/lesson-1-silhouette/
  warrior.aseprite
  mage.aseprite
  thief.aseprite
  archer.aseprite
  dwarf.aseprite
  panel.aseprite
  panel.png
  panel-x4.png
```
