public class Resources {

 private static int wood = 0;
 private static int stone = 0;
 private static int gold = 50;
 private static int food = 100;
 private static int villagers = 1;
 private static int days = 1;

 public static int getWood() {
  return wood;
 }

 public static int getStone() {
  return stone;
 }

 public static int getGold() {
  return gold;
 }

 public static int getFood() {
  return food;
 }

 public static int getVillagers() {
  return villagers;
 }

 public static int getDays() {
  return days;
 }

 public static void updateFood(int data) {
  food -= data;
 }

 public static void updateVillagers (int data) {
  villagers -= data; 
 }

 public static void incrementDays() {
  days++;
 }

 public static void setFood(int value) {
  food = value;
 }

 public static void exploreForest(boolean isActionPossible) {
  wood += (5 * villagers);
  food += (3 * villagers);
  Game.isActionPossible = true;
  System.out.println();
  System.out.println("Vous gagnez " + (5 * villagers) + " bois et " + (3 * villagers) + " nourriture !");
 }

 public static void buildShaft(boolean hasMine, boolean isActionPossible) {
  if (hasMine == false && wood >= 10) {
   wood -= 10;
   Game.hasMine = true;
   Game.isActionPossible = true;
   System.out.println("Vous utilisez 10 bois et vous construisez la mine");
  } else {
   System.out.println("Construction impossible");
   System.out.println();
  }
 }

 public static void workAtShaft(boolean hasMine, boolean isActionPossible) {
  if (hasMine == true) {
   food -= (5 * villagers);
   stone += (5 * villagers);
   gold += (2 * villagers);
   Game.isActionPossible = true;
   System.out.println("Vous avez utilisé " + (5 * villagers) + " de nourriture et vous gagnez " + (5 * villagers)
     + " pierre et " + (2 * villagers) + " or.");
  } else {
   System.out.println("Vous ne pouvez pas travailler a la mine, elle n'est pas construite !");
   System.out.println();
  }
 }

 public static void recruiting(boolean isActionPossible) {
  if (gold >= 30) {
   gold -= 30;
   villagers += 1;
   Game.isActionPossible = true;
   System.out.println("Vous gagnez +1 habitant.");
  } else {
   System.out.println("Vous n'avez pas assez d'argent pour recruter un habitant.");
   System.out.println();
  }
 }

 public static void trade(boolean isActionPossible) {
  if (stone < 5) {
   System.out.println("Vous devez avoir 5 pierre pour commercer !");
   System.out.println();
  } else {
   gold += 10;
   stone -= 5;
   Game.isActionPossible = true;
   System.out.println("Vous gagnez +10 or !");
  }
 }

 public static void buildCastle(boolean hasCastle, boolean isGameEnding, boolean isActionPossible) {
  if (wood >= 100 && stone >= 100 && gold >= 200 && villagers >= 40) {
   wood -= 100;
   stone -= 100;
   gold -= 200;
   Game.hasCastle = true;
   Game.isGameEnding = true;
   Game.isActionPossible = true;
   System.out.println("Vous avez construit LE château !");
  } else {
   System.out.println("Vous n'avez pas les ressources nécessaires pour construire ce bâtiment !");
   System.out.println();
  }

 }
}