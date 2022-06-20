// class TrieNode{
//     char c;
//     TrieNode[] children;
//     boolean endofword;
//     TrieNode(char c){
//         this.children=new TrieNode[26];
//         this.c=c;
//         endofword=false;
//     }
//     TrieNode(TrieNode clone){
//         this.c=clone.c;
//         this.children=clone.children;
//     }
// }
// class Trie{
//     TrieNode root;
//     private List<String>loop;
//     Trie(){
//         //"@" to indicate the start node;
//         root=new TrieNode('@');
        
//     }
    
//     void Insert(String s){
//         TrieNode temp_root=root;
//         for(char c:s.toCharArray()){
//             //System.out.println(temp_root.c+" "+c);
//             if(temp_root.children[c-'a']==null){
                
//                 temp_root.children[c-'a']=new TrieNode(c);
//                 temp_root=temp_root.children[c-'a'];
//                 //System.out.println(temp_root.children[c-'a'].c);
//             }else{
//                 temp_root=temp_root.children[c-'a'];
                
//             }
//         }
//         temp_root.endofword=true;
//     }
//     void dfs(TrieNode root,String cache){
//         cache+=root.c;
//         //System.out.println(cache+" "+root.endofword);
//         if(root.endofword){
//             loop.add(new String(cache));
//         }
//         if(loop.size()>=3){
//             return;
//         }
//         for(TrieNode xx:root.children){
//             if(xx!=null){
//                 dfs(xx,cache);
//             }
//         }
//         return ;
//     }
    
//     List<String> Search(String s){
//         loop=new ArrayList<>();
//         int n=s.length();
//         TrieNode temp_root=root;
//         List<String>ans=new ArrayList<>();
//         String temp="";
//         for(int i=0;i<n;i++){
//             TrieNode n1=temp_root.children[s.charAt(i)-'a'];
//             if(n1!=null){
//                 temp+=n1.c;
//                 temp_root=n1;
//             }
//         }
//         if(temp_root.endofword){
//             loop.add(new String(temp));
//         }
//         for(TrieNode xx:temp_root.children){
            
//             if(xx!=null){
//                 dfs(xx,temp);
//             }
//         }
//         return loop;
//     }
    
// }



// class Solution {
//     List<List<String>>ans;
//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//         ans=new ArrayList<>();
//         Trie s=new Trie();
//         for(String i:products){
//             s.Insert(i);
//         }
//         for(int i=1;i<=searchWord.length();i++){
//             //System.out.println(searchWord.substring(0,i));
//             ans.add(s.Search(searchWord.substring(0,i)));
//         }
//         //System.out.println(s.Search("mo"));
//         return ans;
        
//     }
// }
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            int ind = binarySearch(products, prefix);
            List<String> l = new ArrayList<>();
            for (int j = ind; j < products.length && l.size() <3; ++j) {
                if (products[j].startsWith(prefix)) {
                    l.add(products[j]);
                    continue;
                }
                break;
            }
            list.add(l);
        }
        return list;
    }

    int binarySearch(String[] products, String prefix) {
        int left = 0, right = products.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (products[mid].compareTo(prefix) > -1) right = mid - 1;
            else left = mid + 1;
        }
        return right + 1;
    }
}