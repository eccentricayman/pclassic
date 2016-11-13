import java.util.*;
public class test{
    public static void main(String[]args){
        
    }

     public static int[] findMatch( int[][] listA, int[][] listB){
        for( int i = 0; i < listA.length, i ++ ){
            if( listA[i][0] == listB[i][0] && listA[i][1] == listB[i][1] ){
                return listA[i];
            }
        }
        return [-1,-1];
    }
}
