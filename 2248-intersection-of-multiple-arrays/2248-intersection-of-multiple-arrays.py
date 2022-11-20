class Solution:
    def intersection(self, nums: List[List[int]]) -> List[int]:
        n=len(nums)
        dp=[[0 for i in range(1001)] for j in range(1001)]
        for i in range(n):
            for j in nums[i]:
                dp[i][j]+=1
        ans=[]
        for i in range(1001):
            sum=0;
            for j in range(n):
                sum+=dp[j][i]
            if sum==n:
                ans.append(i)
        return ans;
                
                
        
        