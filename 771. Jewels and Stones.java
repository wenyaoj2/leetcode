import java.util.HashSet;

class JewelAndStone {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewel = new HashSet();
        int num = 0;
        for(char c : J.toCharArray()){
            jewel.add(c);
        }
        for(char c : S.toCharArray()){
            if(jewel.contains(c)){
                num++;
            }
        }
        return num;
    }
}