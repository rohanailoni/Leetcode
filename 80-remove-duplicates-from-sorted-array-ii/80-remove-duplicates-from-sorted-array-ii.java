class Solution {
//     public int removeDuplicates(int[] nums) {
//         int pre=Integer.MIN_VALUE;
//         int count=0;
//         int i=0;
//         while(i<nums.length){
//             if(pre==Integer.MIN_VALUE){
//                 pre=nums[i];
//                 count++;
//             }else if(pre==nums[i] && count<=2){
//                 count++;
//             }else if(count==2 && pre==nums[i]){
//                 for(int j=i+1;j<nums.length;i++){
//                     nums[j-1]=nums[j]
//                 }
//                 count=1;
//                 pre=nums[i];
                
//             }
//             i++;
//         }
//     }
        public int removeDuplicates(int[] nums){
                int n = nums.length;
                int pos=-1;
                for(int i = 0; i<n; i++) {
                 if(pos == -1||pos==0|| nums[pos-1] != nums[i])
                     nums[++pos] = nums[i];
                }
            return pos+1;
        }
}