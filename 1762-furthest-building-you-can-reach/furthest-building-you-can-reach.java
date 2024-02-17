class Solution {
    public int furthestBuilding(int nums[],int bricks , int ladder) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int i = 1;
		while(i < nums.length) {
			int diff = nums[i] - nums[i-1];
			if(diff <= 0) {
				i++;
				continue;
			}
			q.add(diff);
			if(q.size() > ladder) {
				bricks -= q.poll();
				if(bricks < 0) {
					return i - 1;
				}
			}
			i++;
		}
		return nums.length - 1;
	}
}