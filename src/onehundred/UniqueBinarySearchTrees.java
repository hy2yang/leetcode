package onehundred;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {

            System.out.println(numTrees(3));

    }
    
    public static int numTrees(int n) {
        int[] num=new int[n+1];
        num[0]=1;
        num[1]=1;        
        for (int i=2;i<=n;++i) {
            int j=1;
            while (i-j>j-1) {                
                num[i]+=2*num[i-j]*num[j-1];
                ++j;
            }
            if(i-j==j-1) num[i]+=num[j-1]*num[j-1];
        }
        return num[n];        
    }

}
/*
num(i): the number of unique BST for a sequence of length i.
f(j, i), 1 <= j <= n: the number of unique BST, where the number j is the root of BST, and the sequence ranges from 1 to i.
num(i)= sum(f(j, i))
f(j, i)= num(i-1)*num(n-i)  
unique BST composed of nodes to left of i * to right of i
num(i)= num(0) * num(i-1) + num(1) * num(i-2) + … + num(i-1) * num(0) 
*/