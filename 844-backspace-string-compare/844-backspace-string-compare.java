class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>ss=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='#'){
                try{
                    ss.pop();
                }catch(Exception e){
                    continue;
                }
                
            }else{
                ss.push(c);
            }
        }
        String res1="";
        while(!ss.isEmpty()){
            res1+=ss.pop();
        }
        //System.out.println(res1);
        ss=new Stack<>();
        String res2="";
        for(char c:t.toCharArray()){
            if(c=='#'){
                try{
                    ss.pop();
                }catch(Exception e){
                    continue;
                }
            }else{
                ss.push(c);
            }
        }
        while(!ss.isEmpty()){
            res2+=ss.pop();
        }
        //System.out.println(res2);
        if(res1.equals(res2)){
            return true;
        }
        return false;
    }
}