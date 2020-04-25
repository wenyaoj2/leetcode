import java.util.*;
class CountofSmallerNumbersAfterSelf {
    int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        ans = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        List<Integer> res = new ArrayList();
        mergeSort(nums, 0, nums.length - 1, indexes);
        for(int num : ans){
            res.add(num);
        }
        return res;
    }
    
    public void mergeSort(int[] nums, int start, int end, int[] indexes){
        if(start >= end){
            return;
        }
        int mid = (end - start) / 2 + start;
        mergeSort(nums, start, mid, indexes);
        mergeSort(nums, mid+1, end, indexes);
        merge(nums, start, end, indexes);
    }
    
    public void merge(int[] nums, int start, int end, int[] indexes){
        int mid = (end - start) / 2 + start;
        int i = start;
        int j = mid + 1;
        int index = 0;
        int[] curIndex = new int[end - start + 1];
        int rightCount = 0;
        while(i <= mid && j <= end){
            if(nums[indexes[i]] <= nums[indexes[j]]){
                curIndex[index] = indexes[i];
                ans[indexes[i]] += rightCount;
                index++;
                i++;
            }
            else{
                curIndex[index] = indexes[j];
                // ans[indexes[j]] += rightCount;
                rightCount++;
                index++;
                j++;
            }
        }
        
        while(i <= mid){
            curIndex[index] = indexes[i];
            ans[indexes[i]] += rightCount;
            index++;
            i++;
        }
        
        while(j <= end){
            curIndex[index] = indexes[j];
            // ans[indexes[j]] += rightCount;
            index++;
            j++;
        }
        index = 0;
        for(i = start; i <= end; i++){
            indexes[i] = curIndex[index++];
        }
        return;
    }
}