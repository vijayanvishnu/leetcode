class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int idx = 0;
        while(idx < v1.length && idx < v2.length){
            int int_v1 = Integer.parseInt(v1[idx]);
            int int_v2 = Integer.parseInt(v2[idx]);
            if(int_v1 > int_v2){
                return 1;
            }
            if(int_v2 > int_v1){
                return -1;
            }
            idx++;
        }
        if(v1.length > v2.length){
            while(idx < v1.length){
                int int_v1 = Integer.parseInt(v1[idx]);
                if(int_v1 != 0){
                    return 1;
                }
                idx++;
            }
        }else{
            while(idx < v2.length){
                int int_v2 = Integer.parseInt(v2[idx]);
                if(int_v2 != 0){
                    return -1;
                }
                idx++;
            }
        }
        return 0;
    }
}