class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans=0;
        int point=cost.length-1;
        while(point>=0){
            if(point==1){
                ans+=cost[point];
                point--;
            }if(point==0){
                ans+=cost[point];
                point--;
            }else{
                ans+=cost[point];
                point--;
                ans+=cost[point];
                point--;
                point--;
            }
        }
        
        return ans;
    }
}