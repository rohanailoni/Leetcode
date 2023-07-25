/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func searchBST(root *TreeNode, val int) *TreeNode {
    tmp:=root;
    for tmp!=nil{
        if val>tmp.Val{
            tmp=tmp.Right;
        }else if val<tmp.Val {
            tmp=tmp.Left;
        }else{
            return tmp;
        }
    }
    return nil;
}