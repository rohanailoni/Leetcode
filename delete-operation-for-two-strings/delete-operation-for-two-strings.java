class Solution {
    String s1;
    String s2;
    private int dfs(int i,int j){
        
        if(i>=s1.length() || j>=s2.length()){
            return  0;
        }
        
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+dfs(i+1,j+1);
        }else{
            return Math.max(dfs(i+1,j),dfs(i,j+1));
        }
        
        
        
        
    }
    public int minDistance(String word1, String word2) {
        s1=word1;
        s2=word2;
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        Arrays.fill(dp[0],0);
        
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if (i == 0 || j == 0){dp[i][j] = 0;}
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //int l1=dfs(0,0);
        int l1=dp[word1.length()][word2.length()];
        //System.out.println(l1);
        return (word1.length()-l1)+(word2.length()-l1);
    }
}