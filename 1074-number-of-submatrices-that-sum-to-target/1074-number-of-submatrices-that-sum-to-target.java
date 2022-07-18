// class Solution {
//     public int numSubmatrixSumTarget(int[][] matrix, int target) {
//         int ans = 0;
//         int nn=matrix.length;
//         int mm=matrix[0].length;
        
//         int[][] dp=new int[nn][mm];//building the dp;
//         dp[0][0]=matrix[0][0];//making the first value as default
//         for(int i=1;i<mm;i++){
//             dp[0][i]=dp[0][i-1]+matrix[0][i];
            
//         }
//         for(int i=1;i<nn;i++){
//             dp[i][0]=dp[i-1][0]+matrix[i][0];
//         }
//         for(int i=1;i<nn;i++){
//             for(int j=1;j<mm;j++){
//                 //System.out.println(dp[i][j-1]+" "+dp[i-1][j]+" "+dp[i-1][j-1]);
//                 dp[i][j]=dp[i][j-1]+dp[i-1][j]+matrix[i][j]-dp[i-1][j-1];
//             }
//         }
//         // int max=Integer.MIN_VALUE;
//         // HashMap<Integer,Integer>map=new HashMap<>();
//         // for(int i=0;i<n;i++){
//         //     for(int j=0;j<m;j++){
//         //         //map.put(dp[i][j],map.getOrDefault(dp[i][j],0)+1);
//         //         max=Math.max(dp[i][j],max);
//         //     }
//         // }
//         // for(int i=0;i<max;i++){
//         //     for(int j=0;j<max;j++){
//         //         for(int k=0;k<max;k++){
//         //             if(map.containsKey(i) && map.containsKey(j) && map.containsKey(k) && target==i+j-k){
//         //                 if(map.get(i)>0 && map.get(j)>0 && map.get(k)>0){
//         //                     int c=map.get(i);
//         //                     map.put(i,c--);
//         //                     c=map.get(j);
//         //                      map.put(j,c--);
//         //                     c=map.get(k);
//         //                      map.put(k,c--);
//         //                     if(i+j-k==target){
//         //                         ans++;
//         //                     }
//         //                 }
//         //             }
//         //         }
//         //     }
//         // }
        
//         //System.out.println(map);
// //         for(int i=0;i<n;i++){
// //             for(int j=0;j<m;j++){
// //                 int basex=i;
// //                 int basey=j;
// //                 for(int al=0;al<n;al++){
// //                     for(int be=0;be<m;be++){
// //                         if(al==0){
// //                             if(basex==0 && basey==0){
                                
// //                             }
// //                         }
// //                     }
// //                 }
// //             }
// //         }
//         return ans;

//     }
// }
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;

        for(int i = 0; i<matrix[0].length;i++){//left col
            int[] sum = new int[matrix.length];
            for(int m = i; m<matrix[0].length;m++){//right col
                for(int j = 0; j<matrix.length;j++){
                    sum[j]+=matrix[j][m];//add left to right
                    if(sum[j]==target)ans++;            
                }
                for(int j = 0; j<matrix.length;j++){//up row
                    int summe=0;    
                    for(int n = j; n<matrix.length;n++){//down row
                        summe+=sum[n];//add up to down
                        if(n!=j&&summe==target)ans++;
                    }
                }
            }
        }
        
        return ans;

    }
}