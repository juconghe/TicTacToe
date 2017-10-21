import java.awt.event.*;

public interface Controller extends ActionListener {
    default void setIndex(int row, int col){}
    void registerModel(Model model);
    // test method
    Model getModel();
}
