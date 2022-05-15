class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long[] forward=new long[n];
        long[] backward=new long[n];
        
        forward[0]=nums[0];
        for(int i=1;i<n;i++){
            forward[i]=forward[i-1]+nums[i];
        }
        backward[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            backward[i]=backward[i+1]+nums[i];
        }
       
        int ans=0;
        for(int i=0;i<n-1;i++){
            
            if(forward[i]>=backward[i+1]){
                
                ans++;
            }
        }
        return ans;
            
            
            
    }
}