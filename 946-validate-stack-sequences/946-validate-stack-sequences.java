class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st=new Stack<>();
        int h1=0;
        int h2=0;
        if(pushed.length==1)return true;
        
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(st.empty()==false && st.peek()==popped[h2]){
                
                    st.pop();
                    h2++;
                
            }
            
        }
        //System.out.println(st);
        if(st.empty()){
            return true;
        }else{
            return false;
        }
        
    }
}