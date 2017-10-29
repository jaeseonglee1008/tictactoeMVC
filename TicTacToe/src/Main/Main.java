/*
CS520 Programming Assignment 1(MVC) - TicTacToe.
Main.java
*/
public class Main {

	public static void main(String[] args) {
		//Model - logic
		Model model = new Model();
		//View - UI
		View view = new View(3, 3);
		//Controller - bridges the gap between Model and View
		Controller controller = new Controller(model, view);

		view.gui.setVisible(true);
	}
}
