class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int times = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            times++;
        }
        return m <<= times;
    }
}