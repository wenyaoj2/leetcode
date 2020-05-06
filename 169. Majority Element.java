import java.util.HashMap;

class MajorityElement {
    public int majorityElement(int[] nums) {
        int target = nums.length / 2;
        HashMap<Integer, Integer> hash = new HashMap();
        for(int num : nums){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        for(int k : hash.keySet()){
            if(hash.get(k) > target){
                return k;
            }
        }
        return -1;
    }
}