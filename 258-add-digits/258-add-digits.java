class Solution {
    int counting(int num){
        String s=Integer.toString(num);
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=Integer.parseInt(s.substring(i,i+1));
        }
        return count;
    }
    public int addDigits(int num) {
        return counting(counting(counting(num)));
        
    }
}