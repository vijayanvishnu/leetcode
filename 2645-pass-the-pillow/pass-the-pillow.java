class Solution {
    public int passThePillow(int n, int time) {
        int down = time % (n - 1);
        int div = time / (n - 1);
        if((div & 1) == 1){
            return n - down;
        }else{
            return down + 1;
        }
    }
}