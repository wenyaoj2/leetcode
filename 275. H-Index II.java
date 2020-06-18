class HIndexII {
    public int hIndex(int[] citations) {
        if(citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int start = 0;
        int end = citations.length - 1;
        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(citations[mid] == len - mid) {
                return citations[mid];
            }
            else if(citations[mid] < len - mid) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(citations[start] >= len - start) {
            return len - start;
        }
        if(citations[end] >= len - end) {
            return len - end;
        }
        return 0;
    }
}