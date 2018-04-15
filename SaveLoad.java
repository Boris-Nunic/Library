
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class SaveLoad {

	private static Path books = Paths.get("books.txt");
	private static Path members = Paths.get("members.txt");

	private static void createFile(Path path) throws IOException {
		if (!Files.exists(path)) {
			Files.createFile(path);
		}
	}

	public static void saveBooks(BookShelf bookShelf) throws IOException {
		createFile(books);
		BufferedWriter writer = Files.newBufferedWriter(books);
		Collection<Book> collection = bookShelf.getIsbnToBook().values();
		for (Book book : collection) {
			String s = book.toString();
			writer.write(s);
			writer.newLine();
		}
		writer.close();
	}
	
	public static void saveMembers(LibraryMembers libraryMembers) throws IOException {
		createFile(members);
		BufferedWriter writer = Files.newBufferedWriter(members);
		Collection<Member> members= libraryMembers.getIdToMember().values();
		for (Member member : members) {
			writer.write(member.toString());
			writer.newLine();
		}
		writer.close();
	}

	public static BookShelf loadBooks() throws IOException {
		BookShelf result = new BookShelf();
		if (Files.exists(books)) {
			BufferedReader reader = Files.newBufferedReader(books);
			String line = reader.readLine();
			while (line != null) {
				Book book = constructBook(line.split("#"));
				result.addBook(book);
				line = reader.readLine();
			}
			reader.close();
		}
		return result;
	}
	
	public static LibraryMembers loadMembers() throws IOException {
		LibraryMembers result = new LibraryMembers();
		if (Files.exists(members)) {
			BufferedReader reader = Files.newBufferedReader(members);
			String line = reader.readLine();
			while (line != null) {
				Member member = constructMember(line.split("#"));
				result.registerNewMember(member);
				line = reader.readLine();
			}
			reader.close();
		}
		return result;
	}

	private static Book constructBook(String[] tokens) {
		final int ISBN = 0;
		final int AUTHOR = 1;
		final int TITLE = 2;
		final int IS_BORROWED = 3;
		final int DATE = 4;
		Book book = new Book(Integer.parseInt(tokens[ISBN]), tokens[AUTHOR], tokens[TITLE]);
		book.setBorrowDate(Long.parseLong(tokens[DATE]));
		book.setIsBorrowed(Boolean.parseBoolean(tokens[IS_BORROWED]));
		return book;

	}
	
	private static Member constructMember(String[] tokens) {
		final int ID = 0;
		final int NAME = 1;
		Member member = new Member(Integer.parseInt(tokens[ID]), tokens[NAME]);
		for (int i = NAME + 1; i < tokens.length; i++) {
			member.getBorrowedBooks().add(Integer.parseInt(tokens[i]));
		}
		return member;
	}

}
