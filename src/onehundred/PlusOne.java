package onehundred;

public class PlusOne {

    public static void main(String[] args) {
        int[] x= {9,9};
        System.out.println(plusOne(x)[1]);
    }
    
    public static int[] plusOne(int[] a) {
        int last=1;
        for (int i=a.length-1;i>=0;i--) {
            a[i]+=last;
            last=a[i]/10;
            a[i]%=10;
            
        }
        if (last>0) {
            int[] res =new int[a.length+1];
            res[0]=1;
            return res;
        }
        return a;
        
    }

}
