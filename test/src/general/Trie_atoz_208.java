package general;


// utilizing "all inputs are consist of lowercase letters a-z"
// using a array of 26 nodes, null->no child of this letter

class TrieNode {                                
    TrieNode[] children=new TrieNode[26];
    boolean isEnd;
    
    TrieNode(){}
}

public class Trie_atoz_208 {
    private TrieNode root;
    
    public Trie_atoz_208() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] chars=word.toCharArray();
        TrieNode cur=root;
        for (int i=0;i<chars.length;++i) {
            if (cur.children[chars[i]-'a']==null) {
                cur.children[chars[i]-'a']=new TrieNode();
            }
            cur=cur.children[chars[i]-'a'];
        }
        cur.isEnd=true;
    }
    
    // function of search for word and prefix are almost identical, can be merged
    private TrieNode searchHelper(String word){
        char[] chars=word.toCharArray();
        TrieNode cur=root;
        for (int i=0;i<chars.length;++i) {
            if (cur==null) return null; 
            cur=cur.children[chars[i]-'a'];                
        }
        return cur;
    }
    
    public boolean search(String word) {
        TrieNode temp=searchHelper(word);
        return temp!=null && temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchHelper(prefix)!=null;
    }

}
