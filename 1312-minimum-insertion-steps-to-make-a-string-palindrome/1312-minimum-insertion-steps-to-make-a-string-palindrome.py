class Solution:
    def minInsertions(self, s: str) -> int:
        n=len(s)
        dp=[[0]*(n+1) for i in range(n+1)]
        for i in range(n):
            dp[i][i]=0
        for i in range(n-1):
            temp=1
            if(s[i]==s[i+1]):
                temp=0
            dp[i][i+1]=temp
        
        for diff in range(2,n):
            for start in range(0,n-diff):
                i=start
                j=diff+start
                temp=100000
                if(s[i]==s[j]):
                    temp=dp[i+1][j-1]
                dp[i][j]=min(temp,min(dp[i+1][j]+1,dp[i][j-1]+1))
        #print(dp)
        return dp[0][len(s)-1]
        