class ImplementSTr {
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length() + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < needle.length()){
            if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
        
        i = 0;
        j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if(j == needle.length()){
            return i - j;
        }
        return -1;
    }
}