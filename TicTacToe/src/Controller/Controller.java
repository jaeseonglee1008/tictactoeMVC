/*
CS520 Programming Assignment 1(MVC) - TicTacToe.
Controller.java
Controller class manages Model and View components
*/
import javax.swing.*;
import java.awt.event.*;

public class Controller {

	// creats instances objects from Model and View
	public Model model;
	public View view;

	// Constructor takes model and view as parameters.
	public Controller(Model model, View view) {

		// initialize Model
		this.model = model;
		model.reset();

		// initialize View
		this.view = view;

		// ActionListener for buttons
		this.view.buttonListener(new ButtonListener());
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int numRow = view.getNumRow();
			int numCol = view.getNumCol();
			JButton[][] gameBoardButtons = view.getBlocks();
			char mark[][] = model.getBoard();

			JButton reset = view.getReset();

			// Updates Model and View
			// Reads game moves from the command line.
			for (int row = 0; row < numRow; row++)
				for (int col = 0; col < numCol; col++)
					if (e.getSource() == gameBoardButtons[row][col]) {

						// Check with model if valid spot and update if can
						model.updatePlayerTurn(row, col, model.getPlayerTurn());
						if (model.getPlayerTurn() == 'X') {
							view.playerturn.setText("'X': Player 1");
							System.out.format("Player 2('O') Marked point(%d,%d). now Player 1('X')'s turn ",row+1,col+1);
							System.out.println();
						} else {
							view.playerturn.setText("'O': Player 2");
							System.out.format("Player 1('X') Marked point(%d,%d). now Player 2('O')'s turn ",row+1,col+1);
							System.out.println();
						}

						// Update View
						view.setGameBoard(mark);
						view.updateView();
						if (model.movesLeft != 0)
							view.blocks[row][col].setEnabled(false);
						if (model.isWinner() == 'W')
							if (model.getPlayerTurn() == 'X') {
								view.playerturn.setText("Player 1 wins!");
								System.out.println("Player 1 wins! Click the 'Reset' button to play new game.");
								setEnabled();
							} else {
								view.playerturn.setText("Player 2 wins!");
								System.out.println("Player 2 wins! Click the 'Reset' button to play new game.");
								setEnabled();
							}

						if (model.isWinner() == 'D') {
							view.playerturn.setText("Game ends in a draw");
							System.out.println("Game ends in a draw. Click the 'Reset' button to play new game.");
							setEnabled();
						}
					} else if (e.getSource() == reset) {
						
						model.reset();
					
						view.playerturn.setText("Player 1 to play 'X'");
						view.updateView();
						view.blocks[row][col].setEnabled(true);
						view.blocks[row][col].setText("");
					}
		}

		public void setEnabled() {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					view.blocks[i][j].setEnabled(false);
				}
			}
		}
	}

}