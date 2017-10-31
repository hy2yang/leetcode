package onehundred;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> cur= new ArrayList<>();
        if (rowIndex<0) return cur;
        cur.add(1);
        for (int i=0;i<=rowIndex;++i) {
            for (int j=i;j>0;--j) {
                if (j==i) cur.add(1);
                else cur.set(j, cur.get(j-1)+cur.get(j));
            }
        }
        return cur;
    }

}
