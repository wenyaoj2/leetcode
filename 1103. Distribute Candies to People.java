class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int curCandies = 1;
        int index = 0;
        while(candies > 0) {
            if(candies < curCandies) {
                result[index % num_people] += candies;
                candies = 0;
            }
            else {
                result[index % num_people] += curCandies;
                candies -= curCandies;
            }
            curCandies++;
            index++;
        }
        return result;
    }
}