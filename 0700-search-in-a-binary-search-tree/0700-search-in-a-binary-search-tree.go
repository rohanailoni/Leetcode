/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func searchBST(root *TreeNode, val int) *TreeNode {
    
    for root!=nil{
        if val>root.Val{
            root=root.Right;
        }else if val<root.Val {
            root=root.Left;
        }else{
            return root;
        }
    }
    return nil;
}