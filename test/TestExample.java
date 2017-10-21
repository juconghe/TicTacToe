import org.junit.Test;
import static org.junit.Assert.*;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    @Test
    public void testView() {
        View gb1 = new GameBoard("Test 1");
        View gb2 = new GameBoard("Test 2");
        gb1.initRestBtnAndRegisterListener(new ResetBtnListener());
        gb2.initRestBtnAndRegisterListener(new ResetBtnListener());
        assertEquals(gb1.num_listeners(),gb2.num_listeners());
    }

    @Test
    public void testController() {
        Model m = new GameModel();
        Controller c1 = new GameBtnListener();
        c1.registerModel(m);
        Controller c2 = new ResetBtnListener();
        c2.registerModel(m);
        assertEquals(c1.getModel(),c2.getModel());
    }

    @Test
    public void testModel() {
        Model m = new GameModel();
        assertEquals(m.getMoveLeft(),8);
    }
}
