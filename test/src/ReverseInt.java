

public class ReverseInt {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(reverse(-2147483412));

    }
    
    
    public static int reverse(int x) {
        int copy=x;
        int res=0;
        int rev=0;
        
        while (copy!=0){
            
            res=copy%10;
            copy=(copy-res)/10;
            if (((10*rev+res)-res)/10 != rev){                
                return 0;
            }
            rev=10*rev+res;
            
        }
        return rev;        
    }
    
 }


