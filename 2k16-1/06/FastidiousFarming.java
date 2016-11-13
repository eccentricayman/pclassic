
import java.util.*;
import java.io.*;
public class FastidiousFarming {
  public static void main(String[] args) throws FileNotFoundException {
    // Before submitting, make sure the main method hasn't been changed!
    Scanner sc = new Scanner(new FileReader("FastidiousFarmingIN.txt"));
    while(sc.hasNext()) {
      int[] cropAInputs = new int[2];
      int[] cropBInputs = new int[2];
      int[] allowanceInputs = new int[2];

      String cropALine = sc.nextLine();
      String[] cropAStringInputs = cropALine.split(" ");
      cropAInputs[0] = Integer.parseInt(cropAStringInputs[0]);
      cropAInputs[1] = Integer.parseInt(cropAStringInputs[1]);

      String cropBLine = sc.nextLine();
      String[] cropBStringInputs = cropBLine.split(" ");
      cropBInputs[0] = Integer.parseInt(cropBStringInputs[0]);
      cropBInputs[1] = Integer.parseInt(cropBStringInputs[1]);

      String allowanceLine = sc.nextLine();
      String[] allowanceStringInputs = allowanceLine.split(" ");
      allowanceInputs[0] = Integer.parseInt(allowanceStringInputs[0]);
      allowanceInputs[1] = Integer.parseInt(allowanceStringInputs[1]);

      int[] answer = findCrops(cropAInputs,cropBInputs,allowanceInputs);
      System.out.println(answer[0] + " " + answer[1]);
    }
    sc.close();
  }

  // Fill out the body of this method
  // cropAInputs and cropBInputs specify the amount of water and labor required by crop
  // A and B respectively. allowanceInputs specifies the amount of water and labor you have
  // available. You should return an int array of size 2 containing the amount of crop A and B
  // you should grow in that order or [ -1, -1 ] if there aren't any amounts that satisfy the
  // requirements
  public static int[] findCrops(int[] cropAInputs, int[] cropBInputs, int[] allowanceInputs) {
      //int iter = Math.max( cropAInputs[0], cropBInputs[1]);
      ArrayList <int[]> listA = findList( cropAInputs[0], cropBInputs[0], allowanceInputs[0]);
      ArrayList <int[]> listB = findList( cropAInputs[1], cropBInputs[1], allowanceInputs[1]);
      
      return findMatch(listA, listB, cropAInputs[0],cropAInputs[1], cropBInputs[0], cropBInputs[1]);
  }
    public static ArrayList<int[]> findList( int A, int B, int Allowed){
        ArrayList<int[]> list = new ArrayList<int[]>();
        if(A<=0){
            if((B>0)&&(Allowed%B==0)){
                int[] ary = {0,Allowed/B};
                list.add(ary);            
            }
            return list;
        }
        if(B<=0){
            if((A>0)&&(Allowed%A==0)){
                int[] ary = {Allowed/A,0};
                list.add(ary);
            }
            return list;
        }
        int inter  = Allowed / A;
        while(inter >= 0){
            int remain = Allowed - inter * A;
            if( remain % B == 0 ){
                
                int[] ary = new int[2];
                ary[0] = inter;
                ary[1] = remain / B;                
                list.add( ary );
            }
            inter--;
        }
        return list;
    }
    
    public static int[] findMatch( ArrayList<int[]>  listA, ArrayList<int[]> listB, int A1, int A2, int B1, int B2){
        int[] ary = { -1, -1};
        if((A1 == 0 && A2 == 0)||(B1 == 0 && B2 == 0)){
            return ary;
        }
        if(A1 == 0 && B1 == 0){
            /*if (listB.size() > 0){
                return listB.get(0);
                }*/
            return ary;
        }
        if(A2 == 0 && B2 == 0){
            /*if (listA.size() > 0){
                return listA.get(0);
                }*/
            return ary;
        }
        if(A1 == 0 && B2 == 0){
            if ((listA.size() > 0) && (listB.size() > 0)){
                int [] temp = {listA.get(0)[1],listB.get(0)[0]};
                return temp;
            }
            return ary;
        }
        if(B1 == 0 && A2 == 0){
            if ((listA.size() > 0) && (listB.size() > 0)){
                int [] temp = {listA.get(0)[0],listB.get(0)[1]};
                return temp;
            }
            return ary;
        }
        for( int i = 0; i < listA.size(); i ++ ){
            for( int j = 0; j < listB.size(); j++){
                if( listA.get(i)[0] == listB.get(j)[0] && listA.get(i)[1] == listB.get(j)[1] ){
                    return listA.get(i);
                }
            }
        }
        return ary;
    }
    
}
