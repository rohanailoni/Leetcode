class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Trie t=new Trie(k);
        for(String s:words){
            //System.out.println(s+" "+0);
            t.build(s,0,t.root);
        }
        t.dfs(t.root);
        // for(ans a:t.ret){
        //     System.out.println(a.s+" "+a.count);
        // }
        List<String>ans=new ArrayList<>();
        Collections.sort(t.ret,(ans a,ans b)->b.count-a.count);
        for(ans aaa:t.ret){
            if(k>0){
                ans.add(aaa.s);
                k--;
            }
        }
        return ans;
    }
}


class Trie{
    Node root;
    List<ans>ret;
    int k;
    Trie(int k){
        this.k=k;
        this.root=new Node('$');
        ret=new ArrayList<>();
    }
    public void  build(String s,int index,Node n){
        if(index==s.length()-1){
            
            if(n.child[s.charAt(index)-'a']==null){n.child[s.charAt(index)-'a']=new Node(s.charAt(index));}
            n.child[s.charAt(index)-'a'].isEnd=true;
            n.child[s.charAt(index)-'a'].count+=1;
            n.child[s.charAt(index)-'a'].c=s.charAt(index);
            n.child[s.charAt(index)-'a'].whole=s;
            Node nx=n.child[s.charAt(index)-'a'];
            //System.out.println(nx+" "+nx.count+" "+nx.c+" "+nx.whole);
            return;
        }
        //System.out.println(s+" "+index);
        //System.out.println(s.charAt(index)+" "+n.child[s.charAt(index)-'a']);
        if(n.child[s.charAt(index)-'a']==null){
            n.child[s.charAt(index)-'a']=new Node(s.charAt(index));
            n.child[s.charAt(index)-'a'].c=s.charAt(index);
        }
        build(s,index+1,n.child[s.charAt(index)-'a']);
        return;
        
        
    }
    public void dfs(Node n){
        if(n.isEnd==true){
            //System.out.println(n+" "+n.count+" "+n.c+" "+n.whole);
            ret.add(new ans(n.count,n.whole));
            
        }
        for(int i=0;i<26;i++){
            if(n.child[i]!=null){
                dfs(n.child[i]);
            }
        }
        return;
        
    }
}
class Node{
    char c;
    int count;
    boolean isEnd;
    String whole;
    Node[] child;
    Node(char c){
        this.isEnd=false;
        this.count=0;
        this.c=c;
        this.child=new Node[26];
        
    }
    
}
class ans{
    String s;
    int count;
    ans(int n,String s){
        this.s=s;
        this.count=n;
    }
    
}