
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		Library library = new Library();
		while (!library.isOpen()) {
			System.out.println("To open library enter 1");
			int open = MethodsForMenu.getInteger();
			if (open == 1) {
				library.open();
				library.setBookShelf(SaveLoad.loadBooks());
				library.setLibraryMembers(SaveLoad.loadMembers());
			}
		}
		while (library.isOpen()) {
			System.out.println("1> Book Menu\n2> Member Menu\n3> Quit");
			int select = MethodsForMenu.getInteger();
			// Check input
			if (select < 1 || select > 4) {
				System.out.println("Ivalid Input\n");
				continue;
			}
			switch (select) {
			case 1:
				boolean menu = true;
				while (menu) {
					System.out.println(
							"1> Add new book\n2> Remove book\n3> Borrow book\n4> Return book\n5> Info\n6> Back");
					select = MethodsForMenu.getInteger();
					if (select < 1 || select > 6) {
						System.out.println("Invalid input");
						continue;
					}
					switch (select) {
					case 1:
						MethodsForMenu.addBook(library);
						break;
					case 2:
						MethodsForMenu.removeBook(library);
						break;
					case 3:
						MethodsForMenu.borrowBook(library);
						break;
					case 4:
						MethodsForMenu.returnBook(library);
						break;
					case 5:
						menu = true;
						while (menu) {
							System.out.println("\nDisplay book(s) by ");
							System.out.println("1> author\n2> title\n3> Back");
							select = MethodsForMenu.getInteger();
							if (select < 1 || select > 4) {
								System.out.println("Invalid input");
								continue;
							}
							switch (select) {
							case 1:
								System.out.println("Eneter author:");
								String author = input.nextLine();
								library.getBookShelf().dosplayByAuthor(author);
								break;
							case 2:
								System.out.println("Enter title:");
								String title = input.nextLine();
								library.getBookShelf().displayByTitle(title);
								break;
							case 3:
								menu = false;
								break;
							}
						}
						break;
					case 6:
						menu = false;
						break;
					}
				}
				break;
			case 2:
				menu = true;
				while (menu) {
					System.out.println("1> Add Member\n2> Remove member\n3> Back");
					select = MethodsForMenu.getInteger();
					if (select < 1 || select > 4) {
						System.out.println("Invalid input");
						continue;
					}
					switch (select) {
					case 1:
						MethodsForMenu.addMember(library);
						break;
					case 2:
						MethodsForMenu.removeMember(library);
						break;
					case 3:
						menu = false;
						break;
					}
				}
				break;
			case 3:
				System.out.println("Are sure yout wish to quit, all data will be saved\n1> Yes\n2> No");
				select = MethodsForMenu.getInteger();
				if (select != 1 && select != 2) {
					System.out.println("Invalid input");
					continue;
				}
				if (select == 1) {
					SaveLoad.saveBooks(library.getBookShelf());
					SaveLoad.saveMembers(library.getLibraryMembers());
					library.close();
				}
			}
		}

	}

	
}
