class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;

        for (int[] account : accounts) {
            int rich = 0;
            for (int money : account) {
                rich += money;
            }
            ans = Math.max(rich, ans);
        }
		
        return ans;
    }
}