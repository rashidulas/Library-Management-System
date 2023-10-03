package mdi;
import java.util.Scanner;
import library.Library;
import library.Publication;
import library.Video;
import library.Patron;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibraryManager 
{
    private Library library;  
    public LibraryManager(Library library) 
    {
        this.library = library;
    }

    public void listPublications() 
    {
            System.out.println("=================");
            System.out.println("Library Catalogue");
            System.out.println("=================");
            System.out.println(library);
    }

    public void checkInPublication(int publicationIndex) 
    {
        try 
        {
            Publication publication = library.checkIn(publicationIndex);
            Patron loanedTo = publication.LOANEDTO(); 
            System.out.println("Checked in." + (loanedTo != null ? loanedTo.toString() : ""));
        } 
        catch (IndexOutOfBoundsException e) 
        {
            System.out.println("Invalid index");
        }
    }

    public void checkOutPublication(int publicationIndex, int patronIndex) 
    {
        try 
        {
            library.checkOut(publicationIndex, patronIndex);
            System.out.println("Checked out.");
        } 
        catch (IndexOutOfBoundsException e) 
        {
            System.out.println("Invalid index");
        }
    }

    public void addPublication()
    {
        Scanner scannerA = new Scanner(System.in);
        System.out.print("Title: ");
        String titleOf = scannerA.nextLine();
        System.out.print("Author: ");
        String authorOf = scannerA.nextLine();
        System.out.print("Year: ");
        int yearPublished = Integer.parseInt(scannerA.nextLine());
        Publication publicationToBe = new Publication(titleOf, authorOf, yearPublished);
        library.addPublication(publicationToBe);
        System.out.println("Added: " + publicationToBe.toString());
    }

    public void addVideo() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Title: ");
        String titleOf = scanner.nextLine();
        System.out.print("Author: ");
        String authorOf = scanner.nextLine();
        System.out.print("Year: ");
        int yearLaunched = Integer.parseInt(scanner.nextLine());
        System.out.print("Runtime (minutes): ");
        int runtimeOf = Integer.parseInt(scanner.nextLine());
        Video videoToBe = new Video(titleOf, authorOf, yearLaunched, runtimeOf);
        library.addPublication(videoToBe);
        System.out.println("Added: " + videoToBe.toString());
    }
    

    public void addPatron() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String nameOf = scanner.nextLine();
        System.out.print("Email: ");
        String emailOf = scanner.nextLine();
        library.addPatron(new Patron(nameOf, emailOf));
        System.out.println("Added.");
    }

    public void listPatrons()
    {
        System.out.println(library.patronMenu());
    }

    
    public void loadData(String filename) throws IOException 
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
        {
            String typeOf = "";
            String titleOf = "";
            String authorOf = "";
            int yearPublished = 0;
            int runtimeOf = 0;
            String newLine;
            while ((newLine = br.readLine()) != null) 
            {
                if (newLine.startsWith("Publication")) 
                {
                    typeOf = "Publication";
                } 
                else if (newLine.startsWith("Video")) 
                {
                    typeOf = "Video";
                } 
                else if (newLine.startsWith("Title:")) 
                {
                    titleOf = newLine.substring(7).trim();
                } 
                else if (newLine.startsWith("Author:")) 
                {
                    authorOf = newLine.substring(8).trim();
                } 
                else if (newLine.startsWith("Copyright:")) 
                {
                    yearPublished = Integer.parseInt(newLine.substring(11).trim());
                    if (typeOf.equals("Publication")) 
                    {
                        Publication newPublication = new Publication(titleOf, authorOf, yearPublished);
                        library.addPublication(newPublication);
                    } 
                    else if (typeOf.equals("Video")) 
                    {

                    }
                } 
                else if (newLine.startsWith("Runtime:")) 
                {
                    runtimeOf = Integer.parseInt(newLine.substring(8).trim());
                    Video newVideo = new Video(titleOf, authorOf, yearPublished, runtimeOf);
                    library.addPublication(newVideo);
                } 
                else if (newLine.startsWith("Patron")) 
                {
                    typeOf = "Patron";
                } 
                else if (newLine.startsWith("Name:")) 
                {
                    String name = newLine.substring(6).trim();
                    newLine = br.readLine();
                    String email = newLine.substring(7).trim();
                    Patron newPatron = new Patron(name, email);
                    library.addPatron(newPatron);
                }
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Failed to load: " + e.getMessage());
        }
        System.out.println("File: " + filename);
    }
    
    public static void main(String[] args) 
    {
    Library library = new Library("The Library at Lumbini (Nepal)");
    LibraryManager run = new LibraryManager(library);

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("==========");
        System.out.println("Main Menu");
        System.out.println("==========");
        System.out.println();
        System.out.println("The Library at Lumbini (Nepal)");
        System.out.println();
        System.out.println("Publications");
        System.out.println("1) List");
        System.out.println("2) Add");
        System.out.println("3) Check Out");
        System.out.println("4) Check In");
        System.out.println();
        System.out.println("Patrons");
        System.out.println("5) List");
        System.out.println("6) Add");
        System.out.println();
        System.out.println("Files");
        System.out.println("7) Load File");
        System.out.println("0) Exit");
        System.out.println();
        System.out.print("Selection : ");
        String userInput = scanner.nextLine();

        switch (userInput) 
        {
            case "1":
                run.listPublications();
                break;
            case "2":
                Scanner inpt = new Scanner(System.in);
                System.out.println("Press 1 for video and 0 for book");
                Integer opt = inpt.nextInt();
                if(opt == 0)
                {
                    run.addPublication();
                }
                else
                {
                    run.addVideo();
                }
                break;
            case "3":
                System.out.print("Publication Index: ");
                int publicationIndex = Integer.parseInt(scanner.nextLine());
                System.out.print("Patron Index: ");
                int patronIndex = Integer.parseInt(scanner.nextLine());
                run.checkOutPublication(publicationIndex, patronIndex);
                break;
            case "4":
                System.out.print("Publication index: ");
                int publicationIndexIn = Integer.parseInt(scanner.nextLine());
                run.checkInPublication(publicationIndexIn);
                break;
            case "5":
                run.listPatrons();
                break;
            case "6":
                run.addPatron();
                break;
            case "7":
                try 
                {
                    run.loadData("library.txt");
                } 
                catch (IOException e) 
                {
                    System.out.println("Failed: " + e.getMessage());
                }
                break;
            case "0":
                scanner.close();
                return;
            default:
                System.out.println("Try again.");
        }
    }
}
}