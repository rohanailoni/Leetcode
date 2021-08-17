class SeatManager {
    Queue<Integer>q=new PriorityQueue<>();
    
    public SeatManager(int n) {
        for(int i=1;i<=n;i++){
            q.add(i);
        }
    }
    
    public int reserve() {
        return q.remove();
    }
    
    public void unreserve(int seatNumber) {
        q.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */