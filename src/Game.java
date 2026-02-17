import java.util.Scanner;

public class Game {

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
    int wood = 0;
    int stone = 0;
    int gold = 50;
    int food = 100;
    int villagers = 1;
    boolean mine = false;
    boolean castle = false;
    int days = 1;
    boolean peopleFed = true;

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
      System.out.println("\t4 - Créer un soldat");
      System.out.println("\t5 - Commercer");
      System.out.println("\t6 - Construire LE château");
      System.out.println();

      int choice = readInt(scanner, "Quel est votre choix pour cette journée : ");

      //* Prévoir boucle do / while pour rester dans le menu tant qu'un nombre valide n'est pas saisi */

      switch (choice) {
        case 1:
          // appel method forêt
          break;
        case 2:
          // appel method construction mine
          break;
        case 3:
          // appel method mine
          break;
        case 4:
          // appel method soldat
          break;
        case 5:
          // appel method commerce
          break;
        case 6:
          // appel method château
          break;
        default:
          System.out.print("Entrez un numéro valide s'il vous plaît.");
          break;
      }

      if (food > villagers) {
      System.out.println();
      System.out.println("Les habitants prennent un repas bien mérité ! Vous avez perdu " + villagers + " de nourriture.");
      } else {
        break;
      }
      System.out.println();
      System.out.println("Fin de la journée " + days + ", tout le monde file se coucher !");
      System.out.println();

      days++;
      castle = true;

    } while (!castle);

  }

}
