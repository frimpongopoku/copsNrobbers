import java.util.Random;
import java.util.Scanner;

public class Character {
  String name;
  Boolean isCop; // if true> cop else is robber
  Scanner scanner = new Scanner(System.in);
  String NORTH = "gn", SOUTH = "gs", EAST = "ge", WEST = "gw", STAY = "s", QUIT = "q";
  // int ROOM_WIDE, ROOM_LONG;

  public Character(String characterName, Boolean characterIsCop) {
    this.name = characterName;
    this.isCop = characterIsCop;
  }

  public boolean isValid(String input) {
    if (input.isEmpty())
      return false;
    if (input.equals(NORTH) || input.equals(SOUTH) || input.equals(EAST) || input.equals(WEST) || input.equals(STAY)
        || input.equals(QUIT))
      return true;
    return false;
  }
  // public void setRoomDimensions(int width, int height){
  // this.ROOM_LONG = height;
  // this.ROOM_WIDE = width;
  // }

  public String takeUserInput(String displayText) {
    System.out.println(displayText);
    return String.valueOf(scanner.nextLine());
  }

  public String getName() {
    return name;
  }

  // input to number representation
  public int inputToNumRep(String userInput) {
    if (userInput.equals(STAY)) {
      return 0;
    } else if (userInput.equals(NORTH)) {
      return 1;
    } else if (userInput.equals(EAST)) {
      return 2;
    } else if (userInput.equals(SOUTH)) {
      return 3;
    } else if (userInput.equals(WEST)) {
      return 4;
    }
    return 5;
  }

  /**
   * Change the AI(robber)'s position
   * 
   * @return string value of a valid direction
   */
  public String autoRobberMovement() {
    String[] dir = new String[] { "s", "gn", "ge", "gs", "gw" };
    Random rand = new Random();
    int choice = rand.nextInt(5);
    return dir[choice];
  }

  /*
   * Taketurn Allows a player to take a turn Prompts player to give an input (s,
   * gn, ge, gs, gw or q) Evaluates the input to return (0,1,2,3,4,5 or 6) If the
   * input is invalid, asks the player to try again
   */
  public int takeTurn() {
    if (!isCop)
      return inputToNumRep(autoRobberMovement());
    String userInput = "";
    boolean isGood = false;
    while (!isGood) {
      userInput = takeUserInput("Make a move " + name + ", where would you like to go?");
      isGood = this.isValid(userInput);
      if (!isGood)
        System.out.println("Not a proper direction, try again!");
    }

    return inputToNumRep(userInput);
  }

}