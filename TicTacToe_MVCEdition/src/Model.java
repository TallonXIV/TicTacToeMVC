public class Model{
	int numTurns = 0;
	int row1 = 0;
	int row1X = 0;
	int row2 = 0;
	int row2X = 0;
	int row3 = 0;
	int row3X = 0;
	int row4 = 0;
	int row4X = 0;
	
	int col1 = 0;
	int col1X = 0;
	int col2 = 0;
	int col2X = 0;
	int col3 = 0;
	int col3X = 0;
	int col4 = 0;
	int col4X = 0;
	
	int crossRL = 0;
	int crossRLX = 0;
	int crossLR = 0;
	int crossLRX = 0;
	
	//increments turn counter to keep up with how many moves have been made between both players
	public int incrementTurnCounter() {
		if(numTurns == 16)
			numTurns++;
		return numTurns;
	}
	
	//declares draw is all buttons are pressed
	public int declareDraw() {
		if(numTurns == 16)
			return 3;
		else
			return 4; //returns error
	}
	
	//Increments row count for individual buttons per row filled by X
	public int winCheckRX(int whichRow) {
		if(whichRow == 1)
			row1++;
		else if(whichRow == 2) 
			row2++;
		else if(whichRow == 3) 
			row3++;
		else if(whichRow == 4)
			row4++;
		if(row1 == 4 || row2 == 4 ||row3 == 4 || row4 == 4)
			return 1;
		else 
			return 0;
	}
	
	//Increments row count for individual buttons per row filled by 0
	public int winCheckRO(int whichRow) {
		if(whichRow == 1)
			row1X++;
		else if(whichRow == 2) 
			row2X++;
		else if(whichRow == 3) 
			row3X++;
		else if(whichRow == 4)
			row4X++;
		if(row1X == 4 || row2X == 4 ||row3X == 4 || row4X == 4)
			return 1;
		else 
			return 0;
	}
	
	//Increments col count for individual buttons per column filled by X
	public int winCheckCX(int whichCol) {
		if(whichCol == 1)
			col1++;
		else if(whichCol == 2) 
			col2++;
		else if(whichCol == 3) 
			col3++;
		else if(whichCol == 4)
			col4++;
		if(col1 == 4 || col2 == 4 || col3 == 4 || col4 == 4)
			return 1;
		else 
			return 0;
	}
	
	//Increments col count for individual buttons per column filled by O
	public int winCheckCO(int whichCol) {
		if(whichCol == 1)
			col1X++;
		else if(whichCol == 2) 
			col2X++;
		else if(whichCol == 3) 
			col3X++;
		else if(whichCol == 4)
			col4X++;
		if(col1X == 4 || col2X == 4 || col3X == 4 || col4X == 4)
			return 1;
		else 
			return 0;
	}
	
	//Increments cross count for individual buttons per cross filled by X
	public int winCheckCrossX(int whichOne) {
		if(whichOne == 1) 
			crossLR++;
		else if(whichOne == 2)
			crossRL++;
		if(crossLR == 4 || crossRL == 4)
			return 1;
		else return 0;
	}
	
	//Increments cross count for individual buttons per cross filled by O
	public int winCheckCrossO(int whichOne) {
		if(whichOne == 1) 
			crossLRX++;
		else if(whichOne == 2)
			crossRLX++;
		if(crossLRX == 4 || crossRLX == 4)
			return 1;
		else return 0;
	}
}