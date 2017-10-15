
public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        if (strs.length==1) return strs[0];
        int minl=0;
        int length=Integer.MAX_VALUE;
        for (int i=0;i<strs.length;i++) {
            if (strs[i].length()<length) {
                minl=i;
                length=strs[i].length();
            }
            if (length==0) return "";
        }
        
        for (int i=0;i<length;i++){
            for (int j=0;j<strs.length;j++) {
                if (strs[j].charAt(i)!=strs[minl].charAt(i)) {
                    return strs[minl].substring(0, i);
                }
            }            
        }
        return strs[minl].substring(0, length);
    }

}
