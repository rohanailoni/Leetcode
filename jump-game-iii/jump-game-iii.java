class Solution{
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length; 
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            if (arr[curr] == 0) return true;   // reached the target index
            
			// reached this index again, so not possible from this index but might be possible to reach from other direction, so check again in the queue
            if (arr[curr]<0) continue;   
            
            if (curr + arr[curr] < n)
                q.add(curr + arr[curr]);
            if (curr - arr[curr] >= 0)
                q.add(curr - arr[curr]);
            
            arr[curr] = -arr[curr];   // to distinguish between index coming first time or again
        }
        
        return false;
    }
}