impl Solution {
    pub fn coin_change(coins: Vec<i32>, amount: i32) -> i32 {
        if amount==0{
            return 0;
        }
        let mut memo:Vec<i32>=vec![-1;(amount+1)as usize];
        let x:i32=Self::dfs(&coins,0,amount, &mut memo);
        if x==std::i32::MAX{
            return -1;
        }
        return x;
    }
    pub fn dfs(coins: &Vec<i32>,reqAmount:i32,amount:i32,memo:&mut Vec<i32>)->i32{
        let n:usize=coins.len();
        if reqAmount>amount{
            return std::i32::MAX;
        }
        if reqAmount==amount{
            
            return 0;
        }
        let diff:usize=(amount-reqAmount) as usize;
        if memo[diff]!=-1{
            return memo[diff]
        }
        let mut min1:i32=std::i32::MAX;
        for i in 0..n{
            if (reqAmount as i64)+(coins[i] as i64)<=(amount as i64) {
                let x:i32=Self::dfs(coins,reqAmount+coins[i],amount,memo);
                if x!=std::i32::MAX{
                    min1=min1.min(x+1);
                }
                
            }
            
        }
        memo[diff]=min1;
        return min1;
    } 
}