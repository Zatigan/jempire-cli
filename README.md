# jempire-cli

## ![Drapeau français](https://raw.githubusercontent.com/stevenrskelton/flag-icon/master/png/16/country-4x3/fr.png) Qu'est ce que c'est ?
C'est un petit jeu qui se joue uniquement dans le Terminal de votre ordinateur. Votre objectif est de construire un château pour remporter la partie. Pour cela, vous devrez gérer vos villageois et ressources dans un gameplay en tour par tour. 

## Installation et lancement du jeu

Pour tester le jeu sur votre ordinateur, vous devez installer le Java Developper Kit (JDK). Vous pouvez utiliser le package proposé par [Adoptium](https://adoptium.net/fr/temurin/releases?version=8&os=windows&arch=x64&package=jre) qui est gratuit.

Une fois installé, vous pouvez récupérer le projet en le clonant sur votre propre machine.
`https://github.com/Zatigan/jempire-cli.git`

Ouvrez le dossier, faites un clic-droit "Ouvrir dans le Terminal".

`javac -d build/ src/Game.java`
La commande ci-dessus lance le build du fichier Game.java rangé dans le dossier src. Vous allez alors mettre à jour le dossier _build/_ et le fichier _Game.class_.

`java -cp build/ Game`
La commande ci-dessus lance le jeu compilé dans le fichier _Game.class_ dans le terminal.

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
Voici le fichier qui nous a guidé à la création de ce petit jeu en Java. Plusieurs éléments présents dans celui-ci ont subi des évolutions au gré du développement et de notre réflexion sur le projet. <br/>
Vous trouverez également des idées de développement futures, certains déjà implémentés, d'autres peut-être ultérieurement !

## ![Drapeau anglais](https://raw.githubusercontent.com/stevenrskelton/flag-icon/master/png/16/country-4x3/gb.png) What is it ?
It's little game played only in your Terminal. Your goal is to build a castle to win the game. To do so, you will have to manage your villagers and ressources in a turn-based gameplay.

## Install and launch game

First of all, to test the game on your computer, you need to install the Java Developper Kit (JDK). You can use the package offered by [Adoptium](https://adoptium.net/fr/temurin/releases?version=8&os=windows&arch=x64&package=jre) which is free to use.

Once installed, you can clone the project on your computer.
`https://github.com/Zatigan/jempire-cli.git`

Open the folder, do a right click inside the window "Open in Terminal".

`javac -d build/ src/Game.java`
This command starts the build of the file Game.java stored in _src_ folder (it is compiling the code). This will update the _build/_ folder and _Game.class_ file.

`java -cp build/ Game`
The command above will start the compiled file using the Game class.

## JEmpire the game
### Synopsis
When the game begin, you are handling a village with just one villager. To win the game, you have to build a castle that requires plenty of resources.

Here are the actions you can do on at your turn : 
- **Explore the forest** : you earn some wood and food
- **Build a mine** : gives you access to the mine
- **Going to the mine** : you earn some stone and gold
- **Recruit** : recruit one villager
- **Trade** : you earn some gold
- **Build the castle** : you win !

### Win / lose conditions
Each turn, you can only do one action. It may cost you few resources and will make you earn others.

If you build the castle, you win immediately win the game.

If your villagers can not be fed at the end of current turn, you will lose the amount of not fed people. If you reach 0 food and you can't feed your villagers, you lose the game !

## [RoadMap](roadmap.md)
Here is the document (written in French) that guided us through the creation of this little game in Java. Several elements explained in there have evolved all along the development and our thoughts regarding the project.<br/>
You will  find there also some ideas about potential future features, some already implemented, some others may be later !

## Auteurs | Authors
Zatigan & [Théo Pouzet](https://github.com/PouzetTheo)