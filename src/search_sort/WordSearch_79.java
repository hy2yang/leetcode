package search_sort;
/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.
For example,
Given board =
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E'].
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class WordSearch_79 {
    
    public boolean exist(char[][] b, String word) {
        if (word=="") return true;
        int x=b.length;
        int y=b[0].length;
        if ((x*y)<word.length()) return false;
        char[] target=word.toCharArray();
        for (int i=0;i<x;i++) {
            for (int j=0;j<y;j++) {
                if (exist(b, target, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    static boolean exist(char[][] b, char[] target, int i, int j, int pos) {        
        if (pos==target.length) return true;
        int x=b.length;
        int y=b[0].length;
        if (i<0 || j<0 || i>x-1 || j>y-1) return false;
        if (b[i][j]!= target[pos]) return false;
        
        b[i][j]='#';   // make present cell not useable in future
        boolean res=exist(b,target,i,j-1,pos+1)||exist(b,target,i,j+1,pos+1)||exist(b,target,i-1,j,pos+1)||exist(b,target,i+1,j,pos+1);
        // why use a long OR line: if antone in front returns true, the back ones are not calculated
        b[i][j]=target[pos]; //recover present cell
        
        return res;
    }

}
