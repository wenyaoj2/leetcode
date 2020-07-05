class HammingDistance {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int res = 0;
        while(num > 0) {
            res += (num % 2);
            num /= 2;
        }
        return res;
    }
}