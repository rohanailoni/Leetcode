class Solution {
    public int numOfStrings(String[] patterns, String word) {
        Set<String>pat=new HashSet<>();
        
        int count=0;
        
        for(int i=0;i<=word.length();i++){
            for(int j=i+1;j<word.length()+1;j++){
                
                    pat.add(word.substring(i,j));
                    
            
            }
        }
        for(int i=0;i<patterns.length;i++){
            if(pat.contains(patterns[i])){
                count++;
            }
        }
        return count;
    }
}