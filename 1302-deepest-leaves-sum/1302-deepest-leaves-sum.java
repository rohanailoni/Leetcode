/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
   
    public int deepestLeavesSum(TreeNode root) {
        
        queue<TreeNode>qu=new queue<>();
        qu.add(root);
        int ans=root.val;
        while(!qu.isEmpty()){
            int count=qu.size();
            ans=0;
            for(int i=0;i<count;i++){
                TreeNode roo=qu.pop();
                if(roo.left!=null){
                    qu.add(roo.left);
                }if(roo.right!=null){
                    qu.add(roo.right);
                }if(roo.left==null && roo.right==null){
                    ans+=roo.val;
                }
            }
        }
        return ans;
    }
    // public void dfs(TreeNode root){
    //     if(root.left==null && root.right==null){
    //         ans+=root.val;
    //         return;
    //     }
    //     if(root.left!=null){
    //         dfs(root.left);
    //     }
    //     if(root.right!=null){
    //         dfs(root.right);
    //     }
    //     return;
    // }
}