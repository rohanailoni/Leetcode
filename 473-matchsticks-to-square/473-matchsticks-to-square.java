class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total=0;
        for(int i:matchsticks){
            total+=i;
        }
        if(total%4!=0){
            return false;
        }else{
            int n=matchsticks.length-1;Arrays.sort(matchsticks);
            return match(matchsticks,n,0,0,0,0,total/4);
        }
       
        
    }
    public boolean match(int[] matchsticks, int index, int top, int bottom, int left, int right, int target) {
        
        if (top == target && bottom == target && left == target && right == target) return true;

        if (top > target || bottom > target || left > target || right > target ) return false;
                        
        int val = matchsticks[index];
        
        boolean t = match(matchsticks, index - 1, top + val, bottom, left, right, target);
        if (t) return true;
        boolean b = match(matchsticks, index - 1, top, bottom + val, left, right, target);
        if (b) return true;
        boolean l = match(matchsticks, index - 1, top, bottom, left + val, right, target);
        if (l) return true;
        boolean r = match(matchsticks, index - 1, top, bottom, left, right + val, target);
        if (r) return true;
        
        return false;
    }
}