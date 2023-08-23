class Node{
    char c;
    int freq;
    Node(char c,int freq){
        this.c=c;
        this.freq=freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->(b.freq-a.freq));
        HashMap<Character,Integer>map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
           map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(),entry.getValue()));
        }
        int mod=pq.peek().freq;
        char modc=pq.peek().c;
        int poi=0;
        String[] bucket=new String[mod];
        Arrays.fill(bucket,"");
        int sum=0;
        while(!pq.isEmpty()){
            Node temp=pq.poll();
            for(int j=0;j<temp.freq;j++){
                bucket[poi%mod]=bucket[poi%mod]+temp.c;
                poi++;
            }
            if(temp.c!=modc){
                sum+=temp.freq;
            }
        }
        //System.out.println(Arrays.toString(bucket)+" "+sum);
        if(sum<mod-1){
            return "";
        }
        String ans="";
        for(int i=0;i<mod;i++){
            ans+=bucket[i];
        }
        return ans;
    }
}