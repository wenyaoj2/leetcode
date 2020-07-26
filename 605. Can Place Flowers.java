class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) {
                i++;
            }
            else {
                if(i == flowerbed.length - 1 || (i < flowerbed.length - 1 && flowerbed[i + 1] == 0)) {
                    n--;
                    i++;
                }
            }
            
        }
        return n <= 0;
    }
}