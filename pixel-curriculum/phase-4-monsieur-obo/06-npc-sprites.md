# 4.6 - Sprites NPC (2 types)

## Durée estimée

10h

## Objectif d'apprentissage

Concevoir et animer 2 NPC (Non-Player Characters) pour Obo, chacun avec idle et talk.

## Théorie

Les NPC sont les personnages que Obo rencontre et avec qui il interagit (dialogue, quête, commerce). Différents des ennemis : ils ne combattent pas, ils sont en pose de présence, plus expressifs émotionnellement.

**Choix des 2 NPC.**

Tu choisis selon le GDD. Suggestion canonique :

1. **NPC narrateur / sage** : guide, mentor, qui donne des directives. Apparence : robe, capuche, accessoire mystique, bâton.
2. **NPC marchand / fonctionnel** : marchand, forgeron, qui propose un service. Apparence : tablier, accessoire de métier, attitude active.

D'autres options selon GDD : un enfant, un voyageur perdu, un esprit, un animal sentient.

**Animations par NPC.**

1. `idle` : 6 frames, loop. Subtil, mais peut-être un peu plus expressif que celui d'Obo (le NPC est statique en jeu, donc on s'autorise un peu plus).
2. `talk` : 4 frames, loop tant que le dialogue est actif. Head bob ou bouche qui bouge (selon style).
3. Optionnel : `gesture` 4-6 frames one-shot, pour un geste contextuel (le forgeron qui frappe son enclume, le sage qui lève la main).

**Différences avec Obo.**

- Plus statique en idle (mouvement vertical 1 pixel suffit, parfois même 0 si NPC type sage immobile)
- Talk plus marqué que celui d'Obo (le NPC parle "vers" Obo, donc l'animation est mieux visible)
- Pas de walk cycle nécessaire (les NPC restent à leur emplacement)

**4 directions ou pas ?**

Dépend du jeu. Si les NPC peuvent être abordés depuis n'importe quelle direction, oui. Si le NPC est dans un dialogue scénarisé, on peut se contenter d'une direction (souvent face).

Pour cette leçon, on fait 1 direction par NPC (front), car les NPC sont stationnaires et le dialogue se fait toujours en face. Si ton GDD impose 4 directions, ajoute-les.

**Palette.**

Identique à Obo + ennemis (16 couleurs). Cohérence visuelle prioritaire.

**Différenciation des silhouettes.**

Comme pour les ennemis, les 2 NPC doivent être identifiables au premier regard. Le sage et le marchand ne doivent pas avoir la même silhouette :

- Sage : grand, robe longue, élément vertical (chapeau pointu, bâton)
- Marchand : trapu, tablier, attributs horizontaux (table, accessoire au pied)

## Démonstration

- Voir leçons 2.1, 2.9, 4.1 (silhouette, character, sheet)
- Référence sprite : Stardew Valley (NPC variés, expressions claires) ; Eastward (NPC très distincts) ; Children of Morta (NPC narrateurs forts).
- Chaîne MortMort, "Pixel Art NPC Design" (rechercher).

## Exercice pratique

1. Conçois la sheet des 2 NPC : `npc-sheet.aseprite` avec les 2 silhouettes côte à côte
2. Anime chaque NPC : `npc-sage.aseprite` avec tags `idle` et `talk`. `npc-merchant.aseprite` idem.
3. Optionnel : ajoute un tag `gesture` one-shot par NPC
4. Exporte spritesheet + JSON pour les 2

## Critère de validation binaire

OUI si :

- 2 NPC produits, visuellement distincts au test silhouette blackout
- Chaque NPC a 2 animations minimum : `idle` (loop, 6 frames) et `talk` (loop, 4 frames)
- Les 2 fichiers consolidés `npc-sage.aseprite` et `npc-merchant.aseprite` existent
- Mode Indexed, palette identique à celle utilisée pour Obo et les ennemis
- L'amplitude verticale du `idle` est de 1 pixel (subtil)
- Le `talk` a un head bob de 1 pixel d'amplitude
- Les spritesheets et JSON sont exportés avec tags
- La palette utilisée est strictement identique à celle de la character sheet de la leçon 4.1

NON sinon.

## Livrables

```
assets/phase-4/lesson-6-npcs/
  npc-sheet.aseprite
  npc-sheet.png
  npc-sage.aseprite
  npc-sage.png
  npc-sage.json
  npc-merchant.aseprite
  npc-merchant.png
  npc-merchant.json
  sage-talk.gif
  merchant-talk.gif
```
