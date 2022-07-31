class Solution {
    private boolean check(int[] nums){
        for(int i:nums){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    private int getMin(int arr[], int n)
    {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            if(arr[i]!=0) res =Math.min(res, arr[i]);
        return res==Integer.MAX_VALUE?0:res;
    }
    public int minimumOperations(int[] nums) {
        int count=0;
        //System.out.println(Arrays.toString(nums)+" "+check(nums));
        while(check(nums)==false){
            int min = getMin(nums,nums.length);
            //System.out.println(min);
            if(min==0)break;
            count++;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0)nums[i]=nums[i]-min;
            }
            //System.out.println(Arrays.toString(nums));
        }
        return count;
        
    }
}