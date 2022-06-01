class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n];
        temp[0]=nums[0];
        for(int i=1;i<n;i++){
            temp[i]=temp[i-1]+nums[i];
        }
        return temp;
    }
}