// class Solution {
//     public String longestDupSubstring(String s) {
//         int i,j;
//         String alpha;
//         int min=0;
//         String ans="";
//         int start=0;
//         int end=s.length()-1;
//         while(end>start){
//             int k=start+(end-start)/2;
//             //System.out.println(s.substring(5,6));
//             HashSet<String>set=new HashSet<>();
//             i=0;
//             j=k+1;
            
//             while(i>=0 && j<=s.length()){
//                 alpha=s.substring(i,j);
//                 if(set.contains(alpha)){
//                     if(min<alpha.length()){
//                         min=alpha.length();
//                         ans=alpha;
//                         start=k+1;
//                         break;
//                     }
                    
//                 }
//                 set.add(alpha);
//                 i++;
//                 j++;
//                 //System.out.println(ans+" "+alpha);
//             }
            
            
//         }
//         return ans;
//     }
// }
class Solution{
public static String longestDupSubstring(String s) {
        int low = 1, high = s.length();
        String result = "";
        while (low  <= high) {
            int mid = (low + high) >>> 1;
            String tmp = longestDupSubstringRC(s, mid);
            if (!tmp.equals("")) {
                result = tmp;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static String longestDupSubstringRC(String s, int len) {
        Map<Long, List<Integer>> map = new HashMap<>();
        long hash = 0, Q = 19260817, R = 26, RM = 1;
        for (int i = 0; i < len-1; i++) {
            RM = RM % Q * R;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i >= len) {
                hash = (hash  + Q - (s.charAt(i-len) - 'a') * RM % Q) % Q;
            }
            hash = (hash * R + (c - 'a')) % Q;
            if (i < len-1) {
                continue;
            }
            if (map.containsKey(hash) && check(map.get(hash), i, len, s)) {
                return s.substring(i+1-len, i+1);
            }
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(i);
        }
        return "";
    }

    // handle collision
    private static boolean check(List<Integer> list, int curr, int len, String s) {
        for (int end : list) {
            int index = curr;
            boolean found = true;
            for (int i = 0; i < len; i++) {
                if (s.charAt(end--) != s.charAt(index--)) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
        }
        return false;
    }
}