class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>answer=new ArrayList<>();
        int[] coun=new int[26];
        Arrays.fill(coun,0);
        for(char cc:s.toCharArray())coun[cc-'a']++;
        int n=s.length();
        int i=0;
        int j=0;
        int mask=0;
        //System.out.println(Arrays.toString(coun));
        while(j<n){
            mask=mask | (1<<(s.charAt(j)-'a'));
            //System.out.println(mask);
            coun[s.charAt(j)-'a']--;
            if(coun[s.charAt(j)-'a']==0){
                mask=mask^(1<<(s.charAt(j)-'a'));
            }
            if(mask==0){
                answer.add(j-i+1);
                i=j+1;
            }
            j++;
            
            
            
        }
         
        
        
        
        return answer;
        
    }
}