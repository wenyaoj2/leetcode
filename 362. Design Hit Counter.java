class HitCounter {
    int[] times;
    int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int time = timestamp % 300;
        if(times[time] == timestamp) {
            hits[time]++;
        }
        else {
            times[time] = timestamp;
            hits[time] = 1;
        }
        return;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for(int i = 0; i < 300; i++) {
            if(timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */