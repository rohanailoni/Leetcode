class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer>map=new HashMap<>();
        
        int ans=0;
        for(int ele:time){
                int rem=ele%60;
                int want=(60-rem)%60;
                if(map.containsKey(want)){
                    ans+=map.get(want);

                }
                map.put(rem,map.getOrDefault(rem,0)+1);      

            }
        
        
        
        
        
        
        return ans;
        
        
    }
}