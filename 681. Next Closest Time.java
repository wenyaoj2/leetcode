class NextClosestTime {
    int min = Integer.MAX_VALUE;
    String res = "";
    public String nextClosestTime(String time) {
        int[] nums = new int[4];
        int timeNum = 0;
        int index = 0;
        char p = time.charAt(0);
        boolean flag = true;
        for(int i = 0; i < time.length(); i++) {
            if(i == 2) {
                continue;
            }
            if(time.charAt(i) != p) {
                flag = false;
            }
            int n = time.charAt(i) - '0';
            nums[index] = n;
            timeNum = timeNum * 10 + n;
            index++;
        }
        if(flag) {
            return time;
        }
        helper(nums, 0, 0, "", timeNum);
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < res.length(); i++) {
            ans.append(res.charAt(i));
            if(i == 1) {
                ans.append(":");
            }
        }
        return ans.toString();
    }
    public void helper(int[] nums, int index, int curVal, String curString, int timeNum) {
        if(index == 2 && curVal > 23) {
            return;
        }
        if(index == 4) {
            if(curVal > 2359) {
                return;
            }
            if(curVal > timeNum && min > curVal - timeNum) {
                min = curVal - timeNum;
                res = curString;
            }
            else if(curVal < timeNum && min > curVal + 2400 - timeNum) {
                min = 2400 + curVal - timeNum;
                res = curString;
            }
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(index == 0 && nums[i] > 2) {
                continue;
            }
            if(index == 2 && nums[i] > 5) {
                continue;
            }
            helper(nums, index + 1, curVal * 10 + nums[i], curString + nums[i], timeNum);
        }
    }
}