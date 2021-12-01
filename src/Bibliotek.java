
public class Bibliotek {

	public static void main(String[] args) {
		boolean fortsatt = true;
		Register reg = new Register();
		Dialog dialog = new Dialog();
		reg.readFromFile("bockernasRegister.txt");
		dialog.printString("test5");
		while (fortsatt) {
			switch (dialog.readInt("v�lj nummer\n1. l�gg till bok\n2. ta bort bok\n3. visa b�cker\n4. avsluta\n5. s�k f�rfattare\n6. s�k titel")) {
			case 1:
				reg.addBook(dialog.readString("skriv f�rfattare"), dialog.readString("skriv boktitel"));
				break;
				
			case 2:
				reg.removeBook(dialog.readString("skriv f�rfattare"));
				break;
				
			case 3:
				dialog.printString(reg.sortAuthor());
				break;
				
			case 4:
				fortsatt = false;
				reg.writeToFile("bockernasRegister.txt");
				break;
				
			case 5:
				reg.seekAuthor(dialog.readString("skriv f�rfattare"));
				break;
				
			case 6:
				reg.seekTitle(dialog.readString("skriv titel"));
				break;
			}
		}
	}
}
