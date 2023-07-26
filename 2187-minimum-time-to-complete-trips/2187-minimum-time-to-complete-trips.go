func minimumTime(time []int, totalTrips int) int64 {
    total:=findMax(time);
    n:=len(time);
    ans:=1
    low:=1;
    high:=total*totalTrips;
    for low<=high{
        mid:=low+(high-low)/2;
        if calc(time,n,mid)>=totalTrips{
            ans=mid; 
            high=mid-1;

        }else{
            low=mid+1;
        }
    }
    return int64(ans);
}
func calc(time []int,n int,k int)(int){
    total:=0;
    for i:=0;i<n;i++{
        total+=k/time[i]

    }
    return total;
}
func findMax(arr []int) int {
    if len(arr) == 0 {
        return 0 // Return a default value or handle the empty array case as needed
    }

    max := arr[0] // Assume the first element as the maximum
    for _, num := range arr {
        if num > max {
            max = num // Update the maximum value if a larger element is found
        }
    }
    return max
}