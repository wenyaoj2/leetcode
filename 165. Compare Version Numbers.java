class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0; i < Math.max(v1.length, v2.length); i++) {
            String s1 = (i < v1.length) ? v1[i] : "0";
            String s2 = (i < v2.length) ? v2[i] : "0";
            int num1 = 0, num2 = 0;
            boolean flag = false;
            for(char c : s1.toCharArray()) {
                if(c == '0' && !flag) {
                    continue;
                }
                num1 = num1 * 10 + (c - '0');
                flag = true;
            }
            flag = false;
            for(char c : s2.toCharArray()) {
                if(c == '0' && !flag) {
                    continue;
                }
                num2 = num2 * 10 + (c - '0');
                flag = true;
            }
            
            if(num1 > num2) {
                return 1;
            }
            if(num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}