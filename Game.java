import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
  public static Scanner scanner;
  // data
  Building building;
  Character player;
  Character AI;

  int MAX_TURNS = 4;
  int turns_taken = 0;

  // methods

  /*
   * Game constructor Creates a game. Creates a building and decides the
   * dimensions (how many rooms wide and long) Decides whether the player will be
   * a cop or robber Creates the cop and the robber Places the cop and robber in
   * appropriate room(s) 
   * Sets MAX_TURNS - time that cop has to catch robber
   */
  public Game(int roomswide, int roomslong) {
    // Game Constructor - Do setup work here
    this.building = new Building(roomswide, roomslong);

  }

  public static void pause(int secondsToSleep) {
    try {
      TimeUnit.SECONDS.sleep(secondsToSleep);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
  }

  public static String takeUserInput(String displayText) {
    System.out.println(displayText);
    String content = scanner.nextLine();
    return content;
  }

  public static void setGameUp() {
    // ---SETTING UP THE GAME ---\\
    // Print some startup messages to look fancy
    System.out.print("Initialising game content...\t");
    int wait_time = 5;

    for (int cnt = 0; cnt < wait_time; cnt++) {
      if (cnt == 2) {
        System.out.println(" ");
        System.out.println("130MB/135MB  initial content downloaded...");
      } else if (cnt == 4) {
        System.out.println(" ");
        System.out.println("Installing Group 3 Cops && Robbers game...");
      }
      System.out.print(". ");
      pause(1);
    }
  }

  public void setPlayer(Character player) {
    this.player = player;
  }

  public void setAI(Character AI) {
    this.AI = AI;
  }

  public static void shutGameDown() {
    int wait_time = 5;
    System.out.print("Shutting Down\t");

    for (int cnt = 0; cnt < wait_time; cnt++) {
      System.out.print(". ");
      pause(1);
    }
    System.out.print("\n\n\t\tThanks for playing copsNrobbers!!!");

  }

  public static int[] validateRoomParams(int width, int height) {
    int DEFAULT_ROOMS_WIDE = 4;
    int DEFAULT_ROOMS_LONG = 5;
    int[] toGo = { width, height };
    if (width <= 0 || height > 10) {
      toGo[0] = DEFAULT_ROOMS_LONG;
      System.out.println("Value out of range for width, you have been given a default height for your building.");
    }
    if (height <= 0 || height > 10) {
      toGo[1] = DEFAULT_ROOMS_WIDE;
      System.out.println("Value out of range for height, you have been given a default height for your building.");
    }
    return toGo;
  }

  public static void main(String[] args) {

    // // Create a new game (constructor)
    // Game game = new Game(ROOMS_WIDE, ROOMS_LONG, true);

    Game.setGameUp();
    // ----- Ask for initial player details
    String playerName = Game.takeUserInput("What is your name? ");
    playerName = !playerName.isEmpty() ? playerName : "El Default";

    String isCop = Game.takeUserInput("Would you like to play as a cop? (y/n)");
    boolean isAcop = isCop.equals("y") || isCop.equals("yes") ? true : false;
    Character player = new Character(playerName, isAcop);
    Character AI = new Character("Sherlock Holmes", isAcop ? false : true);

    System.out.println("How big would you like your game room to be: ");
    int roomHeight = Integer.parseInt(takeUserInput("Room height (any number 10 or below)? "));
    int roomWidth = Integer.parseInt(takeUserInput("Room Width (any number 10 or below)? "));
    int[] dimensions = Game.validateRoomParams(roomHeight, roomWidth); 

    Game game = new Game(dimensions[0],dimensions[1]); 
    game.setPlayer(player);
    game.setAI(AI);


    // ---ACTUAL GAMEPLAY HAPPENS HERE ---\\
    while (!game.gameOver()) {
      game.turn();

      System.out.println("Only one turn can currently be taken. Goodbye!");
      break;
    }

    // Game loop (The things that happen in the actual game, these happen in an
    // infinite loop)
    /*
     * Allow Cop to take a turn Allow Robber to take a turn Check for game over/quit
     * command
     */

  }

  /*
   * gameOver Checks for game over conditions. These are (students need to figure
   * these out): 1. 2. 3. Should return true if game should end and false
   * otherwise It should also print the appropriate game over message
   */
  public Boolean gameOver() {
    return false;
  }

  /*
   * turn Allows cop and robber to take a turn and increments turns_taken
   *
   */
  public void turn() {
    // playerMove will be used to record the direction player wanted to move
    int playerMove;

    // cop takes his turn
    playerMove = player.takeTurn();

    // Robber takes his turn
    this.robberTurn();

    // increment turn count
    this.turns_taken += 1;

  }

  /*
   * robberTurn Takes an automatic turn for the robber This is necessary because
   * the robber is not human controlled He therefore needs to have his turn taken
   * on his behalf by the program This method will be called by Game.turn()
   */
  public void robberTurn() {
    // For now, this will be empty
    // so the robber does nothing and
    // the cop can easily catch the robber
    System.out.println("The Robber has taken his turn\n\n");
    pause(3);

  }

}