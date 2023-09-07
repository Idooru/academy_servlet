package sec01.ex01;

public class BookVO {

	private int bookId;
	private String bookName;
	private String bookCompany;
	private int bookPrice;

	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCompany() {
		return bookCompany;
	}

	public void setBookCompany(String bookCompany) {
		this.bookCompany = bookCompany;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", bookName=" + bookName + ", bookCompany=" + bookCompany + ", bookPrice="
				+ bookPrice + "]";
	}
	
}
