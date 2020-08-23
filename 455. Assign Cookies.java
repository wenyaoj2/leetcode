import java.util.*;

class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index1 = 0, index2 = 0;
        int result = 0;
        while(index1 < g.length && index2 < s.length) {
            if(g[index1] <= s[index2]) {
                result++;
                index1++;
                index2++;
            }
            else {
                index2++;
            }
        }
        return result;
    }
}