
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookShelf {

	private Map<Integer, Book> isbnToBook = new HashMap<>();
	
	public BookShelf() {
		
	}

	public Map<Integer, Book> getIsbnToBook() {
		return isbnToBook;
	}
	public void addBook(Book newBook) {
		int isbn = newBook.getIsbn();
		if (isbnToBook.containsKey(isbn)) {
			throw new IllegalArgumentException("The book with specified ISBN already exists");
		}
		isbnToBook.put(isbn, newBook);
	}

	public void removeBook(int isbn) {
		if (!isbnToBook.containsKey(isbn)) {
			throw new IllegalArgumentException("The book with specified ISBN doesn't exist");
		}
		isbnToBook.remove(isbn);
	}
	
	public void displayByTitle(String title) {
		Collection<Book> books = isbnToBook.values();
		for (Book book : books) {
			if (title.equals(book.getTitle())) {
				System.out.println(book.toString());
			}
		}
	}
	
	public void dosplayByAuthor(String author) {
		Collection<Book> books = isbnToBook.values();
		for (Book book : books) {
			if (author.equals(book.getAuthor())) {
				System.out.println(book.toString());
			}
		}
	}
	
	public Book lookUpByIsbn(int isbn) {
		return isbnToBook.get(isbn);
	}
	

}
