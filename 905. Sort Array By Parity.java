class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int left = 0, right = A.length - 1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                result[left++] = A[i];
            }
            else {
                result[right--] = A[i];
            }
        }
        return result;
    }
}