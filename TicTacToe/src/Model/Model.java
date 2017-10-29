/*
CS520 Programming Assignment 1(MVC) - TicTacToe.
Model.java
Model class is responsible for all aspects of logic.
*/
public class Model {

	private int rSize = 3;
	private int cSize = 3;
	private char blocks[][] = new char[rSize][cSize];
	private char player = 'X';
	int movesLeft = 9;

	//Player's turn
	public void updatePlayerTurn(int x, int y, char previousPlayer) {

		if (blocks[x][y] == ' ' && movesLeft > 0) {

			blocks[x][y] = previousPlayer;

			if (previousPlayer == 'X') {
				blocks[x][y] = player;
				player = 'O';
				// gameView.playerturn.setText("");
			} else {
				blocks[x][y] = player;
				player = 'X';
			}
			movesLeft--;
		}
	}

	//Reset the game clear the board
	public void reset() {

		for (int row = 0; row < rSize; row++)
			for (int column = 0; column < cSize; column++)
				blocks[row][column] = ' ';

		player = 'X';
		movesLeft = 9;
		//reading from the command line 
		System.out.println("New Game!");
		
	}



	//Checking winner. Return var 'W' as winner, 'D' as draw.
	public char isWinner() {

		// check rows.
		for (int row = 0; row < rSize; row++)
			if (blocks[row][0] == blocks[row][1] && blocks[row][0] == blocks[row][2] && blocks[row][0] != ' ') {
				if (player == 'X') {
					player = 'O';
				} else {
					player = 'X';
				}
				movesLeft = 0;
				return 'W';
			}

		// check cols
		for (int col = 0; col < cSize; col++)
			if (blocks[0][col] == blocks[1][col] && blocks[0][col] == blocks[2][col] && blocks[0][col] != ' ') {
				if (player == 'X') {
					player = 'O';
				} else {
					player = 'X';
				}
				movesLeft = 0;
				return 'W';
			}
		// check diagonal
		if (blocks[0][0] == blocks[1][1] && blocks[0][0] == blocks[2][2] && blocks[0][0] != ' '
				|| blocks[2][0] == blocks[1][1] && blocks[2][0] == blocks[0][2] && blocks[2][0] != ' ') {
			if (player == 'X') {
				player = 'O';
			} else {
				player = 'X';
			}
			movesLeft = 0;
			return 'W';
		}
		// check tie game
		if (movesLeft == 0) {
			return 'D';
		}
		return 'N';
	}
	//getter for variable access
	public int getRow() {
		return rSize;
	}

	public int getCol() {
		return cSize;
	}

	public char getPlayerTurn() {
		return player;
	}

	public char[][] getBoard() {
		return blocks;
	}
}
