import java.awt.event.*;

public class ResetBtnListener implements Controller {
    private Model gameModel;

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("Rest Btn Clicked");
        gameModel.reset();
    }

    public void registerModel(Model model) {
        gameModel = model;
    }

    @Override
    public Model getModel() {
        return gameModel;
    }
}
