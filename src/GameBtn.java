import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBtn extends JButton {
    private int btnRowIdx;
    private int btnColIdx;
    public GameBtn() {
        super();
        super.setPreferredSize(new Dimension(75,75));
        super.setText("");
    }

    public GameBtn(String text) {
        super();
        super.setText(text);
    }

    public void setBtnIndex(int row, int col) {
        btnRowIdx = row;
        btnColIdx = col;
    }

    public void registerActionListener(ActionListener listener) {
        ((GameBtnListener)listener).setIndex(btnRowIdx,btnColIdx);
        this.addActionListener(listener);
    }

}
