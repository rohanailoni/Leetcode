class Solution {
    public boolean isMatch(String str, String pattern) {
	
       boolean[][] dp=new boolean[str.length()+1][pattern.length()+1];
       dp[0][0]=true;
       for(int i=1;i<=str.length();i++){
           dp[i][0]=false;
    }
           for(int j=1;j<=pattern.length();j++){
               if(pattern.charAt(j-1)=='*')
                dp[0][j]=dp[0][j-1];
    }
    
           for(int i=1;i<=str.length();i++){
           for(int j=1;j<=pattern.length();j++){
               if(str.charAt(i-1)==pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
                   dp[i][j]=dp[i-1][j-1];
               }
                if(pattern.charAt(j-1)=='*'){
                   dp[i][j]=dp[i][j-1] || dp[i-1][j];
               }
           }
        }
       return dp[str.length()][pattern.length()];
        
    }
}