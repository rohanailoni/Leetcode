class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int m_m= m;
        int m_n = n;
        for (int[] op : ops){
            m_m = Math.min(m_m,op[0]);
            m_n = Math.min(m_n,op[1]);
        }
        return m_m * m_n;
    }

}