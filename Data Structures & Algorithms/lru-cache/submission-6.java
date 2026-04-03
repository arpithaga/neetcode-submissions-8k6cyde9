class Node {
	int val;
	int key;
	Node next;
	Node prev;

	Node() {
	}

	Node(int key, int val) {
		this.key = key;
		this.val = val;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

}
class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head; // dummy head
    private Node tail; 

	public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        removeNode(node);
        addToFront(node);
        return node.val;
    }
    
    private void addToFront(Node node) {
	   
    	node.next=head.next;
    	node.prev=head;
        head.next.prev = node;
    	head.next=node;
    	
	}

	private void removeNode(Node node) {
		
		node.prev.next=node.next;
		node.next.prev=node.prev;
		
	}

	public void put(int key, int value) {
		
		if(map.containsKey(key)) {
			Node node=map.get(key);
			node.val=value;
            removeNode(node);
			addToFront(node);
		}else {
			Node newNode=new Node(key,value);
			if(map.size()==capacity) {
				Node node=tail.prev;
				removeNode(node);
				map.remove(node.key);
			}
			addToFront(newNode);
			map.put(key, newNode);
		}
        
    }
}
