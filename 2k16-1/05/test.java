import java.util.*;

public class test{
    public static void main(String[]args){
        
        System.out.println(perfectSquare( 64 ) );
        System.out.println(perfectSquare( 56 ) );
        
        System.out.println( (findTriples( 5 )) ) ;
        System.out.println( (findTriples(25 )) ) ;
        System.out.println( (findTriples( 3 )) ) ;
        System.out.println( (findTriples( 1 )) ) ;
        System.out.println( (findTriples( 0 )) ) ;
        System.out.println( (findTriples( -25 )) );
        System.out.println( (findTriples( 100 )) ) ;
        
    }
    public static Iterable<Integer> findTriples(int hyp) {
        /** Implement this method.
         
            This method returns a list containing all possible configurations of the other two
            sides that are of positive integer length. Output each
            configuration as a separate element in a list in the format a b
            where a is in ascending order and b is in descending order in
            respect to the other configurations.
             
            hypotenuse - the length of the aqueduct you want to construct.
         
        **/
        ArrayList<Integer> list = new ArrayList<Integer>();
        for( int i = 1; i < hyp; i++){
            if( perfectSquare( Math.pow(hyp, 2) - Math.pow(i, 2) )){
                list.add(i);
                list.add((int)(Math.sqrt( Math.pow(hyp, 2) - Math.pow(i, 2) )));
            }
        }
        return list;
    }
    
    public static Boolean perfectSquare( double in ){
        if (Math.sqrt(in) == (int)(Math.sqrt(in))){
            return true;
        }else{
            return false;
        }
    }
}
