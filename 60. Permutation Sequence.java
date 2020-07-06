import java.util.*;

class GetPermutation {
    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList();
        for(int i = 0; i < 9; i++) {
            digits.add(i + 1);
        }
        int level = 1;
        for(int i = 1; i <= n; i++) {
            level = level * i;
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            level = level / n;
            int num = k / level;
            sb.append(digits.get(num));
            digits.remove(num);
            k = k % level;
            n--;
            
        }
        return sb.toString();
    }
}