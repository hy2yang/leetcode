package strings;

/*
For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.
Formally, we are allowed to repeatedly choose a group (as defined above) of characters c,
and add some number of the same character c to it so that the length of the group is 3 or more.
Note that we cannot extend a group of size one like "h" to a group of size two like "hh" -
all extensions must leave the group extended - ie., at least 3 characters long.

Given a list of query words, return the number of words that are stretchy.

Example:

Input:
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.

Notes:
0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
 */
public class ExpressiveWords_809 {

    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String i: words){
            if (stretchy(i,S)) ++res;
        }
        return res;
    }

    private boolean stretchy(String cur, String target){

        if (target.length()<cur.length()) return false;

        char[] c = cur.toCharArray();
        char[] t = target.toCharArray();
        int cl=0, ch=0, tl=0,th=0;

        while (th<t.length && ch<c.length){
            if (c[cl]!=t[tl]) return false;
            while (th<t.length && t[th]==t[tl]) ++th;
            while (ch<c.length && c[ch]==c[cl]) ++ch;
            if (th-tl<ch-cl || (th-tl!=ch-cl && th-tl<3)) return false;
            cl=ch;
            tl=th;

        }
        return ch==c.length && th==t.length;
    }
}
