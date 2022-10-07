class NumArray {
    Node arr[];
    int n;
    int[] sum;
    int[] nums;
    public NumArray(int[] nums) {
        n=nums.length;
        this.nums=nums;
        arr=new Node[4*n];
        Arrays.fill(arr,new Node(0));
        sum=new int[4*n];
        this.dsf(0,0,n-1);
        
    }
    public int dsf(int index,int l,int e){
        if(l==e){
            sum[index]=nums[l];
            arr[index]=new Node(index,l,e);
            return sum[index];
        }
        int mid=l+(e-l)/2;
        int a=dsf(2*index+1,l,mid);
        int b=dsf(2*index+2,mid+1,e);
        sum[index]=a+b;
        arr[index]=new Node(index,l,e);
        return sum[index];
        
    }
    public int search(int l,int e,int index){
        Node n=arr[index];
        //no overlab check
        if(n.l>e || l>n.e ){
            return 0;
        }
        //check for complete overlap
        if(n.l>=l && n.e<=e){
            return sum[index];
        }
        
        
        //end is for only check for partial overlap;
        if(n.l==n.e){
            return sum[index];
        }
        int a=search(l,e,2*index+1);
        int b=search(l,e,2*index+2);
        return a+b;
        
    }
    public int sumRange(int left, int right) {
        
        return search(left,right,0);
    }
}
class Node{
    int index;
    int l,e;
    Node(int i){
        this.index=i;
    }
    Node(int i,int l,int h){
        this.index=i;
        this.l=l;
        this.e=h;
    }
}
