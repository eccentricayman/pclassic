import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
 
public class ConfusingCollinearConstellation {
    public static void main(String[] args) throws IOException {
    	// Before submitting, make sure the main method hasn't been changed!
        BufferedReader br = new BufferedReader(new FileReader(
                "ConstellationIN.txt"));
        while (br.ready()) {
            String[] data = br.readLine().split(" ");
            int[] pts;
            pts = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                pts[i] = Integer.parseInt(data[i]);
            }
            System.out.println(hasCollinear(pts));
        }
        br.close();
    }

    // Fill out the body of this method
    private static boolean hasCollinear(int[] pts) {
        int [][] coordinate = new int[pts.length/2][2];
	ArrayList <String> total = new ArrayList<String>();
	for (int i = 0;i < pts.length;i+= 2){
	    coordinate[i/2][0] = pts[i];
	    coordinate[i/2][1] = pts[i+1];
	}
	for(int i = 0;i< coordinate.length-1;i++){
	    for(int i2 = i+1; i <coordinate.length;i++){
		if(total.contains(merge(coordinate[i],coordinate[i2]))){
			return true;
		    }
		total.add(merge(coordinate[i],coordinate[0]));
	    }
	}
	return  false;
    }


    public static double slope(int[] cor1, int[] cor2){
	double ydist = (cor1[1] - cor2[1])* 1.0 ;
	double xdist = (cor1[0] - cor2[0])* 1.0 ;
	return (ydist/xdist);	    
    }

    public static String yint(double slope, int[]cor){
	return (cor[1] - slope*cor[0]) + "";
    }

    public static String merge(int[] cor1, int[] cor2){
	double slopei = slope(cor1,cor2);
	return slopei + "," + yint(slopei,cor1);
    }

    
 
}
