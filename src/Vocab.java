
/**
 * 
 * @author Mattis Wan-Bok-Nale
 */
public class Vocab {
	private String topic;
	private SinglyLinkedList words;
	
	public Vocab(String topic) {
		this.topic = topic;
		this.words = new SinglyLinkedList();
		
	}
	
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public SinglyLinkedList getWords() {
		return words;
	}
	public void setWords(SinglyLinkedList words) {
		this.words = words;
	}
	
	
	
}
