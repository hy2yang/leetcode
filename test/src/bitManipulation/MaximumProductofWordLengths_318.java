package bitManipulation;

public class MaximumProductofWordLengths_318 {
    
    public int maxProduct(String[] words) {
        if (words==null || words.length<2) return 0;
        int[] map=new int[words.length];
        
        for (int i=0;i<words.length;++i) {
            for (int j=0;j<words[i].length();++j) {
                map[i]|= 1<<(words[i].charAt(j)-'a');  // use bits of int to indicate which letters presented in the word
            }
        }
        int res=0, temp;
        for (int i=0;i<map.length-1;++i) {
            for (int j=i+1;j<map.length;++j) {
                if ( (map[i]&map[j])==0 ){            // no common letters <-> no common 1 bits
                    temp=words[i].length()*words[j].length();
                    if (temp>res) res=temp;
                }
            }
        }
        return res; 
    }

}
