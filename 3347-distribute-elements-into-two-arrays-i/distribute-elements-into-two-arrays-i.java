class Solution {
    private int getLast(ArrayList<Integer> nums){
        return nums.get(nums.size() - 1);
    }
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i = 2 ; i < nums.length ; i++){
            int last_1= getLast(arr1);
            int last_2= getLast(arr2);
            if(last_1 > last_2){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }
        int in = 0;
        for(int i : arr1){
            nums[in++] = i;
        }
        for(int i : arr2){
            nums[in++] = i;
        }
        return nums;
    }
}