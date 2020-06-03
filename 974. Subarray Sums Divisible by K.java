import java.util.*;

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        HashMap<Integer, Integer> hash = new HashMap();
        int[] sum = new int[A.length + 1];
        for(int i = 1; i < sum.length; i++) {
            sum[i] = A[i-1] + sum[i-1];
        }
        hash.put(0, 1);
        for(int i = 1; i < sum.length; i++) {
            int n = sum[i] % K;
            if(n < 0) {
                n += K;
            }
            if(hash.containsKey(n)) {
                res += hash.get(n);
            }
            hash.put(n, hash.getOrDefault(n, 0) + 1);
        }
        return res;
    }
}