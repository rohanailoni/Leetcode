class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length==1){
            return nums;
        }
        int top=0;
        int low=nums.length-1;
        while(top<low){
            if(nums[top]%2==0 && nums[low]%2==0){
                top++;
            }else if(nums[top]%2!=0 && nums[low]%2==0){
                System.out.println(top+" "+low);
                int temp=nums[top];
                nums[top]=nums[low];
                nums[low]=temp;
                top++;
                low--;
            }else if(nums[top]%2==0 && nums[low]%2!=0){
                low--;
                top++;
            }else if(nums[top]%2!=0 && nums[low]%2!=0){
                low--;
            }
        }
        return nums;
        
    }
}