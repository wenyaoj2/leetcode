import java.util.*;
class SurroundedRegion {
    int[][] seen;
    int[] dirA = {0, 0, 1, -1};
    int[] dirB = {1, -1, 0, 0};
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) {
            return;
        }
        seen = new int[board.length][board[0].length];
        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O' && seen[0][i] == 0) {
                seen[0][i] = 1;
                helper(board, 0, i);
            }
            if(board[board.length - 1][i] == 'O' && seen[board.length - 1][i] == 0) {
                seen[board.length - 1][i] = 1;
                helper(board, board.length - 1, i);
            }
        }
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O' && seen[i][0] == 0) {
                seen[i][0] = 1;
                helper(board, i, 0);
            }
            if(board[i][board[0].length - 1] == 'O' && seen[i][board[0].length - 1] == 0) {
                seen[i][board[0].length - 1] = 1;
                helper(board, i, board[0].length - 1);
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(seen[i][j] == 1) {
                    continue;
                }
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                    flip(board, i, j);
                }
            }
        }
    }
    public void helper(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < dirA.length; i++) {
                int row = cur[0] + dirA[i];
                int col = cur[1] + dirB[i];
                if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'X' || seen[row][col] == 1) {
                    continue;
                }
                seen[row][col] = 1;
                queue.offer(new int[]{row, col});
            }
        }
    }
    public void flip(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < dirA.length; i++) {
                int row = cur[0] + dirA[i];
                int col = cur[1] + dirB[i];
                if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'X' || seen[row][col] == 1) {
                    continue;
                }
                board[row][col] = 'X';
                queue.offer(new int[]{row, col});
            }
        }
    }
}