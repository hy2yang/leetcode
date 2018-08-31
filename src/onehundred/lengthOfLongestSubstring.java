package onehundred;

public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(FindlengthOfLongestSubstring("tmmzuxt"));
    }
    
    public static int FindlengthOfLongestSubstring(String s) {
        String temp="";
        String longest="";
        for (char c: s.toCharArray()){
            //String update="";
            String p=""+c;
            if (temp.contains(p)){
                /*temp+=c;
                int dup=temp.length();
                
                for(int i=0;i<temp.length();i++){
                    if(temp.toCharArray()[i]==c) dup=i;
                    break;                     
                }
                
                for (int i=dup+1;i<temp.length();i++){
                    update+=temp.toCharArray()[i];
                }
                temp=update;*/
                if (temp.split(p).length==2) temp=temp.split(p)[1];
                else temp="";                                
            }
            temp+=c;
            if(temp.length()>longest.length()) longest=temp;            
        }
        return longest.length();
    }

}
