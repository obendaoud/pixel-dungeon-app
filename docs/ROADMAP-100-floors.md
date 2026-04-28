# Roadmap : 100 étages fonctionnels avec progression folle

Document de design pour étendre Pixel Dungeon de 26 à 100 étages, avec une progression mécanique qui rompt avec le pattern "plus dur, plus profond".

## 1. Vision

100 étages, 4 actes, mécaniques qui se cassent et se réinventent. Pas un donjon plus long : un donjon qui change de règles tous les 25 étages.

**Postulat fondateur** : un roguelike de 100 étages qui ne fait que descendre et grossir devient ennuyeux à l'étage 50. La progression "folle" tient en deux principes :

1. **Variations mécaniques par acte** : chaque acte introduit 1 à 3 mécaniques systémiques nouvelles (gravité inversée, time loop, audio mechanic), pas seulement de nouveaux mobs.
2. **Subversion narrative** : l'objectif change tous les 25 étages. Acte I : descendre. Acte II : tomber. Acte III : trouver une issue. Acte IV : remonter à travers un monde corrompu.

## 2. État actuel

Pixel Dungeon original : 26 étages dans `Dungeon.getLevel(depth)` (cf `src/com/watabou/pixeldungeon/Dungeon.java` lignes 167-222).

| Profondeur | Niveau | Type |
|------------|--------|------|
| 1-4 | SewerLevel | régulier |
| 5 | SewerBossLevel | boss (Goo) |
| 6-9 | PrisonLevel | régulier |
| 10 | PrisonBossLevel | boss (Tengu) |
| 11-14 | CavesLevel | régulier |
| 15 | CavesBossLevel | boss (DM-300) |
| 16-19 | CityLevel | régulier |
| 20 | CityBossLevel | boss (King of Dwarves) |
| 21 | LastShopLevel | utilitaire |
| 22-24 | HallsLevel | régulier |
| 25 | HallsBossLevel | boss (Yog-Dzewa) |
| 26 | LastLevel | utilitaire (amulette) |
| 27+ | DeadEndLevel | game over |

**Acquis techniques** : architecture `Level` / `RegularLevel` / `Painter` / `Room`, terrain enum, traps, features. La structure est extensible.

**Limites actuelles** :

- `getLevel(depth)` est un switch en dur : pas de table de zones, pas d'extension possible sans modifier le switch
- Pas de notion d'**acte** : tous les niveaux sont au même rang sémantique
- Pas de variantes : 1 zone = 1 implémentation `XxxLevel`, pas de "branches"
- Le contenu par étage (mobs, items, traps) est paramétré par profondeur via des constantes scattered

## 3. Cible : 100 étages, 4 actes, 20 zones

| Acte | Étages | Zones | Mécanique systémique |
|------|--------|-------|----------------------|
| I — Descente classique | 1-25 | 5 zones existantes | combat / loot / dungeon |
| II — Strates oubliées | 26-50 | 5 nouvelles zones | environnement hostile (chaleur, froid, ténèbres, asphyxie, corruption) |
| III — Spirale inversée | 51-75 | 5 nouvelles zones | rupture des règles (gravité, temps, miroir, écho, vide) |
| IV — Ascension finale | 76-100 | 5 zones miroir | retour corrompu vers la surface, étages reflétés |

Chaque acte = 25 étages. Chaque zone = 5 étages (4 réguliers + 1 boss). Total : 20 zones × 5 = 100 étages.

### 3.1 Acte I — Descente classique (1-25)

Conservation et polish de l'existant. Pas de nouvelle zone, mais consolidation.

| Profondeur | Zone | Boss | Notes |
|------------|------|------|-------|
| 1-5 | Sewers | Goo | existant, polish des layouts |
| 6-10 | Prison | Tengu | existant, polish |
| 11-15 | Caves | DM-300 | existant, polish |
| 16-20 | City | King of Dwarves | existant, polish |
| 21-25 | Halls | Yog-Dzewa | existant, polish |

L'ancien étage 26 (LastLevel / amulette) devient le **trigger d'entrée dans l'acte II**. Le joueur récupère l'amulette mais une mécanique narrative la "perd" / "transforme" et ouvre l'acte II.

### 3.2 Acte II — Strates oubliées (26-50)

5 nouvelles zones, chacune avec un environnement hostile qui ajoute une mécanique passive.

