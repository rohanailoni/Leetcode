class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        ArrayList<Integer>n1=new ArrayList<Integer>(Collections.nCopies(26, 0));
        ArrayList<Integer>n2=new ArrayList<Integer>(Collections.nCopies(26, 0));
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<p.length();i++){
            n2.set(p.charAt(i)-'a',n2.get(p.charAt(i)-'a')+1);
            
        }
        for(int i=0;i<p.length();i++){
            n1.set(s.charAt(i)-'a',n1.get(s.charAt(i)-'a')+1);
            
        }
        if(n1.equals(n2)){
                ans.add(0);
        }
        for(int i=1;i<=s.length()-p.length();i++){
            
            
            n1.set(s.charAt(i-1)-'a',n1.get(s.charAt(i-1)-'a')-1);
            n1.set(s.charAt(i+p.length()-1)-'a',n1.get(s.charAt(i+p.length()-1)-'a')+1);
            if(n1.equals(n2)){
                //System.out.println(i);
                ans.add(i);
            }
        }
        
        return ans;
    }
}