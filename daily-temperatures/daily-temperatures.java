class Solution {
    class obj{
        int index;
        int number;
        obj(int n,int i){
            index=i;
            number=n;
            
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        int n=temperatures.length;
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.empty() && temperatures[i]>temperatures[st.peek()]){
                ans[st.peek()]=i-st.pop();
            }
            
            st.push(i);
        }
        return ans;
    }
}