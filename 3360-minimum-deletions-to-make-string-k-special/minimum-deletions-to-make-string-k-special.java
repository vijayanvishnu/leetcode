class Solution {
    public int minimumDeletions(String word, int k) {
        int hash[] = new int[26];
        for(int i = 0 ; i < word.length() ; i++){
            int key = word.charAt(i) - 'a';
            hash[key]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;  i < 26 ; i++){
            if(hash[i] != 0){
                list.add(hash[i]);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        int ans = word.length();
        for(int i = 0 ; i < list.size() ; i++){
            int l = i;
            int r = i + 1;
            while(l > -1 && list.get(i) - list.get(l) <= k){
                l--;
            }
            int curr = 0;
            while(l > -1){
                curr = curr + list.get(l);
                l--;
            }
            while(r < list.size()){
                curr = curr + list.get(r) - list.get(i);
                r++;
            }
            ans = Math.min(ans,curr);
        }
        for(int i = 0 ; i < list.size() ; i++){
            int l = i - 1;
            int r = i;
            while(r < list.size() && list.get(r) - list.get(i) <= k){
                r++;
            }
            int curr = 0;
            while(l > -1){
                curr = curr + list.get(l);
                l--;
            }
            while(r < list.size()){
                curr = curr + list.get(r) - list.get(i) - k;
                r++;
            }
            ans = Math.min(ans,curr);
        }
        return ans;
    }
}