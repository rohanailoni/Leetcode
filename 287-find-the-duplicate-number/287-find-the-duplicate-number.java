class Solution {
     private boolean binary(int s,int e,int[] nums,int req){
         
         while(s<=e){
             int mid=s+(e-s)/2;
            
             if(nums[mid]==req){
                 return true;
             }
             if(nums[mid]>req){
                 e=mid-1;
             }
             if(nums[mid]<req){
                 s=mid+1;
             }
         }
         return false;
     }
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(binary(i+1,nums.length-1,nums,nums[i])){
        //         return nums[i];
        //     }
        // }
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);
        
        slow = nums[0];
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
        
        
        
    }
}