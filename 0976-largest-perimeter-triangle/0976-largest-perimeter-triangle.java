class Solution {
    public int largestPerimeter(int[] nums) {
        Integer[] num = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
        Arrays.sort(num,Collections.reverseOrder());
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(num[i]<num[i+1]+num[i+2]){
                return num[i]+num[i+1]+num[i+2];
            }
        }
        return 0;
    }
}