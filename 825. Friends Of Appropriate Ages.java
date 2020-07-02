class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] people = new int[121];
        for(int age : ages) {
            people[age]++;
        }
        for(int i = 1; i <= 120; i++) {
            if(people[i] == 0) {
                continue;
            }
            if(i > i / 2 + 7) {
                res += (people[i] - 1) * people[i];
            }
            for(int j = 1; j < i; j++) {
                if(j > i / 2 + 7) {
                    res += people[j] * people[i];
                }
            }
        }
        return res;
    }
}