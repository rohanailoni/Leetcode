class Solution {
    private String s;
    private List<String>w;
    private List<String>cache;
    public boolean dfs(int j,List<String>cache){
        
        if(j==s.length()){
            //System.out.println(cache+"lol");
            String s="";
            for(int i=0;i<cache.size();i++){
                if(i==cache.size()-1){
                s=s+cache.get(i);
                }else{
                   s=s+cache.get(i)+" "; 
                }
            }
            this.cache.add(s);
            return true;
        }
        if(j>s.length()){
            return false;
        }
        
        
        for(int i=0;i<w.size();i++){
            
            String s1=w.get(i);
            if(j+s1.length()<=s.length()){
                if(s.substring(j,j+s1.length()).equals(s1)){
                    //System.out.println(s.substring(j,j+s1.length())+" "+j+s1.length());
                    cache.add(s.substring(j,j+s1.length()));
                    //System.out.println(cache);
                    dfs(j+s1.length(),cache);
                    cache.remove(cache.size()-1);
                    
                }
            }
            
        }
        
        return false;
        
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s=s;
        this.w=wordDict;
        cache=new ArrayList<>();
        dfs(0,new ArrayList<>());
        return this.cache;
        
    }
}