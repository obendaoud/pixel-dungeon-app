# Project Context — Pixel Dungeon → App Store Commercialization

> **Objet** : document de contexte pour reprendre le projet dans une nouvelle
> session Claude Code (ou toute autre IA). Tient lieu de référence stratégique
> et technique.
>
> **Dernière mise à jour** : 2026-04-19
> **Branche de travail** : `claude/enhance-gameplay-features-eRG61`

---

## 1. Objectif commercial

Transformer le repo Pixel Dungeon (Android/Java, licence GPLv3, version 1.9.1)
en un jeu **commercialisable sur l'App Store iOS**, avec une identité propre,
du contenu enrichi et une monétisation éthique.

**Cible** : joueurs adultes 25–40 ans, amateurs de roguelikes mobiles,
nostalgiques de l'ère Game Boy Color.

---

## 2. État actuel du repo

- **Stack** : Java pur, Android, `com.watabou.noosa` (lib custom, non incluse),
  OpenGL ES 2.0.
- **Android manifest** : min SDK 9, target SDK 20 (obsolète — Android 4.4).
- **Permission** : VIBRATE uniquement. Aucune intégration réseau.
- **Contenu** : 505 fichiers Java, 5 régions (Sewers/Prison/Caves/City/Halls),
  4 classes (Warrior/Mage/Rogue/Huntress), ~25 ennemis, ~149 items, 34 buffs.
- **Assets** : sprites 16×16 pixel-art Watabou dans `/assets/` (~60 PNG), sons
  MP3, tilesets `tiles0.png` à `tiles4.png`.
- **Features manquantes pour App Store** : monétisation, Game Center, iCloud,
  analytics, achievements, leaderboards, méta-progression, mode quotidien,
  tutoriel.

---

## 3. Décisions stratégiques prises

### 3.1 Positionnement : **Seuil 3 — jeu inspiré**

| Seuil | Description | Choix |
|---|---|---|
| 1 | Mod / fork fidèle | ❌ |
| 2 | Fork étendu (type Shattered) | ❌ |
| **3** | **Jeu inspiré, IP propre, commercialisable** | ✅ |
| 4 | Jeu totalement original | ❌ (trop coûteux) |

