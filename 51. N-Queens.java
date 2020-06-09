import java.util.*;

class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] ch : board) {
            Arrays.fill(ch, '.');
        }
        List<List<String>> res = new ArrayList();
        HashSet<Integer> seen = new HashSet();
        helper(n, 0, res, board, seen);
        return res;
    }
    public void helper(int n, int row, List<List<String>> res, char[][] board, HashSet<Integer> seen) {
        if(row == n) {
            ArrayList<String> cur = new ArrayList();
            for(char[] ch : board) {
                cur.add(new String(ch));
            }
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(seen.contains(i)) {
                continue;
            }
            int x = i + row;
            int y = row - i;
            if(isValid(board, x, y)) {
                board[row][i] = 'Q';
                seen.add(i);
                helper(n, row + 1, res, board, seen);
                seen.remove(i);
                board[row][i] = '.';
            }
        }
        return;
    }
    public boolean isValid(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'Q') {
                    if(i + j == x || i - j == y) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}