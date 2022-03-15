class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer>st=new Stack<>();
        char arr[]=s.toCharArray();
        int n;
        n=arr.length;
        //HashSet<Integer>index=new HashSet<>();
        for(int i=0;i<n;i++){
            if(arr[i]=='('){
                st.push(i);
            }else if(st.empty()==false && arr[i]==')'){
                st.pop();
            }else if(arr[i]==')'){
                arr[i]='#';
            }
        }
        while(!st.empty()){
            arr[st.pop()]='#';
        }
        //String ans="";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(arr[i]!='#'){
                //ans+=arr[i];
                sb.append(arr[i]);
            }
        }
        
        
        return sb.toString();
        
    }
    
    
}