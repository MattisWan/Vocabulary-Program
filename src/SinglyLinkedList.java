

/**
 * 
 * @author Mattis Wan-Bok-Nale
 */
public class SinglyLinkedList {
	 	private Node head;
	   
	    
	    private int counter;

	    public SinglyLinkedList() {
	        head = null;
	        counter = 0;
	    }

	    // Add to head
	    public void addAtHead(String word) {
	        head = new Node(word, head);
	        counter++;
	    }
	    
	    public void addAtEnd(String word) {
	        if (head == null) {
	            addAtHead(word);
	        } else {
	            Node position = head;
	            while (position.next != null) {
	                position = position.next;
	            }

	            Node n = new Node(word, null);
	            position.next = n;

	            counter++;
	        }
	    }
	    
	 // Add after 
	    public void addAfter(String referenceValue, String newValue) {
	        Node position = head;
	        while (position != null && !position.word.equals(referenceValue)) {
	            position = position.next;
	        }
	        if (position != null && position.word.equals(referenceValue)) {
	            // if the ref value is the last element
	            if (position.next == null) {
	                addAtEnd(newValue);
	            } else {
	                Node n = new Node(newValue, null);
	                n.next = position.next;
	                position.next = n;
	                counter++;
	            }
	        }
	    }
	    
	    public void remove(String refWord) {
	        if (head == null) {
	            System.out.println("List is empty");
	        }
	        if (head.word.equals(refWord)) {
	            head = head.next;
	            counter--;
	        } else {
	            Node position = head;

	            while (position.next != null && !position.next.word.equals(refWord)) {
	                position = position.next;
	            }
	            if ( position.next != null &&position.next.word.equals(refWord)) {
	                
	                position.next = position.next.next;
	                counter--;
	                
	            }
	            else {
	            	System.out.println("sorry, there is no word: "+ refWord);
	            }
	        }
	        
	    }
	    
	    public int getSize() {
	    	return counter;
	    }
	    
	    // Display
	    public void display() {
	    		int count=1;
	        if (head == null) {
	            System.out.println("Your list is empty.");
	        } else {
	            Node position = head;
	            while (position != null) {
	                System.out.println(count +": "+position.word);
	                position = position.next;
	                count++;

	            }
	        }
	    }
	    
	    //to find a word from index
	    public String findWord(int index) {
	 	   int count =1;
	 	   Node position = head;
	 	   while(count != index) {
	 		   position = position.next;
	 		   count++;
	 	   }
	 	   return position.word;
	    }
	     
	    
	    

	  

	    private class Node {

	        // Data
	        private String word;
	        // Link
	        private Node next;

	        public Node(String word, Node next) {
	            this.word = word;
	            this.next = next;
	        }
	    }

}

