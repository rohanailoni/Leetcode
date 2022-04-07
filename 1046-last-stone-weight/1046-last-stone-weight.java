class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int i:stones){
            pQueue.add(i);
        }
        while(pQueue.size()>1){
            pQueue.add(Math.abs(pQueue.poll()-pQueue.poll()));
        }
        return pQueue.poll();
        
    }
}