import java.util.*;

public class hold{
    public static void main(String [] args){
        String test = "010101010101010101";
        System.out.println(covariance(test));
        String test2 = "01100001010111000100";
        System.out.println(covariance(test2));
        String test3 = "10101110000010011000";
        System.out.println(covariance(test3));
        String test4 = "01001010111010110100";
        System.out.println(covariance(test4));
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
        return avg;
    }
}
