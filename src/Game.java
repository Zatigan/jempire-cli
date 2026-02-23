import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

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
      ressources.add("                                Jour " + Resources.getDays());
      ressources.add("");
      ressources.add("Une nouvelle journée commence. Voici les ressources à votre disposition :");
      ressources.add("    - Bois : " + Resources.getWood());
      ressources.add("    - Pierre : " + Resources.getStone());
      ressources.add("    - Or : " + Resources.getGold());
      ressources.add("    - Nourriture : " + Resources.getFood());
      ressources.add("    - Villageois : " + Resources.getVillagers());
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
            Resources.exploreForest(isActionPossible);
            break;
          case 2:
            Resources.buildShaft(hasMine, isActionPossible);
            break;
          case 3:
            Resources.workAtShaft(hasMine, isActionPossible);
            break;
          case 4:
            Resources.recruiting(isActionPossible);
            break;
          case 5:
            Resources.trade(isActionPossible);
            break;
          case 6:
            Resources.buildCastle(hasCastle, isGameEnding, isActionPossible);
            break;
          default:
            System.out.println("Entrez un numéro valide s'il vous plaît.");
            break;
        }
      } while (!isActionPossible);

      if (!isGameEnding) {
        if (Resources.getFood() > Resources.getVillagers()) {
          System.out.println();
          System.out
              .println(
                  "Les habitants prennent un repas bien mérité ! Vous avez perdu " + Resources.getVillagers()
                      + " de nourriture.");
          Resources.updateFood(Resources.getVillagers());
        } else if (Resources.getFood() < Resources.getVillagers()) {
          int leavingPeople = Resources.getVillagers() - Resources.getFood();
          Resources.updateVillagers(leavingPeople);
          Resources.updateFood(Resources.getVillagers());
          System.out
              .println(
                  "Vous ne pouvez pas nourrir tout le monde aujourd'hui ! Vous avez perdu " + leavingPeople
                      + " habitants.");
          if (Resources.getFood() < 0) {
            Resources.setFood(0);
          }
        }

        if (Resources.getVillagers() < 1) {
          isPeopleFed = false;
          break;
        }

        System.out.println();
        System.out.println("Fin de la journée " + Resources.getDays() + ", tout le monde file se coucher !");
        System.out.println();

        Resources.incrementDays();

        System.out.print("Appuyez sur la touche entrée pour passer au jour " + Resources.getDays());
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
}
