class Solution {
    public int lengthOfLastWord(String s) {
        String[] k=s.split(" ");
        return k[k.length-1].length();
    }
}