func uniquePaths(m int, n int) int {
    // Create a 2D array to store the number of unique paths to each cell.
    dp := make([][]int, m)
    for i := range dp {
        dp[i] = make([]int, n)
    }

    // Initialize the first row and first column to 1 since there's only one way to reach them.
    for i := 0; i < m; i++ {
        dp[i][0] = 1
    }
    for j := 0; j < n; j++ {
        dp[0][j] = 1
    }

    // Calculate the number of unique paths for each cell.
    for i := 1; i < m; i++ {
        for j := 1; j < n; j++ {
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
        }
    }

    // The value in the bottom-right cell represents the total unique paths.
    return dp[m-1][n-1]
}
