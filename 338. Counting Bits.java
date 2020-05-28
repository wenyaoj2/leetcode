class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        int level = 1;
        for(int i = 1; i <= num; i++) {
            if(i / level == 2) {
                level = level * 2;
            }
            int curLen = level / 2;
            if(i - level < curLen) {
                res[i] = res[i - curLen];
            }
            else {
                res[i] = res[i - curLen] + 1;
            }
        }
        return res;
    }
}