class Solution {
    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer,Integer> values = new TreeMap<>();
        for(int i = 0 ; i < score.length ; i++){
            values.put(score[i],i);
        }
        String res[] = new String[score.length];
        int pos = score.length;
        for(Map.Entry<Integer,Integer> entry : values.entrySet()){
            String currAns;
            if(pos > 3){
                currAns = "" + pos;
            }else{
                if(pos == 1){
                    currAns = "Gold";
                }else if(pos == 2){
                    currAns = "Silver";
                }else{
                    currAns = "Bronze";
                }
                currAns = currAns + " Medal";
            }
            res[entry.getValue()] = currAns;
            pos--;
        }
        return res;
    }
}