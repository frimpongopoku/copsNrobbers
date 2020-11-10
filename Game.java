import java.util.concurrent.TimeUnit;

public class Game {
	//data
	Building building;
	Character player;
	Character ai; 

	int MAX_TURNS;
	int turns_taken;

	//methods

	/*Game constructor
	* Creates a game.
	* Creates a building and decides the dimensions (how many rooms wide and long)
	* Decides whether the player will be a cop or robber
	* Creates the cop and the robber
	* Places the cop and robber in appropriate room(s)
	* Sets MAX_TURNS - time that cop has to catch robber
	*/
	public Game(int roomswide, int roomslong, Boolean isCop) {
		//Game Constructor - Do setup work here
		String robberName = "Mandem the Terrible";
		this.building = new Building(roomswide, roomslong);
		Character cop = new Character(true);
		Character robber = new Character(robberName, false); 

		this.player = cop;
		this.ai = robber; 

		this.turns_taken = 0;
	}

	public static void pause(int secondsToSleep) {
		try {
	    TimeUnit.SECONDS.sleep(secondsToSleep);
		} 
	catch (InterruptedException ie) {
	    Thread.currentThread().interrupt();
		}
	}


	public static void main(String[] args) {
	
	int ROOMS_WIDE = 4;
	int ROOMS_LONG = 5;


	// ---SETTING UP THE GAME ---\\
		//Print some startup messages to look fancy
		System.out.print("Initialising game\t");
		int wait_time = 5;

		for (int cnt=0;cnt<wait_time;cnt++) {
			System.out.print(". ");
			pause(1);
		}

		//Create a new game (constructor)
		Game game = new Game(ROOMS_WIDE, ROOMS_LONG, true);
	

	// ---ACTUAL GAMEPLAY HAPPENS HERE ---\\
		while (!game.gameOver()) {
			game.turn();

			System.out.println("Only one turn can currently be taken. Goodbye!");
			break;
		}

		System.out.print("Shutting Down\t");

		for (int cnt=0;cnt<wait_time;cnt++) {
			System.out.print(". ");
			pause(1);
		}
		System.out.print("\n\n\t\tThanks for playing copsNrobbers!!!");

		//Game loop (The things that happen in the actual game, these happen in an infinite loop)
			/* Allow Cop to take a turn
			 * Allow Robber to take a turn
			 * Check for game over/quit command
			 */

	}

	/* gameOver
	 * Checks for game over conditions.  These are (students need to figure these out):
	 * 1. 
	 * 2. 
	 * 3. 
	 * Should return true if game should end and false otherwise
	 * It should also print the appropriate game over message
	 */
	public Boolean gameOver() {
		return false;
	}

	/*turn
	 * Allows cop and robber to take a turn and increments turns_taken
	 *
	 */
	public void turn() {
		//playerMove will be used to record the direction player wanted to move
		int playerMove;

		//cop takes his turn
		playerMove = player.takeTurn();

		//Robber takes his turn
		this.robberTurn(); 

		//increment turn count
		this.turns_taken += 1;

	}

	/* robberTurn
	 * Takes an automatic turn for the robber
	 * This is necessary because the robber is not human controlled
	 * He therefore needs to have his turn taken on his behalf by the program
	 * This method will be called by Game.turn()
	 */
	public void robberTurn () {
		// For now, this will be empty
		// so the robber does nothing and
		// the cop can easily catch the robber
		System.out.println("The Robber has taken his turn\n\n");
		pause(3);

	}

}