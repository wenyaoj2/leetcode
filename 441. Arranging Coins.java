class ArrangeCoins {
    public int arrangeCoins(int n) {
        if(n == 0) {
            return 0;
        }
        long start = 1;
        long end = n;
        while(start + 1 < end) {
            long mid = (end - start) / 2 + start;
            long sum = (long)(mid * (mid + 1) / 2);
            if(sum == n) {
                return (int)mid;
            }
            else if(sum < n) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        long sum = (long)(end * (end + 1) / 2);
        if(sum > n) {
            return (int)(end - 1);
        }
        return (int)end;
    }
}