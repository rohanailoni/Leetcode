impl Solution {
    pub fn unique_paths_with_obstacles(og: Vec<Vec<i32>>) -> i32 {
        let n=og[0].len();
        let m=og.len();
        let mut dp:Vec<Vec<i32>>=vec![vec![-1;n];m];
        return Self::dfs(&og, &mut dp,0,0)
    }
    fn dfs(og: &Vec<Vec<i32>>,dp:&mut Vec<Vec<i32>>,i:usize,j:usize)-> i32{
        if(i>=og.len() || j>=og[0].len()){
            return 0;
        }
        if(og[i][j]==1){
            return 0;
        }
        if(i==og.len()-1 && j==og[0].len()-1){
            return 1
        }
        if(dp[i][j]!=-1){
            return dp[i][j]
        }
        let left= Self::dfs(og,dp,i+1,j);
        let right=Self::dfs(og,dp,i,j+1);
        dp[i][j]=left+right;
        dp[i][j]
        
    }
}