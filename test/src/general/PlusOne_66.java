package general;

/*Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class PlusOne_66 {
    
    public int[] plusOne(int[] a) {
        int carry=1, temp;
        for (int i=a.length-1;i>=0;--i) {
            temp=a[i]+carry;
            a[i]=temp%10;
            carry=temp/10;
        }
        if (carry>0) {
            int[] res=new int[a.length+1];
            res[0]=1;
            return res;
        }
        else return a;
    }

}
