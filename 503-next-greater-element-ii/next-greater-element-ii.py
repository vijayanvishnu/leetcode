class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        output = [-1]*(len(nums))
        for i in range(len(nums)):
            for j in range(1, len(nums)):
                if nums[(i + j) %  len(nums)] > nums[i]:
                    output[i] = (nums[(i + j) % len(nums)])
                    break
        return output
		