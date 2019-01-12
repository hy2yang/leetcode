package general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers_970 {

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (x>y){
            int t = x;
            x=y;
            y=t;
        }  // make sure y is not less than x, so ys can be shorter

        int xsum = 1;
        int ysum = 1;
        Set<Integer> temp = new HashSet<>();
        List<Integer> ys = new ArrayList<>();  // valid ys, more space for faster
        while (ysum<bound){
            ys.add(ysum);
            ysum*=y;
            if (y==1) break;
        }

        while(xsum<bound){
            for (Integer j:ys){
                if (xsum+j>bound) break;
                temp.add(xsum+j);
            }
            if (x==1) break;
            xsum*=x;
        }

        return new ArrayList<>(temp);

    }

    public List<Integer> powerfulIntegersBrute(int x, int y, int bound) {
        Set<Integer> temp = new HashSet<>();

        for (int xsum = 1;xsum<bound;xsum*=x){
            for (int ysum = 1;xsum+ysum<=bound;ysum*=y){
                temp.add(xsum+ysum);
                if (y==1) break;

            }
            if (x==1) break;
        }

        return new ArrayList<>(temp);
    }

    public static void main(String[] args){
        System.out.println(powerfulIntegers(3,2,10));
    }
}
