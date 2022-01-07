class Solution {
    ArrayList<Integer> res = new ArrayList<>(); 
    public Solution(ListNode head) { 
        while(head != null){ // Storing all the values by iterating over the LinkedList
            res.add(head.val);
            head = head.next;
        }
    }
    // 
    public int getRandom() { 
        //Math.random() will generate a random number b/w 0 & 1.
        //then multiply it with the array size, as i have all the value in the list, i know the size of the list
        //take only the integer part which is a random index.
        //return the element at that random index.
        return res.get((int)(Math.random() * res.size()));
    }
}