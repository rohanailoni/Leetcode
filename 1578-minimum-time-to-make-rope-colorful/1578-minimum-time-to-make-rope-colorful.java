class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int ans=0;
        int i=0;
        HashMap<Integer,Boolean>removed=new HashMap<>();
        while(i<n){
            if(removed.containsKey(i)){
                i++;
                continue;
            }else{
                int min=Integer.MAX_VALUE;
                int co=0;
                List<Integer>cache=new ArrayList<>();
                for(int j=i;j<n;j++){
                    if(colors.charAt(i)!=colors.charAt(j)){
                        break;
                    }else{
                        cache.add(neededTime[j]);
                        min=Math.min(neededTime[j],min);
                        co+=1;
                    }
                }
                Collections.sort(cache);
                //System.out.println(cache+" "+co);
                i+=co;
                if(co<=1){
                    continue;
                }
                for(int j=0;j<co-1;j++){
                    ans+=cache.get(j);
                }
                //System.out.println(co);
                //if(min!=Integer.MAX_VALUE && co>1)ans+=min;
                
            }
            
            
        }
        return ans;
    }
}