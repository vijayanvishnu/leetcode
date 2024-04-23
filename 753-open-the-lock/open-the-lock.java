class Solution {
    public class T {
	int nums[];
	public T(int... nums) {
		this();
        for(int i = 0 ; i < nums.length ; i++){
            this.nums[i] = nums[i];
        }
	}
	public T() {
        nums = new int[4];
	}
	@Override
	public boolean equals(Object obj) {
		T tobj = (T) obj;
		boolean res = true;
		for(int i = 0 ; i < tobj.nums.length ; i++) {
			res = res && tobj.nums[i] == nums[i];
		}
		return res;
	}
	@Override
	public int hashCode() {
		int hash = 0;
		int i = 0;
		while(i < nums.length) {
			hash = hash * 10 + nums[i];
			i++;
		}
		return hash;
        }
    }
    public int openLock(String[] deadends, String target) {
        T res = new T(target.charAt(0) - '0' , target.charAt(1) - '0' , target.charAt(2) - '0' , target.charAt(3) - '0');
        Set<T> set = new HashSet<>();
        for(String i : deadends){
            set.add(new T(new int[]{i.charAt(0) - '0' , i.charAt(1) - '0' , i.charAt(2)  - '0' , i.charAt(3) - '0'}));
        }
        if(set.contains(new T(0,0,0,0))) return -1;
        int dir[] = new int[]{-1,1};
        Queue<T> queue = new LinkedList<>();
        queue.add(new T(new int[]{0,0,0,0}));
        int op = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                T poll = queue.poll();
                if(res.equals(poll)){
                    return op;
                }
                int nums[] = poll.nums;
                for(int i = 0 ; i < nums.length ; i++){
                    for(int j = 0; j < dir.length ; j++){
                        int t = nums[i];
                        nums[i] = nums[i] + dir[j];
                        nums[i] = nums[i] + 10;
                        nums[i] = nums[i] % 10;
                        T currObj = new T(nums);
                        if(!set.contains(currObj)){
                            set.add(currObj);
                            queue.add(currObj);
                        }
                        nums[i] = t;
                    }
                }
            }
            op++;
        }
        return -1;
    }
}