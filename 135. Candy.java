import java.util.*;

class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i = 0; i < ratings.length - 1; i++) {
            if(ratings[i] < ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for(int i = ratings.length - 1; i > 0; i--) {
            if(ratings[i - 1] > ratings[i]) {
                if(candies[i - 1] <= candies[i]) {
                    candies[i - 1] = candies[i] + 1;
                }
            }
        }
        int res = 0;
        for(int candy : candies) {
            res += candy;
        }
        return res;
    }
}