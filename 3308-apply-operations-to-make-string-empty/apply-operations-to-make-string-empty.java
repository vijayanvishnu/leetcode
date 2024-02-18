class Solution {
    public String lastNonEmptyString(String s) {
        int hash[] = new int[26];
        int last[] = new int[26];
        int max = 0;
        for(int i = 0; i < s.length() ; i++){
            int key = s.charAt(i) - 'a';
            hash[key]++;
            max = Math.max(max,hash[key]);
            last[key] = i;
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 26;i++){
            if(hash[i] == max){
                list.add(last[i]);
            }
        }
        Collections.sort(list);
        for(int i = 0; i < list.size() ; i++){
            sb.append(s.charAt(list.get(i)));
        }
        return sb.toString();
    }
}