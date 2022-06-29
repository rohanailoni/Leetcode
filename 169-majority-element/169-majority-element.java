class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int min=Integer.MIN_VALUE;
        int ans=0;
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            if(m.getValue()>min){
                min=m.getValue();
                ans=m.getKey();
            }
        }
        
        return ans;
    }
}