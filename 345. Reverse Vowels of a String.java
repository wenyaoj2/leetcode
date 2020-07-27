import java.util.HashSet;

class ReverseVowels {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        while(start < end) {
            while(start < end && !vowels.contains(s.charAt(start))) {
                start++;
            }
            while(start < end && !vowels.contains(s.charAt(end))) {
                end--;
            }
            char c = chars[end];
            chars[end--] = chars[start];
            chars[start++] = c;
        }
        return new String(chars);
    }
}