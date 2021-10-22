// class Solution {
    
//     class obj{
//         List<Character>c;
//         obj(){
//             this.c=new ArrayList<>();
//         }
//         void add(char c){
//             this.c.add(c);
//         }
//     }
//     public String frequencySort(String s) {
//         HashMap<Character,Integer>map=new HashMap<>();
//         char[] c=s.toCharArray();
//         obj[] ans=new obj[52];
//         for(int i=0;i<52;i++){
//             ans[i]=new obj();
            
//         }
//         for(int i=0;i<c.length;i++){
//             if(c[i]>=65 && c[i]<=91){
//                 ans[c[i]-'A'].c.add(c[i]);
//             }else{
//                 ans[c[i]-'a'+26].c.add(c[i]);
//             }
//         }
        
//         String s1=new String("");
//         for(int i=0;i<52;i++){
//             if(ans[i].c.size()!=0){
//                 for(int i=0;i<)
//             }
//         }
//         return s1;
//     }
// }
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
						
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
				
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(c);

        return sb.toString();
    }
}