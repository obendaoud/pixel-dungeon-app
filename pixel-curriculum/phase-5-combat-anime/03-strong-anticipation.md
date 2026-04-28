# 5.3 - Anticipation forte

## Durée estimée

20h

## Objectif d'apprentissage

Animer une anticipation longue et forte (4-8 frames) qui prépare une action explosive, principe fondamental de l'animation de combat shonen.

## Théorie

Tu as vu l'anticipation en leçon 3.4 (4 frames). En combat anime, on parle d'anticipation **forte** : 4 à 8 frames d'anticipation, parfois plus pour un coup ultime. C'est ce qui donne le sentiment "ça va lourder" avant un coup décisif.

**Pourquoi l'anticipation forte est critique en shonen.**

Le shonen vit de la dramatisation des coups. Le spectateur doit ressentir la puissance du coup avant qu'il arrive. L'anticipation longue :

- Permet au spectateur de suivre du regard
- Crée la tension dramatique
- Justifie l'amplitude du coup (plus la prep est longue, plus le payoff est gros)
- Permet d'insérer des effets cinétiques (dust, charge, aura)

**Anatomie d'une anticipation forte.**

Sur 6 frames type :

- Frame 1 : pose neutre (point de départ)
- Frame 2 : amorce du recul (le character commence à se ramasser)
- Frame 3 : recul plus marqué (pic d'amplitude inverse)
- Frame 4 : pic d'anticipation (position la plus opposée à l'action). HOLD long ici (50-100ms vs 30-40 pour les autres frames de transition).
- Frame 5 : début du déchargement, commencement de l'action
- Frame 6 : pic d'action

Note : la frame 4 est tenue 1.5-3x plus longtemps que les transitions. C'est ce hold qui fait que le spectateur "voit" la prep.

**Anticipation visuelle vs physique.**

L'anticipation peut être :

- **Physique** : le corps se déforme (squat, recul, twist). Le plus courant.
- **Visuelle** : le character ne bouge pas physiquement mais ses cheveux s'agitent, ses vêtements se déploient (vent invisible), une aura apparaît. Très anime.
- **Hybride** : les deux ensemble. La plupart des coups shonen importants.

Pour cette leçon, on commence avec l'anticipation physique. La visuelle sera ajoutée en leçon 5.7 (speed lines / FX).

**Exemples d'anticipations canoniques.**

- **Coup de poing droit** : épaule droite recule, bras droit se replie vers l'oreille, buste se tord vers la droite, jambe arrière se charge. Tout dirigé vers l'arrière.
- **Coup de pied tournoyant** : jambe d'attaque commence à monter et se replier, hanches commencent à tourner dans le sens inverse de la rotation finale.
- **Frappe descendante (épée à 2 mains)** : bras qui montent au-dessus de la tête, buste qui se tord en arrière, regard concentré.
- **Charge avant** : poids transféré sur la jambe arrière, buste vers l'avant, bras armé.

**Hold de l'anticipation.**

Le hold de la frame 4 est crucial. C'est ce qui distingue un combat amateur ("le coup arrive trop vite, je n'ai rien vu") d'un combat pro ("je sentais le coup arriver, c'était énorme"). En frames :

- Hold court (40-60ms) : action rapide / faible
- Hold moyen (80-120ms) : action moyenne / lourde
- Hold long (150-200ms) : action ultime / boss attack

À 24 fps, 200ms = 4-5 frames de hold. Tu peux choisir de répéter une frame plusieurs fois plutôt que de modifier la frame duration. Aseprite gère les deux mais répéter visuellement (en dupliquant la cell) est plus visible dans la timeline.

**Cohérence entre anticipation et action.**

L'amplitude de l'anticipation doit matcher l'amplitude de l'action. Petite anticipation = petite action. Grosse anticipation = grosse action. Si tu fais 8 frames d'anticipation et 2 frames d'action faible, le spectateur est frustré (pas de payoff).

## Démonstration

- Voir leçon 3.4 et la chaîne AlanBeckerTutorials (Anticipation principle).
- Chaîne HYUN's dojo, "Combat Animation Anticipation" (rechercher).
- Chaîne Toyoxi, exemples de coups anime avec anticipation forte (rechercher Toyoxi sur Twitter / YouTube).
- Référence visuelle : observer en frame-by-frame des coups ultime de JJK (Domain Expansion sequences), Demon Slayer (Hinokami Kagura), KOF XIII (super moves). Compter les frames d'anticipation vs frames d'action.
- Sprites pro : KOF XIII frame data (publiquement disponible online), tu peux étudier les anticipations frame par frame.

## Exercice pratique

Anime une seule action (coup de poing droit, frontal, character 128x128) en 12 frames totales :

- Frame 1-6 : anticipation forte
- Frame 7-9 : action explosive (le coup part, traversée du bras)
- Frame 10-12 : recovery (retour à la garde)

Détail :

1. Reprends le character de la leçon 5.1 / 5.2
2. Frame 1 : pose de garde (de la leçon 5.2 pose 1)
3. Frame 2-3 : amorce du recul de l'épaule droite, bras qui commence à se replier
4. Frame 4 : pic d'anticipation, bras armé loin en arrière, hanches tordues
5. Frame 4 a une durée de 150ms (vs 40ms pour les autres) - hold long
6. Frame 5 : déchargement, hanches qui commencent à pivoter
7. Frame 6 : transition action
8. Frame 7-9 : bras qui s'étend, point de contact à la frame 8 ou 9
9. Frame 10-12 : retour vers la pose de garde

Frame duration totale : ~700-800ms.

Tag `punch_right`, loop désactivé (one-shot).

## Critère de validation binaire

OUI si :

- Le canvas fait 128x128
- L'animation contient 12 frames
- Mode Indexed, palette 32-48 couleurs (cohérente avec leçons 5.1/5.2)
- La frame 4 (pic d'anticipation) montre le bras d'attaque clairement plus loin en arrière qu'à la frame 1 (recul visible de >= 8 pixels du poing)
- La frame 4 a une durée >= 100ms, supérieure à au moins 2x la durée des frames de transition
- Les frames 7-9 montrent le bras qui s'étend vers l'avant
- Le point de contact (frame 8 ou 9) est lisible (bras le plus tendu, poing le plus en avant)
- Les frames 10-12 retournent à une pose proche de la frame 1
- Tag `punch_right` présent

NON sinon.

## Livrables

```
assets/phase-5/lesson-3-anticipation/
  source.aseprite
  punch.gif
  spritesheet.png
  spritesheet.json
  frames-breakdown.png   (chaque frame numérotée avec durée annotée pour LinkedIn)
```
