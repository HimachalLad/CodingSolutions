/*
 * CSE 2013, NIT SILCHAR
 */

/*--------------------------------------------------------------------
*
*Solution is O(n^3) and can be optimized to O(n^2). I need to do this.
*
*--------------------------------------------------------------------*/
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 *
 * @author Nikhil Pathania
 */
public class PalindomePartition {
   
    static int table[][];
    static String str;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        str=br.readLine();        
        table=new int[str.length()][str.length()];
        
        for(int length=1;length<=str.length();length++)
        {
        for(int i=0;i<str.length();i++)
        {
            for(int j=0;j<str.length();j++)
            {
                if(j-i+1==length)
                {
                    table[i][j]=isPalindrome(i,j);
                    System.out.println("table["+i+"]"+"["+j+"] is "+table[i][j]);
                }
                }
            }
            }
        
        
        
        for(int i=0;i<str.length();i++)
        {
            for(int j=0;j<str.length();j++)
            {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static int isPalindrome(int i,int j)
    {
        int a=checkPalindrome(i,j);
        if(a==1)
        {
            return 0;
        }
        else 
        {
            return 1+CalcMin(i,j);
        }
        
    }
    public static int CalcMin(int i,int j)
    {
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            
            int val=table[i][k]+table[k+1][j];
       //     System.out.println(val);
            if(min>=val)
            {
                min=val;
            }
        }
     //   System.out.println("min for i"+i+" j:"+j+" is"+min);
        return min;
    }
    public static int checkPalindrome(int start,int end)
    {
        int length=end-start+1;
        int palin=1;
        for(int i=0;i<length/2;i++)
        {
            if(str.charAt(i+start)!=str.charAt(end-i))
            {
                palin=0;
            }
            
        }
        return palin;
    }
       public static int ip(String s){
		return Integer.parseInt(s);
	}
}