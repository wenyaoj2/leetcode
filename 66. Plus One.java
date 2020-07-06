import java.util.*;

class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList();
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + carry;
            carry = digit / 10;
            digit = digit % 10;
            list.add(0, digit);
        }
        if(carry == 1) {
            list.add(0, carry);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}