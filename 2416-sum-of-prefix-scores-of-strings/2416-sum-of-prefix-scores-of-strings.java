// class Solution {
//     public int[] sumPrefixScores(String[] words) {
//         int n=words.length;
//         HashMap<String,Integer>sp=new HashMap<>();
//         for(int i=0;i<n;i++){
//             String word=words[i];
//             for(int j=1;j<word.length()+1;j++){
//                 String temp=word.substring(0,j);
//                 sp.put(temp,sp.getOrDefault(temp,0)+1);
//             }
//         }
//         int[] ans=new int[n];
//         for(int i=0;i<n;i++){
//             String temp=words[i];
//             int sum=0;
//             for(int j=1;j<temp.length()+1;j++){
//                 String temp1=temp.substring(0,j);
//                 sum+=sp.getOrDefault(temp1,0);
//             }
//             ans[i]=sum;
//         }
//         return ans;
//     }
// }
class Trie {
    Trie[] ch = new Trie[26];
    int visited = 0;
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int[] ans = new int[words.length];
        int k = 0;
        for (String x: words) {
            Trie t = trie;
            for (int i = 0; i < x.length(); i++) {
                int c = x.charAt(i) - 'a';
                if (t.ch[c] == null) t.ch[c] = new Trie();
                t.ch[c].visited++;
                t = t.ch[c];
            }
        }
        for (String x: words) {
            Trie t = trie; int curr = 0;
            for (int i = 0; i < x.length(); i++) {
                int c = x.charAt(i) - 'a';
                curr += t.ch[c].visited;
                t = t.ch[c];
            }
            ans[k++] = curr;
        }
        return ans;
    }
}