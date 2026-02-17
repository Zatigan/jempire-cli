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
 
}
