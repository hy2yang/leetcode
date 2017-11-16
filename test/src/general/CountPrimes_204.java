package general;

public class CountPrimes_204 {
    
    //Count the number of prime numbers less than a non-negative number, n.
    
    public static int countPrimes(int n) {
        if (n<3) return 0;  // 1 is not prime
        boolean[] notp=new boolean[n];   // notp[i] if i+1 is not prime
        notp[0]=true;
        notp[1]=true;
        for (int i=2;i<=Math.sqrt(n);++i) {
            for (int j=2;j*i<n;++j) {  // less than n
                notp[i*j]=true;
            }
        }
        int res=0;
        for (Boolean x:notp) {
            if (!x) ++res;
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(countPrimes(4));
    }

}
