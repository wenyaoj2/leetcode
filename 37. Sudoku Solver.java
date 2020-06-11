import java.util.*;

class SolveSudoku {
    public void solveSudoku(char[][] board) {
        List<HashSet<Character>> rows = new ArrayList();
        List<HashSet<Character>> cols = new ArrayList();
        List<HashSet<Character>> blocks = new ArrayList();
        for(int i = 0; i < 9; i++) {
            rows.add(new HashSet());
            cols.add(new HashSet());
            blocks.add(new HashSet());
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                int blockNum = (i / 3) * 3 + j / 3;
                blocks.get(blockNum).add(board[i][j]);
            }
        }
        helper(board, rows, cols, blocks);
    }
    public boolean helper(char[][] board, List<HashSet<Character>> rows, List<HashSet<Character>> cols, List<HashSet<Character>> blocks) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    continue;
                }
                int blockNum = (i / 3) * 3 + j / 3;
                for(char c = '1'; c <= '9'; c++) {
                    if(rows.get(i).contains(c) || cols.get(j).contains(c) || blocks.get(blockNum).contains(c)) {
                        continue;
                    }
                    board[i][j] = c;
                    rows.get(i).add(c);
                    cols.get(j).add(c);
                    blocks.get(blockNum).add(c);
                    if(helper(board, rows, cols, blocks)) {
                       return true; 
                    }
                    board[i][j] = '.';
                    rows.get(i).remove(c);
                    cols.get(j).remove(c);
                    blocks.get(blockNum).remove(c);
                }
                return false;
            }
        }
        return true;
    }
}