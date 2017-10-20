import java.awt.event.*;

public class GameBtnListener implements Controller {
    private int btnRowIdx, btnColIdx;
    private Model gameModel;
    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("Btn "+btnRowIdx+" "+btnColIdx +" is clicked" );
        gameModel.update(btnRowIdx, btnColIdx);
}

    public void setIndex(int row, int col) {
        btnRowIdx = row;
        btnColIdx = col;
    }

    public void registerModel(Model model) {
        gameModel = model;
    }
}
