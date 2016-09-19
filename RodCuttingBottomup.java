/*
 * CSE 2013, NIT SILCHAR
 */

package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.StringTokenizer;


/**
 *
 * @author Nikhil Pathania
 */
public class RodCuttingBottomup {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        out.println("Enter the size of the rod");
        int n=ip(br.readLine());
        int price[]=new int[n+1];
        out.println("Enter price of each rod");
        for(int i=1;i<=n;i++)
        {
            price[i]=ip(br.readLine());
        }
        int OptimumRevenue=BottomUpCutRod(price,n);
        out.println("Optimum value is: "+OptimumRevenue);
    }
    
    

       public static int ip(String s){
		return Integer.parseInt(s);
	}

    public static int BottomUpCutRod(int[] p, int n)
    {
    int r[]=new int[n+1];
    r[0]=0;
    for(int j=1;j<=n;j++)
    {
        int q=Integer.MIN_VALUE;
        for(int i=1;i<=j;i++)
        {
            q=Math.max(q,p[i]+r[j-i]);
            
        }
        r[j]=q;
    }
    return r[n];
    }
}