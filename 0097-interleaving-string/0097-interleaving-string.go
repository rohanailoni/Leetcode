func isInterleave(s1 string, s2 string, s3 string) bool {
    var dfs func(i, j, k int) bool
    n := len(s1)
    m := len(s2)
    q := len(s3)
    dp := make([][]int, n)
    for i := 0; i < n; i++ {
        dp[i] = make([]int, m)
        for j := 0; j < m; j++ {
            dp[i][j] = -1 
        }
    }
    dfs = func(i, j, k int) bool {
        if k == q {
            return i == n && j == m
        }
        if i<n && j<m && dp[i][j]!=-1{
            return dp[i][j]==1;
        }
        ans := false

        if i < n && s1[i] == s3[k] && j < m && s2[j] == s3[k] {
            ans = ans || (dfs(i+1, j, k+1) || dfs(i, j+1, k+1))
        }
        
        if i < n && s1[i] == s3[k] {
            ans = ans || dfs(i+1, j, k+1)
        }
        
        if j < m && s2[j] == s3[k] {
            ans = ans || dfs(i, j+1, k+1)
        }
        if i<n && j<m{
            if ans{
                dp[i][j]=1
            }else{
                dp[i][j]=0;
            }
        }
        
        return ans
    }

    ans := dfs(0, 0, 0)
    return ans
}
