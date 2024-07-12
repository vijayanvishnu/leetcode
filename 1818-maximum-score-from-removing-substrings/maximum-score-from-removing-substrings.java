class Solution {
    public int maximumGain(String s, int x, int y) {
        int ab , ba = ab = 0;
        int a , b = a  = 0;
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'a'){
                if(y > x){
                    if(b > 0){
                        b--;
                        ba++;
                    }else{
                        a++;
                    }
                }else{
                    a++;
                }
            }else if(s.charAt(i) == 'b'){
                if(x  >= y){
                    if(a > 0){
                        a--;
                        ab++;
                    }else{
                        b++;
                    }
                }else{
                    b++;
                }
            }else{
                if(x <= y){
                    ab = ab + Math.min(a,b);
                }
                else{
                    ba = ba + Math.min(a,b);
                }
                a = b = 0;
            }
        }
        if(x <= y){
            ab = ab + Math.min(a,b);
        }
        else{
            ba = ba + Math.min(a,b);
        }
        return ab * x + ba * y;
    }
}