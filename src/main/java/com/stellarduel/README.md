# StellarDuel

Jeu de combat spatial tactique au tour par tour, développé en Java avec JavaFX.
Deuxième projet de portfolio après KitchenFlow, avec une architecture plus mature.

## Stack technique
- Java 24
- JavaFX 21
- Maven
- Gson 2.10.1

## Concepts démontrés
- Architecture MVC stricte (Model / View / Controller)
- Design Patterns : Factory, Observer, Strategy
- Intelligence Artificielle : algorithme Minimax (profondeur 2)
- Tests unitaires avec JUnit 5
- JavaFX avancé : GridPane, BorderPane, StackPane, Canvas, AnimationTimer, Tooltip, ComboBox
- Persistance JSON avec Gson
- Sérialisation/désérialisation de parties sauvegardées

## Fonctionnalités
- Sélection personnalisée de flotte avant chaque partie
- 4 types de vaisseaux : Tank, Sniper, Support, Kamikaze
- 2 niveaux de difficulté : Facile et Normal
- Sauvegarde et chargement de partie
- Fond étoilé animé
- Statistiques des vaisseaux au survol

## Niveaux de difficulté
- **Facile** : IA simple, attaque le premier ennemi à portée
- **Normal** : IA avec algorithme Minimax, anticipe 2 coups à l'avance

## Note sur l'IA
Ce projet utilise une IA classique (Minimax) comme première approche intentionnelle
avant d'implémenter du Machine Learning (TensorFlow / DL4J) dans un prochain projet.

## Lancer le projet
Prérequis : Java 24, Maven

```
mvn javafx:run
```
## Structure
- `model/` : données et logique métier
- `view/` : composants JavaFX uniquement
- `controller/` : orchestration entre Model et View
- `controller/IAController` : logique Minimax