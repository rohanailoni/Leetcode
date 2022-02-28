class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        
            List<String> ans = new ArrayList<>();
        
        
            if(nums.length==0)
                return ans;
        
            int l=0; 
            int i=0;
            for(i=1;i<nums.length;i++){
                
                    if(nums[i]-nums[i-1]!=1){
                        
                           if(nums[l]==nums[i-1]){
                               
                                ans.add(""+nums[l]);
                           }
                            
                           else{
                               
                               String b=""+nums[l]+"->"+nums[i-1];
                               ans.add(b);
                           }
                            l=i;
                        
                    }
                 
                
            }
           
               if(nums[l]==nums[i-1]){

                    ans.add(""+nums[l]);
               }

               else{

                   String b=""+nums[l]+"->"+nums[i-1];
                   ans.add(b);
               }
            return ans;
        
        
    }
}