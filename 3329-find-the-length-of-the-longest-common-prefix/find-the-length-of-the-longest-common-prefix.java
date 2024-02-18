class Solution {
    static final int ALPHABET_SIZE = 10;
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // end of a word
        boolean isEndOfWord;
         
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
            index = key.charAt(level) - '0';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }
    static int search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - '0';
      
            if (pCrawl.children[index] == null)
                return level;
      
            pCrawl = pCrawl.children[index];
        }
      
        return length;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new TrieNode();
        for(int i = 0 ; i < arr2.length ; i++){
            insert(Integer.toString(arr2[i]));
        }
        int ans = 0;
        for(int i = 0; i < arr1.length ; i++){
            ans = Math.max(ans,search(Integer.toString(arr1[i])));
        }
        return ans;
    }
}