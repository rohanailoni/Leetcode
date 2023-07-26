func maximumCandies(candies []int, k int64) int {
    n:= len(candies);
    s:=sum(candies);
    req:=int(math.Ceil(float64(s)/float64(k)));
    low:=1;
    high:=req+1;
    ans:=int64(0)
    for low<high{
        mid:= (high+low)/2;
        got:=calc(mid,candies,n);
        //fmt.Println(low,high,mid,ans)
        if got>=k{
            ans=int64(mid);
            low=mid+1;
        }else{
            high=mid;
        }
    }
    return int(ans);   
}


func sum(can []int)(int){
    n:=len(can);
    ans:=0;
    for i:=0;i<n;i++{
        ans+=can[i];
    }
    return ans;
}
func calc(k int,can []int,len int)int64{
    total:=0;
    for i:=0;i<len;i++{
        rem:=can[i]/k;
        //fmt.Println("for get",k,rem)
        total+=rem;
    }
    return int64(total);
}