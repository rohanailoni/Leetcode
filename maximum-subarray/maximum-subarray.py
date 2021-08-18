class Solution:
    def maxSubArraySum(self,a,size):
     
        max_so_far =a[0]
        curr_max = a[0]

        for i in range(1,size):
            curr_max = max(a[i], curr_max + a[i])
            max_so_far = max(max_so_far,curr_max)

        return max_so_far
    def maxSubArray(self, nums: List[int]) -> int:
        # le=len(nums)
        # maxim=-10**5-1
        # dp=[[0 for i in range (0,le)] for i in range (0,le)]
        # for i in range(le):
        #     dp[i][i]=nums[i]
        #     if dp[i][i]>maxim:
        #         maxim=dp[i][i]
        # for i in range(1,le):
        #     dp[0][i]=dp[0][i-1]+nums[i]
        #     if dp[0][i]>maxim:
        #         maxim=dp[0][i]
        # for i in range(1,le):
        #     for j in range(i+1,le):
        #         dp[i][j]=dp[i-1][j]-nums[i-1]
        #         if dp[i][j]>maxim:
        #             maxim=dp[i][j]
                  
        return self.maxSubArraySum(nums,len(nums))