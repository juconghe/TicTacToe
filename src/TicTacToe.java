import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Java implementation of the TicTacToe game, using the Swing framework.
 *
 * This quick-and-dirty implementation violates a number of software engineering
 * principles and needs a thorough overhaul to improve readability,
 * extensibility, and testability.
 */
public class TicTacToe {
    /**
     * The main method that starts the game.
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }

    /**
     * The default constructor, which initializes the GUI.
     */
    public TicTacToe() {
      GameBoard gb = new GameBoard("Tic Tac Toe", 3, 3);
    }
}
