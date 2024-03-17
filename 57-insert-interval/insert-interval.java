class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> list = new ArrayList<>();
        for(int array[] : intervals){
            list.add(array);
        }
        list.add(newInterval);
        Collections.sort(list,(a,b)->a[0]-b[0]);
        LinkedList<int []> res = new LinkedList<>();
        int size = list.size();
        int inserted = 0;
        res.add(list.get(0));
        for(int i=1;i<size;i++){
            if(res.peekLast()[1] >= list.get(i)[0]){
                res.peekLast()[1] = Math.max(list.get(i)[1],res.peekLast()[1]);
            }
            else{
                res.add(list.get(i));
            }
        }
        int k = 0;
        int result[][] = new int[res.size()][];
        for(int [] array : res){
            result[k++] = array;
        }
        return result;
    }
}