class Solution {
   
    int index=0;
    private boolean preorder(String[] s){
        
        if(index>=s.length){
            index++;
            return false;
        }
        if(s[index].equals("#")){
            index++;
            return true;
        }
        if(s[index]!="#"){
            index++;
        }
        preorder(s);
        preorder(s);
        return true;
        
    }
    
    
    public boolean isValidSerialization(String tree) {
      //bfs on the array with increasing index as if if goes out of index that means it is going out of 
        //tree
        
        String[] s=tree.split(",");
        return preorder(s)&&index==s.length;
        
        
        
    }
}