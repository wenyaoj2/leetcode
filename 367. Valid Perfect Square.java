class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 0;
        long end = num;
        while(start + 1 < end) {
            long mid = (end - start) / 2 + start;
            if((long)(mid * mid) == num) {
                return true;
            }
            else if((long)(mid * mid) < num) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return (long)(start * start) == num || (long)(end * end) == num;
    }
}