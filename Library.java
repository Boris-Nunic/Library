
public class Library {

	private boolean isOpen = false;
	private BookShelf bookSelf = new BookShelf();
	private LibraryMembers libraryMembers = new LibraryMembers();

	public Library() {
		
	}

	/**
	 * @return the book shelf
	 */
	public BookShelf getBookShelf() {
		if (!isOpen()) {
			return null;
		}
		return bookSelf;
	}

	/**
	 * @return the members
	 */
	public LibraryMembers getLibraryMembers() {
		if (!isOpen()) {
			return null;
		}
		return libraryMembers;
	}
	
	/**
	 * @return the isOpen
	 */
	public boolean isOpen() {
		return isOpen;
	}
	
	/** Open library and load data */
	public void open(){
		this.isOpen = true;
	}
	
	/** Save data and close library */
	public void close() {
		this.isOpen = false;
		
	}
	
	public void setBookShelf(BookShelf bookShelf) {
		this.bookSelf = bookShelf;
	}
	
	public void setLibraryMembers(LibraryMembers libraryMembers) {
		this.libraryMembers = libraryMembers;
	}

	/** Borrow a book to a member */
	public void borrowBook(int isbn, int memberId) {
		Member member = getLibraryMembers().lookupById(memberId);
		if (!member.canBorrow()) {
			throw new IllegalArgumentException("Member cannot borrow more books");
		}
		Book book = getBookShelf().lookUpByIsbn(isbn);
		if (book.isBorrowed()) {
			throw new IllegalArgumentException("This book is already borrowed"); 
		}
		book.setIsBorrowed(true);
		book.setBorrowDate();
		member.getBorrowedBooks().add(book.getIsbn());
	}

	/** Return borrowed book */
	public void returnBook(int isbn, int memberId) {
		Member member = getLibraryMembers().lookupById(memberId);
		if (!member.getBorrowedBooks().contains(isbn)) {
			throw new IllegalArgumentException("There's no match");
		}
		member.getBorrowedBooks().remove(isbn);
		Book book = getBookShelf().lookUpByIsbn(isbn);
		book.setIsBorrowed(false);
		book.setBorrowDate(0);
	}

}
