import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;


public class FaultyCommandSystem {

    public static void main(String args[]) throws FileNotFoundException {
	// Before submitting, make sure the main method hasn't been changed!
	Scanner fileInput = new Scanner(new File("FaultyCommandSystemIN.txt"));
		
	while(fileInput.hasNext()) {
	    String input = fileInput.nextLine();

	    String[] tempArray = input.trim().split("\\s*,\\s*");
	    ArrayList<Integer> inputArray = new ArrayList<Integer>();
	    for(int i = 0; i < tempArray.length; i++) {
		inputArray.add(Integer.parseInt(tempArray[i]));
	    }
			
	    int displacement = FaultyCommandSystem.getDisplacement(inputArray);
			
	    System.out.println(displacement);
	}
	fileInput.close();
    }

    // Fill out the body of this method
    public static int getDisplacement(ArrayList<Integer> inputArray) {
	int dist = 0;
	ArrayList<Integer>removal = new ArrayList<Integer>();
	ArrayList<Integer> Mins;
	ArrayList<Integer> Maxs;
	while(findMin(inputArray).size()>0 || findMax(inputArray).size()>0){
	    Mins = findMin(inputArray);
	    Maxs = findMax(inputArray);
	    
	    for(int i =0;i<Maxs.size();i++){
		dist += inputArray.get(Maxs.get(i));
		removal.add(Maxs.get(i));
	    }
	    for(int i =0;i<Mins.size();i++){
		dist -= inputArray.get(Mins.get(i));
		removal.add(Mins.get(i));
	    }
	    Collections.sort(removal);
	    int checker = 0;
	    for(int i=0;i<removal.size();i++){
		inputArray.remove(removal.get(i)-checker);
		checker +=1;
	    }
	    removal.clear();
	}
	return dist;
    }

    public static ArrayList<Integer> findMin(ArrayList<Integer> input){
	ArrayList<Integer>output = new ArrayList<Integer>();
	for(int i=1;i<input.size()-1;i++){
	    if(input.get(i)<input.get(i-1) && input.get(i)< input.get(i+1)){
		output.add(i);
	    }
	}
	return output;
    }
    public static ArrayList<Integer> findMax(ArrayList<Integer> input){
	ArrayList<Integer>output = new ArrayList<Integer>();
	for(int i=1;i<input.size()-1;i++){
	    if(input.get(i)>input.get(i-1) && input.get(i)>input.get(i+1)){
		output.add(i);
	    }
	}
	return output;
    }
    
    
}
