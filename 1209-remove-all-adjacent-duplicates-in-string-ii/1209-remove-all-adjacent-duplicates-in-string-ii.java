class node{
    char m;
    int count;
    node next;
    node(char m,int co,node next){
        this.m=m;
        this.count=co;
        this.next=next;
    }
}
class stack{
    public node head;
    stack(){
        head=null;
    }
    void push(char c){
        if(head==null){
            
            head=new node(c,0,null);
        }else{
            char cc=head.m;
            int count=0;
            if(cc==c){
                count=head.count+1;
            }
            node temp=new node(c,count,null);
            temp.next=head;
            head=temp;
        }
    }
    char pop(){
        char c=head.m;
        head=head.next;
        return c;
    }
    boolean empty(){
        return head==null?true:false;
    }
}







// class Solution {
//     public String removeDuplicates(String s, int k) {
//         Stack<Character>ss=new Stack<>();
//         for(char c:s.toCharArray()){
            
//             int count=0;
            
//             while(ss.size()>=1 && ss.peek()==c){
//                 ss.pop();count++;
//             }
//             if(count!=k-1){
//                 for(int i=0;i<count;i++){
//                     ss.push(c);
//                 }
//                 ss.push(c);
//             }
//             //System.out.println(count+" "+ss);
            
            
//         }
//         String ans="";
//         StringBuilder input1 = new StringBuilder();
//         while(ss.size()>0){
//             ans+=ss.pop();
//         }
//         input1.append(ans);
//         input1.reverse();
//         return input1.toString();
//     }
// }
class Solution {
    public String removeDuplicates(String s, int k) {
        //Stack<Character>ss=new Stack<>();
        stack ss=new stack();
        for(char c:s.toCharArray()){
            ss.push(c);
            
            if(ss.head.count==k-1){
                for(int i=0;i<k;i++){
                    ss.pop();
                }
            }
            
        }
        String ans="";
        while(!ss.empty()){
            ans+=ss.pop();
        }
        StringBuilder input1 = new StringBuilder();
        input1.append(ans);
 
        input1.reverse();
 
        return input1.toString();
    }
}