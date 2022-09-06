class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character,Pair>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.get(c).set_b(i);
            }else{
                Pair p=new Pair();
                p.set_a(i);
                map.put(c,p);
            }
        }
        //System.out.println(map);
        for(Map.Entry<Character,Pair>m:map.entrySet()){
            char c=m.getKey();
            Pair p=m.getValue();
            //System.out.println(c+" "+(Math.abs(p.a-p.b)-1));
            if(distance[c-'a']!=Math.abs(p.a-p.b)-1){
                return false;
            }
        }
        return true;
        
    }
}
class Pair{
    public int a,b;
    void set_a(int a){
        this.a=a;
    }
    void set_b(int b){
        this.b=b;
    }
}