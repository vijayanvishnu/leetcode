class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        s = s.replace("  "," ");
        String str[] = s.split(" ");
        return str[str.length - 1].length();
    }
}