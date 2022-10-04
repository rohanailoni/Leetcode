class LUPrefix {
    int steps;
    HashSet<Integer>set;
    public LUPrefix(int n) {
        steps=0;
        set=new HashSet<>();   
    }
    public void upload(int video) {
        if(video==1){
            steps=1;
        }
        set.add(video);
        
            while(set.contains(steps+1)){
                steps++;
            }
        
        
    }
    
    public int longest() {
        return steps;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */