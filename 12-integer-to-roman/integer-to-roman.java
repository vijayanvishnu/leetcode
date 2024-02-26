class Solution {
    static final TreeMap<Integer,String> map = new TreeMap<>();
    static{
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            Map.Entry<Integer,String> entry = map.floorEntry(num);
            int key = entry.getKey();
            String val = entry.getValue();
            int rep = num / key;
            val = val.repeat(rep);
            sb.append(val);
            num = num % key;
        }
        return sb.toString();
    }
}