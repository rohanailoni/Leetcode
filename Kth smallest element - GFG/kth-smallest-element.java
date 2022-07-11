// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        int index=part(arr,l,r);
        if(index==k-1){
            return arr[index];
        }
        else if(index<k-1){
            return kthSmallest(arr,index+1,r,k);
        }else{
            return kthSmallest(arr,l,index-1,k);
        }
       
    } 
    public static void swap(int[] arr,int n,int k){
        int temp=arr[n];
        arr[n]=arr[k];
        arr[k]=temp;
    }
    public static int part(int[] arr,int l,int r){
        int pivot=arr[r];
        int j=l;
        for(int i=l;i<r;i++){
            if(arr[i]<pivot){
                swap(arr,i,j);
                j++;
            }
        }
        swap(arr,r,j);
        return j;
    }
}
