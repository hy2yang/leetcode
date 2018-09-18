package NonLeetcode;

public class MergeSort{

    public static void mergeSort(int[] arr){
        int[] aux = new int[arr.length];
        sort(arr,aux,0,arr.length-1);
    }

    private static void sort(int[] arr, int[] aux, int lo, int hi){
        if (lo>=hi) return;
        int mid = lo + (hi-lo)/2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid+1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] aux, int lo, int mid, int hi){
        int i = lo, j = mid+1, p = lo;
        while (i<=mid && j<=hi){
            if (arr[i]<=arr[j]) aux[p++] = arr[i++];
            else aux[p++] = arr[j++];
        }
        while (i<=mid) aux[p++] = arr[i++];
        while (j<=hi) aux[p++] = arr[j++];

        while (p>lo) arr[--p] = aux[p];
    }

//    public static void main(String[] args){
//
//        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
//        mergeSort(inputArr);
//        for(int i:inputArr){
//            System.out.print(i);
//            System.out.print(" ");
//        }
//    }

}
