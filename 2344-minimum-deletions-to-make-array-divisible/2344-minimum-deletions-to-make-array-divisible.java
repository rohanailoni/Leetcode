class Solution {
    int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans=0;
        int g=numsDivide[0];
        for(int i:numsDivide){
            g=gcd(i,g);
        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i * i <= g; i++)
        {
            if (g % i == 0)
            {
                
                if(map.containsKey(i))min=Math.min(min,i);
                if (g / i != i)
                    //min=Math.min(min,g/i);
                    if(map.containsKey(g/i))min=Math.min(min,g/i);
            }
        }
        if(min==Integer.MAX_VALUE)return -1;
       for(int i:nums){
           if(i<min){
               ans+=1;
           }
       }
        return ans;
        
    }
}