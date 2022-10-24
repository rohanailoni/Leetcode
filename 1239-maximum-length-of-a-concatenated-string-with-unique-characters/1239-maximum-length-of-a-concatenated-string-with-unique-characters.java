class Solution {
    private int result=0;
    private List<String>a;
    private boolean check(String s1){
        Set<Character>s=new HashSet<>();
        for(char i:s1.toCharArray()){
            if(s.contains(i)){return false;}
            s.add(i);
        }return true;
        
        
        
    }
    
    
    
    private void dfs(String path,int index){
        boolean ss=check(path);
        
        
        if(ss){
            result=Math.max(path.length(),result);
        }
        if(ss==false)return;
        
        for(int i=index;i<this.a.size();i++){
            dfs(path+this.a.get(i),i+1);
        }
        
    }
    
    public int maxLength(List<String> arr) {
        
        a=arr;
        dfs("",0);
        return result;
        
        
        
    }
}