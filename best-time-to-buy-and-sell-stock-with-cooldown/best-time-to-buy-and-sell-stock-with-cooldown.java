class Solution {
    private int[] p;
    private int[] dp;
    private int dfs(String state,int index,int buyp,int pointer){
        if(index>=p.length){
            //System.out.println(index+"end"+pointer);
            return pointer;
        }
        if(dp[index]!=-1){
            return dp[index]-pointer;
        }
        //System.out.println(state+" "+index+" "+buyp+" "+pointer);
        int max=-(int)1e9;
        for(int i=index;i<p.length;i++){
            if(state.equals("S") && buyp<=p[i]){
                
                max=Math.max(max,dfs("B",i+2,buyp,p[i]-buyp+pointer));
                //System.out.println(max+"max"+" "+index);
            }
            else if(state.equals("B")){
                max=Math.max(max,dfs("S",i+1,p[i],pointer));
            }
        }
        
        return dp[index]=max==-(int)1e9?0:max;
        
    }
    
    
    
    public int maxProfit(int[] prices) {
//         if(prices.length==1){
//             return 0;
//         }
//         dp=new int[prices.length];
//         Arrays.fill(dp,-1);

//         p=prices;
//         System.out.println();
//         return dfs("B",0,0,0);
        int profit1=0, profit2=0;   
    for(int i=1; i<prices.length; i++){
        int copy=profit1;
        profit1=Math.max(profit1+prices[i]-prices[i-1], profit2);
        profit2=Math.max(copy, profit2);
    }
    return Math.max(profit1, profit2);
        
    }
}