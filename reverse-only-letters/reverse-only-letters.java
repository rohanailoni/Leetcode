class Solution {
    public String reverseOnlyLetters(String s) {
        Stack<Character>st=new Stack<>();
        
        
        for(int i=0;i<s.length();i++){
            int n=s.charAt(i);
            if((n>=31 && n<=64) || (n>=91 && n<=96)){
                
            }else{
                
                st.push(s.charAt(i));
            }
        }
        
        String ans=new String("");
        for(int i=0;i<s.length();i++){
            int n=s.charAt(i);
            if((n>=31 && n<=64) || (n>=91 && n<=96)){
                ans=ans+s.charAt(i);
                
            }else{
                ans=ans+st.pop();
            }
            
        }
        return ans;
        
        
        
    }
}