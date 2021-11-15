class CombinationIterator {

    boolean has=true;
    int length=0;
    String chars;
    int pointers[];
    public CombinationIterator(String characters, int combinationLength) {
        chars=characters;
        length=combinationLength;
        pointers=new int[length];
        for(int i=0;i<length;i++)
            pointers[i]=i;
        
    }
    
    public String next() {
        String result="";
        for(int i=0;i<length;i++)
            result+=chars.charAt(pointers[i]);
        has=check();
        return result;
        
        
        
    }
    
    public boolean check(){
        for(int i=length-1, j=chars.length()-1;i>=0;i--,j--){
            if(pointers[i]!=j){
                pointers[i]++;
                for(int k=i+1;k<length;k++)
                    pointers[k]=pointers[k-1]+1;
                return true;
            }
            
        }
        return false;
    }
    
    
    public boolean hasNext() {
        return has;
    }
}