class Solution {
    static List<Integer> res = new ArrayList<>();
    static {
        for(int i = 2 ; i < 10 ; i++){
            for(int j = 1; j < 9 ; j++){
                StringBuilder sb = new StringBuilder();
                boolean add = true;
                for(int k = 0 ; k < i ; k ++){
                    if(k + j > 9) {
                        add = false;
                        break;
                    }
                    sb.append(k + j);
                }
                try{
                    if(add)
                    res.add(Integer.parseInt(sb.toString()));
                }catch(Exception e){}
            }
        }
    }
    private int binarySearch(int target){
        int left = 0;
        int right = res.size() -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == res.get(mid)){
                return mid;
            }
            else if(target > res.get(mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int l = binarySearch(low);
        int r = binarySearch(high);
        if(res.size() <= r || res.get(r) > high){
            r--;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = l ; i <= r ; i++){
            ans.add(res.get(i));
        }
        return ans;
    }
}