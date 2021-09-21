class Solution {
    private String s;
    private List<String>w;
    int[] dp;
    public boolean dfs(int j){
        
        if(j==s.length()){
            
            return true;
        }
        if(j>s.length()){
            return false;
        }
        if(dp[j]==0){
            return false;
        }
        
        for(int i=0;i<w.size();i++){
            
            String s1=w.get(i);
            if(j+s1.length()<=s.length()){
                if(s.substring(j,j+s1.length()).equals(s1)){
                    //System.out.println(s.substring(j,j+s1.length())+" "+j+s1.length());
                    boolean f=dfs(j+s1.length());
                    if(f){
                        
                        
                        for(int k:dp){System.out.print(k);}
                        System.out.println(dp.length);
                    return true;
                    }else{
                        dp[j]=0;
                    }
                }
            }
            
        }
        
        return false;
        
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s=s;
        this.w=wordDict;
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        
        return dfs(0);
        
    }
}