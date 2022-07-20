class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,Deque<String>>map=new HashMap<>();
        for(char i='a';i<='z';i++){
            map.put((char)i,new LinkedList<>());
        }
        for(String word:words){
            map.get(word.charAt(0)).add(word);
            
        }
        //System.out.println(map);
        int k=0;
        for(char c:s.toCharArray()){
            Deque<String>nn=map.get(c);
            int size=nn.size();
            for(int i=0;i<size;i++){
                String n=nn.removeFirst();
                if(n.length()==1){
                    k++;
                }else{
                     map.get(n.charAt(1)).add(n.substring(1));
                }
            }
        }
        return k;
    }
}