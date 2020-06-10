class MergeTwoArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int index = nums1.length - 1;
        while(pointer1 >= 0 || pointer2 >= 0) {
            if(pointer1 < 0 || (pointer2 >= 0 && nums2[pointer2] > nums1[pointer1])) {
                nums1[index--] = nums2[pointer2--];
            }
            else {
                nums1[index--] = nums1[pointer1--];
            }
        }
    }
}