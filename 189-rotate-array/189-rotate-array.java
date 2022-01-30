class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k%=nums.length;
        reverse(0,len-1,nums);
        reverse(0,k-1,nums);
        reverse(k,len-1,nums);
        
        
    }
    void reverse(int s,int e,int[] nums){
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
            
        }
    }
}