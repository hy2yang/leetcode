package general;

import java.util.HashMap;

/*
Implement a trie with insert, search, and startsWith methods.
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

//basic implemetation with hashmap, easy to understand but slow. not utilizing "all inputs are consist of lowercase letters a-z"    
class TrieNode {                                
    HashMap<Character,TrieNode> children;
    char val;
    boolean isEnd;
    
    TrieNode(char c){
        this.val=c;
        this.isEnd=false;
        this.children=new HashMap<Character,TrieNode>();
    }
}

public class Trie_208{
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie_208() {
        root=new TrieNode(' ');
    }
    
    private TrieNode findChild(TrieNode cur, char c) {
        for (int i=0;i<cur.children.size();++i) {
            if (cur.children.containsKey(c)) return cur.children.get(c);
        }
        return null;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=root;
        char[] chars=word.toCharArray();
        for (int i=0;i<chars.length;++i) {
            TrieNode child=findChild(cur,chars[i]);
            if (child==null) {
                child=new TrieNode(chars[i]);
                cur.children.put(chars[i],child);
            }
            cur=child;
            if(i==chars.length-1) child.isEnd=true;
        }            
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur=root;
        char[] chars=word.toCharArray();
        for (int i=0;i<chars.length;++i) {
            TrieNode child=findChild(cur,chars[i]);
            if (child==null) return false;
            cur=child;
            if(i==chars.length-1 && child.isEnd) return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        char[] chars=prefix.toCharArray();
        for (int i=0;i<chars.length;++i) {
            TrieNode child=findChild(cur,chars[i]);
            if (child==null) return false;
            cur=child;                
        }
        return true;
    } 
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
