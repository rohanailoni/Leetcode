class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int[] ans=new int[2];
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            
        }
        int i=0;
        for(Map.Entry m:map.entrySet()){
            int n=(int)m.getValue();
            if(n==1){
                ans[i]=(int)m.getKey();
                i++;
            }
        }
        return ans;
    }
}