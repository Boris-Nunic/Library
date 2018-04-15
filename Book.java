
import java.util.Date;

public class Book {

	static final int MIN_ISBN = 1;
	private int isbn;
	private String author;
	private String title;
	private boolean isBorrowed;
	private long borrowDate;

	public Book() {

	}

	public Book(int isbn, String author, String title) {
		setIsbn(isbn);
		this.author = author;
		this.title = title;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setIsbn(int isbn) {
		if (isbn < MIN_ISBN) {
			throw new IllegalArgumentException("ISBN must be positive integer");
		}
		this.isbn = isbn;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param isBorrowed
	 *            the borrowed to set
	 */
	public void setIsBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setBorrowDate() {
		this.borrowDate = System.currentTimeMillis();
	}
	
	/** set borrowDate with specified milliseconds  */
	public void setBorrowDate(long millis) {
		this.borrowDate = millis;
	}

	/**
	 * @return the date the book is borrowed on
	 */
	public Date getBorrowDate() {
		if (borrowDate == 0) {
			return null;
		}
		return new Date(borrowDate);
	}
	
	/** return milliseconds that represents the date the book is borrowed on */
	public long getBorrowMilis() {
		return borrowDate;
	}

	/**
	 * @return the id
	 */
	public int getIsbn() {
		return isbn;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the borrowed
	 */
	public boolean isBorrowed() {
		return isBorrowed;
	}

	@Override
	public String toString() {
		return getIsbn() + "#" + getAuthor() + "#" + getTitle() + "#" + isBorrowed() + "#" + getBorrowMilis();
	}
}
