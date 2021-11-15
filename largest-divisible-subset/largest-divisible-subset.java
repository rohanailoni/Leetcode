// class Solution {
//     private int[] dp;
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         dp=new int[nums.length];
//         Arrays.fill(dp,0);
//         int size=getsize(nums);
//         System.out.println(size);
//         return build(size,nums);
        
        
//     }
//     private int getsize(int[] nums){
//         int size=0;
//         for(int i=0;i<nums.length-2;i++){
//             for(int j=i+1;j<nums.length;j++){
                
//                 if(nums[j]%nums[i]==0){
//                     dp[j]=Math.max(dp[i]+1,dp[i]);
//                     size=Math.max(dp[j],size);
//                 }
//             }
            
//         }
//         return size;
        
        
//     }
//     private List<Integer>build(int size,int[] nums){
//         int pre=size;
//         List<Integer>ans=new ArrayList<>();
//         int dpindex=0;
//         for(int i=dp.length-1;i>=0;i--){
//             if(dp[i]==size){
//                 dpindex=i;
//             }
//         }
//         ans.add(nums[dpindex]);
//         for(int i=dpindex-1;i>=0;i--){
//             if(dp[i]==pre){
//                 continue;
//             }
//             else if(dp[i]==pre-1){
//                 ans.add(nums[i]);
//                 pre--;
//             }
//         }
//         return ans;
        
        
        
//     }
// }
public class Solution{
    public List<Integer> largestDivisibleSubset(int[] nums) {
	var dp = new int[nums.length];
	return constructLDS(nums, dp, getLDSSize(nums, dp));
}

private int getLDSSize(int[] nums, int[] dp) {
	Arrays.sort(nums);
	Arrays.fill(dp, 1);
	var ldsSize = 1;

	for (var i = 1; i < nums.length; i++)
		for (var j = 0; j < i; j++)
			if (nums[i] % nums[j] == 0) {
				dp[i] = Math.max(dp[i], dp[j] + 1);
				ldsSize = Math.max(ldsSize, dp[i]);
			}
			
	return ldsSize;
}

private List<Integer> constructLDS(int[] nums, int[] dp, int ldsSize) {
	var prev = -1;
	var lds = new LinkedList<Integer>();

	for (var i = dp.length - 1; i >= 0; i--)
		if (dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)) {
			lds.addFirst(nums[i]);
			ldsSize--;
			prev = nums[i];
		}

	return lds;
}
}