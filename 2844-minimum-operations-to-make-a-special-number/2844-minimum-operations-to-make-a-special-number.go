// func minimumOperations(num string) int {
// //     var dfs func(num string,i int,n int)(int,bool);
// //     dfs=func(num string,i int,n int)(int,bool){
// //         if num=="" && len(num)==0{
// //             return 0,true;
// //         }
// //         if i==n{
// //             if divi(num){
// //                 return 0,true;
// //             }
// //             return 1000,false;
// //         }
// //         //remove a element;
// //         fmt.Println(num,i)
// //         x1,status1:=dfs(num[:i]+num[i+1:],i+1,n);
// //         //dont remove the element
// //         x2,status2:=dfs(num,i+1,n);
        
// //         if status1==false && status2==false{
// //             return 1000,false;
// //         }else if status1==true && status2==true{
// //             return min(x1+1,x2),true;
// //         }else if status1==true && status2==false{
// //             return x1+1,true;
// //         }else{
// //             return x2,true;
// //         }
        
        
// //     }
//     //ans,_:=dfs(num,0,len(num));
//     n:=len(num);
//     mini:=101;
//     for i := 0; i < n; i++ {
//         for j := i + 1; j < n; j++ { 
//             s := string(num[i]) + string(num[j])
//             //fmt.Println(s,num[i],num[j],i,j);
//             //sStr := strconv.Itoa(int(s)) // Convert s to string
//             aa, _ := strconv.Atoi(s)
            
//             if aa < 2 {
//                 continue
//             }
            
//             if aa%25 == 0 {
//                 //fmt.Println(mini,(j-i-1)+(n-j-1),i,j,n,aa)
//                 mini = min(mini, (j-i-1)+(n-j-1)) 
//             }
//         }
//     }
//     if mini==101{
//         return len(num)
//     }
//     return mini;
// }


// func divi(num string)bool{
//     if len(num)<2{
//         return false;
//     }
//     n,_:=strconv.Atoi(num[len(num)-2:]);
//     if n==0{
//         return true;
//     }
//     if n%25==0{
//         return true;
//     }
//     return false;
    
// }
// func min(a,b int)int{
//     if a<b{
//         return a;
//     }
//     return b;
// }
var dp [][25]int

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func fn(ind, num int, s string) int {
	if ind == len(s) {
		if num%25 == 0 {
			return 0
		}
		return math.MaxInt32
	}
	if dp[ind][num] != -1 {
		return dp[ind][num]
	}

	digit := int(s[ind] - '0')
	nonPick := 1 + fn(ind+1, num, s)
	pick := fn(ind+1, (num*10+digit)%25, s)

	dp[ind][num] = min(pick, nonPick)
	return dp[ind][num]
}

func minimumOperations(num string) int {
	dp = make([][25]int, len(num))
	for i := range dp {
		for j := range dp[i] {
			dp[i][j] = -1
		}
	}

	return fn(0, 0, num)
}








