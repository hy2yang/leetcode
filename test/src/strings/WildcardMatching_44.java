package strings;
/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

public class WildcardMatching_44 {
    
    public boolean isMatch(String s, String p) {
        int a=0,b=0, star=-1, forStar=0;
        char[] str=s.toCharArray();
        char[] ptn=p.toCharArray();
        while (a<str.length) {
            
            if (b<ptn.length && ( ptn[b]=='?' || str[a]==ptn[b]) ) {   //match
                ++a;
                ++b;
            }
            
            else if (b<ptn.length && ptn[b]=='*') {  //star, remember star index and 
                star=b++;                            //a's position (the start of a sequence to be matched by star)
                forStar=a;
            }
            
            else if (star!=-1) {          // not match but there's a unused star before
                b=star+1;                 // use this star
                a=++forStar;              // advance a over the end of the sequence matched by star
            }
            
            else return false;        
        }
        
        while (b<ptn.length && ptn[b]=='*') {   // part of pattern left
            ++b;
        }
        
        return b==ptn.length;  
    }

}
