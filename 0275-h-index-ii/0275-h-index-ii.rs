impl Solution {
    pub fn bs(c :&Vec<i32>) -> i32{
        let n=c.len();
        let mut high:i32=(n-1) as i32;
        let mut low:i32=0;
        while low<=high{
             let mid = (high + low) / 2;
             let x:usize=mid as usize;
            if mid+c[x]>=(n as i32){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return (n as i32)-low;
        
    }
    pub fn h_index(citations: Vec<i32>) -> i32 {
        let n = citations.len();
        
        if n == 0 {
            return 0;
        }
        
        let h = Solution::bs(&citations);
        h
    }
}