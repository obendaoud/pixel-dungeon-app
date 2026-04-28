# Pixel Art & Animation Curriculum

Parcours d'apprentissage du pixel art et de l'animation, du zéro absolu jusqu'à la production d'un combo de combat anime de 2 secondes en sprite 128x128.

## Pourquoi ce repo

Deux objectifs simultanés :

1. **Court terme (3 à 6 mois)** : produire les sprites et animations de "L'Odyssée de Monsieur Obo", roguelike narratif sur Godot 4, esthétique Game Boy Color étendu (48x48, 16 couleurs).
2. **Long terme (12 à 24 mois)** : maîtriser l'animation de combat style anime / shonen (références JJK, KOF XIII, Garou Mark of the Wolves), avec smear frames, impact frames, hit stop, anticipation forte, speed lines.

## Profil de départ

- Zéro expérience en dessin
- Aseprite installé, jamais utilisé
- Aucune notion des 12 principes de l'animation
- Dessin à la souris
- 5 à 10h disponibles par semaine
- Horizon 12 à 24 mois

## Structure du parcours

5 phases, environ 41 leçons au total. Chaque phase produit un cap technique mesurable.

| Phase | Sujet | Durée estimée | Leçons |
|-------|-------|---------------|--------|
| 1 | Maîtrise d'Aseprite | 2 à 3 semaines | 6 |
| 2 | Pixel art statique | 8 à 12 semaines | 9 |
| 3 | Animation basics | 8 à 12 semaines | 8 |
| 4 | Production Monsieur Obo | 12 à 16 semaines | 9 |
| 5 | Combat anime | 24 à 36 semaines | 9 |

À 7h par semaine en moyenne, le parcours complet tient sur 14 à 18 mois. À 5h, sur 22 à 26 mois.

## Comment utiliser ce repo

1. Lis `CLAUDE.md` pour comprendre comment Claude Code intervient en session
2. Consulte `PROGRESS.md` pour voir où tu en es
3. Ouvre la prochaine leçon non cochée et lance la session avec Claude Code en disant "session leçon X.Y"
4. Produis le livrable demandé, range-le dans `assets/phase-X/lesson-Y-slug/`
5. Demande la validation à Claude. Tant que c'est NON, tu re-travailles. Quand c'est OUI, tu passes à la suivante.

## Format imposé d'une leçon

Chaque leçon contient :

- Titre et numéro
- Durée estimée en heures
- Objectif d'apprentissage en une phrase
- Théorie de 300 à 500 mots
- Démonstration externe (lien YouTube précis)
- Exercice pratique avec format de sortie défini
- Critère de validation binaire
- Liste des fichiers livrables

## Convention de livrables

```
assets/phase-X/lesson-Y-slug/
  source.aseprite
  export.png
  export-x4.png
  notes.md
```

`source.aseprite` est le fichier de travail. `export.png` est l'export taille native. `export-x4.png` est l'export 4x pour visualisation et LinkedIn. `notes.md` est optionnel.

## Politique de progression

- Pas de saut de leçon (les prérequis sont contrôlés)
- Validation binaire : oui ou non, jamais "presque"
- Réessai illimité, sans pénalité
- La phase 4 ne démarre pas tant que les phases 1 à 3 ne sont pas validées
- La phase 5 ne démarre pas tant que la phase 4 n'est pas validée

## Production de contenu LinkedIn

Le dossier `social-content/` contient un plan de contenu par phase et des templates de captions courts et professionnels. La règle : pas de contenu social tant qu'une leçon n'est pas validée. Pas d'avant après si c'est juste un avant.

## Ressources externes

Toutes les ressources externes (chaînes YouTube, livres, outils) sont consolidées dans `references/`. Auteurs principaux suivis :

- MortMort (fondamentaux pixel art, exercices)
- AdamCYounis (composition, animation, design)
- Pixel Pete (animation, dynamique)
- Brandon James Greer (théorie palette, lumière)
- HYUN's dojo (combat animation, smear, impact)
- Toyoxi (animation fluide, FX)
- AlanBeckerTutorials (12 principes de l'animation)
- PixelOverload (effets de combat, smear frames)

## Statut

Voir `PROGRESS.md`.
