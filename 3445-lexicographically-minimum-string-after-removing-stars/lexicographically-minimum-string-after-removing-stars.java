class Solution {
    public String clearStars(String s) {
        Map<Character,LinkedList<Integer>> fq = new HashMap<>();
        for(char i = 'a' ; i <= 'z' ; i++){
            fq.put(i,new LinkedList<>());
        }
        int size = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char key = s.charAt(i);
            if(key == '*'){
                size--;
                boolean found = false;
                for(char j = 'a'  ; j <= 'z' ; j++){
                    if(fq.get(j).size() > 0){
                        found = true;
                        fq.get(j).pollLast();
                    }
                    if(found){
                        break;
                    }
                }
            }else{
                size++;
                fq.get(key).add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(size > 0){
            char minIdx = '-';
            for(char i =  'a' ; i <= 'z' ; i++){
                if(fq.get(i).size() > 0){
                    if(minIdx == '-'){
                        minIdx = i;
                    }else{
                        if(fq.get(minIdx).getFirst() > fq.get(i).getFirst()){
                            minIdx = i;
                        }
                    }
                }
            }
            sb.append(s.charAt(fq.get(minIdx).pollFirst()));
            size--;
        }
        return sb.toString();
    }
}