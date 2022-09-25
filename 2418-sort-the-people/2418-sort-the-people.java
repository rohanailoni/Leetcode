class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<pair>rr=new ArrayList<>();
        int n=names.length;
        String[] ans=new String[n];
        for(int i=0;i<n;i++){
            rr.add(new pair(names[i],heights[i]));
        }
        Collections.sort(rr,(pair a,pair b)->b.b-a.b);
        for(int i=0;i<n;i++){
            //System.out.println(rr.get(i).a+' '+rr.get(i).b);
            ans[i]=rr.get(i).a;
        }
        return ans;
    }
}
class pair{
    String a;
    int b;
    pair(String a,int b){
        this.a=a;
        this.b=b;
    }
}