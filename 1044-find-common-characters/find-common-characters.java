class Solution {
    public List<String> commonChars(String[] words) {
        int hash[] = new int[26];
        Arrays.fill(hash,101);
        for(int i = 0 ; i < words.length ; i++){
            int curr[] = new int[26];
            for(char j : words[i].toCharArray()){
                int key = j - 'a';
                curr[key]++;
            }
            for(int j = 0 ; j < 26 ; j++){
                hash[j] = Math.min(hash[j],curr[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i < 26 ; i++){
            while(hash[i]-->0){
                String curr = "" + (char)(i + 'a');
                ans.add(curr);
            }
        }
        return ans;
    }
}