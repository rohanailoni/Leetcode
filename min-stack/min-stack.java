class MinStack {
    private Node head;
   
    
    public void push(int val) {
        
        if(head==null){
            head=new Node(val,val,null);
        }
        else{
            head=new Node(val,Math.min(val,head.min),head);
        }
    }
    
    public void pop() {
         head=head.next;
    }
    
    public int top() {
        
        return head.n;
    }
    
    public int getMin() {
        return head.min;
    }
    private class Node{
        
        int n;
        int min;
        Node next;
        
        Node(int n,int min,Node next){
            
            this.n=n;
            this.min=min;
            this.next=next;
        }
        
    }
}
