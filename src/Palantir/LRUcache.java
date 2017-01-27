package Palantir;
import java.util.HashMap;

// Least Recently Used Cache
public class LRUcache {
    private int capacity;
    private int current_size;
    private HashMap<Integer, Node> usage_list;
    private Node leastRecentlyUsed = new Node();
    private Node mostRecentlyUsed = new Node();
    
    public LRUcache(int capacity) {
        this.capacity = capacity;
        this.current_size = 0;
        this.usage_list = new HashMap<>();
        leastRecentlyUsed.next = mostRecentlyUsed;
        mostRecentlyUsed.prev = leastRecentlyUsed;
    }
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node() {
            this.key = -1;
            this.value = -1;
        }
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
    
    public int get(int key) {
        if (!usage_list.containsKey(key)) {
            return -1;
        }
        // update to most recently used item
        Node item = usage_list.get(key);
        item.prev.next = item.next;
        item.next.prev = item.prev;
        updateToMostRecent(item);
        // return item value in O(1)
        return item.value;
    }
    
    public void put(int key, int value) {
        if (usage_list.containsKey(key)) {
            Node item = usage_list.get(key);
            item.value = value;
            item.prev.next = item.next;
            item.next.prev = item.prev;
            updateToMostRecent(item);
            return;
        }
        if (capacity == current_size) {
            // remove least recently used item for memory
            Node item = leastRecentlyUsed.next;
            item.next.prev = leastRecentlyUsed;
            leastRecentlyUsed.next = item.next;
            usage_list.remove(item.key);
            current_size--;
        }
        Node new_item = new Node(key, value);
        usage_list.put(key, new_item);
        updateToMostRecent(new_item);
        current_size++;
    }
    
    public void updateToMostRecent(Node item) {
        mostRecentlyUsed.prev.next = item;
        item.prev = mostRecentlyUsed.prev;
        item.next = mostRecentlyUsed;
        mostRecentlyUsed.prev = item;
    }    
}