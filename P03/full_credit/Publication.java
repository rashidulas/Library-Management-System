import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Publication {

    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    public Publication(String title, String author, int copyright){
        int year = LocalDate.now().getYear();
        if(copyright < 1900 || copyright > year){
            throw new IllegalArgumentException("Invalid year", null);
        }

        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    public void checkOut(String patron){
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    public void checkIn(){
        this.loanedTo = null;
        this.dueDate = null;
    }

    @Override 
    public String toString()
    {
        String info = title +  " by " + author + "," + "copyright" + copyright + 
                      " --> loaned to " + loanedTo + " until " + dueDate;
        
        if(loanedTo == null)
        {
            return title + " by " + author + " (Copyright " + copyright + ")";
        } 
        return info;
    }
    
}
