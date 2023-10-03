package library;
import java.time.LocalDate;

/**
 * A library resource that can be checked out by a patron.
 */
public class Publication 
{
    public static final int LOAN_PERIOD = 14;
    private String title;
    private String author;
    private int copyright;
    private Patron loanedTo;
    private LocalDate dueDate;

    public Patron LOANEDTO()
    {
        return loanedTo;
    }
    public Publication(String title, String author, int copyright) 
    {
        if (copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Invalid copyright year : " + copyright);
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    /**
     * Checks out the publication to a patron.
     *
     * @param patron The name of the patron checking out the publication.
     */
    public void checkOut(Patron patron) 
    {
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(LOAN_PERIOD);
    }

    /**
     * Returns a string representation of the publication.
     *
     * @return A string representation of the publication.
     */
    @Override
    public String toString() 
    {
        return toStringBuilder("Book ", "");
    }
    
    public void checkIn() 
    {
        this.loanedTo = null;
        this.dueDate = null;
    }
    
    /**
     * @param pre The prefix to add before the basic fields.
     * @param mid The suffix to add after the basic fields.
     * @return A formatted string representation.
     */
    protected String toStringBuilder(String pre, String mid) 
    {
        StringBuilder result = new StringBuilder();
        result.append(pre).append("\"").append(title).append("\" by ").append(author).append(", copyright ").append(copyright);
        result.append(mid);

        if (loanedTo != null) 
        {
            result.append(" \n: loaned to ").append(loanedTo).append(" until ").append(dueDate).append("\n");
        }
        return result.toString();
    }

    
}
