import java.util.HashSet;

class NumsSameConsecDiff {
    public int[] numsSameConsecDiff(int N, int K) {
        HashSet<Integer> result = new HashSet();
        if(N == 1) {
            result.add(0);
        }
        for(int i = 1; i <= 9; i++) {
            DFSFindNum(N - 1, i, i, result, K);
        }
        int[] ans = new int[result.size()];
        int index = 0;
        for(int num : result) {
            ans[index++] = num;
        }
        return ans;
    }
    private void DFSFindNum(int N, int curNum, int prevNum, HashSet<Integer> result, int K) {
        if(N == 0) {
            result.add(curNum);
        }
        if(N < 0) {
            return;
        }
        int num1 = prevNum + K;
        int num2 = prevNum - K;
        if(num1 < 10 && num1 >= 0) {
            DFSFindNum(N - 1, curNum * 10 + num1, num1, result, K);
        }
        if(num2 >= 0 && num2 < 10) {
            DFSFindNum(N - 1, curNum * 10 + num2, num2, result, K);
        }
        return;
    }
}