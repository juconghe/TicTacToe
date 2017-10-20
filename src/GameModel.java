public class GameModel {
    private int gameBoard[][];
    private GameBoard gameBoardView;

    public GameModel() {
        gameBoard = new int[3][3];
    }

    public void update() {
        System.out.println("Updating model");
    }

    public void registerView(GameBoard gb) {
        gameBoardView = gb;
    }
}
