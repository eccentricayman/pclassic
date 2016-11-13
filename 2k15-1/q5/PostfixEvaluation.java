import java.util.*;
import java.io.File;
import java.io.IOException;
public class PostfixEvaluation{
		
	public static void main(String[] args) throws IOException{
		String expression = ""; 
	    Scanner in = new Scanner(new File("PostfixEvaluationIN.txt"));
		while(in.hasNext()){
			expression = in.nextLine();
			
			System.out.printf("%.1f\n", solve(expression));
		}
	}
	
	public static double solve (String expression){
		ArrayList<Double> stack = new ArrayList<Double>();
		for (int i = 0; i < expression.length(); i++){
			if (expression.charAt(i) == '+'){
				double res = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
				stack.remove(stack.size() - 1);
				stack.remove(stack.size() - 1);
				stack.add(res);
			} 
			else if (expression.charAt(i) == '-'){
				double res =  stack.get(stack.size() - 2) - stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				stack.remove(stack.size() - 1);
				stack.add(res);
			} 
			else if (expression.charAt(i) == '*'){
				double res = stack.get(stack.size() - 1) * stack.get(stack.size() - 2);
				stack.remove(stack.size() - 1);
				stack.remove(stack.size() - 1);
				stack.add(res);
			} 
			else if (expression.charAt(i) == '/'){
				double res = stack.get(stack.size() - 2) / stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				stack.remove(stack.size() - 1);
				stack.add(res);
			} 
			else {
				stack.add((double)(Integer.parseInt(expression.substring(i,i + 1))));
			}
		}
		return stack.get(0);
	}
}
