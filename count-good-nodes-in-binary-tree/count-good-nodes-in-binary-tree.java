class Solution {
    private int arrmax(List<Integer> arr){
        int max=-Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++){
            
            if(arr.get(i)>max){
                
                max=arr.get(i);
            }
        }
        return max;
    }
    private int dfs(TreeNode node,List<Integer> index,int count){
        
        if(node==null){
            
            return 0;
        }
        if(node.val>=arrmax(index)){
            count++;
        }
        index.add(node.val);
        List<Integer>index1=new ArrayList<>(index);
        
        int left=dfs(node.left,index,count);
        int right=dfs(node.right,index1,count);
        
        if(left>=count){
            left=left-count;
        }
        if(right>=count){
            right=right-count;
        }

        
        return count+right+left;
        
    }
    public int goodNodes(TreeNode root) {
        int n1=-Integer.MAX_VALUE;
        List<Integer>nod=new ArrayList<Integer>(Arrays.asList(n1));
        
        int n=dfs(root,nod,0);
        
        
        return n;
    }
}