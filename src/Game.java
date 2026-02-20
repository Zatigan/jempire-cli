import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

  static int wood = 0;
  static int stone = 0;
  static int gold = 50;
  static int food = 100;
  static int villagers = 1;
  static int days = 1;
  static boolean hasMine = false;
  static boolean hasCastle = false;
  static boolean isActionPossible = false;
  static boolean isPeopleFed = true;
  static boolean isGameEnding = false;

  public static void cadre(List<String> text) {

    if (text.isEmpty()) {
      return;
    }
    int maxLength = 0;
    for (int i = 0; i < text.size(); i++) {
      String textLength = text.get(i);
      if (textLength.length() > maxLength) {
        maxLength = textLength.length();
      }
    }
    System.out.print("╔");

    for (int i = 0; i < maxLength + 2; i++) {
      System.out.print("═");
    }
    System.out.println("╗");

    for (int i = 0; i < text.size(); i++) {
      String arrayText = text.get(i);

      System.out.print("║ ");
      System.out.print(arrayText);

      int comblerEspace = maxLength - arrayText.length();
      for (int j = 0; j < comblerEspace; j++) {
        System.out.print(" ");
      }
      System.out.println(" ║");
    }
    System.out.print("╚");

    for (int i = 0; i < maxLength + 2; i++) {
      System.out.print("═");
    }
    System.out.println("╝");
  }

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
      List<String> ressources = new ArrayList<>();
      ressources.add("                                Jour " + days);
      ressources.add("");
      ressources.add("Une nouvelle journée commence. Voici les ressources à votre disposition :");
      ressources.add("    - Bois : " + wood);
      ressources.add("    - Pierre : " + stone);
      ressources.add("    - Or : " + gold);
      ressources.add("    - Nourriture : " + food);
      ressources.add("    - Villageois : " + villagers);
      ressources.add("");
      cadre(ressources);

      List<String> actionDay = new ArrayList<>();
      actionDay.add("");
      actionDay.add("                      Que voulez-vous faire aujourd'hui ?");
      actionDay.add("");
      actionDay.add("    1 - Explorer la forêt (Coût : 0 / +5 bois ; +3 nourriture)");
      actionDay.add("    2 - Créer une mine (Coût : 10 bois)");
      actionDay.add("    3 - Travailler à la mine (Coût : 5 nourriture / +5 pierre ; +2 or)");
      actionDay.add("    4 - Recruter un soldat (Coût : -30 or / +1 habitant)");
      actionDay.add("    5 - Commercer (Coût : - 5 pierre / +10 or)");
      actionDay.add("    6 - Construire LE château (Coût : -100 bois ; -100 pierre ; -200 or ; 40+ habitants)");
      actionDay.add("");

      cadre(actionDay);

      do {
        isActionPossible = false;
        int choice = readInt(scanner, "Quel est votre choix pour cette journée : ");
        switch (choice) {
          case 1:
            exploreForest();
            break;
          case 2:
            buildShaft();
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
            buildCastle();
            break;
          default:
            System.out.println("Entrez un numéro valide s'il vous plaît.");
            break;
        }
      } while (!isActionPossible);

      if (!isGameEnding) {
        if (food > villagers) {
          System.out.println();
          System.out
              .println(
                  "Les habitants prennent un repas bien mérité ! Vous avez perdu " + villagers + " de nourriture.");
          food -= villagers;
        } else if (food < villagers) {
          int leavingPeople = villagers - food;
          villagers -= leavingPeople;
          food -= villagers;
          System.out
              .println(
                  "Vous ne pouvez pas nourrir tout le monde aujourd'hui ! Vous avez perdu " + leavingPeople
                      + " habitants.");
          if (food < 0) {
            food = 0;
          }
        }

        if (villagers < 1) {
          isPeopleFed = false;
          break;
        }

        System.out.println();
        System.out.println("Fin de la journée " + days + ", tout le monde file se coucher !");
        System.out.println();

        days++;

        System.out.print("Appuyez sur la touche entrée pour passer au jour " + days);
        scanner.nextLine();
      }

    } while (!isGameEnding);

    if (!isPeopleFed) {
      System.out.println();
      System.out
          .println("Vous avez perdu ! Il ne vous restait pas assez de nourriture, les villageois sont morts de faim !");
      System.out.println();
    } else if (hasCastle) {
      System.out.println();
      System.out.println("Vous avez gagné la partie !");
      System.out.println();
    }
  }

  public static void exploreForest() {
    wood += (5 * villagers);
    food += (3 * villagers);
    isActionPossible = true;
    System.out.println();
    System.out.println("Vous gagnez " + (5 * villagers) + " bois et " + (3 * villagers) + " nourriture !");
  }

  public static void buildShaft() {
    if (hasMine == false && wood >= 10) {
      wood -= 10;
      hasMine = true;
      isActionPossible = true;
      System.out.println("Vous utilisez 10 bois et vous construisez la mine");
    } else {
      System.out.println("Construction impossible");
      System.out.println();
    }
  }

  public static void workAtShaft() {
    if (hasMine == true) {
      food -= (5 * villagers);
      stone += (5 * villagers);
      gold += (2 * villagers);
      isActionPossible = true;
      System.out.println("Vous avez utilisé " + (5 * villagers) + " de nourriture et vous gagnez " + (5 * villagers)
          + " pierre et " + (2 * villagers) + " or.");
    } else {
      System.out.println("Vous ne pouvez pas travailler a la mine, elle n'est pas construite !");
      System.out.println();
    }
  }

  public static void recruiting() {
    if (gold >= 30) {
      gold -= 30;
      villagers += 1;
      isActionPossible = true;
      System.out.println("Vous gagnez +1 habitant.");
    } else {
      System.out.println("Vous n'avez pas assez d'argent pour recruter un habitant.");
      System.out.println();
    }
  }

  public static void trade() {
    if (stone < 5) {
      System.out.println("Vous devez avoir 5 pierre pour commercer !");
      System.out.println();
    } else {
      gold += 10;
      stone -= 5;
      isActionPossible = true;
      System.out.println("Vous gagnez +10 or !");
    }
  }

  public static void buildCastle() {
    if (wood >= 100 && stone >= 100 && gold >= 200 && villagers >= 40) {
      wood -= 100;
      stone -= 100;
      gold -= 200;
      hasCastle = true;
      isGameEnding = true;
      isActionPossible = true;
      System.out.println("Vous avez construit LE château !");
    } else {
      System.out.println("Vous n'avez pas les ressources nécessaires pour construire ce bâtiment !");
      System.out.println();
    }
  }
}
