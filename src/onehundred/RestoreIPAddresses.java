package onehundred;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public static void main(String[] args) {
        for (String s :restoreIpAddresses("010010")) {
         System.out.println(s);   
        }
    }
    
    public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> res=new ArrayList<>();
        if (s.length()<4) return res;
        StringBuilder wip=new StringBuilder();
        helper(s, res, wip, 0, 0);
        return res;
    }
    
    static void helper(String s, ArrayList<String> res, StringBuilder wip, int sec, int used) {
        if ( used==s.length() && sec==4) {
            res.add(wip.toString());
            return;
        }
        if ((s.length()-used)>((4-sec)*3)) return;
        
        for (int i=1;i<4;i++) {
            if (used+i>s.length()) break;
            String toadd =s.substring(used, used+i);
            if (toadd.startsWith("0") && toadd.length()>1) continue;
            if (Integer.parseInt(toadd)>255) continue;
            StringBuilder sb=new StringBuilder(wip);
            sb.append(toadd);
            if (sec!=3)sb.append('.');
            helper (s, res, sb, sec+1, used+i );
        }
    }

}
