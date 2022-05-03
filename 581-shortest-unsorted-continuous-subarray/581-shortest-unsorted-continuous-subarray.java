
class pair{
    int max;
    int min;
    pair(int m1,int m2){
        min=m1;
        max=m2;
    }
}



class Solution {
    private pair min_max(int[] nums,int i,int j){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            min=Math.min(min,nums[k]);
            max=Math.max(max,nums[k]);
        }
        return new pair(min,max);
        
        
        
    }
    public int findUnsortedSubarray(int[] nums) {
        
       
        
        int top=0;
        int low=nums.length-1;
        while(top<low){
            pair p=min_max(nums,top,low);
            if(nums[top]==p.min && nums[low]==p.max){
                low--;
                top++;
            }else if(nums[top]==p.min && nums[low]!=p.max){
                top++;
    
            }else if(nums[top]!=p.min && nums[low]==p.max){
                low--;
            }else{
                return low-top+1;
            }
        }
        
        
        return 0;
    }
}