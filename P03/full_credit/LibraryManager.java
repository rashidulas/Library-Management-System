import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args){
        Library library = new Library("Dallas Library");
        library.addPublication(new Publication("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addPublication(new Publication("1984", "George Orwell", 1949));
        library.addPublication(new Publication("Pride and Prejudice", "Jane Austen", 1813));
        System.out.println(library);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of the publication you want to checkout: ");
        int index = sc.nextInt();
        System.out.println("Enter your name: ");
        sc.nextLine();
        String patron = sc.nextLine();
        library.checkOut(index, patron);
        System.out.println(library);
    }
}
