class Solution:
    def minimumString(self, a: str, b: str, c: str) -> str:
        all_strings = list(permutations([a, b, c]))

        def fuse_strings(a, b):
            if b in a:
                return a
            n=len(a)
            for i in range(n):
                diff=n-i;
                if a[i:n]==b[:diff]:
                    return a[:i]+b
            return a+b
            
        ans=[]
        # print(fuse_strings("cab","a"))
        # print(fuse_strings(fuse_strings("cab","a"),"b"))
        for perm in all_strings:
            a,b,c=perm
            
            ans.append(fuse_strings(fuse_strings(a,b),c))
        l=float('inf')
        res=""
        #print(ans)
        for i in ans:
            if len(i)<l:
                res,l=i,len(i)
            elif  len(i)==l:
                res=min(res,i)

        return res


        
        