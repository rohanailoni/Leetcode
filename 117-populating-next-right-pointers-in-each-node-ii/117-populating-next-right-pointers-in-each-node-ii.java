class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node>qu=new LinkedList<>();
        qu.add(root);
        
        while(!qu.isEmpty()){
            int count=qu.size();
            for(int i=0;i<count;i++){
                Node aa=qu.remove();
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