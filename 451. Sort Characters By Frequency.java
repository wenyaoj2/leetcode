class FrequencySort {
    public String frequencySort(String s) {
        int[] chars = new int[256];
        int max = 0;
        for(char c : s.toCharArray()) {
            chars[c - ' '] += 1;
            max = Math.max(max, chars[c - ' ']);
        }
        String[] buckets = new String[max];
        for(int i = 0; i < 256; i++) {
            if(chars[i] == 0) {
                continue;
            }
            char c =  (char)(i + ' ');
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < chars[i]; j++) {
                temp.append(c);
            }
            String cur = temp.toString();
            buckets[chars[i] - 1] = (buckets[chars[i] - 1] == null) ? cur : buckets[chars[i] - 1] + cur;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length - 1; i >= 0; i--) {
            if(buckets[i] == null) {
                continue;
            }
            sb.append(buckets[i]);
        }
        return sb.toString();
    }
}