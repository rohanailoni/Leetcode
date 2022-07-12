// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Pair{
    int currNode;
    int parentNode;
    Pair(int currNode,int parentNode){
        this.currNode = currNode;
        this.parentNode = parentNode;
    }
}
class Solution {
    public boolean bfs(int u,boolean[] vis, ArrayList<ArrayList<Integer>> adj){
       vis[u] = true;
       Queue<Pair> q = new LinkedList<>();
       q.offer(new Pair(u,-1));
       while(!q.isEmpty()){
           Pair tmp = q.poll();
           int curr = tmp.currNode;
           int parent = tmp.parentNode;
           for(int i:adj.get(curr)){
               if(!vis[i]){
                   vis[i] = true;
                   q.offer(new Pair(i,curr));
               }else if(i!=parent){
                   return true;
               }
           }
       }
       return false;
   }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                if(bfs(i,vis,adj)) return true;
            }
        }
        return false;
    }
}