class Solution {
    private void minusPres(int hash[],String num){
        for(char s : num.toCharArray()){
            int idx = s - 'a';
            hash[idx]--;
        }
    }
    public String originalDigits(String s) {
        int hash[] = new int[26];
        int size = s.length();
        for(char i : s.toCharArray()){
            int idx = i - 'a';
            hash[idx]++;
        }
        int ans[] = new int[10];
        while(hash[25] > 0){
            minusPres(hash,"zero");
            ans[0]++;
        }
        int key = 'x' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"six");
            ans[6]++;
        }
        key = 'w' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"two");
            ans[2]++;
        }
        key = 's' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"seven");
            ans[7]++;
        }
        key = 'v' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"five");
            ans[5]++;
        }
        key = 'f' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"four");
            ans[4]++;
        }
        key = 'g' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"eight");
            ans[8]++;
        }
        key = 'h' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"three");
            ans[3]++;
        }
        key = 'o' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"one");
            ans[1]++;
        }
        key = 'n' - 'a';
        while(hash[key] > 0){
            minusPres(hash,"nine");
            ans[9]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < ans[i] ; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}