
import java.util.ArrayList;

public class Member {

	static final int MIN_ID = 1;
	static final int BOOKS_ALLOWED = 3;
	private int id;
	private String name;
	private ArrayList<Integer> borrowedBooks = new ArrayList<>();

	public Member() {

	}

	public Member(int id, String name) {
		setId(id);
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/** Return reference to list of borrowed books */
	public ArrayList<Integer> getBorrowedBooks() {
		return borrowedBooks;
	}

	/** Return true if member can borrow more books */
	public boolean canBorrow() {
		return borrowedBooks.size() < BOOKS_ALLOWED;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		if (id < MIN_ID) {
			throw new IllegalArgumentException("ID must be positive integer");
		}
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String s = getId() + "#" + getName() + "#";
		for (Integer i : borrowedBooks) {
			s += i + "#";
		}
		return s;
	}
}
