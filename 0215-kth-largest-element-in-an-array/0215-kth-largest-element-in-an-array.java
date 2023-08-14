class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>qu=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            qu.add(nums[i]);
        }
        int diff=nums.length-k;
        for(int i=0;i<=diff;i++){
            int ans=qu.poll();
            //System.out.println(ans);
            if(i==diff){
                return ans;
            }
        }
        return -1;
    }
}