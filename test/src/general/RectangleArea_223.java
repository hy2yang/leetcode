package general;
/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

rec1: bottom left (A, B), top right(C, D)
rec2: bottom left (E, F), top right(G, H)
Assume that the total area is never beyond the maximum possible value of int.
*/
public class RectangleArea_223 {
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left= Math.max(A, E);
        int right= Math.max(left, Math.min(C, G));   // by including left, fits both overlap and no overlap stuations
        int bottom= Math.max(B, F);
        int top= Math.max(bottom, Math.min(D, H));   // same here
        
        return (C-A)*(D-B)+(G-E)*(H-F)-(right-left)*(top-bottom);
    }

}
