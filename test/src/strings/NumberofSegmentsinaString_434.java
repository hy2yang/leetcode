package strings;
/*
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
*/
public class NumberofSegmentsinaString_434 {
    
    public int countSegments(String s) {
        int res=0;
        char[] c=s.toCharArray();
        for (int i=0;i<c.length;++i){
            if (c[i]!=' ' && (i==0 || c[i-1]==' ')) ++res;
        }
        return res;
    }
    
}
