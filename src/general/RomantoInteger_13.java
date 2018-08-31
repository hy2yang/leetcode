package general;
/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class RomantoInteger_13 {
    
    public int romanToInt(String s) {
        int res=0;
        char[] cs=s.toCharArray();
        for (int i=cs.length-1;i>=0;--i) {
            switch (cs[i]) {
            case 'M':{
                res+=1000;
                break;
                }
            case 'D':{
                res+=500;
                break;
                }
            case 'C':{
                res+= (res>=500)? -100:100;
                break;
                }
            case 'L':{
                res+=50;
                break;
                }
            case 'X':{
                res+= (res>=50)? -10:10;
                break;
                }
            case 'V':{
                res+=5;
                break;
                }
            case 'I':{
                res+= (res>=5)? -1:1;
                break;
                }
            }
        }
        return res;
    }

}
