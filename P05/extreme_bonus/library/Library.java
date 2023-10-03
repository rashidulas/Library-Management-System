// Copyright 2023 George F. Rice <https://github.com/prof-rice>
// Copyright 2023 Md Rashidul Alam Sami <https://github.com/rashidulas/>
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or 
// (at your option) any later version, see <https://www.gnu.org/licenses/>.
package library;
import java.util.ArrayList;
/**
 * Represents a library that holds a collection of publications.
 */
public class Library 
{
    public Library(String name) 
    {
        this.name = name;
        this.publications = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }
    /**
     * Adds a publication to the library's collection.
     *
     * @param publication The publication to add.
     */
    public void addPublication(Publication publication) 
    {
        publications.add(publication);
    }
    /**
     * Adds a patron.
     *
     * @param patron The patron to add.
     */
    public void addPatron(Patron patron) 
    {
        patrons.add(patron);
    }
    /**
     * Represents a patron menu.
     *
     * @param Patron Menu The patron to add.
     */
    public String patronMenu() 
    {
        StringBuilder newSb = new StringBuilder("Patrons\n\n");
        for (int i = 0; i < patrons.size(); ++i) 
        {
            newSb.append(i).append(")").append(patrons.get(i)).append("\n");
        }
        return newSb.toString();
    }
    /**
     * Checks out a publication to a patron by its index in the collection.
     *
     * @param publicationIndex The index of the publication to check out.
     * @param patron           The name of the patron checking out the publication.
     */
    public void checkOut(int publicationIndex, int patronIndex)
    {
        if (publicationIndex >= 0 && publicationIndex < publications.size()
                && patronIndex >= 0 && patronIndex < patrons.size()) 
        {
            Publication publication = publications.get(publicationIndex);
            Patron patron = patrons.get(patronIndex);
            publication.checkOut(patron);
            System.out.println(publications.get(patronIndex)+"Loaned to: " + patron);
        } 
        else 
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
    
    public Publication checkIn(int publicationIndex) 
    {
        if (publicationIndex >= 0 && publicationIndex < publications.size()) 
        {
            Publication publication = publications.get(publicationIndex);
            publication.checkIn();
            return publication;
        } 
        else 
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
    
@Override
public String toString() 
{
    StringBuilder sb = new StringBuilder(name + "\n\n");
    for (int i = 0; i < publications.size(); ++i) 
    {
        sb.append(i).append(") ").append(publications.get(i).toString()).append("\n");
    }
    return sb.toString();
}
    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Patron> patrons;
}