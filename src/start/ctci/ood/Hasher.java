package start.ctci.ood;

import java.util.ArrayList;

public class Hasher<K, V> {

	private static class LinkedListNode<K, V> {
		LinkedListNode<K, V> prev;
		LinkedListNode<K, V> next;
		K key;
		V value;

		LinkedListNode(K k, V v) {
			key = k;
			value = v;
		}
	}
	
	ArrayList<LinkedListNode<K, V>> arr;
	
	public Hasher(int capacity) {
		arr=new ArrayList<>(capacity);
	}
	
	void put(K k,V v) {
		LinkedListNode<K,V> ll =  getNodeForKey(k);
		if(ll.value!=null) {
			ll.value=v;//same value
			return;
		}
		
		ll = new LinkedListNode(k, v);
		int index = getIndexForKey(k);
		if(arr.get(index)!=null) {
			ll.next = arr.get(index);
			ll.next.prev = ll.next;
		}
		
		arr.set(index, ll);
	}
	
	void remove(K k) {
		LinkedListNode<K,V> ll =  getNodeForKey(k);
		if(ll.prev!=null) {
			ll.prev.next = ll.next;
		} else {
			int hashKey = getIndexForKey(k);
			arr.set(hashKey, ll.next);
		}
		
		if(ll.next!=null) {
			ll.next.prev = ll.prev;
		}
	}
	
	V get(K k) {
		LinkedListNode<K,V> ll =  getNodeForKey(k);
		return ll!=null ? ll.value : null;
	}
	
	LinkedListNode<K, V> getNodeForKey(K k) {
		int index = getIndexForKey(k);
		LinkedListNode current = arr.get(index);
		while(current!=null) {
			if(current.key.equals(k)) {
				return current;
			}
			current= current.next;
		}
		return null;
	}
	
	//naive function
	int getIndexForKey(K k) {
		return k.hashCode() % arr.size();
	}

}
