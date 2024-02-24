class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // get index of meetings with same time together 
        Arrays.sort(meetings , (a,b)->Integer.compare(a[2],b[2]));
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        int i=0;
        int lastTime = meetings[i][2];
        while(i<meetings.length){
            if(meetings[i][2]==lastTime){
                l.add(i);
                i++;
            }
            else{
                ArrayList<Integer> r = new ArrayList<>();
                r.addAll(l);
                graph.add(r);
                l.clear();
                lastTime=meetings[i][2];
            }
        }
        graph.add(l);

        // DISJOINT SET
        djs(n);
        union(0,firstPerson);
        for(int j=0 ;j<graph.size() ; j++){
            HashSet<Integer> set = new HashSet<>();

            // union both person meeting at a time
            for(int e : graph.get(j)){
                int x = meetings[e][0];
                int y = meetings[e][1];
                union(x,y);
                set.add(x);
                set.add(y);
            }
            // reset person not knowing secret at a time
            for(int e: set){
                if(find(0)!=find(e)) reset(e);
            }
        }

        // return person who know secret
        List<Integer> list = new ArrayList<>();
        for(int j=0 ;j<n ; j++){
            if(find(0)==find(j)) list.add(j);
        }
        return list;
        
    }
    
    // union find
    int[] parent = new int [100000];
    void djs(int n){
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
        }
    }
    int find(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    boolean union(int u ,int v){
        u = find(u);
        v = find(v);
        if(u!=v){
            parent[u] = v;
            return true;
        }
        return false;
    }

    // reset function
    void reset(int node){
        parent[node] = node;
    }

}