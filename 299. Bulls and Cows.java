class GetHint {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> hash = new HashMap();
        int numBull = 0, numCow = 0;
        for(int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g) {
                numBull++;
            }
            else {
                if(hash.getOrDefault(s, 0) < 0) {
                    numCow++;
                }
                if(hash.getOrDefault(g, 0) > 0) {
                    numCow++;
                }
                hash.put(s, hash.getOrDefault(s, 0) + 1);
                hash.put(g, hash.getOrDefault(g, 0) - 1);
            }
        }
        return numBull + "A" + (numCow) + "B";
    }
}