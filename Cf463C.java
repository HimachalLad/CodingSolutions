package MyPractice;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Cf463C {
   
 public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int gen = in.nextInt();
        int cno = in.nextInt();
        int tot = 1 << (gen-1);
        System.out.println(tot);
        int flip = 0;
        while(cno != 1){
            tot /= 2;
            if(cno > tot){
                flip++;
                cno -= tot;
            }
            
        }
     
     if(flip%2 == 0) System.out.println("E");
     else System.out.println("D");
     
 }
    
}
