class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k=s1.length();
        for(int i=0;i<s2.length()-k+1;i++){
            String temp=s2.substring(i,i+k);
            if(isPermutation(s1,temp)){
                return true;
            }
        }
        return false;
    }
    public  boolean isPermutation(String s1, String s2) {
        int[] frequencyOfS1 = new int[26];
        int[] frequencyOfS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            frequencyOfS1[s1.charAt(i) - 'a']++;
            frequencyOfS2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(frequencyOfS1, frequencyOfS2);
    }
}
