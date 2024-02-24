class Solution {
    int unionFind[];
    private int find(int idx){
        if(idx == unionFind[idx]){
            return idx;
        }
        return unionFind[idx] = find(unionFind[idx]);
    }
    private void union(int idxA , int idxB){
        int prnt_a = find(idxA);
        int prnt_b = find(idxB);
        if(prnt_b > prnt_a){
            unionFind[prnt_b] = prnt_a;
        }else{
            unionFind[prnt_a] = prnt_b;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        unionFind = new int[n];
        Arrays.sort(meetings , (a,b) -> a[2] - b[2]);
        for(int i = 0; i < n ; i++){
            unionFind[i] = i;
        }
        int i = 0;
        union(0,firstPerson);
        while(i < meetings.length){
            int ref = meetings[i][2];
            Set<Integer> set = new HashSet<>();
            while(i < meetings.length && meetings[i][2] == ref){
                int min = Math.min(meetings[i][0] , meetings[i][1]);
                int max = Math.max(meetings[i][0] , meetings[i][1]);
                union(min , max);
                set.add(meetings[i][0]);
                set.add(meetings[i][1]);
                i++;
            }
            for(int j : set){
                if(find(j) != 0){
                    unionFind[j] = j;
                }
            }
        }
        for(i = 0 ; i < n ; i++){
            if(find(i) == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}