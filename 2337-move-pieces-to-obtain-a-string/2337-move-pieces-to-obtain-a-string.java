class Solution {
    public boolean canChange(String start, String target) {
        if (!(start.replaceAll("_", "")).equals(target.replaceAll("_", ""))) {
            return false;
        }
        for (int i = 0, j = 0, n = start.length(); i < n && j < n; ++i, ++j) {
            while (i < n && start.charAt(i) == '_') {
                ++i;
            }
            while (j < n && target.charAt(j) == '_') {
                ++j;
            }
            if ((i < n) != (j < n)) {
                return false;
            }else if (i < n && j < n) {
               
                if (start.charAt(i) != target.charAt(j) || (start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j)) {
                    return false;
                }
            }
        }
        return true;
    }
}