class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;
    
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int cnt = freq.getOrDefault(val, 0);
        cnt++;
        maxFreq = Math.max(maxFreq, cnt);
        freq.put(val, cnt);
        Stack<Integer> st = group.getOrDefault(cnt, new Stack<>());
        st.push(val);
        group.put(cnt, st);
        return;
    }
    
    public int pop() {
        Stack<Integer> st = group.get(maxFreq);
        int cur = st.pop();
        freq.put(cur, maxFreq - 1);
        if (st.isEmpty()) {
            maxFreq--;
        }
        return cur;
    }
}