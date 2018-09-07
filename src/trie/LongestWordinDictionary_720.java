package trie;

/*
Given a list of strings words representing an English Dictionary,
find the longest word in words that can be built one character at a time by other words in words.
If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.

Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary.
However, "apple" is lexicographically smaller than "apply".

Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
 */

public class LongestWordinDictionary_720 {

    public String longestWord(String[] words) {
        Trie720 t = new Trie720();
        for (String i: words){
            t.insert(i);
        }
        return t.getLongest();
    }

    class Trie720{

        private TrieNode root;

        Trie720(){
            this.root = new TrieNode();
        }

        void insert(String word){
            char[] cs = word.toCharArray();
            TrieNode cur = root;
            for (char c : cs){
                if (!cur.contains(c)){
                    cur.put(c, new TrieNode());
                }
                cur = cur.get(c);
            }
            cur.setWord(word);
        }

        String getLongest(){
            return getLongest(root, "");
        }

        String getLongest(TrieNode cur, String sofar) {
            String res = "", temp;
            int max = 0;
            for (TrieNode n :cur.children){
                if (n!=null && n.isEnd()){
                    temp = getLongest(n, n.word);
                    if (temp.length()>max){
                        max = temp.length();
                        res = temp;
                    }
                }
            }
            return max>sofar.length()? res:sofar;
        }

        class TrieNode {
            TrieNode[] children;
            String word;

            TrieNode(){
                children = new TrieNode[26];
            }

            public boolean isEnd() {
                return word!=null;
            }

            public void setWord(String word){
                this.word = word;
            }

            public void put(char c, TrieNode child){
                this.children[c-'a'] = child;
            }

            public TrieNode get(char c){
                return this.children[c-'a'];
            }

            public boolean contains(char c){
                return this.children[c-'a']!=null;
            }
        }

    }

}
