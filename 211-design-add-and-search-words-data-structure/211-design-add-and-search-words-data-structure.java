class WordDictionary {
    Trie root;
    public WordDictionary() {
        root=new Trie('#');
    }
    
    public void addWord(String word) {
        Trie cur=root;
        
        for(char c:word.toCharArray()){
            if(cur.child[c-'a']==null){
                cur.child[c-'a']=new Trie(c);
            }
            cur=cur.child[c-'a'];
        }
        cur.last=true;
    }
    
    public boolean search(String word) {
        Trie s=this.root;
        return dfs(s,0,word);
        
    }
    public boolean dfs(Trie s,int index,String word){
        if(index>=word.length())return s.last;
        
        if(word.charAt(index)=='.' ){
            for(int i=0;i<26;i++){
                if(s.child[i]!=null && dfs(s.child[i],index+1,word)){
                    return true;
                }
            }
        }else{
            if(s.child[word.charAt(index)-'a']==null || s.child[word.charAt(index)-'a'].c!=word.charAt(index))return false;
            return dfs(s.child[word.charAt(index)-'a'],index+1,word);
        }
        return false;
            
    }
}



class Trie{
    Trie[] child;
    boolean last;
    char c;
    
    Trie(char c){
        this.c=c;
        this.child=new Trie[26];
        last=false;
        
    }
    
    
}