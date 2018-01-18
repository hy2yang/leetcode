package strings;
/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", 
it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/
public class CompareVersionNumbers_165 {
    
    public int compareVersion(String version1, String version2) {
        if (version1==null || version2==null ) return 0;
        char[] v1=version1.toCharArray(), v2=version2.toCharArray();
        int x1,x2, p1=0,p2=0;
        while (p1<v1.length || p2<v2.length) {
            x1=0; x2=0;
            while (p1<v1.length && v1[p1]!='.') x1=x1*10+v1[p1++]-'0';
            while (p2<v2.length && v2[p2]!='.') x2=x2*10+v2[p2++]-'0';
            if (x1!=x2) return Integer.compare(x1, x2);
            ++p1;++p2;
        }
        return 0; 
    }

}
