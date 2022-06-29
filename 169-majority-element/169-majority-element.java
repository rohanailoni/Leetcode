class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        int max_len=20;
        int n=nums.length;
        int num=0;
        
    
        for(int i=0;i<max_len;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if((nums[j] & (1<<i))!=0){
                    count++;
                }
                
            }
            //System.out.println(count);
            if(count>n/2){
                  
                ans+=(1<<i);
            }
            
            
        }
        //System.out.println(1<<20);
        return ans;
    }
}