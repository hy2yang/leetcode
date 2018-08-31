package onehundred;

public class LengthofLastWord {
    
    public int lengthOfLastWord(String s) {
        if (s.length()==0) return 0;
        char[] c=s.toCharArray();
        int i=c.length-1;
        while (i>0 && c[i]==' '){
            i--;
        }
        if (i==0) {
            return (c[i]==' ')? 0:1;
        }
        int l=0;
        while(i>0 && c[i]!=' '){
            i--;
            l++;
        }
        if (i==0) {
            return (c[i]==' ')? l:++l;
        }
        return l;
    }

}
