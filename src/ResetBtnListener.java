import java.awt.event.*;

public class ResetBtnListener implements ActionListener {
    private GameModel gameModel;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Rest Btn Clicked");
        gameModel.reset();
    }

    public void registerModel(GameModel model) {
        gameModel = model;
    }
}
