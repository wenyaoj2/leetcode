import java.util.*;

class ProductOfNumbers {
    int zeroPos;
    List<Integer> list;
    public ProductOfNumbers() {
        zeroPos = -1;
        list = new ArrayList();
        list.add(1);
    }

    public void add(int num) {
        if(num != 0) {
            int products = num * list.get(list.size() - 1);
            list.add(products);
        }
        else {
            zeroPos = list.size();
            list.add(1);
        }
    }

    public int getProduct(int k) {
        if(list.size() - k <= zeroPos) {
            return 0;
        }
        return list.get(list.size() - 1) / list.get(list.size() - k - 1);
    }
}