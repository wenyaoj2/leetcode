class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1) {
            return helper(nums1, 0, nums2, 0, len / 2 + 1);
        }
        else {
            double left = helper(nums1, 0, nums2, 0, len / 2);
            double right = helper(nums1, 0, nums2, 0, len / 2 + 1);
            return (left + right) / 2;
        }
        
    }
    
    public double helper(int[] nums1, int index1, int[] nums2, int index2, int k) {
        if(index1 >= nums1.length) {
            return nums2[index2 + k - 1];
        }
        if(index2 >= nums2.length) {
            return nums1[index1 + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        if(index1 + k / 2 <= nums1.length) {
            num1 = nums1[index1 + k / 2 - 1];
        }
        if(index2 + k / 2 <= nums2.length) {
            num2 = nums2[index2 + k / 2 - 1];
        }
        if(num1 < num2) {
            return helper(nums1, index1 + k / 2, nums2, index2, k - k / 2);
        }
        else {
            return helper(nums1, index1, nums2, index2 + k / 2, k - k / 2);
        }
    }
}