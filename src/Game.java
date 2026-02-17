import java.util.Scanner;

public class Game {

 public static int readInt(Scanner scanner) {
  System.out.println("Entrez un nombre : ");
  String input;
  boolean isValid = false;
  int result = 0;

  do {
   input = scanner.nextLine();

   try {
    result = Integer.parseInt(input);
    isValid = true;
   } catch (Exception e) {
    System.err.print("Entrez un nombre valide");
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

 do {
  System.out.println("Journée " + days);
  System.out.println("Une nouvelle journée commence. Voici les ressources à votre disposition.");
  System.out.println();


 
 } while (peopleFed);


 }
 
}
