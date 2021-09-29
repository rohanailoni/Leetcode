class Solution {
    class unionfind{
        int[] parent;
        unionfind(int n){
            parent=new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i]=i;
            }
        }
        int findparent(int u){
            
            if(parent[u]==u){
                return u;
            }
            
            return parent[u]=findparent(parent[u]);
            
        }
        boolean union(int v1,int v2){
            int p1=findparent(v1);
            int p2=findparent(v2);
            
            if(p1!=p2){
                parent[p1]=p2;
                return false;
            }
            return true;
            
            
            
        }
        
        
        
    }
    
    
    
    
    
    public int[] findRedundantConnection(int[][] edges) {
        
        unionfind un=new unionfind(edges.length);
        
        for(int i=0;i<edges.length;i++){
            if(un.union(edges[i][0],edges[i][1])){
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[]{};
        
        
        
    }
}