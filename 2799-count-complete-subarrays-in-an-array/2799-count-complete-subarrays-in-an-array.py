class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        n = len(set(nums))
        cou={}
        left,t=0,0
        for r,num in enumerate(nums):
            if num not in cou:
                cou[num]=1
            else:
                cou[num]+=1
            while len(cou)==n:
                t+=len(nums)-r
                cou[nums[left]]-=1
                if cou[nums[left]]==0:
                    del cou[nums[left]]
                left+=1
        return t
        
        