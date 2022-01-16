class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = -1;
        int max = -1;
        for(int i=0;i<seats.length;i++) {
            if(seats[i] == 1) {
                if(prev == -1) max = i-prev-1;
                else max = Math.max(max, (i-prev) / 2);
                prev = i;
            }
        }
        if(seats[seats.length - 1] == 0) max = Math.max(max, seats.length-1 - prev);
        return max;
    }
}
