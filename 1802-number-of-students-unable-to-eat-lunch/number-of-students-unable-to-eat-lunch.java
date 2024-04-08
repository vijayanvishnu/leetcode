class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> st = new LinkedList<>();
        for(int i: students){
            st.add(i);
        }
        for(int i = 0 ; i < sandwiches.length ; i++){
            int rot = 0;
            int size = st.size();
            while(rot < size){
                if(st.peekFirst() == sandwiches[i]){
                    st.pollFirst();
                    break;
                }else{
                    st.add(st.pollFirst());
                }
                rot++;
            }
            if(rot == size) break;
        }
        return st.size();
    }
}