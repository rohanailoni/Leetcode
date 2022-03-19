class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] left=new int[n];
        int[] right=new int[n];
        //int max=height[0];
        left[0]=height[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        right[n-1]=height[n-1];
        right[0]=height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i+1]);
        }
        int ans=0;
        //System.out.println(Arrays.toString(left)+" "+Arrays.toString(right));
        for(int i=0;i<n;i++){
            int waterLevel = Math.min(left[i], right[i]);
            if (waterLevel >= height[i]) ans += waterLevel - height[i];
        }
        
        return ans;
        
    }
}