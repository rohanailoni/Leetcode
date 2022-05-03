// class Solution {
//     double [][] arr;
//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//         arr=new double[26][26];
//         for(double[] r:arr){
//             Arrays.fill(r,-1);
//         }
//         build(equations,values);
//         double ans[]=new double[queries.size()];
//         int[] stor=new int[26];
//         //System.out.println(Arrays.deepToString(arr));
        
//         for(int i=0;i<queries.size();i++){
//             char A=queries.get(i).get(0).charAt(0);
//             char B=queries.get(i).get(1).charAt(0);
//             if(check(B)){
//                 ans[i]=-1;
//             }else{
//                 ans[i]=dfs('a','c',1,stor);
//             }
//         }
        
        
//         //dfs('b','a',1,stor);
        
        
//         return ans;
        
        
//     }
//     private double dfs(char start,char end,double ans,int[] ar){
        
//         if(start==end){
//             System.out.println(ans);
//             return ans;
//         }
        
       
//         for(int i=0;i<26;i++){
           
//             if(arr[start-'a'][i]!=-1 && ar[i]==0){
//                 ar[i]=1;
//                 dfs((char)(i+'a'),end,ans*arr[start-'a'][i],ar);
//                 ar[i]=0;
//             }
//         }
//         return ans;
        
        
//     }
//     private void build(List<List<String>> equations,double[] values){
//         for(int i=0;i<equations.size();i++){
//             char A=equations.get(i).get(0).charAt(0);
//             char B=equations.get(i).get(1).charAt(0);
//             arr[A-'a'][B-'a']=(double)values[i];
//             arr[B-'a'][A-'a']=1/values[i];
//         }
//     }
//     private boolean check(char end){
//         for(int i=0;i<26;i++){
//             if(arr[i][end-'a']!=-1){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution {

    class pair {
        String vrtx;
        double weight;

        pair(String vrtx, double weight) {
            this.vrtx = vrtx;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<pair>> graph = new HashMap<>();
        int index = 0;

        for (List<String> e : equations) {
            String u = e.get(0), v = e.get(1);
            double weight = values[index++];
            //it will be a directed graph
            if (graph.containsKey(u)) {
                graph.get(u).add(new pair(v, weight));
            } else {
                List<pair> temp = new ArrayList<>();
                temp.add(new pair(v, weight));
                graph.put(u, temp);
            }

             if (graph.containsKey(v)) {
                graph.get(v).add(new pair(u, (1/weight)));
            } else {
                List<pair> temp = new ArrayList<>();
                temp.add(new pair(u, (1/weight)));
                graph.put(v, temp);
            }
        }


        double[] ans = new double[queries.size()];

        index=0;


        for (List<String> q : queries) {
            ans[index++]=dfs(graph,new HashMap<>(),q.get(0),q.get(1),1);
        }
        return ans;
    }

    public double dfs(HashMap<String,List<pair>> graph,HashMap<String,Boolean> visited,String src,String dest,double val){

        if(src.equals(dest) && graph.containsKey(dest)){
            return val;
        }

        visited.put(src,true);
        if(graph.containsKey(src))
        for(pair p:graph.get(src)){
            if(!visited.containsKey(p.vrtx)){
               double v= dfs(graph,visited,p.vrtx,dest,val*p.weight);
                if(v!=-1)return v;
            }
        }
        visited.remove(src);
        return -1;
    }

}
