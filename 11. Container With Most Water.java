
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int max = 0;
        while(left < right){
            sum = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, sum);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}