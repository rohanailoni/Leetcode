class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        
        int count=0;
        map.put(0,1);
        int currsum=0;
        int def;
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            def=currsum-k;
            if(map.containsKey(def)){
                count+=map.get(def);
            }
            map.put(currsum,map.getOrDefault(currsum,0)+1);
        }
        return count;
    }
}