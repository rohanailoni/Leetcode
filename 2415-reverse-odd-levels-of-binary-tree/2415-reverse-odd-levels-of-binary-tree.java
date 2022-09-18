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
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<Pair>qu=new LinkedList<>();
        qu.add(new Pair(root,0));
        int depth=0;
        while(!qu.isEmpty()){
            if(depth%2==0){
                int num=power(depth);
                for(int i=0;i<num;i++){
                    Pair p=qu.poll();
                    if(p.root.left!=null){
                        qu.add(new Pair(p.root.left,depth+1));
                    }
                    if(p.root.right!=null){
                        qu.add(new Pair(p.root.right,depth+1));
                    }
                }
            }else{
                ArrayList<Integer>r=new ArrayList<>();
                int num=power(depth);
                int h=0;
                for(Pair i:qu){
                    r.add(i.root.val);
                    h++;
                    if(h==num){
                        break;
                    }
                    
                }
                //System.out.println(r);
                reverseArrayList(r);
                //System.out.println(r+" "+num);
                h=0;
                for(Pair i:qu){
                    i.root.val=r.get(h);
                    h++;
                    if(h==num){
                        break;
                    }
                }
                for(int i=0;i<num;i++){
                    Pair pp=qu.poll();
                    if(pp.root.left!=null){
                        qu.add(new Pair(pp.root.left,depth+1));
                    }
                    if(pp.root.right!=null){
                        qu.add(new Pair(pp.root.right,depth+1));
                    }
                    
                }
                
            }
            depth++;
        }
        return root;
    }
    public int power(int n){
        return (int)Math.pow(2,n);
    }
    public ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist)
    {
        for (int i = 0; i < alist.size() / 2; i++) {
            Integer temp = alist.get(i);
            alist.set(i, alist.get(alist.size() - i - 1));
            alist.set(alist.size() - i - 1, temp);
        }
        return alist;
    }
    
}
class Pair{
    TreeNode root;
    int depth;
    Pair(TreeNode root,int depth){
        this.root=root;
        this.depth=depth;
    }
}