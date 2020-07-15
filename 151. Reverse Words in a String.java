class ReverseWords {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) {
            if(strs[i].equals("")) {
                continue;
            }
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}