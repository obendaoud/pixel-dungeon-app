# Assets

Tes livrables. Un dossier par phase, un sous-dossier par leçon.

## Structure

```
assets/
  phase-1/
    lesson-1-installation/
    lesson-2-tools/
    lesson-3-layers/
    lesson-4-timeline/
    lesson-5-palettes/
    lesson-6-export/
  phase-2/
    lesson-1-silhouette/
    lesson-2-jaggies/
    lesson-3-clusters/
    lesson-4-palette-gbc/
    lesson-5-hue-shift/
    lesson-6-shading/
    lesson-7-volume/
    lesson-8-textures/
    lesson-9-character/
  phase-3/
    lesson-1-twelve-principles/
    lesson-2-bouncing-ball/
    lesson-3-timing-spacing/
    lesson-4-anticipation/
    lesson-5-follow-through/
    lesson-6-idle/
    lesson-7-walk-cycle/
    lesson-8-run-cycle/
  phase-4/
    lesson-1-turnaround/
    lesson-2-idle/
    lesson-3-walk/
    lesson-4-utility/
    lesson-5-enemies/
    lesson-6-npcs/
    lesson-7-tileset/
    lesson-8-items/
    lesson-9-godot/
  phase-5/
    lesson-1-anatomy/
    lesson-2-dynamic-pose/
    lesson-3-anticipation/
    lesson-4-smear/
    lesson-5-impact/
    lesson-6-hitstop/
    lesson-7-fx/
    lesson-8-vfx/
    lesson-9-final-combo/
```

## Convention de fichiers par leçon

Standard minimum dans chaque dossier de leçon :

- `source.aseprite` : le fichier de travail (binaire Aseprite)
- `export.png` : export PNG taille native
- `export-x4.png` : export PNG zoom 4x pour visualisation et LinkedIn

Pour les leçons d'animation, ajoute :

- `<nom>.gif` : export GIF de l'animation
- `spritesheet.png` : export horizontal strip
- `spritesheet.json` : métadonnées Aseprite (tags, durations, frames)

Voir le détail des livrables attendus à la fin de chaque fichier de leçon.

## Note Git

Les `.aseprite` sont des fichiers binaires. Git les versionne mais le diff n'est pas lisible. Acceptable pour un repo perso de curriculum, moins idéal pour de la prod massive (tu fais grossir le repo).

Si tu veux optimiser :

- Ne commit pas les variantes intermédiaires si elles ne sont pas demandées par la leçon
- Utilise Git LFS si tu commences à dépasser 100 MB de assets total

Pour ce curriculum, simple Git suffit. La taille reste raisonnable même après 41 leçons (estimation 50-200 MB).

## Backup

Sauvegarde régulièrement les `.aseprite` ailleurs que sur ton dépôt local. Recommandation :

- Cloud sync (Drive, Dropbox) du dossier complet du repo
- Push fréquent sur GitHub (privé ou public selon ta préférence)

Un fichier `.aseprite` perdu n'est pas récupérable depuis un PNG.
