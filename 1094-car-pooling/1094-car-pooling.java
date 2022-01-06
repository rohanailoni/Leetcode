class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] car=new int[1001];
        for(int[] trip:trips){
            car[trip[1]]+=trip[0];
            car[trip[2]]-=trip[0];
            
        }
        //System.out.println(Arrays.toString(car));
        int pass=0;
        for(int p:car){
            pass+=p;
            if(pass>capacity){
                return false;
            }
        }
        return true;
    }
}