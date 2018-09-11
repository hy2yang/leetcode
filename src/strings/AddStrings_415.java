package strings;
/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class AddStrings_415 {

    public String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        int i = n1.length - 1;
        int j = n2.length - 1;
        char[] cs = i >= j ? new char[n1.length + 1] : new char[n2.length + 1];
        int p = cs.length - 1;

        int carry = 0, cur;
        while (i >= 0 && j >= 0) {
            cur = n1[i--] - '0' + n2[j--] - '0' + carry;
            carry = (cur > 9) ? 1 : 0;
            cs[p--] = Character.forDigit(cur % 10, 10);
        }
        while (i >= 0) {
            cur = n1[i--] - '0' + carry;
            carry = (cur > 9) ? 1 : 0;
            cs[p--] = Character.forDigit(cur % 10, 10);
        }
        while (j >= 0) {
            cur = n2[j--] - '0' + carry;
            carry = (cur > 9) ? 1 : 0;
            cs[p--] = Character.forDigit(cur % 10, 10);
        }

        if (p == 0 && carry == 0) ++p;
        if (carry > 0) cs[0] = '1';
        return new String(cs, p, cs.length - p);
    }
    
}
