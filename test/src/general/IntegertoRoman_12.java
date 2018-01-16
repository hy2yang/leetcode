package general;
/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class IntegertoRoman_12 {

    public String intToRoman(int num) {
        String[] r= {"","M","MM","MMM",
                "","C","CC","CCC","CD","D","DC","DCC","DCCC","CM",
                "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC",
                "","I","II","III","IV","V","VI","VII","VIII","IX"};
        
        StringBuilder sb=new StringBuilder();
        sb.append(r[num/1000]);
        sb.append(r[(num%1000)/100+4]);
        sb.append(r[(num%100)/10+14]);
        sb.append(r[(num%10+24)]);
        return sb.toString();
    }
    
}
