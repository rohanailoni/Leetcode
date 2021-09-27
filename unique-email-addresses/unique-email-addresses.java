class Solution {
    private class pair{
        String local;
        String domain;
        pair(String l,String d){
            local=l;
            domain=d;
            
        }
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>(); 
        for (String email : emails) {
            String[] parts = email.split("@"); 
            String[] local = parts[0].split("\\+"); 
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); 
        }
        return normalized.size();
    }
}