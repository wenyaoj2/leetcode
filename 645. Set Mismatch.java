import java.util.HashSet;

class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> ans = new HashSet();
        int[] last = new int[2];
        for(int i:nums){
            if(!ans.add(i)){
                last[0] = i;
            }
            else{
                ans.add(i);
            }
        }
        for(int i =1;i<=nums.length;i++){
            if(!ans.contains(i)){
                last[1] = i;
            }
        }
        return last;
    }
}
