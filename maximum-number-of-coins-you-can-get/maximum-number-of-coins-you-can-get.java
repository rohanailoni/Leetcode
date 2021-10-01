class Solution {
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return;
    }
    private int parition(int arr[],int i,int j){
        int ref=i;
        int pivot=arr[j];
        for(int k=i;k<j;k++){
            if(arr[k]<pivot){
                swap(arr,ref,k);
                ref++;
            }
        }
        swap(arr,j,ref);
        return ref;
    }
    
    
    
    
    private void quicksort(int[] nums,int i,int j){
        if(i<j){
            int par=parition(nums,i,j);
            
            
            quicksort(nums,0,i-1);
            quicksort(nums,i+1,j);
        }
    }
    
    
    
    
    
    
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        //quicksort(piles,0,piles.length-1);
        for(int i:piles){
            System.out.print(i);
        }
        System.out.println();
        List<Integer>a=new ArrayList<>();
        for(int i:piles)a.add(i);
        int sum=0;
        for(int i=0;i<piles.length/3;i++){
            sum+=a.get(a.size()-2);
            a.remove(0);
            a.remove(a.size()-2);
            a.remove(a.size()-1);
            
        }
        return sum;
        
    }
}