class Solution {
    HashMap<String,Integer>map=new HashMap<>();
    private boolean isvalid(String s){
        if(s.length()==0)return false;
        if(s.charAt(0)==0)return false;
        int n=Integer.parseInt(s);
        if(n>=1 && n<=26){
            return true;
        }
        return false;
        
    }
    private int dfs(String s){
        if(s.length()==0)return 1;
        if(s.charAt(0)=='0')return 0;
        if(s.length()<=1 && isvalid(s))return 1;
        if(map.containsKey(s))return map.get(s);
        int left=0;int right=0;
        if(s.length()>1){
            if(isvalid(s.substring(0,1))){
                //map.put(s.substring(1,s.length()),map.getOrDefault(s,0)+1);
                
                left=dfs(s.substring(1,s.length()));
            }
            
            if(isvalid(s.substring(0,2))){
                //map.put(s.substring(2,s.length()),map.getOrDefault(s,0)+1);
                right=dfs(s.substring(2,s.length()));
            }
        }
        
        map.put(s,map.getOrDefault(s,0)+left+right);
        return left+right;
        
    }
    
    
    
    
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        
        int n=dfs(s);
        
        
        return n;
    }
}