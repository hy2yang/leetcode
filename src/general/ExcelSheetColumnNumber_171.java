package general;

public class ExcelSheetColumnNumber_171 {
    
    public static int titleToNumber(String s) {
        int res=0;
        for (int i=0;i<s.length();++i) {            
            res*=26;            
            res+=1+(int)s.charAt(i)-'A';
            //res=res*26+1+(int)s.charAt(i)-'A';
        }
        return res;
    }
    
    public static void main(String args[]) {
        System.out.println(titleToNumber("A"));
    }

}
