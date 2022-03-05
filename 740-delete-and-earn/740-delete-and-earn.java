class Solution {
    public int deleteAndEarn(int[] nums) {
    int[] bucket = new int[10001];
	// max & min can make iteration a bit faster
    int max = 1;
    int min = 10000;
    for (int n : nums) {
        bucket[n]++;
        if (n > max) max = n;
        else if (n < min) min = n;
    }


    int n0 = 0;
    int n1 = 0;

    int res = 0;

    for (int i = min; i <= max; i++) {
        res = Math.max(n0+i*bucket[i], n1);
		// right shift n0 & n1
        n0 = n1;
        n1 = res;
    }

    return res;
}
}