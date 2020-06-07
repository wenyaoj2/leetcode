import java.util.*;

class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int[][] seats = new int[people.length][2];
        for(int[] seat : seats) {
            Arrays.fill(seat, -1);
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }  
        };
        Arrays.sort(people, comparator);
        for(int[] person : people) {
            int num = person[1];
            // System.out.println(seats[0][0] + " "+ seats[0][1]);
            for(int i = 0; i < seats.length; i++) {
                if(seats[i][0] != -1) {
                    continue;
                }
                if(num == 0) {
                    seats[i][0] = person[0];
                    seats[i][1] = person[1];
                    break;
                }
                if(seats[i][0] == -1) {
                    num--;
                }
            }
        }
        return seats;
    }
}