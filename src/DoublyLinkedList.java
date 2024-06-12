
/**
 * 
 * @author Mattis Wan-Bok-Nale
 */
public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	//default constructor
	public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
	
	// Add at head
    public void addAtHead(Vocab obj) {
        Node temp = head;
        head = new Node(obj, null, head);

        if (tail == null) {
            tail = head;
        } else {
            temp.before = head;
        }

        size++;
    }
    
    // Add at tail
    public void addAtTail(Vocab obj) {
        Node temp = tail;
        tail = new Node(obj, tail, null);
        if (head == null) {
            head = tail;
        } else {
            temp.after = tail;
        }

        size++;
    }
    
    // Add after (while going from the head to tail)
    public void addAfter(Vocab referenceValue, Vocab newValue) {
        Node position = head;
        while (position != null && position.obj != referenceValue) {
            position = position.after;
        }
        if (position != null && position.obj == referenceValue) {
            // if the ref value is the last element
            if (position.after == null) {
                addAtTail(newValue);
            } else {
                Node n = new Node(newValue, null, null);
                n.after = position.after;
                n.before = position;
                position.after.before = n;
                position.after = n;
                size++;
            }
        }
    }
    
    //Add before, going from tail to head
    public void addBefore(Vocab referenceValue, Vocab newValue) {
    	Node position = tail;
    	while (position != null && position.obj != referenceValue) {
    		position = position.before;
    	}
    	
    	if (position != null && position.obj == referenceValue) {
    		if (position.before == null) {
    			//that means that the value is the head
    			addAtHead(newValue);
    		} else {
    			Node n = new Node(newValue, null, null);
    			n.after = position;
    			n.before = position.before;
    			position.before.after = n;
    			position.before = n;
    			size++;
    		}
    	}
    	
    	
    	
    }
    
    public void remove(Vocab value) {
    	Node position = head;
    	while (position != null && position.obj != value) {
    		position = position.after;
    	}
    	
    	if (position != null && position.obj == value) {
    		//if at head
    		if (position.before == null) {
    			head = head.after;
    			head.before = null;
    			size--;
    		}
    		
    		//if at tail
    		else if (position.after == null) {
    			tail = tail.before;
    			tail.after = null;
    			size--;
    			
    			
    		}
    		else {
    			position.before.after = position.after;
    			position.after.before = position.before;
    			size--;
    		}
    		
    	}
    }
    
    
    
    public void displayWords(String topic) {
    	Node position = head;
    	while(!position.obj.getTopic().equals(topic) && position.after != null) {
    		position = position.after;
    	}
    	if (position.obj.getTopic().equals(topic)) {
    		position.obj.getWords().display();
    	}
    	
    }
    
    
    public void displayTopics() {
    	Node position = head;
    	int count =0;
    	while (position.after != null) {
    		count++;
    		System.out.println(count + "  "+ position.obj.getTopic());
    		position = position.after;
    	}
    	
    }
    
   public int getSize() {
	   return size;
   }
   
   //method to get the vocab object at a node
   public Vocab getVocab(int index) {
	   int count =1;
	   Node position = head;
	   while(count != index) {
		   position = position.after;
		   count++;
	   }
	   return position.obj;
   }
    
    
   
    
   
    
    
    
    
    

	
	 private class Node {

	        // Data
	        private Vocab obj;
	        // Links
	        private Node after;
	        private Node before;

	        public Node(Vocab obj, Node before, Node after) {
	            this.obj = obj;
	            this.before = before;
	            this.after = after;
	        }
	    }
}