class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head, tail;

    DoublyLinkedList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    void insertAfterHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // removes node and returns key
    int removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        return node.key;
    }
}

class LRUCache {
    int capacity, size;
    DoublyLinkedList list;
    HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.list = new DoublyLinkedList();
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        list.removeNode(node);
        list.insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            list.removeNode(node);
            list.insertAfterHead(node);
        } else {
            Node node = new Node(key, value);
            if (size == capacity) {
                int keyToBeRemoved = list.removeNode(list.tail.prev);
                cache.remove(keyToBeRemoved);
                list.insertAfterHead(node);
                cache.put(key, node);
            } else {
                list.insertAfterHead(node);
                cache.put(key, node);
                ++size;
            }
        }
    }
}
