import java.util.ArrayList;
import java.util.Scanner; 
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Register {
	Dialog dialog = new Dialog();
	private ArrayList<Book> reg; // registret skall lagras i en ArrayList
	//... Konstruktor och alla metoderna f�r registerhanteringen
	public Register() {
		reg = new ArrayList<Book>();
		//skapa fil som det lagras i
	}
	
	public void addBook(String author, String title) {
		Book book = new Book(author, title);
		int index = 0;
		//OM F�RFATTARES NAMN �R L�NGRE FRAM I BOKSTAVSORDNINGEN �N TIDIGARE F�RFATTARE
		while (index < reg.size() && author.charAt(0) >= reg.get(index).getAuthor().charAt(0)) {
			index++;
		}
		reg.add(index, book);
	}
	
	public void removeBook(String author) {
		//letar efter r�tt index, bin�rs�k
		//radera p� index, se om index har samma titel, tar bort
		//if TITEL == TITEL {RADERA[i]}
		//IF INDEX+1 > INDEX && INDEX-1 < INDEX SLUTA
		//n�r index inte �r men har raderat, g� ned
		int index = 0;
		//OM F�RFATTARES NAMN �R L�NGRE FRAM I BOKSTAVSORDNINGEN �N TIDIGARE F�RFATTARE
		while (index < reg.size()) {
			if (author.equals(reg.get(index).getAuthor())) {
				reg.remove(index);
			} else {
				index++;
			}
		}
	}
	
	public void seekAuthor(String author) {
		int index = 0;
		String temp = "";
		String output = "";
		
		//KOLLA STORLEK, J�MF�R SIFFROR 
		while (index < reg.size()) {
			
			for (int i = 0; i < author.length(); i++) {
				if (author.charAt(i) == reg.get(index).getAuthor().charAt(i)) {
					temp += reg.get(index).getAuthor().charAt(i);
				} else {
					temp = "";
					break;
				}
			}
			System.out.println(index);
			if (author.equals(temp)) {
				output += reg.get(index).getAuthor() + " " + reg.get(index).getTitle() + "\n";
			}
			index++;
		}
		
		dialog.printString(output);
	}
	
	public void seekTitle(String title) {
		int index = 0;
		String temp = "";
		String output = "";
		
		//KOLLA STORLEK, J�MF�R SIFFROR 
		while (index < reg.size()) {
			
			for (int i = 0; i < title.length(); i++) {
				if (title.charAt(i) == reg.get(index).getTitle().charAt(i)) {
					temp += reg.get(index).getTitle().charAt(i);
				} else {
					temp = "";
					break;
				}
			}
			System.out.println(index);
			if (title.equals(temp)) {
				output += reg.get(index).getAuthor() + " " + reg.get(index).getTitle() + "\n";
			}
			index++;
		}
		
		dialog.printString(output);
	}
	
	public String sortAuthor() {
		//mata bara ut
		String retur = "B�CKER\n";
		for(int i = 0; i < reg.size(); i++) {
			retur += reg.get(i).getAuthor() + " " + reg.get(i).getTitle() + "\n";
		}
		return retur;
	}
	
	public void sortTitle() {
		
	}
	
	public String getBookAt(int i) {
		return reg.get(i).toString();
	}
	
	/** L�ser registret fr�n filen med namn fileName. */
	public void readFromFile(String fileName) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
			while(scan.hasNextLine()) {
				System.out.println("ja");
				addBook(scan.nextLine(), scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte �ppnas");
			System.exit(1);
		}
	}
	
	/** Sparar registret p� fil med namnet fileName. */
	public void writeToFile(String fileName) {
		PrintWriter out = null;
		String inmatning = "";
		try {
			out = new PrintWriter(new File(fileName)); //"bockernasRegister.txt"
			for(int i = 0; i < reg.size(); i++) {
				inmatning += reg.get(i).getAuthor() + "\n" + reg.get(i).getTitle() + "\n";
			}
			out.write(inmatning);
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte �ppnas");
			System.exit(1);
		}
		out.close(); // st�nger filen
	}
}