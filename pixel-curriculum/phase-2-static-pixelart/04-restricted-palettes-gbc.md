# 2.4 - Palettes restreintes et contrainte GBC

## Durée estimée

6h

## Objectif d'apprentissage

Comprendre la contrainte palette GBC, construire une palette de 16 couleurs cohérente, et dessiner sous contrainte stricte.

## Théorie

La Game Boy Color (GBC, 1998) avait un système graphique basé sur :

- 32 768 couleurs possibles dans le hardware (5 bits par canal RGB)
- 8 palettes de background simultanées, chacune de 4 couleurs
- 8 palettes de sprite simultanées, chacune de 4 couleurs (dont 1 transparente)
- Maximum 56 couleurs visibles simultanément à l'écran

Donc un sprite GBC strict = 4 couleurs (ou 3 + transparent). La GBC peut afficher plusieurs palettes simultanément, donc dans un même écran tu peux avoir un sprite à 4 couleurs (palette A) à côté d'un autre à 4 couleurs (palette B).

**Pour Monsieur Obo, on utilise GBC étendu : 16 couleurs.** L'idée : on conserve l'esthétique chunky, low-res, palette restreinte de la GBC, mais on s'autorise jusqu'à 16 couleurs par sprite (équivalent à 4 palettes GBC combinées sur un même sprite). Plus de marge pour exprimer le character sans renier le look GBC.

**Pourquoi 16 et pas 32 ou 64.** À 16 couleurs, chaque ajout est un choix. Tu apprends à composer avec peu. À 64 couleurs, tu te dilues, tu perds la rigueur.

**Structure d'une palette de 16 couleurs.** Tu organises en ramps. Une ramp est une suite ordonnée du foncé au clair pour une "famille" de couleur. Pour Monsieur Obo, on vise :

- 1 ramp peau (4 couleurs)
- 1 ramp tissu / vêtement principal (4 couleurs)
- 1 ramp métal / accessoire (3 couleurs)
- 1 ramp environnement / accent (3 couleurs)
- 2 couleurs neutres (noir d'outline, blanc / point lumineux)

Total : 16 exact. Tu peux varier la répartition selon le character mais le principe (3 à 4 ramps + neutres) reste.

**Palette à respecter dans Aseprite.** Mode Indexed obligatoire. Palette importée et verrouillée. Aucune dérogation : si tu as besoin d'une 17e couleur, tu refais ta palette.

**Règles pour une bonne ramp :**

- Saturation augmente vers les valeurs moyennes, baisse aux extrêmes (les noirs et blancs purs sont rares)
- Le hue shift (leçon 2.5) décale légèrement la teinte le long de la ramp
- L'écart de luminosité entre deux couleurs voisines doit être lisible : au moins 15 unités de Value sur 100. Sinon les deux couleurs se confondent.

**Lospec.com.** Les palettes "Sweetie 16", "Resurrect 32", "Endesga 32" sont des palettes communautaires de référence. Pour Monsieur Obo, tu construiras ta propre palette en t'inspirant de "Sweetie 16" (16 couleurs très bien équilibrées) ou de "PicoEncore" (variante Pico-8 16 couleurs).

**Outils Aseprite.**

- Window > Palette pour afficher
- Edit > Replace Color : remplacer une couleur par une autre
- Sprite > Color Mode > Indexed pour passer en mode strict
- Edit > Preferences > Color > New Palette : choisis "Empty" pour partir d'une palette vide quand tu construis la tienne

**Erreur classique.** Tu travailles en RGB et tu te dis "je ferai la palette plus tard". Résultat : tu as 60 couleurs dans ton sprite, tu tentes de réduire à 16 et 80% du sprite est à refaire. Travaille dès le début en Indexed, palette définie d'avance.

## Démonstration

- Chaîne MortMort, "How to Choose Pixel Art Colors" et "Pixel Art Palette Tutorial" (rechercher). Observe la construction d'une palette ramp par ramp.
- Chaîne Brandon James Greer, "How to Choose Colors for Pixel Art" (rechercher exact). Théorie de la palette appliquée. Observe la logique des ramps.
- Site Lospec : navigate "16 colour palettes". Télécharge "Sweetie 16" en `.gpl`.
- Documentation Aseprite : Indexed mode et palette workflow.

## Exercice pratique

1. Télécharge la palette "Sweetie 16" sur Lospec
2. Crée un canvas 48x48 en mode Indexed avec cette palette
3. Dessine un objet de ton choix (potion, épée, casque, livre) en utilisant exactement les 16 couleurs (ou un sous-ensemble explicite si tu n'as besoin que de 8 ou 12)
4. Note dans `notes.md` combien de couleurs tu as utilisées effectivement et pourquoi tu n'as pas utilisé les autres
5. Exporte un PNG taille native + un PNG x4

Variante d'entraînement (pas livrable mais à faire dans la même session) : produis 3 mini-sprites 16x16 différents avec exclusivement la palette "Game Boy" (4 couleurs). Pour t'entraîner à la contrainte stricte.

## Critère de validation binaire

OUI si :

- Le canvas fait 48x48
- Le mode est Indexed
- La palette importée est exactement Sweetie 16, et aucune couleur de la palette ne dépasse l'index 15
- Aucun pixel du sprite n'est hors palette
- Tu as utilisé au minimum 6 couleurs de la palette (pour ne pas tricher en faisant un sprite à 2 couleurs)
- Le fichier `notes.md` documente les couleurs utilisées (numéro d'index ou nom) et celles non utilisées

NON sinon.

## Livrables

```
assets/phase-2/lesson-4-palette-gbc/
  source.aseprite
  export.png
  export-x4.png
  notes.md
```
