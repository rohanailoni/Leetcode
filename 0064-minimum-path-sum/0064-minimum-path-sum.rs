// impl Solution {
//     pub fn min_path_sum(grid: Vec<Vec<i32>>) -> i32 {
//         let m:usize=grid.len();
//         let n:usize=grid[0].len();
//         return Self::BottomUpdfs(0,0,&grid,m ,n); 
//     }
//     pub fn BottomUpdfs(i:usize,j : usize,g: &Vec<Vec<i32>>,m:usize,n:usize)-> i32{
//         if i>=m || j>=n{
//             return std::i32::MAX;
//         }
//          if i == m - 1 && j == n - 1 {
//             return g[i][j]; // Base case: reached bottom right cell
//         }
//         let right:i32=g[i][j]+Self::BottomUpdfs(i,j+1,g,m,n);
//         let left:i32=g[i][j]+Self::BottomUpdfs(i+1,j,g,m,n);
        
        
//         return right.min(left);
        
//     }
// }
impl Solution {
    pub fn min_path_sum(grid: Vec<Vec<i32>>) -> i32 {
        let m: usize = grid.len();
        let n: usize = grid[0].len();
        let mut memo = vec![vec![-1; n]; m]; // Memoization array
        
        return Self::bottom_up_dfs(0, 0, &grid, m, n, &mut memo); 
    }
    
    pub fn bottom_up_dfs(i: usize, j: usize, g: &Vec<Vec<i32>>, m: usize, n: usize, memo: &mut Vec<Vec<i32>>) -> i32 {
        if i >= m || j >= n {
            return std::i32::MAX; // Return a large value for invalid paths
        }
        if i == m - 1 && j == n - 1 {
            return g[i][j]; // Base case: reached bottom right cell
        }
        
        if memo[i][j] != -1 {
            return memo[i][j]; // Return memoized value if available
        }
        
        let right: i64 = g[i][j] as i64 + (Self::bottom_up_dfs(i, j + 1, g, m, n, memo) as i64);
        let down: i64 = g[i][j] as i64 + (Self::bottom_up_dfs(i + 1, j, g, m, n, memo) as i64);
        // Memoize and return the minimum of right and down paths
        memo[i][j] = right.min(down) as i32;
        return memo[i][j];
    }
}
