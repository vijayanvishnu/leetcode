class Solution {
    Set<String> set = null;
    List<String> res = null;
    List<String> list = null;
    private void helper(int idx,String str){
        if(idx == str.length()){
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            for(int i=1;i<list.size();i++){
                sb.append(" ");
                sb.append(list.get(i));
            }
            res.add(sb.toString());
        }
        for(int i=idx;i<str.length();i++){
            String s = str.substring(idx,i+1);
            if(set.contains(s)){
                list.add(s);
                helper(i+1,str);
                list.remove(list.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        res = new ArrayList<>();
        list = new ArrayList<>();
        for(String i : wordDict){
            set.add(i);
        }
        helper(0,s);
        return res;
    }
}