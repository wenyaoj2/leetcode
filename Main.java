import java.util.*;

public class Main {
    public static int findTimes(String T, String S) {
        String[] parts = S.split("\\*");
        
        String front = parts[0], behind = parts[1];
        // System.out.println(front + " " +  behind);
        int start = 0, end = T.length() - 1;
        int res = 0;
        while(start <= end) {
            while(start <= end && !T.substring(start, start + front.length()).equals(front)) {
                start++;
            }
            while(start <= end && !T.substring(end - behind.length() + 1, end + 1).equals(behind)) {
                end--;
            }
            if(T.substring(start, start + front.length()).equals(front) && T.substring(end - behind.length() + 1, end + 1).equals(behind)) {
                res++;
                start += front.length();
                end -= behind.length();
            }
            
        }
        return res;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        // String[] parts = s.split(" ");
         
        System.out.println(findTimes("AAA333", "A*3"));
    }
}