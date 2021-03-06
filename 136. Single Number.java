import java.util.*;

class SingleNumber {
    public int singleNumber(int[] nums) {
        int last = 0;
        Map<Integer,Integer> ans = new HashMap();
        for(int i:nums){
            ans.put(i,ans.getOrDefault(i,0)+1);
        }
        for(int i : ans.keySet()){
            if(ans.get(i)==1){
                last = i;
            }
        }
        return last;
    }
}

//方法二使用^异或来解决奇偶问题
// 0^0 = 0
// 1^1 = 0
// 0^a = a
// a^b^a = a^a^b = 0^b = b
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i: nums){
            ans = ans^i;
        }
        return ans;
    }
}
