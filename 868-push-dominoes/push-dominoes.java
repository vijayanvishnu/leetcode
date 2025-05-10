class Solution {
    public String pushDominoes(String dominoes) {
        char str[] = dominoes.toCharArray();
        int rPtr = Integer.MAX_VALUE;
        int lPtr = 0;
        int ptr = 0;
        StringBuilder sb = new StringBuilder();
        while(ptr < str.length){
            char ch = str[ptr];
            if(ptr >= lPtr){
                lPtr = ptr;
            }
            while(lPtr < str.length && str[lPtr] != 'L'){
                if(str[lPtr] == 'R'){
                    break;
                }
                lPtr++;
            }
            if(ch == '.'){
                // System.out.println(ptr + " " + lPtr + " " + rPtr);
                if(lPtr < str.length && str[lPtr] != 'R'){
                    if(rPtr == Integer.MAX_VALUE || lPtr - ptr < ptr - rPtr){
                        ch = 'L';
                    }else if(rPtr != Integer.MAX_VALUE && lPtr - ptr > ptr - rPtr){
                        ch = 'R';
                    }
                }else{
                   if(rPtr != Integer.MAX_VALUE){
                    ch = 'R';
                   }
                }
                sb.append(ch);
            }else if(ch == 'R'){
                rPtr = ptr;
                sb.append(ch);
            }else{
                rPtr = Integer.MAX_VALUE;
                sb.append(ch);
            }
            ptr++;
        }
        return sb.toString();
    }
}