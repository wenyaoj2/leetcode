import java.util.*;

class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    HashSet<Integer> used = new HashSet();
    HashSet<Integer> pool = new HashSet();
    public PhoneDirectory(int maxNumbers) {
        for(int i = 0; i < maxNumbers; i++) {
            pool.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(pool.isEmpty()) {
            return -1;
        }
        for(int num : pool) {
            pool.remove(num);
            used.add(num);
            return num;
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return pool.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        pool.add(number);
        used.remove(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */