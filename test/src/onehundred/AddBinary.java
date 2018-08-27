package onehundred;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1","1"));

    }
    
    public static String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        char[] x=a.toCharArray();
        char[] y=b.toCharArray();
        int add=0;
        int temp=0;
        while (i>-1 && j>-1){            
            temp=x[i--]+y[j--]-96+add;            
            sb.append(temp%2);
            add=temp/2;
        }
        while (i>-1 ){            
            temp=x[i--]-48+add;
            sb.append(temp%2);
            add=temp/2;
        }
        while (j>-1 ){
            temp=y[j--]-48+add;
            sb.append(temp%2);
            add=temp/2;
        }
        if(add!=0) sb.append(1);
        sb.reverse();
        return sb.toString();
    }

}
