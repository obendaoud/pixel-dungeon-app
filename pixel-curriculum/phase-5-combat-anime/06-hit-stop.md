# 5.6 - Hit stop et frame timing

## Durée estimée

16h

## Objectif d'apprentissage

Implémenter le hit stop dans une animation de combat : freeze de plusieurs frames sur l'impact qui amplifie la sensation de poids et de puissance.

## Théorie

Le hit stop est un **freeze temporaire** de l'animation au moment de l'impact. Pendant 2 à 8 frames (80-330ms à 24 fps), le sprite reste figé dans la pose de contact. Cela crée une sensation tactile de "ça cogne fort" : le mouvement est arrêté par la collision, ressenti par le spectateur comme un weight transfer.

**Pourquoi.**

Trois fonctions :

1. **Sensation de poids** : sans hit stop, un coup paraît passer "à travers" la cible. Avec hit stop, le coup paraît "être bloqué" par la cible, ce qui communique une force.
2. **Lisibilité** : le spectateur a quelques frames de plus pour enregistrer ce qui se passe (le coup connecte, qui frappe qui, où).
3. **Drama** : le freeze crée un moment dramatique. Plus le hit stop est long, plus le coup paraît important.

**Ne pas confondre hit stop et impact frame.**

- Impact frame : une frame visuellement différente (white flash, distortion, cut). Effet **visuel**.
- Hit stop : plusieurs frames identiques tenues plus longtemps. Effet **temporel**.

Tu peux les combiner : 1 frame d'impact (white flash) puis 3 frames de hit stop (la pose de contact figée).

**Durée du hit stop.**

- Coup léger : 2 frames de hit stop (~80ms)
- Coup moyen : 3-4 frames (125-165ms)
- Coup ultime : 5-8 frames (200-330ms)

Plus de 8 frames de hit stop : ça paraît cassé, le spectateur attend que ça reprenne. Sauf coup vraiment ultime (boss kill, super move final).

**Implémentation en pixel art.**

Deux méthodes :

**Méthode 1 : Frame duration prolongée.**

Tu prends 1 seule frame (la pose de contact) et tu lui donnes une durée longue (par exemple 250ms au lieu de 40ms).

Avantage : économie de frames dans le spritesheet.

Inconvénient : pas de variation visuelle pendant le freeze (ça paraît un peu plat).

**Méthode 2 : Frames identiques répétées.**

Tu dupliques la pose de contact en 3-5 frames consécutives. Chacune dure 40-50ms. Tu peux ajouter une légère variation à 1-2 des copies (tremblement de 1 pixel pour suggérer la vibration de l'impact).

Avantage : tu peux ajouter des micro-variations qui rendent le hit stop "vivant".

Inconvénient : plus de frames dans le spritesheet, donc plus de RAM dans le moteur.

Pour cette leçon, on utilise la **méthode 2** avec micro-variation. C'est ce qui rend les hit stops shonen vivants.

**Camera shake (suggéré).**

En complément du hit stop, beaucoup de jeux pixel art ajoutent un **camera shake** au moment de l'impact : la caméra bouge de 2-4 pixels pendant 3-5 frames. Implémenté côté moteur (Godot, Unity), pas dans le sprite lui-même. Mais l'animation doit "anticiper" le shake en ne plaçant pas d'éléments critiques au pixel près qui se confondraient avec le shake.

**Frame timing global d'un coup avec hit stop.**

Anatomie type d'une attaque avec impact frame + hit stop :

- Frames d'anticipation : 6 frames, durée standard (40ms chacune)
- Frames d'action / smear : 3 frames, durée courte (40ms)
- Frame d'impact (white flash) : 1 frame, durée standard (40ms)
- Frames de hit stop : 4 frames identiques de la pose de contact, durée standard (40ms chacune)
- Frames de recovery : 4 frames, durée standard

Total : 18 frames, ~720ms.

Le hit stop apparaît "naturel" en lecture car les 4 frames identiques produisent un freeze visible mais pas cassant.

## Démonstration

- Chaîne New Frame Plus, "Why Hit Stop Feels So Good" (rechercher). Analyse théorique du hit stop dans les jeux.
- Chaîne PixelOverload, "Hit Stop in Pixel Art" (rechercher).
- Chaîne HYUN's dojo, "How to Animate Hits" (rechercher).
- Référence : Smash Bros (Nintendo) utilise du hit stop massif. Étudier les frames de hit en frame-by-frame.
- Référence anime : ralentir des frames de combat de JJK / Demon Slayer pour identifier les freezes (souvent 3-5 frames identiques au moment du contact).

## Exercice pratique

Reprends `punch-impact.aseprite` de la leçon 5.5. Tu vas y ajouter un hit stop.

1. Sauve sous `punch-hitstop.aseprite`
2. Après la frame d'impact (white flash, frame 9) et la frame de pose d'impact (frame 10), insère 3 frames supplémentaires identiques à la frame 10
3. Le hit stop fait donc 4 frames totales (la frame 10 + 3 répliques)
4. Sur l'une des 4 frames de hit stop (typiquement la 2e ou 3e), ajoute une **micro-variation** : déplace tout le character de 1 pixel à droite, ou ajoute un cluster de 2-3 pixels d'éclat près du point d'impact (effet vibration)
5. L'animation passe de 13 à 16 frames
6. Frame duration : 40ms par frame de hit stop, 80ms si tu utilises la méthode 1 sur l'une d'elles
7. Tag `punch_hitstop`

Bonus : produis une seconde version `punch-noslow-hitstop.aseprite` SANS hit stop, et compare les deux côte à côte. Tu devrais ressentir une différence importante.

## Critère de validation binaire

OUI si :

- Le fichier `punch-hitstop.aseprite` existe, 128x128, 16 frames
- Mode Indexed, palette 32-48 couleurs
- 4 frames consécutives correspondant au hit stop sont présentes (la pose d'impact tenue)
- Au moins 1 des 4 frames de hit stop a une micro-variation visible (1 pixel de translation, ou cluster d'éclat ajouté)
- Durée totale du hit stop : au minimum 160ms (4 x 40ms)
- À la comparaison avec `punch_impact.gif` de la leçon 5.5, le `punch_hitstop.gif` paraît plus impactant
- Tag `punch_hitstop` présent

NON sinon.

## Livrables

```
assets/phase-5/lesson-6-hitstop/
  punch-hitstop.aseprite
  punch_hitstop.gif
  spritesheet.png
  spritesheet.json
  comparison-no-hitstop-vs-hitstop.gif
  hitstop-frames-isolated.png    (les 4 frames de hit stop, agrandies)
```
