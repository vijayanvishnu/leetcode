class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String itr : strs){
            int hash[] = new int[26];
            char arr[] = itr.toCharArray();
            for(char citr : arr){
                hash[citr-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(hash[i]+":");
            }
            String hashedString = sb.toString();
            if(map.containsKey(hashedString)){
                map.get(hashedString).add(itr);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(itr);
                map.put(hashedString,list);
            }
        }
        return  new ArrayList(map.values());
    }
}