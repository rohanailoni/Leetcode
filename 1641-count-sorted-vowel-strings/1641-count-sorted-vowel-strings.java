class Solution {
    char[] clas={'a','e','i','o','u'};
    int count;
    public int countVowelStrings(int n) {
        count=0;
        
        dfs(0,n,0);
        
        return count;
    }
    public void dfs(int index,int n,int len){
        if(len==n){
            count++;
            return;
        }
        for(int i=index;i<5;i++){
            dfs(i,n,len+1);
        }
        return;
    }
}