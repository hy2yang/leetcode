package NonLeetcode;

import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int lo, int hi){
        if (lo<hi){
            int p = pivot(arr, lo, hi);
            sort(arr, lo, p-1);
            sort(arr, p+1, hi);
        }
    }

    private static int pivot(int[] arr, int lo, int hi){
        int pos = lo-1, pval = arr[hi];
        for (int i = lo; i<hi; ++i){
            if (arr[i]<pval){
                ++pos;
                swap(arr, pos, i);
            }
        }
        swap(arr, hi, pos+1);
        return pos+1;
    }

    private static void swap(int[] arr, int p1, int p2){
        int temp = arr[p2];
        arr[p2] = arr[p1];
        arr[p1] = temp;
    }

    public static void main(String[] args){


        int[] input2 = new int[102400];
        Random random = new Random();
        for (int i = 0; i<input2.length; ++i) input2[i]=random.nextInt();
        long start = System.currentTimeMillis();
        quickSort(input2);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(check(input2));

    }

    private static boolean check(int[] arr){
        for (int i=0;i<arr.length-1;++i){
            if (arr[i]>arr[i+1]) return false;
        }
        return true;
    }
}
