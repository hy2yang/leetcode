package onehundred;

public class SortColors_DNF {
    
    public void sortColors(int[] a) {
        int lo=0,i=0;
        int hi=a.length-1;
        while (i<=hi){    // i point to an unprocessed value
            if (a[i]<1) swap(a,i++,lo++);
            else if (a[i]>1) swap(a,i,hi--);
            else i++;            
        }
    }
    
    public static void swap (int[] a, int i, int j){
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }

}
