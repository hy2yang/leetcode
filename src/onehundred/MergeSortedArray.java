package onehundred;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] a= {2,0};
        int[] b= {1};
        merge(a,1,b,1);
        System.out.println(a[0]);
    }
    // m FROM a, n FROM b;
    //You may assume that a has enough space (size that is greater or equal to m + n) to hold additional elements from b. 
    //The number of elements initialized in a and b are m and n respectively.
    
    public static void merge(int[] a, int m, int[] b, int n) {
        int l=m-1;
        int s=n-1;
        int p=m+n-1;
        while (l>=0 && s>=0) {
            a[p--]= (a[l]>b[s])? a[l--]:b[s--];
        }
        while(s>=0) {
            a[p--]=b[s--];
        }
    }

}
