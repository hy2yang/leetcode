package general;
/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

import java.util.ArrayDeque;

public class SimplifyPath_71 {
    
    public static String simplifyPath(String path) {
        ArrayDeque<String> s=new  ArrayDeque<>();
        String[] parts=path.split("/");
        
        for (int i=0;i<parts.length;++i) {
            if (!parts[i].isEmpty() && !parts[i].equals(".")) {
                if (parts[i].equals("")) {
                    if (!s.isEmpty()) s.pop();
                }
                else s.push(parts[i]);
            }            
        }
        if (s.isEmpty()) return "/";
        StringBuilder sb=new StringBuilder();
        while (!s.isEmpty()) {
            sb.append("/"+s.pollLast());
        }
        return sb.toString();
        
    }
    
    public static void main (String[] args) {
        System.out.println(simplifyPath("/abc/..."));
    }

}
