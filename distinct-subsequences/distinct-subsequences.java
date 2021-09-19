class Solution {
    private int[][]dp;
    private String t;
    private String s;
    public int substr(int ptr1,int ptr2){
        if(ptr2==t.length()){
            return 1;
        }
        if(ptr1==s.length()){
            return 0;
        }
        if(dp[ptr1][ptr2]!=-1){
            return dp[ptr1][ptr2];
        }
        
        
        if(s.charAt(ptr1)==t.charAt(ptr2)){
            
            return dp[ptr1][ptr2]=substr(ptr1+1,ptr2+1)+substr(ptr1+1,ptr2);
        }
        else{
            return dp[ptr1][ptr2]=substr(ptr1+1,ptr2);
        }
        
        
        
    }
    
    
    
    public int numDistinct(String s, String t) {
        dp=new int[s.length()][t.length()];
        this.t=t;
        this.s=s;
        for(int[] r:dp)Arrays.fill(r,-1);
        return substr(0,0);
        
        
        
    }
}