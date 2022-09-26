class Solution {
    public int minCostConnectPoints(int[][] p) {
        //List<Edge>arr=new ArrayList<>();
        PriorityQueue<Edge>pq=new PriorityQueue<>((Edge a,Edge b)->a.w-b.w);
        int n=p.length;
        boolean[] visited=new boolean[n];
        visited[0]=true;
        for(int i=1;i<n;i++){
            int w=Math.abs(p[0][0]-p[i][0])+Math.abs(p[0][1]-p[i][1]);
            pair p1=new pair(p[0][0],p[0][1]);
            pair p2=new pair(p[i][0],p[i][1]);
            pq.offer(new Edge(p1,p2,w,0,i));
        }
        
        
        
        
        int j=0;
        int ans=0;
        //int m=arr.size();
        //int[] ap=IntStream.range(0,n).toArray();
        while(j<n-1 && !pq.isEmpty()){
            Edge e=pq.poll();
            if(visited[e.i]==true && visited[e.j]==true){
                continue;
            }
            //System.out.println(e.i+" "+e.j+" "+pq.size());
            ans+=e.w;
            j++;
            for(int i=0;i<n;i++){
                if(i!=e.i){
                    int w=Math.abs(p[e.j][0]-p[i][0])+Math.abs(p[e.j][1]-p[i][1]);
                     pair p1=new pair(p[e.j][0],p[e.j][1]);
                     pair p2=new pair(p[i][0],p[i][1]);
                     pq.offer(new Edge(p1,p2,w,0,i));
                }
            }
            visited[e.j]=true;
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
    Edge(int w,int i,int j){
        this.w=w;
        this.i=i;
        this.j=j;
    }
    Edge(pair p1,pair p2,int w,int i,int j){
        this.p1=p1;
        this.p2=p2;
        this.w=w;
        this.i=i;
        this.j=j;
    }
    
}