| Profondeur | Zone | Boss | Mécanique env. |
|------------|------|------|----------------|
| 26-30 | Forge | Furnace King | tile lave qui inflige des DOT, vapeurs aveuglantes par moment |
| 31-35 | Crypt | The Lich | ténèbres permanentes, vision réduite à 3 cases sans torche |
| 36-40 | Library | Whispering Tome | scrolls hostiles (pages flottantes qui agressent), zones de silence |
| 41-45 | Garden | Verdant Heart | spores qui se propagent (status négatifs aléatoires), plants ennemies |
| 46-50 | Vault | The Goldsmith | gravité d'or (l'or au sol attire le joueur), gardiens incorruptibles |

**Implémentation par zone** :

- 1 nouvelle classe `XxxLevel extends RegularLevel`
- 1 nouvelle classe `XxxBossLevel extends Level`
- 1 set de tiles dédié (tilesheet 16x16, à intégrer comme `tiles5.png` à `tiles9.png`)
- 3-5 nouveaux mobs par zone
- 1-2 nouveaux items thématiques par zone
- 1 nouvelle mécanique d'environnement (`Blob` / `Buff` / `Trap` selon nature)

### 3.3 Acte III — Spirale inversée (51-75)

5 zones qui rompent les règles fondamentales du jeu.

| Profondeur | Zone | Boss | Mécanique systémique |
|------------|------|------|----------------------|
| 51-55 | Mirror Halls | Mirror Self | les mobs sont des copies du joueur avec une portion de son inventaire |
| 56-60 | Gravity Wells | The Pull | sens de la gravité change tous les N tours (Nord, Est, Sud, Ouest) |
| 61-65 | Time Loop | The Watcher | l'étage redémarre toutes les K rounds, le progrès partiel persiste |
| 66-70 | Echo Chambers | The Resonance | vision réduite, mais bruits d'autres mobs audibles via UI textuel ou audio |
| 71-75 | Void Reach | The Eater | les items disparaissent progressivement de l'inventaire si non utilisés |

**Risque technique** : ces mécaniques touchent des systèmes core (mouvement, tour de jeu, vision, inventaire). Implémentation incrémentale obligatoire.

### 3.4 Acte IV — Ascension finale (76-100)

Retour à la surface à travers les zones de l'acte I, mais corrompues. Chaque zone est une "version inversée" de la zone correspondante de l'acte I.

| Profondeur | Zone | Boss | Inversion |
|------------|------|------|-----------|
| 76-80 | Corrupted Halls | Yog Reborn | layouts inversés, mobs amplifiés |
| 81-85 | Tainted City | Dwarf Lich | les NPCs marchands sont devenus hostiles |
| 86-90 | Burning Caves | DM-666 | les pièces sont en feu permanent |
| 91-95 | Bloody Prison | Tengu Trinity | 3 Tengus simultanés |
| 96-100 | Final Sewer | The First Goo | retour à l'origine mais boss ultime à 100 |

**Étage 100 — confrontation finale** : un boss spécifique, peut-être hommage au joueur lui-même (cf Mirror Self acte III, mais mortel).

## 4. Mécaniques transversales

Quelques mécaniques fonctionnent à travers plusieurs actes pour donner une cohérence.

### 4.1 Système d'actes

Nouvel enum `Act { ONE, TWO, THREE, FOUR }` calculé depuis `Dungeon.depth` :

```
ONE   : depth 1-25
TWO   : depth 26-50
THREE : depth 51-75
FOUR  : depth 76-100
```

Méthodes statiques `Dungeon.act()`, `Dungeon.zone()`, `Dungeon.zoneFloor()`.

### 4.2 Refactor de getLevel()

Remplacer le switch de `Dungeon.getLevel(depth)` par une table de zones :

```
private static final Zone[] ZONES = {
  new Zone(1,  5,  Sewer, Goo),
  new Zone(6,  10, Prison, Tengu),
  ...
  new Zone(96, 100, FinalSewer, FirstGoo),
};
```

Puis `getLevel(depth)` itère sur la table et instancie la classe Level configurée.

### 4.3 Méta-progression (optionnel V2)

À chaque fin d'acte, un débloquage permanent (nouveau personnage, nouveau starting item, nouvelle classe). Pas obligatoire pour les 100 étages fonctionnels mais structure incitative pour la rejouabilité.

### 4.4 Difficulty curve

Stats ennemies, drops, résistance bosses scalent par profondeur. Courbe non linéaire :

