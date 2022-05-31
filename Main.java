import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Vector<Book> bookVector = new Vector<>();
	Scanner scan = new Scanner(System.in);
	
	public Main() {
		int input;
		
		do {
			System.out.println("Welcome to JuGlib");
			System.out.println("1. View Book");
			System.out.println("2. Add Book");
			System.out.println("3. Update Book");
			System.out.println("4. Exit");
			System.out.print("Choose [1-4] >> ");
			
			input = scan.nextInt();
			scan.nextLine();
			
			switch (input) {
			case 1:
				viewBook();
				break;
			case 2:
				addBook();				
				break;
			case 3:
				updateBook();
				break;
			}
		} while (input != 4);
	}
	
	public void viewBook() {
		if(bookVector.isEmpty()) {
			System.out.println("There is no book.");
			System.out.println("Press enter to continue...");
		}else {
			System.out.println("List of Book:");
			System.out.println("==============================================================================================================");
			System.out.printf("|| %-12s|| %-9s|| %-21s|| %-11s|| %-21s|| %-16s||\n", "Library Name","Book Id", "Book Name", "Book Price", "Book Description", "Library Country");
			System.out.println("==============================================================================================================");
			
			for(int i=0; i<bookVector.size(); i++) {
				Book book = bookVector.get(i);
				
				if(book.getLibrary().equals("EchLib")) {
					System.out.printf("|| %12s|| %-9s|| %-21s|| %-11s|| %-21s|| %-16s||\n", book.getLibrary(), book.getId(), book.getName(), book.getPrice(), book.getDesc(), "Singapore");
				}else if(book.getLibrary().equals("JustGoLib")) {
					System.out.printf("|| %-12s|| %-9s|| %-21s|| %-11s|| %-21s|| %-16s||\n", book.getLibrary(), book.getId(), book.getName(), book.getPrice(), book.getDesc(), "Indonesia");
				} else if(book.getLibrary().equals("XLib")) {
					System.out.printf("|| %-12s|| %-9s|| %-21s|| %-11s|| %-21s|| %-16s||\n", book.getLibrary(), book.getId(), book.getName(), book.getPrice(), book.getDesc(), "Malaysia");
				}
			}
				System.out.println("==============================================================================================================");
		}
	}
	
	public void addBook() {
		String library, id, name, desc;
		int price;
		
		System.out.print("Input book name >> ");
		name = scan.nextLine();
		
		do {
			System.out.print("Input book price [ more than 20000 ] >> ");
			price = scan.nextInt();
			scan.nextLine();
			
			if(price <= 20000) {
				System.out.println("Book price must be more than 20000!");
			}
		} while (price <= 20000);
		
		do {
			System.out.print("Input book description [ 5..20 ] >> ");
			desc = scan.nextLine();
			
			if(desc.length() < 5 || desc.length() > 20) {
				System.out.println("Description should be between 5 and 20 characters");
			}
		} while (desc.length() < 5 || desc.length() > 20);
		
		do {
			System.out.print("Input library name [ EchLib | JustGoLib | XLib ] >> ");
			library = scan.nextLine();
		} while (!library.equals("EchLib") && 
				!library.equals("JustGoLib") && 
				!library.equals("XLib"));
		
		Random rand = new Random();
		int[] num = new int[5];
		num[0] = rand.nextInt(10);
		num[1] = rand.nextInt(10);
		num[2] = rand.nextInt(10);
		num[3] = rand.nextInt(10);
		id = "BOOK" + num[0] + num[1] + num[2] + num[3];
		
		bookVector.add(new Book(library, id, name, desc, price));
	}
	
	public void updateBook() {
		if(bookVector.isEmpty()) {
			System.out.println("There is no book.");
			System.out.println("Press enter to continue...");
		}else {
			String id;
			int count = 0;
			
			System.out.print("Input Book Id [ e.g. BOOK1234 ] >> ");
			id = scan.nextLine();
			
			for(int i=0; i<bookVector.size(); i++) {
				int input;
				
				if(id.equals(bookVector.get(i).getId())) {
					count = 1;
					System.out.println("Update: ");
					System.out.println("1. Update book name");
					System.out.println("2. Update book price");
					System.out.println("3. Update book description");
					System.out.print("Choose [ 1 - 3 ] >> ");
					input = scan.nextInt();
					scan.nextLine();
					
					String newName, newDesc;
					int newPrice;
					
					switch (input) {
					case 1:
						System.out.print("Input book name >> ");
						newName = scan.nextLine();
						
						bookVector.get(i).setName(newName);
						System.out.println("Succesfully changed book name!");
						System.out.println("Press enter to continue...");
						break;
					case 2:
						do {
							System.out.print("Input book price [ more than 2000>> ");
							newPrice = scan.nextInt();
							scan.nextLine();
						} while (newPrice <= 20000);
						
						bookVector.get(i).setPrice(newPrice);
						System.out.println("Succesfully changed book price!");
						System.out.println("Press enter to continue...");
						break;
					case 3:
						do {
							System.out.print("Input book description [5..20 ] >> ");
							newDesc = scan.nextLine();
						} while (newDesc.length() < 5 || newDesc.length() > 20);
						
						bookVector.get(i).setDesc(newDesc);
						System.out.println("Succesfully changed book description!");
						System.out.println("Press enter to continue...");
						break;
					}
				}
			}
			
			if(count != 1) {
				System.out.println("Book Id not found!");
				System.out.println("Press enter to continue...");
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
