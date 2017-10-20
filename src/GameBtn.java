import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GameBtn extends JButton {
    private int btnRowIdx;
    private int btnColIdx;
    GameBtn() {
        super();
        super.setPreferredSize(new Dimension(75,75));
        super.setText("");
    }

    GameBtn(String text) {
        super();
        super.setText(text);
    }

    void setBtnIndex(int row, int col) {
        btnRowIdx = row;
        btnColIdx = col;
    }

    void registerActionListener(ActionListener listener) {
        ((GameBtnListener)listener).setIndex(btnRowIdx,btnColIdx);
        this.addActionListener(listener);
    }

}
