impl Solution {
    pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut ans: Vec<Vec<i32>> = Vec::new();
        let n: usize = nums.len();
        let mut nums = nums.clone(); // Clone the input to modify it

        nums.sort(); // Sort the array in ascending order
        
        for i in 0..n {
            if i > 0 && nums[i] == nums[i - 1] {
                continue;
            }
            let mut j: usize = i + 1;
            let mut k: usize = n - 1;
            
            while j < k {
                let sum: i32 = nums[i] + nums[j] + nums[k];
                
                if sum < 0 {
                    j += 1;
                } else if sum > 0 {
                    k -= 1;
                } else {
                    let mut temp: Vec<i32> = Vec::new();
                    temp.push(nums[i]);
                    temp.push(nums[j]);
                    temp.push(nums[k]);
                    ans.push(temp);
                    
                    j += 1;
                    k -= 1;
                    
                    while j < k && nums[j] == nums[j - 1] {
                        j += 1;
                    }
                    while j < k && nums[k] == nums[k + 1] {
                        k -= 1;
                    }
                }
            }
        }
        
        ans 
    }
}
