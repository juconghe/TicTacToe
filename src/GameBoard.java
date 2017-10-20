import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameBoard {
    int player = 1;
    int movesLeft = 9;
    private String gameName;
    private JButton[][] blocks;
    private JPanel game;
    private JFrame gui;
    private JTextArea playerturn;
    private JButton reset;
    private JPanel gamePanel, options, messages;
    public GameBoard(String gameName) {

        this.gameName = gameName;
        blocks = new GameBtn[3][3];
        initBoard();
    }

    private void initBoard() {
        gui = new JFrame(gameName);
        playerturn= new JTextArea();
        reset = new GameBtn("Reset");

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);
        gui.setVisible(true);

        gamePanel = new JPanel(new FlowLayout());
        game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        options = new JPanel(new FlowLayout());
        options.add(reset);
        messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");

    }

    public void initBtnsAndRegisterListener(ActionListener[][] listener) {
        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<blocks.length ;row++) {
            for (int column = 0; column < blocks[0].length; column++) {
                GameBtn btn = new GameBtn();
                blocks[row][column] = btn;
                btn.setBtnIndex(row, column);
                btn.registerActionListener(listener[row][column]);
                game.add(btn);
            }
        }
    }

    public void initRestBtnAndRegisterListener(ActionListener listener) {
        reset.addActionListener(listener);
    }

}
