class Solution {
    public String customSortString(String order, String s) {
        int hash[] = new int[26];
        Arrays.fill(hash,26);
        for(int i = 0; i < order.length() ; i++){
            int key = order.charAt(i) - 'a';
            hash[key] = i;
        }
        Character arr[] = new Character[s.length()];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr,(a,b)->{
            int key_a = a - 'a';
            int key_b = b - 'a';
            return Integer.compare(hash[key_a],hash[key_b]);
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length ; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}