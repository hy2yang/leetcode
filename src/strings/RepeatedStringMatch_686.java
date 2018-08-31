package strings;

/*
Given two strings A and B, find the minimum number of times A has to be repeated 
such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; 
and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
*/

public class RepeatedStringMatch_686 {
	
	public int repeatedStringMatch(String A, String B) {
		if (A==null || A.length()<1) return -1;
        StringBuilder sb = new StringBuilder(A);
        int count=1;
        while (sb.length() < B.length()) {
        	sb.append(A);
        	++count;
        }
        if (sb.lastIndexOf(B)>=0) return count;    // lastIndexOf way faster than indexOf, why
        if (sb.append(A).lastIndexOf(B)>=0) return ++count;  
        // this append ensures we can use any position in A as start position to look up for B
        // since sb.length()>=B before this append
        // and sb is repeated As        
        return -1;        
    }	
	

}
