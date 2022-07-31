class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int ans=-1;
        int n=edges.length;
        int[] closet1=new int[n];Arrays.fill(closet1,-1);
        int[] closet2=new int[n];Arrays.fill(closet2,-1);
        boolean[] visited1=new boolean[n];
        boolean[] visited2=new boolean[n];
        Arrays.fill(visited1,false);
        Arrays.fill(visited2,false);
        dfs(0,node2,edges,visited1,closet1);
        dfs(0,node1,edges,visited2,closet2);
        //System.out.println(Arrays.toString(closet1)+" "+Arrays.toString(closet2));
        ArrayList<node>an=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(closet1[i]!=-1 && closet2[i]!=-1){
                an.add(new node(i,Math.max(closet1[i],closet2[i])));
            }
        }
        Collections.sort(an,(node a,node b)->a.dis-b.dis);
        // for(node a:an){
        //     System.out.println(a.dis+" "+a.val);
        // }
        if(an.size()==0){return -1;}
        int min=an.get(0).val;
        int val=an.get(0).dis;
        //System.out.println(min);
        for(int i=1;i<an.size();i++){
            if(an.get(i).val<min && an.get(i).dis==val){
                min=an.get(i).val;
            }
        }
        
        return min;
    }
    public void dfs(int depth,int node,int[] edges,boolean[] visited,int[] closet){
        if(visited[node]==false)closet[node]=depth;
        if(edges[node]==-1 || visited[node]==true){
            return;
        }
        visited[node]=true;
        
        dfs(depth+1,edges[node],edges,visited,closet);
        return;
    }
    class node{
        int val;
        int dis;
        node(int v,int d){
            this.val=v;
            this.dis=d;
        }
    }

}