- 1-25 : linéaire douce (existant)
- 26-50 : pente plus forte
- 51-75 : palier (mécaniques compensent la difficulté brute)
- 76-100 : pic exponentiel

Constants à introduire dans une nouvelle classe `Balance` ou via override par zone.

## 5. Milestones d'implémentation

Découpage en 7 milestones, chacun produit un build jouable et testable.

### M1 — Foundation (semaine 1-2)

**Objectif** : refactoriser `getLevel()` en table, introduire `Act` / `Zone` abstractions, sans casser le comportement existant.

**Livrable** : le jeu se joue exactement comme avant (étages 1-26), mais le code est prêt pour extension.

**Critère de validation** :
- [ ] Test manuel : run complet 1 → 26 sans régression
- [ ] Aucune classe Level existante modifiée (juste refactor du dispatcher)
- [ ] Code review : table `ZONES` lisible et extensible

### M2 — Acte II première zone : Forge (26-30) (semaine 3-5)

**Objectif** : implémenter une seule nouvelle zone complète (Forge, profondeurs 26-30) pour valider le pipeline.

**Livrables** :
- `ForgeLevel.java` extends `RegularLevel`
- `ForgeBossLevel.java` extends `Level`, avec `FurnaceKing` comme boss
- Tileset Forge (sera fait par toi en pixel art ; en attendant, palette swap des Caves)
- 3 nouveaux mobs : `LavaImp`, `MoltenGolem`, `EmberRat`
- 2 nouveaux items : `ForgedSword`, `EmberAmulet`
- Mécanique : tile lave (DOT 5/turn) + vapeur (blind 3 turns aléatoire)

**Critère de validation** :
- [ ] Run 1 → 30 jouable et finissable
- [ ] FurnaceKing tuable
- [ ] Aucune régression sur les étages 1-25
- [ ] Tests unitaires sur ForgeLevel.create() et boss spawning

### M3 — Acte II zones 2-5 (semaine 6-12)

**Objectif** : compléter l'acte II (Crypt, Library, Garden, Vault).

**Livrables** : pour chaque zone, mêmes livrables que M2 multipliés par 4.

**Critère de validation** :
- [ ] Run 1 → 50 jouable et finissable
- [ ] Les 4 nouveaux bosses tuables
- [ ] Build Android compile et tourne
- [ ] Playtest : compléter l'acte II prend 90-180 minutes

### M4 — Système d'actes et difficulté (semaine 13-14)

**Objectif** : introduire `Act` / `Difficulty` / `Balance`, calibrer les courbes.

**Livrables** :
- `Act.java` enum
- `Balance.java` constants table
- Tooltips UI : afficher l'acte courant
- Music switch par acte (asset audio à fournir séparément)

### M5 — Acte III : mécaniques systémiques (semaine 15-22)

**Objectif** : implémenter les 5 zones de l'acte III, qui demandent des modifications du core.

C'est le **morceau le plus risqué techniquement**. Un sprint par zone.

| Sprint | Zone | Risque core touché |
|--------|------|--------------------|
| Sprint 1 | Mirror Halls (51-55) | mob AI : copier inventory du joueur |
| Sprint 2 | Gravity Wells (56-60) | movement system : direction de gravité globale |
| Sprint 3 | Time Loop (61-65) | level state save/restore par tour |
| Sprint 4 | Echo Chambers (66-70) | vision system + audio bridge |
| Sprint 5 | Void Reach (71-75) | inventory : item degradation |

**Critère de validation par sprint** :
- [ ] Run 1 → étage de fin de sprint jouable
- [ ] Mécanique fonctionne dans tous les cas testés (5 scenarios par sprint)
- [ ] Performance : pas de drop FPS notable

**Critère de validation M5** :
- [ ] Run 1 → 75 jouable et finissable
- [ ] Aucun crash récurrent
- [ ] Playtest externe (1-2 testeurs) : l'acte III est ressenti comme distinct et "weird"

### M6 — Acte IV : zones miroir (semaine 23-28)

**Objectif** : 5 zones miroir des zones de l'acte I, layouts inversés ou randomisés agressivement.

**Livrables par zone** : variants de la zone d'origine (héritage de classe avec override de painter et de mob spawn table). Implémentation plus rapide que M3 / M5 car repose sur l'existant.

