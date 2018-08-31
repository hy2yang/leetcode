package general;

/*
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.
    For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */

public class ExcelSheetColumnTitle_168 {
    
    public String convertToTitle(int n) {
        StringBuilder sb= new StringBuilder();
        while (n>0) {
            int i=(--n)%26;                    // to solve as a 26-based notation, assume that 0 -> A, 25 -> Z 
            sb.insert(0,(char)('A'+i));        // (starts with 0 rather than 1), left to right (not sb.append)
            n/=26;
        }
        return sb.toString();
    }

}
