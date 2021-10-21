class RandomizedSet {
    HashMap<Integer,Integer>n;
    java.util.Random rand=new java.util.Random();
    ArrayList<Integer>storage;
    public RandomizedSet() {
        n=new HashMap<>();
        storage=new ArrayList<>();
        
    }
    
    public boolean insert(int val) {
        if(n.containsKey(val)){
            //n.put(val,n.get(val)+1);
            return false;
        }else{
            n.put(val,storage.size());
            storage.add(val);
            
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(n.containsKey(val)){
            int loc = n.get(val);
            if (loc < storage.size() - 1 ) { // not the last one than swap the last one with this val
                int lastone = storage.get(storage.size() - 1 );
                storage.set( loc , lastone );
                n.put(lastone, loc);
            }
            n.remove(val);
            storage.remove(storage.size() - 1);
            return true;
        
        }
        else{
            return false;
        }
    }
    
    public int getRandom() {
        
        return storage.get(rand.nextInt(storage.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */