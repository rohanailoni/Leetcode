class Solution {
    static void reverse(int arr[], int n)
    {
        int i=0,j=n-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        
        
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int[] arr=new int[k];
        
        
        int count=0;
        ListNode temp=head;
        ListNode start=head;
        while(temp!=null){
            arr[count]=temp.val;
            count++;
            
            
            if(count==k){
                reverse(arr,k);
                //System.out.println(Arrays.toString(arr));
                
                int i=0;
                while(i<k){
                    start.val=arr[i++];
                    start=start.next;
                    
                }
                i=0;
                //if(start!=null)start=start.next;
                count=0;
                arr=new int[k];
            }
            temp=temp.next;
        }
        
        
        
        return head;
        
    }
}