class Solution {
    public void swap(char[] c,int i,int j){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
        return;
    }
    public int minMovesToMakePalindrome(String s) {
        int n=s.length();
        char c[]=s.toCharArray();
        int i=0;
        int j=n-1;
        int ans=0;
        int pos_of_middle=-2;
        while(i<j){
            if(c[i]!=c[j]){
                int x=j-1;
                while(c[i]!=c[x]){
                    x--;
                }
                if(x!=i){
                    for(int al=x;al<j;al++){
                        swap(c,al,al+1);
                        ans++;
                    }
                }else{
                    pos_of_middle=x;
                    j++;
                }
                
            }
            i++;
            j--;
        }
        if(pos_of_middle!=-2){
            ans+=Math.abs(n/2-pos_of_middle);
        }
        return ans;
        
    }
}