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

    private GameBoard gb;
    private ActionListener[][] btnListeners = new GameBtnListener[3][3];
    private GameModel gameModel;
    /**
     * The default constructor, which initializes the GUI.
     */
    public TicTacToe() {
        gameModel = new GameModel();
        gb = new GameBoard("Tic Tac Toe");
        gameModel.registerView(gb);
        initListeners();
    }

    private void initListeners() {
        for(int row = 0; row<btnListeners.length ;row++) {
            for(int column = 0; column<btnListeners[0].length;column++) {
                GameBtnListener gL = new GameBtnListener();
                gL.registerModel(gameModel);
                btnListeners[row][column] = gL;
            }
        }
        gb.initBtnsAndRegisterListener(btnListeners);
        ResetBtnListener rL = new ResetBtnListener();
        rL.registerModel(gameModel);
        gb.initRestBtnAndRegisterListener(rL);
    }
}
