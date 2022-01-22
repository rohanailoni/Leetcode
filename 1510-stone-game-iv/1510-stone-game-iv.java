// class Solution {
//     public boolean winnerSquareGame(int n) {
//         //if pos==0 then Alice chance pos==1 the bob
//         return dfs(n,0);
//     }
    
//     boolean dfs(int n,int pos){
//         //base case;
//         System.out.println(n);
//         if(n<=0 && pos==1){
//             return true;
//         }
//         if(n<=0 && pos==0){
//             return false;
//         }
        
//         for(int i=1;i*i<=n;i++){
//             boolean opp;
//             if(pos==0){
//                  opp=dfs(n-i*i,1);
//             }
//             else{
//                 opp=dfs(n-i*i,0);
//             }
//             if(opp==true){
//                 return true;
//             }
            
//         }
//         return false;
//     }
// }
class Solution {
    Boolean[] dp = new Boolean[100001];

        public boolean winnerSquareGame(int n) {
            if (n == 0) return false;
            if (dp[n] != null) return dp[n];
            boolean winner = false;
            for (int i = 1; i * i <= n; i++) {
                if (!winnerSquareGame(n - i * i)) {
                    winner = true;
                    break;

                }
            }
            return dp[n] = winner;
        }
}