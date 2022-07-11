// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {   int ans=0;
        for(int i=0;i<30;i++){
            int count=0;
            for(int j=0;j<size;j++){
                if((a[j] & (1<<i))!=0){
                    count++;
                }
            }
            if(count>(size/2)){
                ans+=(1<<i);
            }
        }
        int count=0;
        for(int i:a){
            if(i==ans){
                count++;
            }
        }
        if(count>size/2){
            return ans;
        }
        return -1;
    }
}