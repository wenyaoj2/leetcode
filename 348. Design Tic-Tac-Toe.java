class TicTacToe {

    /** Initialize your data structure here. */
    int n = 0;
    int[][] rows;
    int[][] cols;
    int[][] diagonals;
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n][2];
        cols = new int[n][2];
        diagonals = new int[2][2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row][player - 1]++;
        cols[col][player - 1]++;
        if(row == col) {
            diagonals[0][player - 1]++;
        }
        if((row + col) == (n - 1)) {
            diagonals[1][player - 1]++;
        }
        return (rows[row][player - 1] == n || cols[col][player - 1] == n || diagonals[0][player - 1] == n || diagonals[1][player - 1] == n) ? player : 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */