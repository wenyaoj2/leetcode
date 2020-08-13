import java.util.*;

class CombinationIterator {
    List<String> list = new ArrayList();
    String cur = "";
    int combinationLength = 0;
    int curIndex = 0;
    public void findCombinations(String cur, List<String> list, int index, String characters, int combinationLength) {
        if(cur.length() == combinationLength) {
            list.add(cur);
            return;
        }
        for(int i = index; i < characters.length(); i++) {
            findCombinations(cur + characters.charAt(i), list, i + 1, characters, combinationLength);
        }
    } 
    public CombinationIterator(String characters, int combinationLength) {
        this.cur = characters;
        this.combinationLength = combinationLength;
        findCombinations("", list, 0, cur, combinationLength);
    }
    
    public String next() {
        return list.get(curIndex++);
    }
    
    public boolean hasNext() {
        return curIndex < list.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */