class node{
    public int n;
    public node next;
    node(int n,node next){
        this.n=n;
        this.next=next;
    }
}
class queue{
    node head,tail;
    queue(){
        head=null;
        tail=null;
    }
    void push(int x){
        if(head==null){
            head=new node(x,null);
            
        }else{
            node temp=new node(x,null);
            temp.next=head;
            head=temp;
        }
    }
    int top(){
        return head.n;
    }
    int pop(){
        int n=head.n;
        head=head.next;
        return n;
        
    }
    boolean empty(){
        return head==null?true:false;
    }
    
    
}


class MyStack {
    queue qu;
    public MyStack() {
        qu=new queue();
    }
    
    public void push(int x) {
        qu.push(x);
    }
    
    public int pop() {
        return qu.pop();
    }
    
    public int top() {
        return qu.top();
    }
    
    public boolean empty() {
        return qu.empty();
    }
}

