# Palettes recommandées

Toutes téléchargeables depuis Lospec.com en formats `.gpl`, `.hex`, ou `.png`.

## Phase 1 (apprentissage Aseprite)

- **Game Boy** (4 couleurs) : pour exercices à contrainte stricte
  - URL : lospec.com/palette-list/nintendo-gameboy
  - Couleurs : 4 nuances de vert classique GB

## Phase 2 (apprentissage pixel art statique)

- **Sweetie 16** (16 couleurs) : palette équilibrée, idéale pour apprentissage du hue shifting
  - URL : lospec.com/palette-list/sweetie-16
  - Auteur : GrafxKid
  - Très utilisée dans la communauté

- **NA16** (16 couleurs) : alternative à Sweetie 16
  - URL : lospec.com/palette-list/na16
  - Auteur : Nauris Amatnieks

- **Pico-8** (16 couleurs) : palette emblématique du moteur Pico-8
  - URL : lospec.com/palette-list/pico-8
  - Couleurs très spécifiques, look immédiatement reconnaissable

## Phase 4 (Monsieur Obo, GBC étendu 16 couleurs)

Tu construis ta propre palette de 16 couleurs en début de phase. Inspirations possibles :

- **Sweetie 16** comme base
- **GBC custom** : une palette inspirée des jeux GBC (Pokemon Crystal, Wario Land 3, Zelda Oracle of Ages). Pas de palette unique standard, à construire.
- **Resurrect 16** (extraction d'une sélection de 16 couleurs depuis Resurrect 32)

Process de construction :
1. Liste les besoins (peau, vêtement principal, accessoire, environnement)
2. Choisis 1 ramp existante de Sweetie 16 par besoin
3. Modifie chaque ramp pour qu'elle matche le ton souhaité (plus chaud, plus froid, plus saturé)
4. Vérifie que le total fait 16 couleurs et qu'elles sont distinctes en luminosité

## Phase 5 (combat anime, palettes larges 32-48 couleurs)

- **Resurrect 32** (32 couleurs) : ramps multiples bien construites
  - URL : lospec.com/palette-list/resurrect-32
  - Auteur : Kerrie Lake

- **Endesga 32** (32 couleurs) : palette game art classique
  - URL : lospec.com/palette-list/endesga-32
  - Auteur : ENDESGA

- **Endesga 64** (64 couleurs) : version étendue, plus de marge
  - URL : lospec.com/palette-list/endesga-64

- **AAP-64** (64 couleurs) : palette équilibrée pour pixel art moderne
  - URL : lospec.com/palette-list/aap-64
  - Auteur : Adigun A. Polack

- **DB32** (32 couleurs) : Dawnbringer 32, palette historique
  - URL : lospec.com/palette-list/dawnbringer-32

## Tools de conversion

- **Aseprite : Sprite > Color Mode > Indexed** : passe en mode palette stricte
- **Aseprite : Edit > Convert Color Mode** : conversion avec dithering optionnel
- **PalettePicker (web)** : palettepicker.com pour explorer des palettes par tonalité

## Conseil construction palette personnelle

Pour Monsieur Obo, tu construiras ta propre palette en début de phase 4. Process :

1. Référence visuelle : pose côte à côte 5 sprites GBC qui te plaisent
2. Pipette les couleurs dominantes de chacun (garde 30-40 couleurs total brut)
3. Élimine les redondances (couleurs trop proches en HSV)
4. Organise en ramps par hue
5. Réduis à 16 en gardant les plus distinctes et utiles
6. Vérifie en grayscale : la luminosité doit varier, pas de plateau
7. Sauve la palette avec un nom (ex : `obo-palette-v1.gpl`)
8. Verrouille : tout sprite Obo utilise cette palette, sans dérogation

Si en cours de phase tu rencontres un blocage palette (besoin de 17e couleur), arrête, refais la palette, repars.
