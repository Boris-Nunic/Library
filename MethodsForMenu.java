
import java.util.Scanner;

public class MethodsForMenu {
	static Scanner input = new Scanner(System.in);

	public static void addMember(Library library) {
		System.out.println("Enter ID:");
		int id = getInteger();
		System.out.println("Enter name:");
		String name = input.nextLine();
		Member member = new Member(id, name);
		try {
			library.getLibraryMembers().registerNewMember(member);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removeMember(Library library) {
		System.out.println("Enter ID");
		int id = getInteger();
		try {
			library.getLibraryMembers().removeMember(id);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addBook(Library library) {
		System.out.println("Enter ISBN:");
		int isbn = getInteger();
		System.out.println("Enter author");
		String author = input.nextLine();
		System.out.println("Enter title");
		String title = input.nextLine();
		Book book = new Book(isbn, author, title);
		try {
		library.getBookShelf().addBook(book);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		

	}

	public static void removeBook(Library library) {
		System.out.println("Enter ISBN");
		int isbn = getInteger();
		try {
		library.getBookShelf().removeBook(isbn);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void borrowBook(Library library) {
		System.out.println("Enter member's ID");
		int id = getInteger();
		System.out.println("Enter books ISBN:");
		int isbn = getInteger();
		try {
		library.borrowBook(isbn, id);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void returnBook(Library library) {
		System.out.println("Enter member's ID");
		int id = getInteger();
		System.out.println("Enter book's ISBN:");
		int isbn = getInteger();
		try {
		library.returnBook(isbn, id);
		}
		catch(IllegalArgumentException e) {
			e.getMessage();
		}
	}

	public static int getInteger() {

		do {
			try {
				int n = input.nextInt();
				input.nextLine();
				return n;
			} catch (Exception e) {
				System.out.println("Enter Integer:");
				input.nextLine();

			}
		} while (true);
	}

}
