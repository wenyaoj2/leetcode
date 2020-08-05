import java.util.*;
class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    HashSet<Integer> used = new HashSet();
    Queue<Integer> pool = new LinkedList();
    public PhoneDirectory(int maxNumbers) {
        for(int i = 0; i < maxNumbers; i++) {
            pool.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(pool.isEmpty()) {
            return -1;
        }
        int num = pool.poll();
        used.add(num);
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!used.contains(number)) {
            return;
        }
        pool.offer(number);
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