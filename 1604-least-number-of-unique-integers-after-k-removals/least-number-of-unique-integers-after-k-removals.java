class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int itr : arr){
            map.put(itr,map.getOrDefault(itr,0)+1);
        }
        Object object_arr[] = map.values().toArray();
        Integer integer_arr[] = new Integer[object_arr.length];
        for(int i=0;i<object_arr.length;i++){
            integer_arr[i] = (Integer) object_arr[i];
        }
        int cnt = 0;
        Arrays.sort(integer_arr);
        for(int i=0;i<integer_arr.length;i++){
            int min = Math.min(integer_arr[i],k);
            k-=min;
            integer_arr[i]-=min;
            if(integer_arr[i]>=1) cnt++;
        }
        return cnt;
    }
}