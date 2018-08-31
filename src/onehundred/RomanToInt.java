package onehundred;

public class RomanToInt {

    static int romanToInt(String s) {
        int result=0;
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)=='I'){
                result+=((result>=5)? -1:1);
                continue;
            }
            if (s.charAt(i)=='V') {
                result+=5;
                continue;
            }
            if (s.charAt(i)=='X'){
                result+=((result>=50)? -10:10);
                continue;
            }
            if (s.charAt(i)=='L'){
                result+=50;
                continue;
            }
            if (s.charAt(i)=='C'){
                result+=((result>=500)? -100:100);
                continue;
            }
            if (s.charAt(i)=='D') {
                result+=500;
                continue;
            }
            if (s.charAt(i)=='M') {
                result+=1000;
                continue;
            }
        }
        return result;
    }
}

