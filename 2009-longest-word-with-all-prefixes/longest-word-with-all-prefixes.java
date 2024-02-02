class Solution {
    String ans = null;
    class Trie{
        Trie child[] = new Trie[26];
        boolean end = false;
        Trie(){};
        public void insert(char str[],int idx){
            if(idx == str.length){
                this.end = true;
                return;
            }
            int key = str[idx] - 'a';
            if(child[key] == null){
                child[key] = new Trie();
            }
            child[key].insert(str,idx+1);
        }
    }
    private void display(Trie trie,StringBuilder sb,boolean found){
        if(trie == null){
            return;
        }
        if(trie.end){
            if(ans.length() < sb.length() && found){
                ans = sb.toString();
            }
        }else{
            return;
        }
        for(int i = 0 ; i < 26 ; i++){
            sb.append((char)('a' + i));
            display(trie.child[i], sb,found);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public String longestWord(String[] words) {
        ans = "";
        Trie trie = new Trie();
        trie.end = true;
        for(String i : words){
            trie.insert(i.toCharArray(), 0);
        }
        display(trie,new StringBuilder(),true);
        return ans;
    }
}