class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans=0;
        if(income<=0){
            return ans;
        }
        int n=brackets.length;
        int index=0;
        while(index<n){
            if(index==0){
                if(brackets[0][0]<=income){
                    ans+=(brackets[0][0])*(brackets[index][1]/(double)100);
                }else{
                    ans+=(income)*(brackets[index][1]/(double)100);
                    break;
                }
            }else{
                if(brackets[index][0]<=income){
                    ans+=(brackets[index][0]-brackets[index-1][0])*(brackets[index][1]/(double)100);
                }else{
                    ans+=(income-brackets[index-1][0])*(brackets[index][1]/(double)100);
                    break;
                }
            }
            
            index++;
        }
        return ans<0?0:ans;
        
    }
}