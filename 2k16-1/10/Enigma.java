import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Enigma {
  public static void main(String[] args) throws IOException {
    BufferedReader b = new BufferedReader(new FileReader("EnigmaIN.txt"));
    while (b.ready()) {
      String s1 = b.readLine();
      String s2 = b.readLine();
      System.out.println(first_is_random(s1, s2));
    }
  }
    // Fill out the body of this method, you should return "nonrandom" if the first string
    // is the non random on and "random" otherwise
    public static String first_is_random(String s1, String s2) {
        double covar1 = covariance(s1);
        double covar2 = covariance(s2);

        if (covar1 < covar2){
            return "nonrandom";
        }
        return "random";
    }

    public static double covariance(String number){
        ArrayList<Double> result = new ArrayList<Double>();
        int len = number.length();
        for(int i = 0; i < len;i++){
            result.add(Integer.parseInt(""+number.charAt(i))+ 0.0);
        }
        double sum = 0;
        for (int i = 0;i < len;i++){
            sum += result.get(i);
        }
        double avg = sum / len;
        for (int i = 0;i < len;i++){
            result.set(i,result.get(i)-avg+0.0);
        }
        double variancesum = 0;
        sum = 0;
        avg = 0;
        for (int i = 0;i < len;i++){
            sum += result.get(i);
        }
        avg = sum / len;
        for(int i = 0; i < len; i++){
            variancesum += Math.pow(result.get(i)-avg,2);
        }
        variancesum = variancesum / (len-1);
        variancesum = Math.sqrt(variancesum);
        double filter = 1/variancesum;
        for(int i = 0; i < len;i++){
            result.set(i,Integer.parseInt(number.charAt(i)+"")*filter);
        }
        sum = 0;
        avg = 0;
        for (int i = 0;i < len;i++){
            sum += result.get(i);
        }
        avg = sum / len;
        variancesum = 0;
        for(int i = 0; i < len; i++){
            variancesum += Math.pow(result.get(i)-avg,2);
        }
        variancesum = variancesum / (len-1);
        return variancesum;
    }
}
