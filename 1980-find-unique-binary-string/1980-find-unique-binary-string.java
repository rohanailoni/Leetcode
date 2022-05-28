class Solution {
    public String findDifferentBinaryString(String[] nums) {
      
        int n=nums.length;
        int[] mem=new int[n];
        for(int i=0;i<n;i++){
            mem[i]=Integer.parseInt(nums[i],2);
        }
        
        //System.out.println(Math.pow(2,16));
        int pow=(int)Math.pow(2,16);
        boolean[] dp=new boolean[pow];
        Arrays.fill(dp,false);
        for(int i=0;i<n;i++){
            dp[mem[i]]=true;
        }
        for(int i=0;i<pow;i++){
            if(!dp[i]){
                String ans=Integer.toBinaryString(i);
                if(ans.length()<n){
                    while(ans.length()<n){
                        ans="0"+ans;
                    }
                    return ans;
                }
                return ans;
            }
        }
        
        return "";
        
    }
}