class IsPalindromeNum {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int y = 0, x1 = x;
        while(x1 > 0) {
            y = y * 10 + x1 % 10;
            x1 = x1 / 10;
        }
        return y == x;
    }
}