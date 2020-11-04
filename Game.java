public class Game {
	//data
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
	public Game(int roomswide, int roomslong, Boolean isCop, ) {
		//Game Constructor - Do setup work here
	}


	public static void main(String[] args) {
		//Print some startup messages

		//Create a new game (constructor)

		//Game loop (The things that happen in the actual game, these happen in an infinite loop)
			/* Allow Cop to take a turn
			 * Allow Robber to take a turn
			 * Check for game over/quit command
			 */

	}

	/* gameOver
	 * Checks for game over conditions. These are (students need to figure these out):
	 * 1. 
	 * 2. 
	 * 3. 
	 * It should also print the appropriate game over message
	 */
	public Boolean gameOver() {

	}

	/*turn
	 * Allows cop and robber to take a turn and increments turns_taken
	 *
	 */
	public void turn() {

	}

	/* robberTurn
	 * Takes an automatic turn for the robber
	 * This is necessary because the robber is not human controlled
	 * He therefore needs to have his turn taken on his behalf by the program
	 * This method will be called by Game.turn()
	 */
	public void robberTurn () {

	}

}