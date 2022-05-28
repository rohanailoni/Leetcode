class obj{
    int words;
    String sender;
    obj(int words,String sender){
        this.words=words;
        this.sender=sender;
    }
}

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        TreeMap<String,Integer>map=new TreeMap<>();
        
        int n=senders.length;
        for(int i=0;i<n;i++){
            map.put(senders[i],0);
        }
         for(int i=0;i<n;i++){
                //System.out.println(senders[i]);
                map.put(senders[i],map.get(senders[i])+messages[i].split(" ").length);
            
        }
        int max=Integer.MIN_VALUE;
        String owner=senders[0];
        ArrayList<String>sort=new ArrayList<>();
        for(Map.Entry<String,Integer>mm:map.entrySet()){
            if(mm.getValue()>max){
                max=mm.getValue();
                owner=mm.getKey();
            }
        }
        for(Map.Entry<String,Integer>mm:map.entrySet()){
            if(mm.getValue()==max){
                sort.add(mm.getKey());
            }
            
        }
        Collections.sort(sort);
        //System.out.println(map);
        return sort.get(sort.size()-1);
    }
}