class Solution {
    static final int ALPHABET_SIZE = 26;
     
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
     
        boolean isEndOfWord;
        long count = 0;
         
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
      
    static TrieNode root; 
    static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
        }
        pCrawl.count++;
        pCrawl.isEndOfWord = true;
    }
      
    static long search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        StringBuilder sb = new StringBuilder();
        long ans = 0;
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            sb.append(key.charAt(level));
            if (pCrawl.children[index] == null){
                return ans;
            }
            pCrawl = pCrawl.children[index];
            if(pCrawl.isEndOfWord && key.endsWith(sb.toString())){
                ans = ans + pCrawl.count;
            }
        }
        return ans;
    }
    public long countPrefixSuffixPairs(String[] words) {
        root = new TrieNode();
        long ans = 0;
        for(int i = 0 ; i < words.length ; i++){
            ans = ans + search(words[i]);
            insert(words[i]);
        }
        return ans;
    }
}