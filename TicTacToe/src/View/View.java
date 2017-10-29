/*
CS520 Programming Assignment 1(MVC) - TicTacToe.
View.java
View class is responsible for all aspects of UI
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View {
	//View part variables. Creating gameBoard instead of .setText("X")or("O")
	public JFrame gui = new JFrame("Tic Tac Toe");
	public JButton[][] blocks = new JButton[3][3];
	public JButton reset = new JButton("Reset");
	public JTextArea playerturn = new JTextArea();
	private int numRow;
	private int numCol;
	private char[][] gameBoard = {};
	
	//Set up panel, layout, board
	View(int rSize, int cSize) {
		//setup window size and component location
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(new Dimension(500, 350));
		gui.setResizable(true);

		JPanel gamePanel = new JPanel(new FlowLayout());
		JPanel game = new JPanel(new GridLayout(3, 3));
		gamePanel.add(game, BorderLayout.CENTER);
		JPanel options = new JPanel(new FlowLayout());
		options.add(reset);

		JPanel messages = new JPanel(new FlowLayout());
		messages.setBackground(Color.white);
		gui.add(gamePanel, BorderLayout.NORTH);
		gui.add(options, BorderLayout.CENTER);
		gui.add(messages, BorderLayout.SOUTH);
		messages.add(playerturn);
		playerturn.setText("Player 1 to play 'X'");

		numRow = rSize;
		numCol = cSize;

		// Create and insert buttons to Panel
		for (int row = 0; row < numRow; row++)
			for (int col = 0; col < numCol; col++) {
				blocks[row][col] = new JButton();
				blocks[row][col].setPreferredSize(new Dimension(75, 75));
				blocks[row][col].setText("");
				game.add(blocks[row][col]);
				blocks[row][col].setFocusPainted(false);
			}
	}

	//Applying buttonlinsters to buttons. 
	public void buttonListener(ActionListener listener) {

		// buttonlisteners for buttons on board
		for (int row = 0; row < numRow; row++)
			for (int col = 0; col < numCol; col++)
				blocks[row][col].addActionListener(listener);

		// buttonlisteners for reset button
		reset.addActionListener(listener);

	}

	//Updates view for UI
	void updateView() {

		for (int row = 0; row < numRow; row++)
			for (int col = 0; col < numCol; col++) {
				try {
					blocks[row][col].setText("" + gameBoard[row][col]);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
	}

	// Getter, Setter for var access
	public int getNumRow() {
		return numRow;
	}

	public int getNumCol() {
		return numCol;
	}

	public JButton[][] getBlocks() {
		return blocks;
	}

	public JButton getReset() {
		return reset;
	}

	public void setGameBoard(char[][] gameBoard) {
		this.gameBoard = gameBoard;
	}
}