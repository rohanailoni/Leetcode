class Solution {
    public int findLUSlength(String[] strs) {
        HashMap<String,Integer>map=new HashMap<>();
        for(String i :strs){
            
            for(String s:getSubseqs(i)){
                
                map.put(s,map.getOrDefault(s,0)+1);
                
                
            }
            
            
        }
        int ans=-1;
        for(Map.Entry<String,Integer>m:map.entrySet()){
            if(m.getValue()==1){
                ans=Math.max(ans,m.getKey().length());
            }
        }
        
        
        
        
        return ans;
    }
    public static Set<String> getSubseqs(String s) {
    Set<String> res = new HashSet<>();
    if (s.length() == 0) {
         res.add("");
         return res;
    }
    Set<String> subRes = getSubseqs(s.substring(1));
    res.addAll(subRes);
    for (String seq : subRes) res.add(s.charAt(0) + seq);
    return res;
}
}