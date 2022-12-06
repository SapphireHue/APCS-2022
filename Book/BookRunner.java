public class BookRunner
{
	public static void main(String args[])
	{
		Book textBook = new Book();
		System.out.println(textBook);  //What does this line do?

		Book book1 = new Book("Hitchhikers Guide to the Galaxy", 345391802);
		System.out.println(book1);

		textBook.setBookName("Learn JAVA now!!!");
		textBook.setBookISBN(12345678);

		System.out.println("Book 0 name: "+ textBook.getBookName() + " ISBN(" + textBook.getBookISBN() + ")");
		System.out.println("Book 1 name: "+ book1.getBookName() + " ISBN(" + book1.getBookISBN() + ")");

		System.out.println(textBook);
		System.out.println(book1);
	}
}