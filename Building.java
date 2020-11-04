public class Building {
	//Data
	private int ROOMS_LONG;
	private int ROOMS_WIDE;

	private int[] cop_position = new int[2];
	private int[] robber_position = new int[2];

	//Methods
	public Building(int rooms_wide, int rooms_long) {
		this.ROOMS_WIDE = rooms_wide;
		this.ROOMS_LONG = rooms_long;

		//TODO: Use setter (moveCharacter) to set these
		this.cop_position[0] = 0;
        this.cop_position[1] = 0;
        this.robber_position[0] = ROOMS_WIDE-1;
        this.robber_position[1] = ROOMS_LONG-1;

		/*ROOM LAYOUT when ROOMS_WIDE = 6, ROOMS_LONG = 4
		 _ _ _ _ _ _ _ _ _ _ _ _
		|   |   |   |   |   |   |
		|0,3|1,3|2,3|3,3|4,3|5,3|		
		| - - - - - - - - - - - |
		|   |   |   |   |   |   |
		|0,2|1,2|2,2|3,2|4,2|5,2|
		| - - - - - - - - - - - |	LENGTH
		|   |   |   |   |   |   |
		|0,1|1,1|2,1|3,1|4,1|5,1|
		| - - - - - - - - - - - |
		|   |   |   |   |   |   |
		|0,0|1,0|2,0|3,0|4,0|5,0|
		|- - - - - - - - - - - -|
				WIDTH
		*/


	}	

	/* moveCharacter
	 * Moves the specified character in the specified direction 
	 * Directions (0,1,2,3,4) mean (Stay, North, East, West, South) respectively
	 * Returns true if it is a valid move and false otherwise
	 * e.g. if the character is at the leftmost wall, asking them
	 * to move left should return false and not change their position
	 */
	Boolean moveCharacter (Boolean cop, int direction) {
		/*if cop
			move the cop
		else
			move the robber
		 */
		int[] characterToMove;
		if(cop){
			characterToMove = cop_position; 
		} else {
			characterToMove = robber_position;
		}

		if (direction == 0){
			//Stay where you are
			return true;
		}
		else if(direction == 1) { 
			if (characterToMove[1] > ROOMS_LONG - 2) {
				//if we are on the Northern edge
				return false;
			}
			else {
				characterToMove[1] += 1;
				return true;
			}

		}
		else if(direction == 2) { 
			
		}
		else if(direction == 3) { 
			
		}
		else if(direction == 4) { 
			
		}
		else if(direction == 5) { 
			
		}
		else {
			return false;
		}

		return false;
	}

	//Getter that returns cop or robber pos
	int[] getCharacterPos (Boolean cop) {
		/*if cop
			return cop's position
		else
			return robber's position
		 */
		int[] characterToGet;
		if(cop){
			characterToGet = cop_position; 
		} else {
			characterToGet = robber_position;
		}

		//Clone method ensures we only pass a copy of the cop/robber position
		//So it cant be editted
		int[] position = characterToGet.clone();

		return position;
	}


}