package intervals;
/*
A rectangle is represented as a list [x1, y1, x2, y2],
where (x1, y1) are the coordinates of its bottom-left corner,
and (x2, y2) are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.
To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

Example 1:
Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true

Example 2:
Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false

Notes:
Both rectangles rec1 and rec2 are lists of 4 integers.
All coordinates in rectangles will be between -10^9 and 10^9.
 */
public class RectangleOverlap_836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] x1 = new int[]{rec1[0], rec1[2]};
        int[] x2 = new int[]{rec2[0], rec2[2]};
        int[] y1 = new int[]{rec1[1], rec1[3]};
        int[] y2 = new int[]{rec2[1], rec2[3]};

        return overlap(x1, x2)&&overlap(y1,y2);
    }

    private boolean overlap(int[] i1, int[] i2){
        return !(i1[1]<=i2[0] || i2[1]<=i1[0]);
    }

}
