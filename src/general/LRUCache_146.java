package general;

import java.util.HashMap;

/*Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/


class DListNode {
    DListNode next,pre;
    int key,val;
    public DListNode (int k, int v) {
        this.val=v;
        this.key=k;
        next=null;
        pre=null;
    }
}

public class LRUCache_146 {
    
    private final int capacity;
    private int size;
    private DListNode dHead, dTail;
    HashMap<Integer, DListNode> map;  
    
    
    public LRUCache_146(int c){
        this.capacity=c;
        map=new HashMap<Integer,DListNode>();
        size=0;
        dHead=new DListNode(0,0);
        dTail=new DListNode(0,0);
        dHead.next=dTail;
        dTail.pre=dHead;
    }
    
    public int get(int k) {
        if (map.containsKey(k)) {
            moveToHead(map.get(k));
            return map.get(k).val;
        }
        else return -1;
    }
    
    private void moveToHead(DListNode cur) {
        cur.pre.next=cur.next;
        cur.next.pre=cur.pre;
        
        addToList(cur);
    }

    public void put (int k, int v) {
        DListNode cur;
        if (map.containsKey(k)) {
            cur=map.get(k);
            cur.val=v;
            moveToHead(cur);
        }
        else{
            cur=new DListNode(k,v);
            map.put(k, cur);
            addToList(cur);
            if (size==capacity) {
                DListNode out=popTail();
                map.remove(out.key);
            }
            else ++size;
        }
        
    }

    private DListNode popTail() {
        if (dTail.pre==dHead) return null;
        DListNode out=dTail.pre;        
        out.pre.next=dTail;
        dTail.pre=out.pre;
        out.pre=null;
        out.next=null;
        return out;
    }

    private void addToList(DListNode cur) {
        cur.next=dHead.next;
        cur.pre=dHead;
        dHead.next.pre=cur;
        dHead.next=cur;
    }

}
