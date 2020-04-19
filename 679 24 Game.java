import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Game24 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList();
        for(int num : nums){
            list.add((double) num);
        }
        return helper(list);
    }
    
    public boolean helper(List<Double> list){
        if(list.size() == 1){
            return Math.abs(list.get(0) - 24) < 0.001;
        }
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1;  j < list.size(); j++){
                for(double num : compute(list.get(i), list.get(j))){
                    List<Double> cur = new ArrayList();
                    cur.add(num);
                    for(int k = 0; k < list.size(); k++){
                        if(k != i && k != j){
                            cur.add(list.get(k));
                        }
                    }
                    if(helper(cur)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public List<Double> compute(double a, double b){
        List<Double> results = Arrays.asList(a + b, a - b, a * b, a / b, b - a, b / a);
        return results;
    }
}