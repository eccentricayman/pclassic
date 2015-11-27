import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SafeSpacewalks {
    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("SafeSpacewalksIN.txt"));
        while (fileInput.hasNext()) {
            int sum = fileInput.nextInt();
            int k = fileInput.nextInt();
            ArrayList<Integer> tools = new ArrayList<Integer>();
            for (int i = 0; i < k; i++) {
                tools.add(fileInput.nextInt());
            }
            int numValidQuadruples = fourSum(sum, tools);
            System.out.println(numValidQuadruples);
        }
    }

    // Fill out the body of this method
    public static int fourSum(int sum, ArrayList<Integer> tools) {
        return 0;
    }


}
