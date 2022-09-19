class Solution {
    public int maxProduct(int[] arr) {
        int maxLeft = arr[0];
	    int maxRight = arr[0];
	    
	    boolean zeroPresent = false;
	    
	    int prod = 1;
	    
	    for(int i:arr) {
	        prod *= i;
	        if(i == 0) {
	            zeroPresent = true;
	            prod = 1;
	            continue;
	        }
	        maxLeft = Math.max(maxLeft,prod);
	    }
	    
	    prod = 1;
	    
	    for(int j=arr.length-1;j>=0;j--) {
	        prod *= arr[j];
	        if(arr[j] == 0) {
	            zeroPresent = true;
	            prod = 1;
	            continue;
	        }
	        maxRight = Math.max(maxRight,prod);
	    }
	    
	    if(zeroPresent) return Math.max(Math.max(maxLeft,maxRight),0);
	    return Math.max(maxLeft,maxRight);
    }
}