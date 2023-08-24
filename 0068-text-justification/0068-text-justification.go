func fullJustify(words []string, maxWidth int) []string {
    n:=len(words);
    var possible func(i,j int)(bool,int);
    var dis map[string]int;
    var ans []string;
    var dfs func(i int);
    var attach func(i,k int)string;
    dis=make(map[string]int,0);
    
    possible=func(i,j int)(bool,int){
        sum:=0;
        for k:=i;k<=j;k++ {
            sum+=dis[words[k]];
        }
        sum+=(j-i);
        if sum>maxWidth{
            return false,0;
        }
        return true,sum;
    }
    for i:=0;i<n;i++{
        dis[words[i]]=len(words[i]);
    }
    attach=func(i,k int)string{
        ans:="";
        for i:=i;i<=k;i++{
            ans+=words[i];
        }
        return ans;
    }
    dfs=func(i int){
        for k:=n-1;k>=i;k-- {
            if bo,sum:=possible(i,k);bo {
                x:=(k-i)
                for a:=i;a<k;a++{
                    words[a]+=" ";
                }
                diff:=maxWidth-sum;
                counter:=0;
                for diff>0 && x!=0 && k!=n-1{
                    words[(counter%x)+i]+=" ";
                    diff--;
                    counter++;
                    //fmt.Println(temp,"yo")
                }
                
                
               
                if x==0||k==n-1{
                   words[k]+=strings.Repeat(" ", diff)
                    
                }
                //temp=append(temp,tempword);
                ans=append(ans,attach(i,k));
                dfs(k+1);
                break;
            }
        }
    }
    dfs(0);
    return ans;
    
}