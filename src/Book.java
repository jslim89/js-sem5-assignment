public class Book
{
	private String isbn;
	private String title;
	private String publisher;
	private String author;
	private String type;
	private String description;
	private double rentPrice;
	private int quantity;
	
	public Book()
	{
		isbn = "";
		title = "";
		publisher = "";
		author = "";
		type = "";
		description = "";
		rentPrice = 0.0;
		quantity = 0;
	}
	
	public Book(String isbn,String title,String publisher,String author, String type, String description,double rentPrice,int quantity)
	{
		setISBN(isbn);
		setTitle(title);
		setPublisher(publisher);
		setAuthor(author);
		setType(type);
		setDescription(description);
		setRentPrice(rentPrice);
		setQuantity(quantity);
	}
	
	public void setISBN(String isbn)
	{ this.isbn = isbn; }
	
	public void setTitle(String title)
	{ this.title = title; }
	
	public void setPublisher(String publisher)
	{ this.publisher = publisher; }
	
	public void setAuthor(String author)
	{ this.author = author; }
	
	public void setType(String type)
	{ this.type = type; }
	
	public void setDescription(String description)
	{ this.description = description; }
	
	public void setRentPrice(double rentPrice)
	{ this.rentPrice = rentPrice; }
	
	public void setQuantity(int quantity)
	{ this.quantity = quantity; }
	
	public String getISBN()
	{ return isbn; }
	
	public String getTitle()
	{ return title; }
	
	public String getPublisher()
	{ return publisher; }
	
	public String getAuthor()
	{ return author; }
	
	public String getType()
	{ return type; }
	
	public String getDescription()
	{ return description; }
	
	public double getRentPrice()
	{ return rentPrice; }
	
	public int getQuantity()
	{ return quantity; } 
}