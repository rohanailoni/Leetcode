class node<T>{
    T obj;
    node next;
    node(T obj){
        this.obj=obj;
        next=null;
    }
    
}
class queue<T>{
    node<T> head;
    node<T> tail;
    int count;
    queue(){
        head=null;
        tail=null;
        count=0;
    } 
    T peek(){
        return head.obj;
    }
    T pop(){
        count--;
        node<T> temp=head;
        
        head=head.next;
        return temp.obj;
    }
    void add(T n){
        count++;
        if(head==null){
            node<T> n1=new node<>(n);
            head=n1;
            tail=n1;
            return;
        }else{
            node<T>n1=new node<>(n);
            tail.next=n1;
            tail=n1;
            
        }
    }
    int size(){
        return count;
    }
    boolean isEmpty(){
        return head==null?true:false;
    }
}


class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        queue<Node>qu=new queue<Node>();
        qu.add(root);
        while(!qu.isEmpty()){
            int count=qu.size();
            for(int i=0;i<count;i++){
                Node aa=qu.pop();
                //System.out.println(aa.val);
                if(qu.size()>=1 && i!=count-1){
                    aa.next=qu.peek();
                }else{
                    aa.next=null;
                }
                
                if(aa.left!=null){
                    
                    qu.add(aa.left);
                }if(aa.right!=null){
                    
                    qu.add(aa.right);
                }
                
            }
        }
        return root;
    }
    
}