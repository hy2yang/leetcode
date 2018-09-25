package NonLeetcode;

public class BinarySearch {

    public static int indexOf(int[] arr, int target){
        int lo=0, hi=arr.length-1;
        int mid;
        while (lo<=hi){
            mid = lo + (hi-lo)/2;
            if (arr[mid]==target) return mid;
            else if (arr[mid]>target) hi=mid-1;
            else lo=mid+1;
        }
        return -1;
    }


}
