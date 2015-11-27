import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SpaceResources {
    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("SpaceResourcesIN.txt"));
        while (fileInput.hasNext()) {
            int a = fileInput.nextInt();
            int b = fileInput.nextInt();

            List<String> requested = new ArrayList<String>();
            for (int i = 0; i < a; i++) {
                requested.add(fileInput.next());
            }

            List<String> available = new ArrayList<String>();
            for (int i = 0; i < b; i++) {
                available.add(fileInput.next());
            }

            List<String> duplicates = findDuplicates(requested, available);
            StringBuilder builder = new StringBuilder();
            for (String resource : duplicates) {
                builder.append(resource).append(" ");
            }
            if (builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            System.out.println(builder.toString());
        }
    }

    // Fill out the body of this method
    public static List<String> findDuplicates(List<String> requested, List<String> available) {
        return null;
    }


}
