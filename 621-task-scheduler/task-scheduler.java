class Solution {
    public int leastInterval(char[] tasks, int n) {
        int hash[] = new int[26];
        for(int i = 0 ; i < tasks.length ; i++){
            int k = tasks[i] - 'A';
            hash[k]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0 ; i < 26 ; i++){
            if(hash[i] != 0)
            q.add(hash[i]);
        }
        int ans = 0;
        while(q.size() > 0){
            int t = n + 1;
            List<Integer> list = new ArrayList<>();
            while(t > 0){
                if(q.size() == 0){
                    if(list.size() != 0)
                    ans = ans + t;
                    break;
                }
                int tt = q.poll();
                if(tt > 1){
                    list.add(tt-1);
                }
                t--;
                ans++;
            }
            for(int i : list){
                q.add(i);
            }
        }
        return ans;
    }
}