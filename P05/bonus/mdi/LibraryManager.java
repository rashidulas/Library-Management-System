package mdi;
import java.util.Scanner;
import library.Library;
import library.Publication;
import library.Video;
import library.InvalidRuntimeException;
import library.Patron;


public class LibraryManager
{
	public static void main(String[] args)
	{
		Library library= new Library("Sami's Library\n");
		
		library.addPublication(new Publication("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addPublication(new Publication("1984", "George Orwell", 1949));
        library.addPublication(new Publication("The Picture of Dorian Gray", "Oscar Wilde", 1913));
		
		try
		{
		library.addPublication(new Video("Casablanca", "Michael Curtiz", 1942, 102));
		library.addPublication(new Video("Gone with the Wind", "Victor Fleming", 1939, 238));
		library.addPublication(new Video("Star Wars: Episode IV - A New Hope", " George Lucas", 1977, 121));
		}
		catch(InvalidRuntimeException e)
		{
			System.out.println("Invalid runtime exception: "+e.getMessage());
		}
		
		Patron patron=new Patron("Md Rashidul Alam Sami","rashidulalam@gmail.com");
		library.addPatron(patron);
		System.out.println(library);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Which publication to check out? ");
		int publicationIndex= scanner.nextInt();
		
		System.out.println(library.patronMenu());
		scanner.nextLine();
		System.out.print("Your Name: ");
		int patronIndex=scanner.nextInt();
		
		try
		{
			library.checkOut(publicationIndex, patronIndex);
			System.out.println("Book checked out successfully.");
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Invalid publication index. Enter valid index");
		}
		
		System.out.println("Sami's Library");
		System.out.println(library);
		
		scanner.close();
	}
}