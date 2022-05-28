class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer>hash=new HashSet<>();
        for(int i:nums){
            if(i>0){
                hash.add(i);
            }
        }
        for(int i=1;i<=nums.length+1;i++){
            if(!hash.contains(i))return i;
        }
        return 1;
    }
}