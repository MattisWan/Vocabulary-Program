

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * @author Mattis Wan-Bok-Nale
 */
public class Driver {
	/**
     * This is the main method
     * 
     */
	public static void main(String[] args) {
		System.out.println("Welcome Mattis Wan-Bok-Nale");
		int choice = 0;
		Scanner keyIn = new Scanner(System.in);
		DoublyLinkedList myList= new DoublyLinkedList();
		String fileName ="";
		do {
			System.out.println("-----------------------------");
			System.out.println("  Vocabulary Control Center  ");
			System.out.println("-----------------------------");
			System.out.println(" 1  browse a topic ");
			System.out.println(" 2  insert a new topic before another one ");
			System.out.println(" 3  insert a new topic after another one  ");
			System.out.println(" 4  remove a topic ");
			System.out.println(" 5  modify a topic  ");
			System.out.println(" 6  search topics for a word  ");
			System.out.println(" 7  load from a file(enter inputFiles.txt) ");
			System.out.println(" 8  show all words starting with a given letter ");
			System.out.println(" 9  save to file ");
			System.out.println(" 0  exit ");
			System.out.println("-----------------------------");
			System.out.print("Enter your choice:");
			choice = keyIn.nextInt();
			
			try {
				switch(choice) {
				case 1:
					option1(myList);
					break;
				case 2:
					option2(myList);
					break;
				case 3:
					option3(myList);
					break;
				case 4:
					option4(myList);
					break;
				case 5:
					option5(myList);
					break;
				case 6:
					option6(myList);
					break;
				case 7:
					System.out.println("Enter the name of the input file: ");
					fileName = keyIn.next();
					myList = readFile(fileName);
					break;
				case 8:
					option8(myList);
					break;
				case 9:
					saveToFile(myList,fileName);
					break;
				}
			}
			catch(Exception e) {
				System.out.println("No vocab Objects");
			}
			
			
			
			
		} while (choice !=0);
		
		System.out.println("Goodbye!");
		keyIn.close();
	}
	
