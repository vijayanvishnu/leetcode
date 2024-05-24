class Solution {
    private int helper(int idx,String words[],int freq[] , int score[]){
        if(idx == words.length){
            return 0;
        }
        boolean possible = true;
        int scr = 0;
        for(int i = 0; i < words[idx].length() ; i++){
            int key = words[idx].charAt(i) - 'a';
            scr = scr + score[key];
            freq[key]--;
            if(freq[key] < 0){
                possible = false;
            }
        }
        int ans = 0;
        if(possible){
            ans = scr + helper(idx + 1, words , freq , score); 
        }
        for(int i = 0; i < words[idx].length() ; i++){
            int key = words[idx].charAt(i) - 'a';
            freq[key]++;
        }
        ans = Math.max(ans,helper(idx + 1 , words , freq , score));
        return ans;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int[26];
        for(char i : letters){
            int key = i - 'a';
            freq[key]++;
        }
        int ans = helper(0,words,freq,score);
        return ans;
    }
}