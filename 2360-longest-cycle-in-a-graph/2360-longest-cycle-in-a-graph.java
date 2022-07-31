// class Solution {
//     int max;
//     int check[];
//     public int longestCycle(int[] edges) {
//         max=Integer.MIN_VALUE;
//         int n=edges.length;
        
//         check=new int[n];
//         for(int i=0;i<n;i++){
//             int[] closet=new int[n];
//             Arrays.fill(closet,-1);
//             boolean[] visited=new boolean[n];
//             int nn=dfs(0,i,edges,visited,closet);
//             check[i]=nn;
//             //System.out.println(nn);
//             //System.out.println(Arrays.toString(closet)+" "+Arrays.toString(visited));
            
                
//         }
//         max=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             if(check[i]==i){
//                 int[] closet=new int[n];
//                 Arrays.fill(closet,-1);
//                 boolean[] visited=new boolean[n];
//                 dfs(0,i,edges,visited,closet);
//             }
//         }
//         return max==Integer.MIN_VALUE?-1:max;
//     }
//     public int dfs(int depth,int node,int[] edges,boolean[] visited,int[] closet){
//         if(visited[node]==false)closet[node]=depth;
//         if(visited[node]==true){
//             max=Math.max(max,depth);
//             return node;
//         }
//         if(edges[node]==-1 || visited[node]==true){
//             return-1;
//         }
//         visited[node]=true;
        
//         return dfs(depth+1,edges[node],edges,visited,closet);
       
//     }
// }
class Solution{
    public int longestCycle(int[] edges) {
    int res = -1;
    boolean[] vis = new boolean[edges.length]; 
    for(int i=0; i<edges.length; i++){
        if(vis[i]) continue;
        int dist = 0, idx = i;
        HashMap<Integer, Integer> x = new HashMap<>();  // local visited
        while(idx!=-1){
            if(x.containsKey(idx)){
                res = Math.max(res, dist-x.get(idx));
                break;
            }
            if(vis[idx]) break;
            vis[idx] = true;
            x.put(idx, dist++);
            idx = edges[idx];
        } 
    }
    return res;
}
}