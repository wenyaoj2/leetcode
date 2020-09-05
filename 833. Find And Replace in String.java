class FindReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, String> hash = new HashMap();
        HashMap<Integer, Integer> range = new HashMap();
        for(int i = 0; i < indexes.length; i++) {
            boolean flag = false;
            int index = indexes[i];
            String source = sources[i];
            String target = targets[i];
            for(int j = index; j < index + source.length(); j++) {
                if(S.charAt(j) != source.charAt(j - index)) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                continue;
            }
            hash.put(index, target);
            range.put(index, index + source.length() - 1);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if(hash.containsKey(i)) {
                result.append(hash.get(i));
                i = range.get(i);
            }
            else {
                result.append(S.charAt(i));
            }
        }
        return result.toString();
    }
}