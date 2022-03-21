class Solution {
    public int minStartValue(int[] nums) {
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            sum+=i;
            if(sum<=0)min=Math.min(min,sum);
            
        }
        return min==Integer.MAX_VALUE?1:-min+1;
    }
}