package search_sort;
/*
Given a string, sort it in decreasing order based on the frequency of characters.

Input:
"tree"
Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Input:
"cccaaa"
Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Input:
"Aabb"
Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

public class SortCharactersByFrequency_451 {
    
    public String frequencySort(String s) {
        if (s==null || s.length()<1) return "";
        int[] map=new int[128];
        for (int i=0;i<s.length();++i) {
            ++map[s.charAt(i)];
        }
        
        StringBuilder sb=new StringBuilder();
        int max,index;
        do {
            index=0;
            max=0;
            for (int i=0;i<128;++i) {
                if (map[i]>max) {
                    index=i;
                    max=map[i];
                }
            }
            while (map[index]>0) {
                sb.append((char)index);
                --map[index];
            }            
        }while (max>0); 
        
        return sb.toString();
    }

}
