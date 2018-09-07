package trie;

public class Trie{

    class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(){
            this.isEnd = true;
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

    private TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        char[] cs = word.toCharArray();
        TrieNode cur = root;
        for (char c : cs){
            if (!cur.contains(c)){
                cur.put(c, new TrieNode());
            }
            cur = cur.get(c);
        }
        cur.setEnd();
    }

    public TrieNode searchPrefix(String word){
        char[] cs = word.toCharArray();
        TrieNode cur = root;
        for (char c : cs){
            if (!cur.contains(c)) return null;
            cur = cur.get(c);
        }
        return cur;
    }

    public boolean contains(String word){
        TrieNode res = searchPrefix(word);
        return res!=null && res.isEnd();
    }

}

