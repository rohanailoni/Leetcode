class Solution {
    HashMap<Integer,Integer>dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] whole=new int[profit.length][3];
        
        for(int i=0;i<profit.length;i++){
            whole[i]=new int[]{startTime[i],endTime[i],profit[i]};
            
        }
        Arrays.sort(whole,(a,b)->a[0]-b[0]);
        
        
        dp=new HashMap<>();
        
        
        return dfs(0,whole);
        
        
    }
    
    private int dfs(int current,int[][] whole){
        
        if(current>=whole.length){
            return 0;
        }
        if(dp.containsKey(current)){
            return dp.get(current);
        }
        
        int next=next(current,whole);
        
        int includethis=whole[current][2]+(next==-1?0:dfs(next,whole));
        int excludethis=dfs(current+1,whole);
        
        int n=Math.max(includethis,excludethis);
        dp.put(current,n);
        
        return n;
        
    }
    private int  next(int current,int[][] whole){
        //List<Integer>n=new ArrayList<Integer>();
        for(int i=current+1;i<whole.length;i++){
            if(whole[i][0]>=whole[current][1]){
                return  i;
            }
        }
        return -1;
        
    }
    
    
}