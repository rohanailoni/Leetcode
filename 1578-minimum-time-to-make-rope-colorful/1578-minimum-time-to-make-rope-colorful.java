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
                int max=Integer.MIN_VALUE;
                int temp=0;
                for(int j=i;j<n;j++){
                    if(colors.charAt(i)!=colors.charAt(j)){
                        break;
                    }else{
                        temp+=neededTime[j];
                        max=Math.max(neededTime[j],max);
                        co+=1;
                    }
                }
                //System.out.println(temp+" "+max);
               
                if(co>1)ans+=(temp-max);
                i+=co;
                
            }
            
            
        }
        return ans;
    }
}