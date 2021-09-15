class Solution {
    private int k;
    private int n;
    private List<List<Integer>> count;
    private void dfs(List<Integer>stack,int start,int order){
        if(order==this.k){
            
            count.add(new ArrayList<Integer>(stack));
            //System.out.println(count);
            return;
        }
        
        //stack.add()
        for(int i=start;i<=n;i++){
            stack.add(i);
            
            dfs(stack,i+1,order+1);
            
            stack.remove(stack.size()-1);
        }
        
        
       
        
}
    
    
    
    
    
    public List<List<Integer>> combine(int n, int k) {
        this.k=k;
        this.n=n;
        count = new ArrayList<List<Integer>>();
        //List<Integer>n1=;
        dfs(new ArrayList<Integer>(),1,0);
        return count;
        
    }
}