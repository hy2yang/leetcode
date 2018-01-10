package general;
/*
Given an Iterator class interface with methods: next() and hasNext(), 
design and implement a PeekingIterator that support the peek() operation 
-- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

Follow up: How would you extend your design to be generic and work with all types, not just integer?
*/

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator_284 implements Iterator<Integer>{
    
    private Iterator<Integer> it;
    private Integer top;
    
    public PeekingIterator_284(Iterator<Integer> iterator) {
        this.it=iterator;
        if (it.hasNext()) top=it.next();
        else top=null;
    }
    
    public Integer peek() {
        return top;
    }

    @Override
    public boolean hasNext() {
        return top!=null;
    }

    @Override
    public Integer next() {
        Integer res=top;
        top=it.hasNext()? it.next():null;
        return res;
    }
    
    // the inner 'actual' iterator is 1 position later

}
