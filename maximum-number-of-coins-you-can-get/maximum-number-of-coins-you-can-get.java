class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        List<Integer>a=new ArrayList<>();
        for(int i:piles)a.add(i);
        int sum=0;
        for(int i=0;i<piles.length/3;i++){
            sum+=a.get(a.size()-2);
            a.remove(0);
            a.remove(a.size()-2);
            a.remove(a.size()-1);
            
        }
        return sum;
        
    }
}