**Critère de validation** :
- [ ] Run 1 → 99 jouable
- [ ] Les 5 zones miroir lisent comme "the same place but corrupted"
- [ ] Bosses miroir distincts mécaniquement de leur version acte I

### M7 — Étage 100 et endgame (semaine 29-31)

**Objectif** : boss final à 100, ending narratif, endgame ouvert.

**Livrables** :
- `FinalLevel100.java`
- Boss ultime (à designer plus tard)
- Cinematic d'ending (texte ou animation simple)
- Save d'endgame : option "+1" pour relancer en mode "New Game Plus"

**Critère de validation** :
- [ ] Run complet 1 → 100 finissable par un joueur expérimenté
- [ ] Durée totale d'un run réussi : 8 à 15 heures (équivalent d'un run roguelike long)
- [ ] Stable : 5 runs complets de suite sans crash bloquant

## 6. Estimation totale

| Milestone | Durée | Cumul |
|-----------|-------|-------|
| M1 | 2 semaines | 2 |
| M2 | 3 semaines | 5 |
| M3 | 7 semaines | 12 |
| M4 | 2 semaines | 14 |
| M5 | 8 semaines | 22 |
| M6 | 6 semaines | 28 |
| M7 | 3 semaines | 31 |

**Total** : ~31 semaines à temps plein, soit **6 à 8 mois** en plein régime, **12 à 18 mois** en temps partiel.

À 10h/semaine : 31 × 4 = 124 semaines, soit 2.5 ans. Ambitieux mais pas absurde si le projet est prioritaire.

## 7. Risques techniques

### 7.1 Régressions sur 1-26

Tout refactor du dispatcher `getLevel()` peut casser les étages existants. Mitigation : suite de tests automatisés avant M1, vérification après chaque commit.

### 7.2 Mécaniques systémiques (acte III)

Toucher au movement, vision, inventory peut introduire des bugs subtils. Mitigation : feature flags, possibilité de désactiver une mécanique à la volée, tests unitaires forts.

### 7.3 Performance

100 étages avec mob count cumulatif + scrolling memory peut tirer sur la perf Android. Mitigation : profiling après M3 et M5, optimisations ciblées.

### 7.4 Volume de contenu

20 zones × ~5 mobs × ~2 items × tiles dédiées = environ 100 nouveaux mobs, 40 items, 15 tilesets. C'est massif. Mitigation : réutiliser des palettes / animations existantes pour 50% du contenu, créer du nouveau pour les 50% restants.

### 7.5 Equilibre difficulté

Une courbe mal calibrée rend l'acte II trop dur ou l'acte IV trivial. Mitigation : playtest dès M3, une session de tuning à la fin de chaque acte.

## 8. Hors scope (V1)

Pour rester focalisé sur les 100 étages fonctionnels, sont exclus de cette roadmap :

- Multijoueur
- Online leaderboard
- Modding tools
- Localisation (autre que la langue actuelle)
- Re-design UI complet
- Refactor du save system (sauf si M5 le force)
- Nouveau moteur de rendu

Tout ça peut faire l'objet d'une V2 après les 100 étages livrés.

## 9. Métriques de succès

À la fin de M7 :

- [ ] Un joueur expérimenté peut compléter un run 1 → 100 en 8-15h
- [ ] Le taux de crash est < 1% par session
- [ ] Le ratio "runs commencés / runs finis" est entre 5% et 15% (équilibre roguelike sain)
- [ ] Le retour playtest sur les actes II et III est : "ça change vraiment des roguelikes classiques"

## 10. Décisions à valider avant M1

Avant de commencer l'implémentation, ces points doivent être tranchés :

- [ ] **Compatibilité saves** : on casse les saves existantes ou on migre ? (recommandé : casser, le jeu original n'est pas en prod live)
- [ ] **Branche de dev** : tout sur `master` au fur et à mesure, ou une branche `100-floors-dev` jusqu'à M3/M5 ?
- [ ] **Java cible** : Java 8 (compat Android historique) ou Java 11+ (modernisation) ?
- [ ] **Tests** : on adopte un framework (JUnit 5) avant M1 ou on ajoute au fil de l'eau ?
- [ ] **CI** : on configure une CI avant M1 ?
- [ ] **Asset pipeline** : qui produit les tilesets / sprites des 15 nouvelles zones ? (toi en pixel art, moi pour les placeholders en palette swap ?)

Une fois ces 6 points tranchés, on peut commencer M1.
