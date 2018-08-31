package onehundred;
import java.util.LinkedList;

public class PermutationSequence {

    public static void main(String[] args) {

        System.out.println(getPermutation(3,5));

    }
    
    public static String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        LinkedList<Integer> a=new LinkedList<>();
        int m=1;
        for (int i=1;i<n;i++) {
            m*=i;
            a.add(i);
        }
        a.add(n);
        int c=n;
        while (c>0) {            
            sb.append(a.get((k-1)/m));
            a.remove((k-1)/m);
            k-=((k-1)/m)*m;
            if(c==1) break;
            m/=(--c);
        }
        return sb.toString();
    }
    

}
