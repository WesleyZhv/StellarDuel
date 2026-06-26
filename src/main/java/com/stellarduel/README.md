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
- Intelligence Artificielle : algorithme Minimax (IA classique)
- Programmation Orientée Objet avancée
- JavaFX : GridPane, BorderPane, animations, gestion d'événements
- Pattern Factory (VaisseauFactory)
- Persistance JSON avec Gson (en cours)

## Note sur l'IA
L'IA de ce projet est une IA classique basée sur l'algorithme Minimax.
C'est une première approche intentionnelle avant d'implémenter
une vraie IA avec du Machine Learning (TensorFlow / DL4J) dans un prochain projet.

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