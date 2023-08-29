func bestClosingTime(customers string) int {
    n := len(customers)
    //prefixY := make([]int, n)
    prefixN := make([]int, n)
    
    if customers[0] == 'Y' {
        //prefixY[0] = 1
        prefixN[0] = 0
    } else {
        //prefixY[0] = 0
        prefixN[0] = 1
    }
    
    for i := 1; i < n; i++ {
        if customers[i] == 'Y' {
            //prefixY[i] = prefixY[i-1] + 1
            prefixN[i] = prefixN[i-1]
        } else {
            prefixN[i] = prefixN[i-1] + 1
            //prefixY[i] = prefixY[i-1]
        }
    }
    
    ans := 1e9
    minpen := 0
    
    for i := 0; i <= n; i++ {
        var temp int;
        if i>0 && i!=n{
            //temp = prefixN[i-1] + (prefixY[n-1] - prefixY[i-1]);
            temp=prefixN[i-1]+(n-i-(prefixN[n-1]-prefixN[i-1]));
        }else{
            //temp=prefixY[n-1]
            temp=n-prefixN[n-1];
        }
        if i==n{
            temp=prefixN[n-1];
            //temp=prefixY[]
        }
        //fmt.Println(temp)
        if ans > float64(temp) {
            ans = float64(temp)
            minpen = i
        }
    }
    
    return minpen
}
