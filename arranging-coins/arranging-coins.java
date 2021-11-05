class Solution {
    public int arrangeCoins(int n) {
        return (int)((-1+Math.sqrt(1+(long)8*n))/2);
    }
}