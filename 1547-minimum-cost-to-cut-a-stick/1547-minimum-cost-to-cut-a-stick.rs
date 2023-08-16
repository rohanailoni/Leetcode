use std::collections::HashMap;

impl Solution {
    pub fn min_cost(n: i32, cuts: Vec<i32>) -> i32 {
        let mut memo: HashMap<String, i32> = HashMap::new();
        Self::dfs(0, n, &cuts, &mut memo)
    }

    pub fn dfs(l: i32, r: i32, cuts: &[i32], memo: &mut HashMap<String, i32>) -> i32 {
        let x = format!("{}.{}", l, r);
        if let Some(&value) = memo.get(&x) {
            return value;
        }
        
        let mut min = std::i32::MAX;
        
        for &cut in cuts {
            if cut > l && cut < r {
                let temp = Self::dfs(l, cut, cuts, memo) + Self::dfs(cut, r, cuts, memo) + r - l;
                min = min.min(temp);
            }
        }
        
        if min == std::i32::MAX {
            min = 0;
        }
        
        memo.insert(x, min);
        min
    }
}
