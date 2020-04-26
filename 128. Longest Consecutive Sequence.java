import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet();
        for(int num : nums){
            hash.add(num);
        }
        int max = 0;
        int cur = 0;
        for(int num : nums){
            if(!hash.contains(num - 1)){
                while(hash.contains(num)){
                    cur++;
                    num += 1;
                }
                max = Math.max(cur, max);
                cur = 0;
            }
        }
        // max = Math.max(max, cur);
        return max;
    }
}