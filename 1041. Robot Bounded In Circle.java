class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        int x = 0, y = 0;
        int dir = 0;
        for(char c : instructions.toCharArray()) {
            if(c == 'L') {
                dir = (dir + 3) % 4;
            }
            else if(c == 'R') {
                dir = (dir + 1) % 4;
            }
            else {
                x += dirX[dir];
                y += dirY[dir];
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
}