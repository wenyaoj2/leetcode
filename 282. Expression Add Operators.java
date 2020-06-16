import java.util.*;

class AddOperators {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList();
        helper(num, 0, target, "", 0, 0);
        return res;
    }
    public void helper(String num, int index, int target, String cur, long curVal, long preVal) {
        if(index == num.length()) {
            if(curVal == target) {
                res.add(cur);
            }
            return;
        }
        
        long curNum = 0;
        for(int i = index; i < num.length(); i++) {
            curNum = curNum * 10 + num.charAt(i) - '0';
            if(index == 0) {
                helper(num, i + 1, target, "" + curNum, curVal + curNum, curNum);
            }
            else {
                helper(num, i + 1, target, cur + "+" + curNum, curVal + curNum, curNum);
                helper(num, i + 1, target, cur + "-" + curNum, curVal - curNum, -curNum);
                helper(num, i + 1, target, cur + "*" + curNum, curVal - preVal + (preVal * curNum), preVal * curNum);
            }
            if(num.charAt(index) == '0') {
                break;
            }
        }
    }
}