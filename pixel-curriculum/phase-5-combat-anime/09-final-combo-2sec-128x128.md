# 5.9 - Combo final 2 secondes en sprite 128x128

## Durée estimée

60h

## Objectif d'apprentissage

Produire un combo de combat de 2 secondes en sprite 128x128 qui consolide tous les acquis de la phase 5 et passe pour une animation shonen pro.

## Théorie

C'est l'examen final du curriculum. Tu prends tout ce que tu as appris dans la phase 5 (anatomie, line of action, anticipation, smear, impact, hit stop, speed lines, VFX) et tu le mets dans une animation de 2 secondes.

**Cahier des charges.**

- Sprite 128x128
- Durée : 2.0 secondes (exactement, à 24 fps cela fait 48 frames)
- Combo : minimum 3 actions enchaînées (par exemple : punch, kick, ultimate)
- Au moins 2 smear frames
- Au moins 1 impact frame avec white flash
- Au moins 1 hit stop de 3+ frames
- Speed lines visibles pendant les actions
- Au moins 1 VFX d'impact (shockwave OU particles OU dust)
- Anticipation forte sur le coup d'ouverture

**Structure recommandée du combo.**

Beat 1 (frames 1-12, 500ms) : action 1
- 6 frames anticipation
- 3 frames action / smear
- 1 frame impact
- 2 frames hit stop

Beat 2 (frames 13-24, 500ms) : action 2 (transition fluide depuis action 1)
- 4 frames repositionnement
- 2 frames anticipation courte
- 3 frames action / smear
- 1 frame impact
- 2 frames hit stop

Beat 3 (frames 25-48, 1000ms) : action ultime
- 8 frames anticipation forte (charge, aura)
- 4 frames action / smear long
- 2 frames impact (cut frame + white flash)
- 6 frames hit stop dramatique
- 4 frames recovery / pose finale dramatique

Total : 48 frames, 2.0s à 24 fps.

**Choix créatif.**

Le combo peut être :

- Punch + uppercut + super punch
- Slash + slash + final slash (épée)
- Kick + spin kick + jumping ultimate kick
- Plus libre : combinaison d'attaques aux mains et aux pieds

Tu choisis, tu documentes dans `notes.md`.

**Workflow.**

1. **Scénariser** (1h) : décris le combo en mots, frame par frame. Quel coup, quelle pose, quelle direction.
2. **Storyboard pixel** (4-6h) : dessine 6-10 frames clés (key frames) sans les inbetweens. Une frame par "beat" du combo, plus quelques poses critiques.
3. **Inbetweens** (20-30h) : remplis les frames intermédiaires en respectant timing et spacing. C'est le gros du travail.
4. **VFX et FX cinétiques** (10-15h) : ajoute speed lines, smear, impact, VFX d'impact, aura.
5. **Polish** (5-10h) : revue frame par frame, correction des incohérences, ajustement timing des holds.
6. **Export** (1h) : spritesheet, JSON, GIF.

**Layers Aseprite recommandés.**

- `body` : le character principal
- `body-extras` : cheveux, cape, accessoires animés
- `vfx-aura` : auras de charge
- `vfx-impact` : white flashes, cut frames, distortion
- `vfx-shockwave` : ondes radiales
- `vfx-particles` : éclat / debris
- `vfx-dust` : poussière au sol
- `speed-lines` : trails et lignes radiales
- `bg-lines` : optionnel, fond avec speed lines de background

Tu peux activer / désactiver chaque layer pour vérifier l'isolement de chaque effet.

**Itération.**

Tu n'auras pas un combo parfait au premier jet. Plan : produis une version V1 en 30h. Critique-la (lis-la 50 fois en boucle). Identifie les 5 problèmes les plus visibles. Corrige en V2 (10-15h supplémentaires). Re-critique. V3 si nécessaire. Le but n'est pas perfection, c'est un combo qui passe les critères de validation.

**Revue par un pair.**

À ce stade, tu as fait beaucoup de travail. Avant de soumettre à Claude pour validation finale, partage le GIF avec :

- Un autre pixel artist (forum / discord)
- Un animateur traditionnel
- Un fan de shonen anime

Demande : "qu'est-ce qui ne lit pas ?". Note les retours, ajuste.

## Démonstration

- Tout ce que tu as vu dans les leçons 5.1 à 5.8 est applicable. Re-regarde si nécessaire.
- Référence à étudier en frame-by-frame avant de commencer ton combo :
  - Une scène de combat shonen 2-3 secondes (par exemple Tanjiro hinokami kagura, JJK Itadori divergent fist, Garou super attack)
  - Une animation de combat KOF XIII complète (un super move) au ralenti
- Chaîne PixelOverload, "Pixel Art Combat Animation Tutorial" si disponible (rechercher).
- Chaîne HYUN's dojo, "How to Animate Combat" et démos longues (rechercher).

## Exercice pratique

Produis le combo final selon le cahier des charges.

1. `notes.md` : scénarisation du combo (15 lignes max). Description de chaque beat, du character, et des effets utilisés.
2. `keyframes.aseprite` : 6-10 key frames seulement (poses critiques)
3. `combo-final.aseprite` : 48 frames complètes, 128x128, mode Indexed avec palette 32-48 couleurs
4. `combo-final.gif` : export GIF, durée totale 2.0s
5. `combo-final.png` : spritesheet 6144x128 pixels (48 frames de 128 alignées) ou alternative en plusieurs lignes
6. `combo-final.json` : JSON Aseprite avec tags par beat (`beat1`, `beat2`, `beat3` couvrant les frames respectives)
7. `breakdown.png` : composition statique qui montre les frames clés annotées avec les techniques utilisées (anticipation, smear, impact, hit stop, etc.). Pour LinkedIn.

## Critère de validation binaire

OUI si :

- Le fichier `combo-final.aseprite` existe, 128x128, exactement 48 frames
- Mode Indexed, palette 32-48 couleurs
- Durée totale exactement 2.0s à 24 fps (vérifiable dans le timeline Aseprite)
- Au minimum 3 actions enchaînées identifiables visuellement (les 3 beats)
- Au minimum 2 smear frames identifiables (le bras / la jambe étirés sur 1 frame chaque)
- Au minimum 1 white flash (silhouette pleine en couleur claire) sur la frame d'impact d'un des coups
- Au minimum 1 hit stop de 3 frames consécutives identiques (la pose d'impact tenue)
- Speed lines visibles pendant les frames d'action (vérifiable layer `speed-lines`)
- Au moins 1 VFX d'impact présent (vérifiable parmi les layers `vfx-shockwave`, `vfx-particles`, `vfx-dust`)
- Anticipation forte (>= 6 frames) sur le coup d'ouverture (beat 3 si c'est l'ultimate, ou beat 1 si tu pars fort)
- Le `combo-final.gif` est lisible et "passe" pour une animation shonen / combat anime (Claude jugera à l'oeil le résultat global)
- `breakdown.png` produit pour LinkedIn

NON sinon. Si NON, identifie le critère manquant et refais une passe ciblée.

## Livrables

```
assets/phase-5/lesson-9-final-combo/
  notes.md
  keyframes.aseprite
  combo-final.aseprite
  combo-final.gif
  combo-final.png
  combo-final.json
  breakdown.png
  layers-isolated/                  (optionnel : exports de chaque layer isolé pour debugging et content social)
    body-only.gif
    vfx-only.gif
    speed-lines-only.gif
```

Une fois cette leçon validée, le curriculum complet est terminé.
