class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        int num = n & (n - 1);
        return num == 0;
    }
}