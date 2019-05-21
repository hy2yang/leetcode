package strings;

import java.util.ArrayList;
import java.util.List;
/*
Given an array A of strings made only from lowercase letters, return a list of all characters that
show up in all strings within the list (including duplicates).
For example, if a character occurs 3 times in all strings but not 4 times,
you need to include that character three times in the final answer.

You may return the answer in any order.

Example 1:
Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: ["cool","lock","cook"]
Output: ["c","o"]

Note:
    1 <= A.length <= 100
    1 <= A[i].length <= 100
    A[i][j] is a lowercase letter
 */
public class FindCommonCharacters_1002 {

    public List<String> commonChars(String[] A) {
        int[] freq = new int[26];
        boolean[] common = new boolean[26];
        for (int i=0;i<26;++i) {
            common[i]=true;
            freq[i]=Integer.MAX_VALUE;
        }

        for (String i: A){
            int[] temp = new int[26];
            for (char c: i.toCharArray()) {
                ++temp[c-'a'];
            }
            for (int j=0;j<26;++j){
                common[j] &= temp[j]>0 ;
                if (common[j] && temp[j]<freq[j]) freq[j]=temp[j];
            }
        }

        List<String> res = new ArrayList();
        for (int i=0;i<26;++i){
            if (common[i]){
                while(freq[i]>0){
                    res.add(String.valueOf((char)(i+'a')));
                    --freq[i];
                }
            }
        }

        return res;
    }
}
