import java.util.TreeSet;

class ExamRoom {
    TreeSet<Integer> room = new TreeSet();
    int size;
    public ExamRoom(int N) {
        this.size = N;
    }
    
    public int seat() {
        if(room.isEmpty()) {
            room.add(0);
            return 0;
        }
        int pos = 0;
        int dis = room.first();
        int prev = 0;
        for(int seat : room) {
            int curDis = (seat - prev) / 2;
            if(curDis > dis) {
                pos = prev + curDis;
                dis = curDis;
            }
            prev = seat;
        }
        if(size - room.last() - 1 > dis) {
            room.add(size - 1);
            return size - 1;
        }
        room.add(pos);
        return pos;
    }
    
    public void leave(int p) {
        room.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */