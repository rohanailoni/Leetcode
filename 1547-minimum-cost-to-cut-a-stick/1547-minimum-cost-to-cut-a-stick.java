// class Solution {
//     int cost;
//     public int minCost(int n, int[] cuts) {
//         cost=Integer.MAX_VALUE;
//         int[] len=new int[n+1];len[0]=1;len[n]=1;
//         boolean visited[]=new boolean[cuts.length];
//         Arrays.fill(visited,false);
//         return dfs(visited,cuts,n,0,len);
//     }
//     public int checker(int[] len,int cut){
//         int upper=0;
//         int lower=0;
//         for(int i=cut-1;i>=0;i--){
//             if(len[i]==1){
//                 lower=i;
//                 break;
//             }
//         }
//         for(int i=cut+1;i<len.length;i++){
//             if(len[i]==1){
//                 upper=i;
//                 break;
//             }
//         }
//         return upper-lower;
        
        
//     }
//     public int dfs(boolean[] visited,int[] cuts,int n,int index,int[] len){
//         if(index==cuts.length){
//             return 0;
                
//         }
//         int min=Integer.MAX_VALUE;
//         for(int i=0;i<cuts.length;i++){
//             if(visited[i]==false){
//                 visited[i]=true;
//                 len[cuts[i]]=1;
//                 min=Math.min(min,checker(len,cuts[i])+dfs(visited,cuts,n,index+1,len));
//                 len[cuts[i]]=0;
//                 visited[i]=false;
//             }
//         }
//         return min;
        
//     }
// }
class Solution {
    int cost;
    public int minCost(int n, int[] cuts) {
        return dfs(0,n,new HashMap<>(),cuts);
    }
    public int dfs(int l,int r,HashMap<String,Integer>cache,int[] cuts){
        String s=l+"-"+r;
        if(cache.containsKey(s))return cache.get(s);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cuts.length;i++){
            if(cuts[i]>=r || cuts[i]<=l){
                continue;
            }
            min=Math.min(min,dfs(l,cuts[i],cache,cuts)+(r-l)+dfs(cuts[i],r,cache,cuts));
            
            
        }
        min=min==Integer.MAX_VALUE?0:min;
        cache.put(s,min);
        return min;
    }
   

}