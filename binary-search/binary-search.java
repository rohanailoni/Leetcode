class Solution {
    private int t;
    private int[] num;
    private int binary(int l,int h){
        if(h>=l){
            int mid=l+(h-l)/2;
            if(num[mid]==t){
                return mid;

            }
            
            else if(num[mid]>t){

                return binary(l,mid-1);
            }
            else if(num[mid]<t){
                return binary(mid+1,h);
            }
        }
        
        return -1;
    }
    
    
    
    public int search(int[] nums, int target) {
        this.t=target;
        this.num=nums;
        return binary(0,nums.length-1);
    }
}