**Implications** :
- Nouveau nom, nouveau branding.
- Assets graphiques 100% remplacés.
- Code réécrit (pas d'héritage GPL).
- On garde : genre (roguelike tour par tour), structure 5 régions, classes,
  boss signatures mais revisités.

### 3.2 Identité visuelle : **GBC stylisé type Zelda: Oracle of Ages**

Pas d'émulation stricte des contraintes GBC (pas de palette swap runtime), mais
un **look GBC assumé** :
- Sous-palettes 4 couleurs fixes par biome.
- Tiles 16×16, shading 3 plans (ombre / base / highlight).
- Contours marqués 1px.
- Font bitmap type GB.
- Cadres de dialogue style Zelda GBC.

**Sous-palettes cibles (à valider)** :

| Sous-palette | Usage | Couleurs (hex) |
|---|---|---|
| Terre/Donjon | Sewers, Prison | `#2a1f1a` `#6b4a3a` `#c9a378` `#f5e3c0` |
| Pierre/Grottes | Caves | `#1a2838` `#3d5a7a` `#7ba3c8` `#d4e8f5` |
| Végétation | Extérieurs, plantes | `#1a2a1a` `#3d6b3a` `#7ac87a` `#d4f5c0` |
| Feu/Magie | Effets, City | `#3a1a1a` `#8a3a3a` `#e8a838` `#f5e8a0` |
| Héros/UI | Sprites joueur, HUD | `#1a1a2a` `#4a4a7a` `#a8a8d8` `#f0f0ff` |

### 3.3 Stack technique cible : **libGDX + MobiVM** (à confirmer)

Même route que Shattered Pixel Dungeon (référence documentée).
- **Pour** : réutilisation massive de la logique Java, build iOS natif via
  MobiVM, multi-plateforme gratuit.
- **Contre** : MobiVM est un fork communautaire ; Unity/Godot restent
  alternatives si on préfère repartir de zéro.

### 3.4 Monétisation éthique

- ✅ Cosmétiques (skins, palettes, trails).
- ✅ Season Pass cosmétique trimestriel.
- ✅ DLC classes / donjons thématiques.
- ❌ Pas d'énergie / timers.
- ❌ Pas de pay-to-win.

---

## 4. Points de vigilance légaux

1. **Licence GPLv3** du code source Pixel Dungeon : contagieuse. Toute
   modification du code oblige à republier sous GPL. **Apple refuse
   régulièrement les apps GPL**.
   → **Action** : réécrire le code, ne pas copier-coller.
2. **Propriété intellectuelle Watabou** : vérifier les droits commerciaux
   avant de lancer.
3. **Assets** : les sprites Watabou ne doivent PAS être dans le build final.

---

## 5. Roadmap — 8 phases

### Phase 0 — Fondations légales & stratégiques (1 semaine)
- Vérifier licence exacte et implications GPL.
- Choisir nom du jeu + domaine + handles réseaux sociaux.
- Créer compte Apple Developer (99 $/an).
- Rédiger bible créative : pitch, ton, USP.

### Phase 1 — Bible graphique GBC (2 semaines)
- Finaliser 5-8 sous-palettes définitives.
- Produire sprites de référence (1 par catégorie).
- Écrire script Python (Pillow) de conversion posterize + quantize.
- Choisir font bitmap GBC (ex: Early GameBoy).
- Redessiner chrome UI style Zelda GBC.

### Phase 2 — Portage technique (2–4 mois)
- Choisir stack définitive (libGDX+MobiVM recommandé).
- Étudier migration noosa→libGDX de Shattered Pixel Dungeon.
- Setup projet multi-plateforme (core / android / ios).
- Réécrire couche rendu/input/audio.
- Porter logique gameplay (réécriture propre).
- Build iOS + TestFlight.

### Phase 3 — Refonte visuelle (2–3 mois, en parallèle Phase 2)
- Convertir 5 tilesets au style GBC.
- Redessiner 4 sprites héros + animations.
- Redessiner ~25 ennemis + bosses.
- Redessiner items, effets, UI.
- Nouveau logo, splash, écran-titre.

### Phase 4 — Nouveau contenu gameplay (2–3 mois)
**Priorité haute (rétention)** :
- Méta-progression (arbre de talents permanents).
- 40–60 achievements + Game Center.
- Quêtes journalières + donjon quotidien à seed partagé.
- Classements Game Center.

**Priorité moyenne (contenu)** :
- 1–2 nouvelles classes (Nécromancien, Druide…).
- Mode Endless + Boss Rush.
- Système de reliques à effets uniques.
- Événements aléatoires d'étage.

### Phase 5 — Intégrations iOS (1 mois)
- Sauvegarde iCloud.
- StoreKit (cosmétiques + DLC).
- Game Center (achievements + leaderboards).
- Haptic feedback + sons remasterisés.
- Privacy manifest + ATT.
- Safe areas / Dynamic Island.

### Phase 6 — Polish & accessibilité (1 mois)
- Tutoriel interactif.
- Difficulté ajustable + New Game+.
- Options accessibilité (daltonisme, taille UI).
- Optimisation 60 fps iPhone SE.
- Traductions EN/FR/ES/DE/JA.

### Phase 7 — Lancement App Store (2 semaines)
- Screenshots + trailer.
- Fiche App Store + ASO.
- Privacy policy + CGU.
- Build final + review.
- Plan communication (Reddit, Twitter, presse indé).

### Phase 8 — Post-lancement (continu)
- Monitoring crashs + analytics.
- Patchs J+7/14/30.
- Season Pass trimestriel.
- Updates majeures tous les 3 mois.
- Portage Android Play Store en V2.

---

## 6. Questions ouvertes à trancher

- [ ] **Nom du jeu** — à définir.
- [ ] **Licence effective** du repo source (GPL confirmé ? autre fork sous MIT ?).
- [ ] **Stack technique définitive** — libGDX vs Unity vs Godot.
- [ ] **Outil de conversion sprites** — l'utilisateur a mentionné un outil dans
      le repo mais non trouvé. À clarifier.
- [ ] **Modèle économique précis** — prix premium one-shot (ex: 4,99 €) ou
      freemium + DLC ?
- [ ] **Périmètre V1** — faut-il livrer les 8 phases ou un MVP plus court ?

---

## 7. Fichiers clés du repo actuel

- `AndroidManifest.xml` — manifest Android (à remplacer pour iOS).
- `src/com/watabou/pixeldungeon/PixelDungeon.java` — activité principale.
- `src/com/watabou/pixeldungeon/Dungeon.java` — état de jeu central.
- `src/com/watabou/pixeldungeon/actors/` — hero, ennemis, buffs.
- `src/com/watabou/pixeldungeon/items/` — 149 items.
- `src/com/watabou/pixeldungeon/levels/` — 18 niveaux.
- `src/com/watabou/pixeldungeon/scenes/` — écrans UI.
- `assets/` — sprites + sons (tous à remplacer).
- `res/` — resources Android (icônes, strings).

---

## 8. Prompt de continuation

> À coller au début d'une nouvelle session Claude Code pour reprendre le projet :

```
Je reprends le projet de commercialisation de Pixel Dungeon sur l'App Store.
Lis d'abord docs/PROJECT_CONTEXT.md à la racine du repo — il contient le
contexte complet : objectifs, décisions stratégiques (positionnement Seuil 3,
identité GBC stylisée type Zelda Oracle of Ages, stack libGDX+MobiVM),
roadmap en 8 phases, questions ouvertes et fichiers clés.

Une fois lu, confirme que tu as bien intégré le contexte, puis demande-moi
sur quelle phase ou question je veux avancer. Ne prends aucune action
irréversible (commit, push, refactor majeur) sans confirmation explicite.
```

---

## 9. Historique des sessions

- **2026-04-19** — Session initiale : analyse du repo, définition du
  positionnement Seuil 3, choix de l'identité GBC, rédaction de la roadmap,
  création de ce document.
