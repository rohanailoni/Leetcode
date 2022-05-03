// class Solution {
//     long count;
//     public long numberOfWays(String s) {
//         count=0;
//         dfs(s,0,new ArrayList<>(),s.length());
//         return count;
//     }
//     public void dfs(String s,int index,List<Character>sto,int n){
//         //System.out.println(sto.size());
//         if(sto.size()==3){
//             //System.out.println(sto);
//             count++;
//             return;
//         }
        
//         for(int i=index;i<n;i++){
//             int ss=sto.size();
            
//             if(ss!=0 && sto.get(ss-1)!=s.charAt(index)){
//                 //System.out.println(s.charAt(index)+" "+sto.get(ss-1));
//                 sto.add(s.charAt(index));
//                 System.out.println(sto);
//                 dfs(s,i+1,sto,n);
//                 sto.remove(sto.size()-1);
//             }else if(ss==0){
//                 sto.add(s.charAt(index));
//                 System.out.println(sto);
//                 dfs(s,i+1,sto,n);
//                 sto.remove(sto.size()-1);
//             }
//         }
//         return;
//     }
// }
// class Solution{
//     public long numberOfWays(String s){
//         long count=0;
//         int n=s.length();
//         for(int i=0;i<n-3;i++){
//             String ss=s.substring(i,i+1);
//             if(ss.equals("010")){
//                 count++;
//             }else if(ss.equals("101")){
//                 count++;
//             }
//         }
//         return count;
//     }
    
// }

class Solution {
    public long numberOfWays(String s) {
       int n = s.length();
        long[][][] dp = new long[n][4][4];
        for(long[][] y : dp)
            for(long[] x : y)
        Arrays.fill(x,-1);
        return solve(0,0,'2',s.toCharArray(),dp);
    }
    public long solve(int i ,int c ,char prev ,char[] s,long[][][] dp){
        if(c==3)return 1;
        if(i>=s.length) return 0;
         if(dp[i][c][prev-'0']!=-1) return dp[i][c][prev-'0'];
        long a=0 ,b=0;
        if(s[i]!=prev){
            a= solve(i+1,c+1,s[i],s,dp); 
        } 
            b = solve(i+1,c,prev,s,dp);
        
        return dp[i][c][prev-'0'] =   (a+b);
        
    }
}