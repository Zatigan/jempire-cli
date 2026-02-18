import java.util.Scanner;

public class Game {

  static int wood = 0;
  static int stone = 0;
  static int gold = 250;
  static int food = 100;
  static int villagers = 41;
  static boolean mine = false;
  static boolean castle = false;
  static int days = 1;
  static boolean peopleFed = true;
  static boolean gameEnding = castle == true || !peopleFed;

  public static int readInt(Scanner scanner) {
    return readInt(scanner, "Entrez un nombre :");
  }

  public static int readInt(Scanner scanner, String prompt) {
    System.out.print(prompt);
    String input;
    boolean isValid = false;
    int result = 0;

    do {
      input = scanner.nextLine();

      try {
        result = Integer.parseInt(input);
        isValid = true;
      } catch (Exception e) {
        System.err.print("Entrez un nombre valide : ");
      }

    } while (!isValid);

    return result;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println();
      System.out.println("\t Jour " + days);
      System.out.println();
      System.out.println("Une nouvelle journée commence. Voici les ressources à votre disposition :");
      System.out.println("\t - Bois : " + wood);
      System.out.println("\t - Pierre : " + stone);
      System.out.println("\t - Or : " + gold);
      System.out.println("\t - Nourriture : " + food);
      System.out.println("\t - Villageois : " + villagers);
      System.out.println();
      System.out.println("Que voulez-vous faire aujourd'hui ?");
      System.out.println("\t1 - Explorer la forêt");
      System.out.println("\t2 - Créer une mine");
      System.out.println("\t3 - Travailler à la mine");
      System.out.println("\t4 - Recruter un soldat");
      System.out.println("\t5 - Commercer");
      System.out.println("\t6 - Construire LE château");
      System.out.println();

      int choice = readInt(scanner, "Quel est votre choix pour cette journée : ");

      // * Prévoir boucle do / while pour rester dans le menu tant qu'un nombre valide
      // n'est pas saisi (prendre en compte le cas ou la construction de la mine n'est
      // pas possible) */

      switch (choice) {
        case 1:
          forest();
          break;
        case 2:
          shaft();
          break;
        case 3:
          workAtShaft();
          break;
        case 4:
          recruiting();
          break;
        case 5:
          trade();
          break;
        case 6:
          castle();
          // prévoir break dans la method pour sortir de la boucle dès la construction du
          // château
          break;
        default:
          System.out.print("Entrez un numéro valide s'il vous plaît.");
          break;
      }

      if (!gameEnding) {
        if (food > villagers) {
          System.out.println();
          System.out
              .println(
                  "Les habitants prennent un repas bien mérité ! Vous avez perdu " + villagers + " de nourriture.");
          food -= villagers;
        } else {
          peopleFed = false;
          break;
        }
        System.out.println();
        System.out.println("Fin de la journée " + days + ", tout le monde file se coucher !");
        System.out.println();

        days++;

        System.out.print("Appuyez sur la touche entrée pour passer au jour " + days);
        scanner.nextLine();
      }

    } while (!gameEnding);

    if (!peopleFed) {
      System.out.println();
      System.out
          .println("Vous avez perdu ! Il ne vous restait pas assez de nourriture, les villageois sont morts de faim !");

      System.out.println();
    } else if (castle) {
      System.out.println();
      System.out.println("Vous avez gagné la partie !");
      System.out.println();
    }
    ;
  }

  public static void forest() {
    wood += 5;
    food += 3;
    System.out.println();
    System.out.println("Vous gagnez +5 bois et +3 nourriture !");
  }

  public static void shaft() {
    if (mine == false && wood >= 10) {
      wood -= 10;
      mine = true;
      System.out.println("Vous utilisez 10 bois et vous construisez la mine");
    } else {
      System.out.println("Construction impossible");
    }
  }

  public static void workAtShaft() {
    if (mine == true) {
      food -= 5;
      stone += 5;
      gold += 2;
      System.out.println("Vous avez utilisez 5 de nourriture et vous gagnez 5 de pierre et 2 d'or.");
    } else {
      System.out.println("Vous ne pouvez pas travailler a la mine, elle n'est pas construite !");
    }
  }

  public static void recruiting() {
    if (gold >= 30) {
      gold -= 30;
      villagers += 1;
      System.out.println("Vous gagnez 1 habitant.");
    } else {
      System.out.println("Vous n'avez pas assez d'argent pour recruter un habitant.");
    }
  }

  public static void trade() {
    if (stone < 5) {
      System.out.println("Vous devez avoir 5 pierre pour commercer !");
    } else {
      gold += 10;
      stone -= 5;
      System.out.println("Vous gagnez +10 or !");
    }
  }

  public static void castle() {
    if (wood >= 100 && stone >= 100 && gold >= 200 && villagers >= 40) {
      wood -= 100;
      stone -= 100;
      gold -= 200;
      castle = true;
      gameEnding = true;
      System.out.println("Vous avez construit LE château !");
    } else {
      System.out.println("Vous n'avez pas les ressources nécessaires pour construire ce bâtiment !");
    }
  }
}
