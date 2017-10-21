import javax.swing.*;
public interface View {
    void updateBtn(int row, int col, int player);

    void resetGame();

    void gameOver(int player);

    void initRestBtnAndRegisterListener(Controller controller);

    void initBtnsAndRegisterListener(Controller[][] controllers);

    // testing method for view
    int num_listeners();
}
