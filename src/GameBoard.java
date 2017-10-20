import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class GameBoard implements View{
    private String gameName;
    private JButton[][] blocks;
    private JPanel game;
    private JButton reset;
    private JTextArea playerturn;
    GameBoard(String gameName) {

        this.gameName = gameName;
        blocks = new JButton[3][3];
        initBoard();
    }

    private void initBoard() {
        JFrame gui = new JFrame(gameName);
        playerturn = new JTextArea();
        reset = new JButton("Reset");

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);
        gui.setVisible(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        game = new JPanel(new GridLayout(3,3));
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

    }

   public void initBtnsAndRegisterListener(Controller[][] controllers) {
        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<blocks.length ;row++) {
            for (int column = 0; column < blocks[0].length; column++) {
                JButton btn = new JButton();
                blocks[row][column] = btn;
                btn.setPreferredSize(new Dimension(75,75));
                controllers[row][column].setIndex(row,column);
                registerBtnListener(btn,controllers[row][column]);
                game.add(btn);
            }
        }
    }

   public void initRestBtnAndRegisterListener(Controller controller) {
        registerBtnListener(reset,controller);
    }

    private void registerBtnListener(JButton btn, Controller controller) {
        btn.addActionListener(controller);
    }

    public void updateBtn(int row, int col, int player) {
        if (player == 1) {
            blocks[row][col].setText("X");
        } else {
            blocks[row][col].setText("O");
        }
        blocks[row][col].setEnabled(false);
    }

   public void resetGame() {
        for (JButton[] block : blocks) {
            for (int column = 0; column < blocks[0].length; column++) {
                block[column].setText("");
                block[column].setEnabled(true);
            }
        }
        playerturn.setText("Player 1 to play 'X'");
    }

   public void gameOver(int player) {
        playerturn.setText("Player "+player+" won!");
        for (JButton[] block : blocks) {
            for (int column = 0; column < blocks[0].length; column++) {
                block[column].setEnabled(false);
            }
        }
    }
}
