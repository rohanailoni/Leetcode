class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(k == 0 || n < 2) {       
            return false;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int runningSum = 0;
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];  
            runningSum %= k;
			
            if(map.containsKey(runningSum)) {   //we check for the remainder
                if(i - map.get(runningSum) > 1) {   //we check if the length is greater than 1
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }
        }
        
        return false;
    }
    
}