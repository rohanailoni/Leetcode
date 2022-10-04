// class Solution {
//     public boolean equalFrequency(String word) {
//         int[] freq=new int[26];
//         for(int i=0;i<word.length();i++){
//             freq[word.charAt(i)-'a']++;
//         }
//         int[]aa=new int[100];
//         for(int i=0;i<26;i++){
//             if(freq[i]!=0){
//                 aa[freq[i]]++;
//             }
//         }
//         int co=0;
//         for(int i=0;i<100;i++){
//             if(aa[i]!=0){
//                 co++;
//             }
//         }
//         if(co==1){
//             return false;
//         }
//         if(co>2){
//             return false;
//         }
//         List<Integer>ans=new ArrayList<>();
//         for(int i=0;i<100;i++){
//             if(aa[i]!=0){
//                 ans.add(i);
//             }
//         }
//         int x=ans.get(0);
//         int y=ans.get(1);
        
//         System.out.println(Arrays.toString(freq)+" "+x+" "+y);
//         return true;
        
        
//     }
// }
class Solution {
    public boolean check(int[] map){
        int pre=-1;
        for(int i=0;i<26;i++){
            if(map[i]!=0){
                if(pre==-1){
                    pre=map[i];
                    continue;
                }
                if(map[i]!=pre){
                    return false;
                }
            }
            
        }
        return true;
    }
    public boolean equalFrequency(String word) {
        int n=word.length();
        for(int i=0;i<n;i++){
            int[] map=new int[26];
            for(int j=0;j<n;j++){
                if(i!=j){
                    map[word.charAt(j)-'a']++;
                }
            }
            if(check(map)){
                return true;
            }
        }
        return false;
    }
    
        
}