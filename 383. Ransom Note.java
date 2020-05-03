import java.util.HashMap;

class RandomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hash = new HashMap();
        for(char c : magazine.toCharArray()){
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if(!hash.containsKey(c) || hash.get(c) < 1){
                return false;
            }
            else{
                hash.put(c, hash.get(c) - 1);
            }
        }
        return true;
    }
}