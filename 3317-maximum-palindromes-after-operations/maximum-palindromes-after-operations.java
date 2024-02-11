class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int hash[] = new int[26];
        int res = 0;
        for(int i = 0; i < words.length ; i++){
            for(char itr : words[i].toCharArray()){
                hash[itr - 'a']++;
            }
            q.add(words[i].length());
        }
        int even = 0;
        int odd = 0;
        for(int i = 0 ; i < 26 ; i++){
            if((hash[i] & 1) == 1){
                odd = odd + 1;
                even = even + hash[i] - 1;
            }else{
                even = even + hash[i];
            }
        }
        while(!q.isEmpty()){
            int poll = q.poll();
            if((poll & 1) == 1){
                if(odd > 0){
                    odd--;
                    if(even >= poll - 1){
                        even -= poll - 1;
                        res++;
                    }
                }else{
                    if(even > poll){
                        res++;
                        even -= poll - 1;
                        odd++;
                    }
                }
            }else{
                if(even >= poll){
                    even -= poll;
                    res++;
                }
            }
        }
        return res;
    }
}