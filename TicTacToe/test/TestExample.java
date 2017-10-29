import org.junit.Test;
import static org.junit.Assert.*;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    @Test
    public void testNewGame() {
    
		Model model = new Model();
		View view = new View(3, 3);
		Controller game = new Controller(model, view);
		
		assertEquals (9, game.model.movesLeft);

      //   TicTacToe game = new TicTacToe();


      // //  assertEquals (1, game.player);
      //   assertEquals (9, game.movesLeft);
    }
}
