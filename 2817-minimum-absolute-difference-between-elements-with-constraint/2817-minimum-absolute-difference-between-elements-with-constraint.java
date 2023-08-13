class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans=Integer.MAX_VALUE;
        TreeSet<Integer> nm=new TreeSet<>();
        int size=nums.size();
        for(int i=x;i<size;i++)
        {
            nm.add(nums.get(i-x));
            Integer val=nm.ceiling(nums.get(i));
            if(val!=null)
            {
                ans=Math.min(ans,Math.abs(nums.get(i)-val));
            }
            Integer val1=nm.floor(nums.get(i));
            if(val1!=null)
            {
                ans=Math.min(ans,Math.abs(nums.get(i)-val1));
            }
        }
        return ans;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class TreeSet1 {
    private TreeNode root;

    public void add(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }
    public Integer ceiling(int val) {
        return findCeiling(root, val);
    }

    private Integer findCeiling(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (val == node.val) {
            return val;
        } else if (val < node.val) {
            Integer leftCeiling = findCeiling(node.left, val);
            return (leftCeiling != null && leftCeiling >= val) ? leftCeiling : node.val;
        } else {
            return findCeiling(node.right, val);
        }
    }

    public Integer floor(int val) {
        return findFloor(root, val);
    }

    private Integer findFloor(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (val == node.val) {
            return val;
        } else if (val < node.val) {
            return findFloor(node.left, val);
        } else {
            Integer rightFloor = findFloor(node.right, val);
            return (rightFloor != null && rightFloor <= val) ? rightFloor : node.val;
        }
    }
}

