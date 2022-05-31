
public class Book {
	private String library, id, name, desc;
	private int price;
	
	public Book(String library, String id, String name, String desc, int price) {
		super();
		this.library = library;
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
