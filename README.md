# jempire-cli
A little game played only in Terminal where your goal is to build a castle to win the game. You will have to manage your villagers and ressources on a turn-based gameplay.

## Installation et lancement du jeu

Pour tester le jeu sur votre ordinateur, vous devez installer le Java Developper Kit (JDK). Vous pouvez utiliser le package proposé par [Adoptium](https://adoptium.net/fr/temurin/releases?version=8&os=windows&arch=x64&package=jre).

Lorsque vous avez réussi, vous pouvez récupérer le projet en le clonant sur votre propre machine.
`https://github.com/Zatigan/jempire-cli.git`

Ouvrez le dossier, faites un clic-droit "Ouvrir dans le Terminal".

`javac -d build/ src/Game.java`
La commande ci-dessus lance le build du fichier Game.java.

`java -cp build/ Game`
La commande ci-dessus lance le jeu dans le terminal.

## JEmpire le jeu
### Synopsis
Vous gérez un village avec un seul habitant au départ.
Pour gagner, il vous faut construire un château qui requiert de nombreuses ressources.

Les actions à votre disposition sont les suivantes : 
- **Explorer la forêt** : rapporte du bois et de la nourriture
- **Construire une mine** : donne accès à la mine
- **Aller à la mine** : récupère de la pierre et de l'or
- **Recruter** : recrute un habitant
- **Commercer** : rapporte de l'or
- **Construire le château** : c'est win !

### Conditions de victoire ou défaite
A chaque tour, vous pouvez réaliser une seule action. Celle-ci vous coûtera quelques ressources et vous en rapportera d'autres.

Si vous construisez le château, vous remportez la partie immédiatement.

Si vos habitants ne peuvent pas être nourris à la fin du tour en cours, vous perdez autant d'habitants que le nombre n'ayant pas eu à manger. Si vous avez 0 nourriture, vous perdez la partie !

## [RoadMap](roadmap.md)
Voici le fichier qui nous a guidé à la création de ce petit jeu en Java. Plusieurs éléments présents dans celui-ci ont subi des évolutions au gré du développement et de notre réflexion sur le projet.
Vous trouverez également des idées de développement futures, certains déjà implémentés, d'autres peut-être ultérieurement !

## Auteurs
Zatigan & [Théo Pouzet](https://github.com/PouzetTheo)