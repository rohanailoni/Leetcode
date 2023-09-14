func findItinerary(tickets [][]string) []string {
    var unique map[string]int;
    unique=make(map[string]int);
    occurance:=make(map[string]int);
    //m:=len(tickets);
    for _, row := range tickets {
        for _, value := range row {
            unique[value]=1;
        }
        x:=row[0]+row[1]
        if _,ok:=occurance[x];ok{
            occurance[x]=occurance[x]+1;
        }else{
            occurance[x]=1;
        }
        
    }
    placearr:=make([]string,0);
    for key,_:=range unique{
        placearr=append(placearr,key);
    }
    
    
    sort.Strings(placearr)
    
    
    for index,value:=range placearr{
        unique[value]=index;
    }
    
    n:=len(placearr);
    
    visited := make([][]int,n);
    for i := range visited {
        visited[i] = make([]int, n)
    }
    for _,row:=range tickets{
        visited[unique[row[0]]][unique[row[1]]]=occurance[row[0]+row[1]];
    }
    ans:=make([]string,0);
    var dfs func(terminal string)bool;
    var check func()bool;
    visitedcopy:=deepCopy2DArray(visited)
    dfs=func(terminal string)bool{
        
        
        index:=unique[terminal];
        //fmt.Println(index);
        for i:=0;i<n;i++{
            if i!=index && visited[index][i]>=1{
                visited[index][i]-=1;
                if visited[index][i]==0{
                    visited[index][i]=-1;
                }
                ans=append(ans,placearr[i]);
                //fmt.Println("check",ans,visited)
                if dfs(placearr[i]){
                    
                    return true;
                }
                if visited[index][i]==-1{
                    visited[index][i]=0;
                }
                ans=ans[:len(ans)-1];
                visited[index][i]+=1;
            }
        }
        //fmt.Println(visited,check())
        return check();
        
    }
    check=func()bool{
        for i:=0;i<n;i++{
            for j:=0;j<n;j++{
                if visitedcopy[i][j]>=1{
                    if visited[i][j]!=-1{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //fmt.Println(visited,unique,placearr);
    ans=append(ans,"JFK");
    dfs("JFK");
    return ans;
}
func deepCopy2DArray(original [][]int) [][]int {
    // Get the dimensions of the original 2D array
    numRows := len(original)
    numCols := len(original[0]) // Assuming all rows have the same number of columns

    // Create a new 2D array with the same dimensions
    copyArray := make([][]int, numRows)
    for i := range copyArray {
        copyArray[i] = make([]int, numCols)
    }

    // Copy the elements from the original array to the new array
    for i := 0; i < numRows; i++ {
        for j := 0; j < numCols; j++ {
            copyArray[i][j] = original[i][j]
        }
    }

    return copyArray
}
//["JFK","ANU","EZE","AXA","TIA","ANU","JFK","TIA","ANU","TIA","JFK"]
// [JFK ANU EZE AXA TIA ANU JFK TIA ANU TIA JFK]