import java.util.*;

class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> hash;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList();
        hash = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hash.containsKey(val)) {
            return false;
        }
        list.add(val);
        hash.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hash.containsKey(val)) {
            return false;
        }
        int index = hash.get(val);
        int last = list.get(list.size() - 1);
        hash.put(last, index);
        list.set(index, last);
        list.remove(list.size() - 1);
        hash.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int rand = (int)(Math.random() * list.size());
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */