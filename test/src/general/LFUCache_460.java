package general;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, 
it should invalidate the least frequently used item before inserting a new item. 
For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), 
the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 \/* capacity *\/ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


public class LFUCache_460 {
	
	private class LfuNode{
		int key;
		int value;
		int freq;
		
		LfuNode(int k, int v){	
			this.key = k;
			this.value = v;
			this.freq = 0;
		}
	}
	
	private int capacity;
	private int minF;
	private Map<Integer, LfuNode> nodeMap ;
	private Map<Integer, LinkedHashSet<Integer>> freqMap;
	
	public LFUCache_460(int capacity) {
		this.capacity = capacity;
		minF = 0;		
		nodeMap = new HashMap<>();
		freqMap = new HashMap<>();
	}

	public int get(int key) {
		if (nodeMap.containsKey(key)) {
			LfuNode cur = nodeMap.get(key);
			promote(cur);
			return cur.value;
		}
		return -1;
	}

	public void put(int key, int value) {
        if (capacity <= 0) return;
		
		if (nodeMap.containsKey(key)) {
			LfuNode cur = nodeMap.get(key);
			cur.value = value;
            promote(cur);
		} 
		else {
            if (nodeMap.size()==capacity) {
			    this.invalidate();
		    }
			LfuNode cur = new LfuNode(key, value);
			minF = 0;
            nodeMap.put(key, cur);
		    putIntoFreqMap(cur);
		}
	}
	
	private void putIntoFreqMap(LfuNode cur) {	
		if (freqMap.containsKey(cur.freq)) {
			freqMap.get(cur.freq).add(cur.key);
		}
		else {
			LinkedHashSet<Integer> temp =new LinkedHashSet<>();
			temp.add(cur.key);
			freqMap.put(cur.freq, temp);
		}
	}
	
	private void promote(LfuNode cur) {
		int freq = cur.freq;

		Set<Integer> thisFSet = freqMap.get(freq);
		thisFSet.remove(cur.key);
		if (thisFSet != null && thisFSet.isEmpty()) {
			freqMap.remove(freq);
			if (freq == minF) {
				++minF;
			}
		}
		++cur.freq;		
		putIntoFreqMap(cur);
	}
	
	private void invalidate() {
		LinkedHashSet<Integer> minFSet = freqMap.get(minF);
		int key = minFSet.iterator().next();
		minFSet.remove(key);
		nodeMap.remove(key);
		if (minFSet.isEmpty()) {
			freqMap.remove(minF);
		}
	}
	
	public static void main(String[] args) {
		LFUCache_460 obj = new LFUCache_460(2);
		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println(obj.get(1));
		obj.put(3, 3);
		System.out.println(obj.get(2));
		System.out.println(obj.get(3));
		obj.put(4, 4);
		System.out.println(obj.get(1));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
	}

}
