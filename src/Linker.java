import java.util.LinkedList;

public class Linker {

    private String PhotoFile;
    private String description; // Changed from LinkedList<String> to String

    public Linker(String PF, String d) {
        this.PhotoFile = PF;
        this.description = d;
    }

    public String getDescription() {
        return description;
    }

    public String getFile() {
        return PhotoFile;
    }

    public String toString() {
        return PhotoFile + ":\n" + description + "\n"; // Modified to handle a single String for description
    }
}
