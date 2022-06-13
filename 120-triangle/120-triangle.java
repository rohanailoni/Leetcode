// class Solution {
//     public int min=Integer.MAX_VALUE;
//     int n;
//     List<List<Integer>> triangle;
//     public int minimumTotal(List<List<Integer>> triangle) {
//         n=triangle.size();
//         this.triangle=triangle;
//         dfs(triangle.get(0).get(0),,0);
//         return min;
//     }
//     public void dfs(int sum,int size,int index){
//         if(size==n){
//             min=Math.min(min,sum);
//             return;
//         }
//         for(int i=index;i<=index+1;i++){
//              dfs(sum+triangle.get(size).get(i),size+1,i);
//         }
        
       
//         //dfs(sum+triangle.get(size).get(index+1),size+1,index+1);
//         return;
//     }
// }
class Solution {
    public int min=Integer.MAX_VALUE;
    int n;
    List<List<Integer>> triangle;
    public int minimumTotal(List<List<Integer>> triangle) {
    int[] A = new int[triangle.size()+1];
    for(int i=triangle.size()-1;i>=0;i--){
        for(int j=0;j<triangle.get(i).size();j++){
            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
        }
    }
    return A[0];
}
    public void dfs(int sum,int size,int index){
        if(size==n){
            min=Math.min(min,sum);
            return;
        }
        for(int i=index;i<=index+1;i++){
             dfs(sum+triangle.get(size).get(i),size+1,i);
        }
        
       
        //dfs(sum+triangle.get(size).get(index+1),size+1,index+1);
        return;
    }
}