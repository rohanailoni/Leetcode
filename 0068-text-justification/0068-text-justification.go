func fullJustify(words []string, maxWidth int) []string {
    n:=len(words);
    var possible func(i,j int)(bool,int);
    var dis map[string]int;
    var ans []string;
    var dfs func(i int);
    var attach func(s []string)string;
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
    attach=func(s []string)string{
        x:=len(s);
        ans:="";
        for i:=0;i<x;i++{
            ans+=s[i];
        }
        return ans;
    }
    dfs=func(i int){
        for k:=n-1;k>=i;k-- {
            if bo,sum:=possible(i,k);bo {
                x:=(k-i)
                temp:=make([]string,(k-i)+1);
                o:=0
                for a:=i;a<k;a++{
                    temp[o]=words[a]+" ";
                    o++;
                }
                diff:=maxWidth-sum;
                //apper:="";
                //spaces:=k-i;
                //fmt.Println(diff,temp,x,k)
                counter:=0;
                if k==n-1{
                    
                }else{
                    for diff>0 && x!=0{
                        temp[counter%x]=temp[counter%x]+" ";
                        diff--;
                        counter++;
                        //fmt.Println(temp,"yo")
                    }
                }
                
                tempword:=words[k];
                if x==0||k==n-1{
                   
                    for oo:=0;oo<diff;oo++{
                        tempword=tempword+" ";
                    }
                }
                temp=append(temp,tempword);
                ans=append(ans,attach(temp));
                dfs(k+1);
                break;
            }
        }
    }
    dfs(0);
    return ans;
    
}