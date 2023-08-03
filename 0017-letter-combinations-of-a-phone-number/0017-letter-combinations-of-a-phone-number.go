func letterCombinations(digits string) []string {
    if len(digits)==0{
        return []string{};
    }

    var ans []string;
    var cacher map[string]bool;

    memory := map[byte]string{
        '2': "abc",
        '3': "def",
        '4': "ghi",
        '5': "jkl",
        '6': "mno",
        '7': "pqrs",
        '8': "tuv",
        '9': "wxyz",
    }
    cacher=make(map[string]bool,0);
    ans=make([]string,0)

    n:=len(digits);
    var dfs func(digits string,index int,cache string);

    dfs = func(digits string,index int,cache string){
        if index==n{
            if _,ok:=cacher[cache];!ok{
                ans=append(ans,cache);
                cacher[cache]=true;
            }
            
            return ;
        }
        req:= memory[digits[index]];
        nx:=len(req);
        for i:=0;i<nx;i++{
            cache=cache+string(req[i]);
            dfs(digits,index+1,cache);
            cache=cache[:len(cache)-1];
        }

    }
    dfs(digits,0,"");
    return ans;
}