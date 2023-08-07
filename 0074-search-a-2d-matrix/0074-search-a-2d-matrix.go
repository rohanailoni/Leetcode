func searchMatrix(matrix [][]int, target int) bool {
    m:=len(matrix);
    n:=len(matrix[0]);
    var bs func(i,j,req int)bool;



    bs=func(i,j,req int)bool{
        bottom:=i;
        top:=j;

        for bottom<top{
            mid:=bottom+((top-bottom)/2);
            if matrix[req][mid]==target{
                return true;
            }else if matrix[req][mid]>target{
                top=mid;
            }else{
                bottom=mid+1;
            }
        }
        return false;

    }
    for i:=0;i<m;i++{
        if matrix[i][0]<=target && matrix[i][n-1]>=target{
            return bs(0,n,i);
        }
    }
    return false;
}