// class Solution {
//     boolean check(int n){
//         int che=10;
//         while(n>0){
//             //System.out.println(n%10);
//             if(che==10){
//                 che=n%10;
//             }
//             else if(che-1==(n%10)){
//                 che=n%10;
//             }else{
//                 return false;
//             }
//             n=(int)n/10;
//         }
//         return true;
//     }
//     public List<Integer> sequentialDigits(int low, int high) {
//         List<Integer>ans=new ArrayList<Integer>();
//         for(int i=low;i<=high;i++){
//             if(check(i)){
//                 ans.add(i);
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        int nl = String.valueOf(low).length();
        int nh = String.valueOf(high).length();
        
        for(int i = nl; i <= nh; i++){
            for(int j = 0; j < 10 - i; j++){
                int num = Integer.parseInt(digits.substring(j, j + i));
                if(num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }
}