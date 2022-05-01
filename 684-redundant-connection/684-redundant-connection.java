class Solution {
    private boolean union(int[] arr,int a,int b){
        int a1=find(arr,a);
        int a2=find(arr,b);
        if(a1!=a2){
            arr[a1]=a2;
            return false;
        }
        return true;
    }
    private int find(int[] arr,int a){
        if(arr[a]==a){
            return a;
        }
        return find(arr,arr[a]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] arr=new int[n+1];
        for(int i=0;i<n;i++)arr[i]=i;
        for(int[] r:edges){
            if(union(arr,r[0],r[1])){
                return new int[]{r[0],r[1]};
            }
        }
        return new int[]{0,0};
    }
}