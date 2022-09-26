class Solution {
    public int minCostConnectPoints(int[][] p) {
        List<Edge>arr=new ArrayList<>();
        int n=p.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                pair p1=new pair(p[i][0],p[i][1]);
                pair p2=new pair(p[j][0],p[j][1]);
                int w1=weight(p1,p2);
                arr.add(new Edge(p1,p2,w1,i,j));
            }
        }
        Collections.sort(arr,(Edge e1,Edge e2)->e1.w-e2.w);
        boolean[] visited=new boolean[n];
        int i=0;
        int j=0;
        int ans=0;
        int m=arr.size();
        int[] ap=IntStream.range(0,n).toArray();
        while(j<n-1 && i<m){
            Edge e=arr.get(i);
            i++;
            if(union(ap,e.i,e.j)){
                ans+=e.w;
                j+=1;
            }
            
            
        }
        return ans;
    }
    boolean union(int[] arr,int i,int j){
        int a=find_parent(arr,i);
        int b=find_parent(arr,j);
        if(a!=b){
            arr[a]=arr[b];
            return true;
        }
        return false;
    }
    int find_parent(int[] arr,int i){
        if(arr[i]==i){
            return i;
        }
        return arr[i]=find_parent(arr,arr[i]);
    }
    int weight(pair p1,pair p2){
        return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
    }
    boolean check_ifall(boolean[] b,int n){
        for(int i=0;i<n;i++){
            if(b[i]==false){
                return false;
            }
        }
        return true;
    }
}

class pair{
    int x;
    int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Edge{
    pair p1;
    pair p2;
    int w,i,j;
    Edge(pair p1,pair p2,int w,int i,int j){
        this.p1=p1;
        this.p2=p2;
        this.w=w;
        this.i=i;
        this.j=j;
    }
    
}