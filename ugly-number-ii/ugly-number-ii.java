class Solution {
    
    public int nthUglyNumber(int n) {
        if(n==1)return 1;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        pq.add(1L);
        HashSet<Long>n1=new HashSet<>();
        int i=1;
        while(i<n){
            Long val=pq.poll();
            if(n1.add(2*val)){
                pq.add(2*val);
            }
            if(n1.add(3*val)){
                pq.add(3*val);
            }
            if(n1.add(5*val)){
                pq.add(5*val);
            }
            i++;
        }
        
        return (int)(long)pq.poll();
    }
}