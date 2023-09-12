import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Publication> publications = new ArrayList<>();

    public Library(String name){
        this.name = name;
    }

    public void addPublication(Publication publication){
        publications.add(publication);
    }

    public void checkOut(int publicationIndex , String patron){
        if(publicationIndex >= 0 && publicationIndex < publications.size()){
            publications.get(publicationIndex).checkOut(patron);
        }
        else{
            throw new IndexOutOfBoundsException("Invalid publication index");
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        for(int i = 0; i < publications.size(); i++){
            sb.append(i).append(") ").append(publications.get(i)).append("\n");
        }
        return sb.toString();
    }
}
