class Solution {
    public String minimizeStringValue(String s) {
        int hash[] = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != '?'){
                int key = s.charAt(i) - 'a';
                hash[key]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '?'){
                int min = 0;
                for(int j = 0 ; j < 26 ; j++){
                    if(hash[min] > hash[j]){
                        min = j;
                    }
                }
                list.add(min);
                hash[min]++;
            }
        }
        Collections.sort(list);
        int in = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '?'){
                sb.append((char)(list.get(in++) + 'a'));
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}