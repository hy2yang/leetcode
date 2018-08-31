package search_sort;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence 
from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
*/
public class WordLadder_127 {
    
    public int ladderLength(String beginWord, String endWord, List<String> list) {
        Set<String> dict=new HashSet<>(list);
        Set<String> visited=new HashSet<>();
        Queue<String> q=new ArrayDeque<>();
        q.offer(beginWord);
        int res=1;
        
        while (!q.isEmpty()){  
            ++res;
            int temp;
            for (temp=q.size();temp>0;--temp){
                String cur=q.poll();
                visited.add(cur);
                char[] cs=cur.toCharArray();                
                for (int i=0;i<cs.length;++i) {
                    char old=cs[i];
                    for (char j='a';j<='z';++j) {
                        cs[i]=j;
                        String change=new String(cs);
                        if (dict.contains(change)) {
                            if (change.equals(endWord)) return res;
                            else if (visited.add(change)) q.offer(change);
                        }
                    }
                    cs[i]=old;
                }                               
            }
            
        }        
        return 0;
    }       
    
}
