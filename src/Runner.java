import java.util.*;
import java.io.*;
import java.sql.DatabaseMetaData;

public class Runner {

    public static void main(String[] agrs) throws IOException {

        LinkedList<Photo> photo = new LinkedList<Photo>();
        getData(photo);

        print(photo);
        System.out.println("DONE");
    }

    public static void getData(LinkedList<Photo> photo) throws IOException {
        FileReader myFile = new FileReader("database.dick");
        Scanner scan = new Scanner(myFile);
        int amtPhotos = 0;

        while (scan.hasNext()) {
            int weekNum = scan.nextInt();

            String ActivityName = scan.next();
            amtPhotos = scan.nextInt();
            

            String PhotoFile;
            LinkedList<String> description = new LinkedList<String>();
            var photos = new LinkedList<Linker>();

            for (int i = 0; i < amtPhotos; i++) {
                PhotoFile = scan.next();

                description = Description(scan);
                StringBuilder desVal = new StringBuilder();
                for (String descLine : description) {
                    desVal.append(check(descLine));
                }

                photos.add(new Linker(PhotoFile, desVal.toString()));
            }

            String space = scan.next();

            ActivityName = check(ActivityName);

            photo.add(new Photo(weekNum, ActivityName, amtPhotos, photos));
        }
    }

   
	private static LinkedList<String> Description(Scanner scan) {
        String str = scan.next();
        LinkedList<String> retVal = new LinkedList<String>();
        while (scan.hasNext() && (!str.equals("*"))) {
            retVal.add(str);
            str = scan.next();
        }

        return retVal;
    }

    public static void print(LinkedList<Photo> p) throws IOException {
        FileWriter file = new FileWriter("index.html");
        PrintWriter printer = new PrintWriter(file);

        TopHTML(file, printer);

        int count = 1;

        printer.println("\n");

        for (Photo photo : p) {
            System.out.println("Week " + photo.getWeekNum() + "\n\t" + photo.toString());
            printer.println(photo.toStringHTML());
            printer.println("\n\n<br>\n<br>\n<br>\n<br>\n\n");
        }

        // to end the html
        printer.println("\n\t</body>");
        printer.println("\n</html>");

        // to close the files
        printer.close();
        file.close();
    }

    public static void TopHTML(FileWriter file, PrintWriter printer) throws IOException {
        printer.println("<!DOCTYPE html>");
        printer.println("\n<html>");

        printer.println("\n<head><link href=\"StyleSheet.css\" rel=\"stylesheet\"></head>");

        printer.println("\n\t<title>Brandon Schadoff Photo Blog</title>");

        printer.println("\n\t<body>");

        printer.println("<div id = top>");
        printer.println("\n\t\t<center>\n\n\t\t\t<h1>\n\t\t\t\t<b>Brandon Schadoff Photo Blog</b>\n\t\t\t</h1>\n\n\t\t</center>");
        printer.println("</div>");
    }

    public static String check(String name) {
        String checked = "";

        for (int i = 0; i < name.length(); i++) {
            int k = i + 1;
            if (!(name.substring(i, k).equals("-"))) {
                checked = checked + name.substring(i, k);
            } else {
                checked = checked + " ";
            }
        }

        return checked;
    }
}
