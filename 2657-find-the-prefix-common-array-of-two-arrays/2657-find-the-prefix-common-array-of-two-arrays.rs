use std::collections::HashMap;

impl Solution {
    pub fn find_the_prefix_common_array(a: Vec<i32>, b: Vec<i32>) -> Vec<i32> {
        let n:usize=a.len();
        let mut ans:Vec<i32>=vec![0;n];
        let mut map1=HashMap::new();
        let mut map2=HashMap::new();
        if a[0]==b[0]{
            ans[0]=1;
        }
        map1.insert(a[0],1);
        map2.insert(b[0],1);
        for i in 1..=n-1{
            let y1=a[i];
            let y2=b[i];
            if y1==y2{
                ans[i]=ans[i-1]+1;
                map1.insert(y1,1);
                map2.insert(y2,1);
                continue;
            }
            //println!("y1 {}, y2 {}, map1 y2{}, map2 y2{}",y1,y2,map1.contains_key(&y2),map2.contains_key(&y2));
            let mut x=0;
            if map2.contains_key(&y1) && !map1.contains_key(&y1){
                x+=1;
            }
            if map1.contains_key(&y2) && !map2.contains_key(&y2){
                x+=1
            }
            ans[i]=x+ans[i-1];
            map1.insert(y1,1);
            map2.insert(y2,1);
        }
        return ans;
    }
}