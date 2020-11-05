public class Character {
	//data (name, role (cop/robber))
	String name;
	Boolean isCop; //if true> cop else is robber


	//Methods
	public Character(Boolean characterIsCop) {
		this.isCop = characterIsCop;

		//TODO: Use Appropriate input methods to query the user for their name instea
		String characterName;
		if (this.isCop) { 
			characterName = "Sergeant Okonkwo";
			}
		else {
			characterName = "Abdallah TheRobber";
		}

		this.name = characterName;
	}

	public Character(String characterName, Boolean characterIsCop) {
		this.name = characterName;
		this.isCop = characterIsCop; 
	}

	/*Taketurn
	 * Allows a player to take a turn
	 * Prompts player to give an input (s, gn, ge, gs, gw or q)
	 * Evaluates the input to return (0,1,2,3,4,5 or 6)
	 * If the input is invalid, asks the player to try again
	 */
	int takeTurn() {
		System.out.print("\n\nStarting to take turn\n\n");
		return 1;
	}

}