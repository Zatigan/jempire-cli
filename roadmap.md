# RoadMap
## Contrainte technique 

- Boucle principale

- Gestion des ressources

- Conditions de victoire / défaite

- Prévoir des while, switch, if

- Documentation
	- Section installation & lancement depuis le terminal :
		Explication de comment compiler (javac)
		Explication de comment lancer (java)

- Utilisation du camelCase pour les variables / méthodes

- Utilisation du PascalCase pour les class

- Code commenté en français

- Types primitifs en priorité !

- Code simple, propre et découpé



## Etat Initial

- Bois = 0			static int
- Pierre = 0			static int
- Or = 50			static int
- Nourriture = 100		static int
- Habitants = 1			static int
- Mine				static bool
- Château			static bool (pas affiché en début de tour mais permet de prendre en compte la condition de fin de game)
- Tours de jeu = 0 		static int
- Tout le monde a mangé		static bool

## Conditions
 (while !château ou habitant = 0) 

Victoire = création d'un château (donc boucle principale autour de cette condition)

Défaite = si tout les habitants n'ont pas à manger, YOU LOSE ! (dans le futur, si le nombre d'habitants est égal à 0)

## Tour de jeu (boucle do)
Déroulé d'un tour de boucle : 

- Message : "Une nouvelle journée commence, voici les ressources à votre disposition :"

- Affichage des ressources en stock

- Message : "Que voulez-vous faire aujourd'hui ?"

- Affichage du menu d'actions (switch case en utilisant les numéros ; 1 fonction par option du menu)

ATTENTION : Les coûts et les gains sont à multiplier par le nombre d'habitants SAUF pour le château !

## Menu in-game

 1.  Explorer la forêt (static void)
		Coût : 0
		Gains :
			Bois +5
			Nourriture +3
		Affichage d'un message d'information ("Vous gagnez X ressources")
		Modification des variables associées à l'action (gain / perte)

2. Créer une mine (static void)
		Condition : Si mine = true OU bois < 10 => construction impossible
			    Si mine = false ET bois >= 10 => construction
		Coût (fixe car bâtiment) : - 10 bois
		Gain : accès à la mine
		Affichage d'un message d'information ("Vous construisez une mine")
		Modification des variables associées à l'action (gain / perte)
	
3. Travailler à la mine (static void)
		Condition : la mine doit être déjà construite sinon impossible
		Coût : -5 nourriture
		Gains :
			Pierre +5
			Or +2
		Affichage d'un message d'information (""Vous gagnez X ressources")
		Modification des variables associées à l'action (gain / perte)

4. Recruter un soldat (static void)
		Coût : Or -30
		Gain : Habitant +1
		Affichage d'un message d'information ("Vous gagnez X ressources")
		Modification des variables associées à l'action (gain / perte)

5. Commercer (static void)
		Coût : Pierre -5
		Gain : Or +10
		Affichage d'un message d'information ("Vous gagnez X ressources")
		Modification des variables associées à l'action (gain / perte)

6. CONSTRUIRE LE CHÂTEAU (static void)
		Coût : 
			Bois -100
			Pierre -100
			Or -200
			Habitants >= 40
		Affichage d'un message d'information ("Vous construisez un château")
		Modification des variables associées à l'action (gain / perte)
### Condition Du Menu

Une fois sorti du menu : 
	"Les habitants prennent un repas bien mérité ! Vous perdez X nourriture."
	SI nourriture < nbre d'habitants = PERDU
	X = au nombre d'habitants présents dans le village.

Nouveau message :
	"Fin de la journée Y, tout le monde file se coucher !"
	Y = correspond au nombre de tour de boucle réalisé

## Fin De Tour

- Les villageaois mange 1 de nourriture chacun 
- Passage au jour suivant (tour de boucle)



## Ameliorations Futures
- Implémenter des champs qui contre x bois (?) donne une génération passive limitée de nourriture tous les jours.

- Implémenter Construire des maisons, qui demande X bois. Chaque 2 maisons, fait +1 habitant / tour.

- Créer variable de soldats à incrémenter lors du recrutement. Finalité = besoin de 40 soldats pour construire le château, et pas 40 habitants.

- Chaque habitant peut réaliser une action différente.

- Création d'une class pour les ressources puis créer un fichier à part appelé dans game ?
  
- Si tous les habitants n'ont pas de nourriture, soustraire uniquement le nombre d'habitants n'ayant pas à manger du total d'habitants. => OK

- Empêcher le travail à la mine tant que la mine n'est pas construite (donc vérification à faire sur la variable mine). => OK

- Afficher un message d'erreur pour construire le château tant que TOUTES les conditions ne sont pas respectées => OK
