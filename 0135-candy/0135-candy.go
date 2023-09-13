func candy(arr []int) int {
    n:=len(arr);
    var ans []int;
    ans=make([]int,n);
    for i:=0;i<n;i++{
        ans[i]=1;
    }
    for i:=1;i<n;i++{
        if arr[i]>arr[i-1]{
            ans[i]=ans[i-1]+1;
        }
    }
    for i:=n-1;i>0;i--{
        if arr[i-1]>arr[i]{
            ans[i-1]=max(ans[i]+1,ans[i-1]);
        }
    }
    return sum(ans);
}

func sum(arr []int)int{
    ans:=0;
    for i:=0;i<len(arr);i++{
        ans+=arr[i];
    }
    return ans;
}
func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
