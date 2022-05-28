// class Solution {
//     public int missingNumber(int[] nums) {
//         int n=nums.length;
//         int[] missing=new int[n+1];
//         Arrays.fill(missing,0);
//         for(int i=0;i<n;i++){
//             missing[nums[i]]+=1;
//         }
//         for(int i=0;i<n+1;i++){
//             if(missing[i]==0){
//                 return i;
//             }
//         }
//         return 0;
//     }
// } 
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            //System.out.println(answer+"1");
            answer ^= i;
            //System.out.println(answer+"2");
            answer ^= nums[i - 1];
            //System.out.println(answer+"3");
        }
        return answer;
    }
} 