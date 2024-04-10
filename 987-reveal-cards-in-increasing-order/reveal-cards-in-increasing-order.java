class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int in = 0;
        int i = 0;
        int ans[] = new int[deck.length];
        int c = 1;
        while(in < deck.length){
            if(ans[i] == 0){
                c++;
                if(c == 2){
                    c = 0;
                    ans[i] = deck[in];
                    in++;
                }
            }
            i++;
            i = i % deck.length;
        }
        return ans;
    }
}