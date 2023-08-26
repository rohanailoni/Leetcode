func findLongestChain(pairs [][]int) int {
    n:=len(pairs)
    sort.Slice(pairs, func(i, j int) bool {
        return pairs[i][0] < pairs[j][0]
    });
    dp:=make([]int,n);
    for i,_:=range dp{
        dp[i]=1;
    }
    var dfs func(pairs [][]int, prevEnd int, currentIndex int)int;
    dfs=func(pairs [][]int, prevEnd int, currentIndex int)int{
        if currentIndex == len(pairs) {
            return 0
        }
        if dp[currentIndex]!=-1{
            return dp[currentIndex];
        }
        takeCurrent := 0
        if pairs[currentIndex][0] > prevEnd {
            takeCurrent = 1 + dfs(pairs, pairs[currentIndex][1], currentIndex+1)
        }
        
        skipCurrent := dfs(pairs, prevEnd, currentIndex+1)
        dp[currentIndex]=int(math.Max(float64(takeCurrent), float64(skipCurrent)));
        return dp[currentIndex];
    }
    for i:=1;i<n;i++{
        for j:=0;j<i;j++{
            if pairs[j][1]<pairs[i][0]{
                dp[i]=max(dp[i],dp[j]+1);
            }
        }
    }
    ans := 0
    for _, val := range dp {
        ans = max(ans, val)
    }
    return dp[n-1];
}


func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

