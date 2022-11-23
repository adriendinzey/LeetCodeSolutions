# The most popular leetcode question out there, I used an O(N) time and O(N) space solution that creates a hashmap 
#that stores the difference between a previously seen number and the target.
# It does this after checking if the number we are looking at could be used with a previous number seen to sum to the target and if not it adds that difference to the map
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d={}
        for i in range(len(nums)):
            if nums[i] in d.keys():
                return i,d[nums[i]]
            else:
                d[target-nums[i]]=i
