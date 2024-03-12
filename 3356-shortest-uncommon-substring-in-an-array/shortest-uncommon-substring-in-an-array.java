class Solution {
    public String[] shortestSubstrings(String[] arr) {
        Map<String,Integer> hash = new HashMap<>();
        String key = "";
        for(int i = 0; i < arr.length ; i++){
            for(int j= 0; j < arr[i].length() ; j ++){
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i].charAt(j));
                key = sb.toString();
                hash.putIfAbsent(key,0);
                hash.put(key,hash.get(key) + 1);
                for(int k =  j + 1 ; k < arr[i].length() ; k++){
                    sb.append(arr[i].charAt(k));
                    key = sb.toString();
                    hash.putIfAbsent(key,0);
                    hash.put(key,hash.get(key) + 1);
                }
            }
        }
        String ans [] = new String[arr.length];
        for(int i= 0; i < arr.length ; i++){
            int size = arr[i].length();
            Map<String,Integer> currHash = new HashMap<>();
            for(int j = 0 ; j < size;j++){
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i].charAt(j));
                key = sb.toString();
                currHash.putIfAbsent(key,0);
                currHash.put(key,currHash.get(key) + 1);
                for(int k =  j + 1 ; k < arr[i].length() ; k++){
                    sb.append(arr[i].charAt(k));
                    key = sb.toString();
                    currHash.putIfAbsent(key,0);
                    currHash.put(key,currHash.get(key) + 1);
                }
            }
            String ians = "";
            for(Map.Entry<String,Integer> entry : currHash.entrySet()){
                key = entry.getKey();
                int val = entry.getValue();
                if(hash.get(key) == val){
                    if(ians.length() > key.length() || ians.equals("")){
                        ians = key;
                    }
                    else if(ians.length() == key.length() && ians.compareTo(key) > 0){
                        ians = key;
                    }
                }
            }
            ans[i] = ians;
        }
        return ans;
    }
}