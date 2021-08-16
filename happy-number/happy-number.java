class Solution {
    
    public boolean isHappy(int n) {
        Set<Integer>se=new HashSet<>();
        
        while(se.add(n)){
            int sum=0;
            while(n>0){
                sum+=Math.pow(n%10,2);
                n/=10;
            }
            
             
            if(sum==1){
                return true;
            }
            else{
                n=sum;
            }
            
        }
        return false;
        
    }
}