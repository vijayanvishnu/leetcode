class Solution {
    public String getHint(String secret, String guess) {
        int cmn = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0 ; i < secret.length() ; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                cmn++;
            }else{
                map.putIfAbsent(secret.charAt(i) , 0);
                map.put(secret.charAt(i) , map.get(secret.charAt(i)) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cmn);
        cmn = 0;
        sb.append("A");
        for(int i =0 ; i < secret.length() ; i++){
            if(secret.charAt(i) != guess.charAt(i)){
                if( map.containsKey(guess.charAt(i))  && map.get(guess.charAt(i)) > 0){
                    cmn++;
                    map.put(guess.charAt(i) , map.get(guess.charAt(i)) - 1 );
                }
            }
        }
        sb.append(cmn);
        sb.append("B");
        return sb.toString();
    }
}