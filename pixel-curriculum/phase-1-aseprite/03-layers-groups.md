# 1.3 - Layers et groupes

## Durée estimée

2h

## Objectif d'apprentissage

Organiser un sprite en layers nommés et groupés, et utiliser les layer modes (Normal, Multiply, Screen) pour le shading non destructif.

## Théorie

Un layer Aseprite est une feuille transparente sur laquelle tu dessines. Plusieurs layers superposés forment l'image finale. La règle de base : **un layer par fonction**, jamais "tout sur le même layer".

**Layers types pour un sprite character :**

- `outline` : le contour (souvent en noir ou couleur foncée)
- `base` : la couleur de fond (silhouette pleine, plus claire que l'outline)
- `shadow` : ombres
- `highlight` : reflets lumineux
- `details` : yeux, accessoires, motifs

L'ordre compte : du bas vers le haut, c'est ce qui est dessous d'abord. Donc base est en bas, outline et highlights sont en haut.

**Création d'un layer.** Bouton `+` dans le panneau Layers, ou clic droit > New Layer. Renomme tout de suite (double-clic sur le nom) sinon tu te perds en 10 minutes. Convention recommandée : noms en minuscules, anglais, sans accent.

**Groupes.** Tu peux empaqueter plusieurs layers dans un groupe (clic droit > New Group, puis drag les layers dedans). Utile pour Monsieur Obo : groupe `body`, groupe `hat`, groupe `weapon`. Tu masques le groupe entier d'un clic, tu déplaces le groupe entier.

**Layer modes (blend modes).** Comme Photoshop. Les utiles en pixel art :

- `Normal` : par défaut
- `Multiply` : les pixels sombres dominent. Pratique pour ajouter des ombres sans choisir la couleur exacte
- `Screen` ou `Add` : les pixels clairs dominent. Pour highlights, lueur, glow
- `Color` : applique la teinte sans changer la luminosité (rare en pixel art à palette stricte)

Attention : en mode Indexed (palette stricte), les blend modes sont contraints par la palette. Ils marchent mieux en mode RGB.

**Opacité.** Curseur Opacity en haut du panneau Layers. À 50%, la base est divisée par deux. Utile pour faire des passes successives, mais dangereux en pixel art car ça crée des couleurs hors palette. Tu utilises l'opacité pour visualiser, pas pour livrer.

**Visibility et lock.** Icône oeil pour cacher / afficher. Icône cadenas pour verrouiller (empêche l'édition accidentelle). Verrouille systématiquement les layers que tu ne touches plus.

**Reference layer.** Clic droit sur un layer > Convert To > Reference Layer. Le layer devient une référence non exportée, pour tracer par-dessus une image. Utile en phase 5 pour suivre une vidéo de combat frame par frame.

**Layer pour animation.** En animation, chaque cel d'un layer correspond à une frame. Tu peux avoir un layer `body` qui change à chaque frame, et un layer `background` qui reste fixe. Tu vois ça en leçon 1.4.

## Démonstration

- Chaîne MortMort, "Aseprite Tutorial - Layers" (rechercher). Observe : la création de layers nommés, le drag pour réorganiser, le passage en mode Multiply pour les ombres.
- Chaîne AdamCYounis, "How I Animate" (rechercher exact, série). Plusieurs vidéos couvrent l'organisation en groupes par partie de corps.

## Exercice pratique

Dans un canvas 48x48 :

1. Crée 4 layers nommés : `outline`, `base`, `shadow`, `details`
2. Sur `base` : dessine une silhouette pleine d'un fantôme (forme cloche, deux pieds en demi-cercles), couleur claire (gris clair par exemple)
3. Sur `outline` : trace le contour de la silhouette en noir, brush 1, Pixel Perfect ON
4. Sur `shadow` (mode Multiply) : peins une ombre sur la moitié inférieure droite, couleur grise moyenne
5. Sur `details` : dessine deux yeux noirs et une bouche
6. Crée un groupe `ghost` qui contient les 4 layers
7. Verrouille les layers `outline` et `base` une fois finis

## Critère de validation binaire

OUI si :

- 4 layers existent avec exactement ces noms : `outline`, `base`, `shadow`, `details`
- Les 4 layers sont dans un groupe nommé `ghost`
- Le layer `shadow` est en mode `Multiply`
- L'ordre vertical (de bas en haut dans le panneau) est : base, shadow, details, outline
- Les layers `outline` et `base` ont leur cadenas activé
- Si tu masques le layer `details`, les yeux et la bouche disparaissent et le reste reste visible

NON sinon.

## Livrables

```
assets/phase-1/lesson-3-layers/
  source.aseprite
  export.png
  export-x4.png
```
