import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;


public class Treasons
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("TreasonsIN.txt"));
        int i=0;
        String[] input=new String[10000];
        while (sc.hasNext()) {
            input[i]=sc.next();
            i++;    
        }
        int counter=0;
        String[] input2=new String[i];
        while (counter<i){
            input2[counter]=input[counter];
            counter++;}
        String[] input20=new String[20];
        int counter2=0;
        for (int j=0; j<i;j++){
            if (!(input2[j].equals("|"))){
                input20[counter2]=input2[j];
                counter2++;
            }
            else{
                counter2=0;
                System.out.println(Arrays.toString(maximalAnagramList(input20)));
            }
        }
        sc.close();
    }
    /*The function will be given an array of distinct strings. The purpose of this method is to return
     * the largest set of strings which anagram to each other in an array with the strings in the 
     * output array being in alphabetical order.
     */
    public static String[] maximalAnagramList(String[] array) {
        String[] store = alphabetize(array);
        System.out.print(Arrays.toString(store) + "\n");
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        for(int i = 0; i < store.length; i++){            
            for(int j = 0; j < store.length; j++){
                if( i != j && store[i].equals(store[j]) ){
                    indexes.add(j);
                }
            }
            indexes.add(i);
            if( indexes.size() > curr.size() ){
                //System.out.println(curr);
                //System.out.println(indexes);
                
                curr = (ArrayList<Integer>)(indexes.clone());
            }
            indexes.clear();
        }
        String[] res = new String[ curr.size() ];
        for( int i = 0; i < curr.size(); i++ ){
            res[i] = array[curr.get(i)];
        }
        //System.out.println(Arrays.toString(res));
        Arrays.sort(res);
        curr.clear();
        indexes.clear();
        return res;
    }


    
    public static String[] alphabetize(String[] ary) {
        String[] res = new String[ary.length];
        for(int i =0;i < ary.length; i++){
            res[i] = alphabetize( ary[i] );         
        }
        return res;
        
    }

    public static String alphabetize( String in ){
        char[] str= new char[in.length()];
        for( int i =0; i < in.length(); i++){
            str[i] = in.charAt(i);
        }
        Arrays.sort(str);
        String s = "";
        for(int i =0; i < str.length; i++){
            s += str[i];
        }
        return s;
    }

    
}
