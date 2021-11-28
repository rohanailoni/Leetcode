class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int start=0;
        int end=graph.length-1;
        Queue<List<Integer>>que=new LinkedList<>();
        que.add(new ArrayList<>(Arrays.asList(0)));
        List<List<Integer>>ans=new ArrayList<>();
        while(que.size()!=0){
            List<Integer>temp=que.poll();
            
            for(int i:graph[temp.get(temp.size()-1)]){
                if(i==end){
                    temp.add(i);
                    ans.add(new ArrayList<>(temp));
                    temp.remove(temp.size()-1);
                }else{
                    temp.add(i);
                    que.add(new ArrayList<>(temp));
                    temp.remove(temp.size()-1);
                }
                
                
            }
        }
        return ans;
    }
}