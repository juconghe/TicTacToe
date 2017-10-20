class GameModel {
    private int gameBoard[][];
    private GameBoard gameBoardView;
    private int player;
    GameModel() {
        player = 1;
        gameBoard = new int[3][3];
    }

    void update(int row, int col) {
        gameBoard[row][col] = player;
        gameBoardView.updateBtn(row,col,player);
        if(isGame()){
            gameBoardView.gameOver(player);
        }
        if (player == 1) {
            player = 2;
        } else {
            player = 1;
        }
    }

    void registerView(GameBoard gb) {
        gameBoardView = gb;
    }

    void reset() {
        gameBoard = new int[3][3];
        gameBoardView.resetGame();
        player = 1;
    }

    private boolean isGame() {
        return checkDiagonal() || checkRowANDCol();
    }

    private boolean checkRowANDCol() {
        for(int row = 0; row < gameBoard.length; row ++) {
            int rowCount = 0;
            int colCount = 0;
            for(int col = 0; col <gameBoard[0].length; col ++) {
                if (gameBoard[row][col] == player) {
                    rowCount += 1;
                }
                if (gameBoard[col][row] == player) {
                    colCount += 1;
                }
            }
            if (rowCount == 3 || colCount == 3) {
                return true;
            }
        }
        return  false;
    }

    private boolean checkDiagonal() {
        int leftDCount = 0;
        int rightDCount = 0;
        for(int row = 0; row <gameBoard.length; row ++) {
            if (gameBoard[row][row] == player) {
                leftDCount += 1;
            }
        }

        for(int row = gameBoard.length -1; row >= 0; row --) {
            if (gameBoard[row][row] == player) {
                rightDCount += 1;
            }
        }

        if (leftDCount == 3 || rightDCount == 3) {
            return  true;
        } else {
            return false;
        }
    }
}
