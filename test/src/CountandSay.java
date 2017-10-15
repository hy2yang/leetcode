
public class CountandSay {
    
    public String countAndSay(int n) {
        String res="1";
        for (int i=1;i<n;i++) {
            res=readoff(res);
        }
        return res;
    }
    
    static String readoff(String in) {
        StringBuilder sb=new StringBuilder();
        char[] x=in.toCharArray();
        int i=0;
        int count=1;
        while (true) {
            if (i+1<in.length()) {
                if (x[i]==x[i+1]) count++;
                else {
                    sb.append(count);
                    sb.append(x[i]);
                    count=1;
                }
                i++;
            }
            else {
                sb.append(count);
                sb.append(x[i]);
                break;
            }                
        }        
        return sb.toString();
    }

}