	/**
     * This method reads from a file and returns a DLL
     * 
     * @param fileName 
     * @return DoublyLinkedList
     */
	public static DoublyLinkedList readFile(String fileName) {
		
	
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream(fileName));
			System.out.println("Done loading");
		}
		catch (FileNotFoundException e) {
			System.out.println(fileName+ " not found or could not be opened");
		}
		
		DoublyLinkedList myVocabList = new DoublyLinkedList();
		Vocab currentVocab= null;
		
		//checking if file has lines
		while(input.hasNextLine()) {
			String line = input.nextLine();
			if (!line.isEmpty()) {
				if (line.charAt(0) == '#') {
					currentVocab = new Vocab(line.substring(1));
					myVocabList.addAtTail(currentVocab);
				} else {
					currentVocab.getWords().addAtEnd(line);
				} 
			}
			
			
		}
	
		return myVocabList;
		
	}
	/**
     * This method displays a list of all topics
     * 
     * @param takes DLL myList
     */
	public static void displayTopics(DoublyLinkedList myList) {
		System.out.println("------------------------------");
		System.out.println("          Pick a topic        ");
		System.out.println("------------------------------");
		myList.displayTopics();
		System.out.println("0  Exit");
		System.out.println("------------------------------");
		
	}
	
	
	/**
     * This method allows users to browse through topics
     * 
     * @param DLL myList
     */
	public static void option1(DoublyLinkedList myList) {
		int choice =0;
		Scanner keyIn= new Scanner(System.in);
		do {
			displayTopics(myList);
			System.out.print("Enter your choice:");
			
			choice = keyIn.nextInt();
			if (choice !=0) {
				System.out.println("Topic: " + myList.getVocab(choice).getTopic());
				myList.displayWords(myList.getVocab(choice).getTopic());
			}
			
		} while (choice !=0);
		
		
	}
	
	/**
     * This method takes a DLL and adds a topic before another one
     * 
     * @param DLL myList
     */
	public static void option2(DoublyLinkedList myList) {
		
		Scanner keyIn;
		int choice;
		do {
			displayTopics(myList);
			System.out.print("Enter your choice:");
			keyIn = new Scanner(System.in);
			choice = keyIn.nextInt();
			keyIn.nextLine();
			if (choice > myList.getSize()) {
				System.out.println("Invalid number.");
			} 
		} while (choice>myList.getSize());
		System.out.println("Enter a topic name:");
		
		String topicName = keyIn.nextLine();
		System.out.println("Enter a word - to quit press Enter");
		Vocab myVocab = new Vocab(topicName);
		String word;
		SinglyLinkedList myWords = new SinglyLinkedList();
		do {
			word= keyIn.nextLine();
			if (!word.isEmpty()) {
				myWords.addAtEnd(word);
			}
			
		}while (!word.isEmpty());
		myVocab.setWords(myWords);
		myList.addBefore(myList.getVocab(choice), myVocab);
		
	}
	
	
	/**
     * This method takes a DLL and adds a topic after another one
     * 
     * @param DLL myList
     */
	public static void option3(DoublyLinkedList myList) {
		
		Scanner keyIn;
		int choice;
		do {
			displayTopics(myList);
			System.out.print("Enter your choice:");
			keyIn = new Scanner(System.in);
			choice = keyIn.nextInt();
			keyIn.nextLine();
			if (choice > myList.getSize()) {
				System.out.println("Invalid number.");
			} 
		} while (choice>myList.getSize());
		System.out.println("Enter a topic name:");
		
		String topicName = keyIn.nextLine();
		System.out.println("Enter a word - to quit press Enter");
		Vocab myVocab = new Vocab(topicName);
		String word;
		SinglyLinkedList myWords = new SinglyLinkedList();
		do {
			word= keyIn.nextLine();
			if (!word.isEmpty()) {
				myWords.addAtEnd(word);
			}
			
		}while (!word.isEmpty());
		myVocab.setWords(myWords);
		myList.addAfter(myList.getVocab(choice), myVocab);
		
	}
	
	/**
     * This method removes a topic
     * 
     * @param DLL myList
     */
	public static void option4(DoublyLinkedList myList) {
		displayTopics(myList);
		
		System.out.print("Enter your choice:");
		Scanner keyIn = new Scanner(System.in);
		int choice = keyIn.nextInt();
		System.out.println("------------------------------");
		myList.remove(myList.getVocab(choice));
		
		
	}
	
	/**
     * This method is used to modify a topic
     * 
     * @param DLL myList
     */
	public static void option5(DoublyLinkedList myList) {
		displayTopics(myList);
		
		System.out.print("Enter your choice:");
		Scanner keyIn = new Scanner(System.in);
		int choice = keyIn.nextInt();
		System.out.println("------------------------------");
		System.out.println("     Modify Topics Menu");
		System.out.println("------------------------------");
		System.out.println("a add a word");
		System.out.println("r remove a word");
		System.out.println("c change a word");
		System.out.println("0 Exit");
		System.out.println("------------------------------");
		System.out.print("Enter your choice:");
		String choice2 = keyIn.next();
		
		String word;
		switch (choice2){
		case "a":
			keyIn.nextLine();
			System.out.println("Enter a word:");
			word = keyIn.nextLine();
			Vocab myVocab = myList.getVocab(choice);
			myVocab.getWords().addAtHead(word);
			break;
		
		case "r":
			keyIn.nextLine();
			System.out.println("Enter a word:");
			word  = keyIn.nextLine();
			Vocab myVocab1 = myList.getVocab(choice);
			myVocab1.getWords().remove(word);
			break;
		
		case "c":
			keyIn.nextLine();
			myList.getVocab(choice).getWords().display();
			System.out.print("Enter the number of the word you want to modify:");
			int choice3 = keyIn.nextInt();
			keyIn.nextLine();
			System.out.println("Enter new word:");
			String newWord=keyIn.nextLine();
			myList.getVocab(choice).getWords().addAfter(myList.getVocab(choice).getWords().findWord(choice3), newWord);
			myList.getVocab(choice).getWords().remove(myList.getVocab(choice).getWords().findWord(choice3));
			break;
		case "0":
			break;
			
			
		}
		
			
	}
	
	/**
     * This method searches every topic for a word
     * 
     * @param DLL myList
     */
	public static void option6(DoublyLinkedList myList) {
		System.out.print("Enter the word:");
		Scanner keyIn = new Scanner(System.in);
		String word = keyIn.nextLine();
		boolean found = false;
		for (int i=1;i<=myList.getSize();i++) {
			for (int j=1;j<=myList.getVocab(i).getWords().getSize();j++) {
				if (myList.getVocab(i).getWords().findWord(j).equals(word)) {
					found = true;
					System.out.println("Word found in topic: "+ myList.getVocab(i).getTopic());
					break;
				}
			}
		}
		if (found == false) {
			System.out.println("Word not found.");
		}
		
	}
	/**
     * This method prints all words starting with the same letter in alphabetical order
     * 
     * @param DLL myList
     */
	public static void option8(DoublyLinkedList myList) {
		System.out.print("Enter a letter:");
		
		Scanner keyIn =new Scanner(System.in);
		char letter = Character.toLowerCase(keyIn.next().charAt(0));
		ArrayList<String> list = new ArrayList<>();

		//checking ever word from every topic to see if they match the first letter
		
		for (int i=1;i<=myList.getSize();i++) {
			for (int j=1;j<=myList.getVocab(i).getWords().getSize();j++) {
				if (Character.toLowerCase(myList.getVocab(i).getWords().findWord(j).charAt(0)) == letter) {
					list.add(myList.getVocab(i).getWords().findWord(j));
					
				}
			}
		}
		sortArrayList(list);
		
		for (String item : list) {
		    System.out.println(item);
		}

		
		
	}
	
	/**
     * This method saves the contents of the DLL to fileName
     * 
     * @param DLL myList
     * @param String fileName
     */
	public static void saveToFile(DoublyLinkedList myList,String fileName) {
		PrintWriter fileOut = null;
		try {
			fileOut = new PrintWriter(new FileOutputStream(fileName,false));
			for (int i=1;i<=myList.getSize();i++) {
				fileOut.println("#"+myList.getVocab(i).getTopic());
				for (int j=1;j<=myList.getVocab(i).getWords().getSize();j++) {
					fileOut.println(myList.getVocab(i).getWords().findWord(j));
					
				}
				fileOut.println();
			}
			System.out.println("Successfully saved to file.");
		}
		catch(FileNotFoundException e){
			System.out.println("File could not be found or opened.");
			
		}
		finally {
			fileOut.close();
		}
		
	
		
	}
	/**
     * This method takes an arrayList and sorts it in alphabetical order
     * 
     * @param ArrayList list
     */
	 public static void sortArrayList(ArrayList<String> list) {
	        int n = list.size();
	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
	                    minIndex = j;
	                }
	            }
	            if (minIndex != i) {
	                // Swap elements if they are out of order
	                String temp = list.get(i);
	                list.set(i, list.get(minIndex));
	                list.set(minIndex, temp);
	            }
	        }
	    }
	
	

	
	
	
	

}
