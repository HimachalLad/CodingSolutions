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
public class ExtendedBottomUpRodCutting {
   static int s[];
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        out.println("Enter the size of the rod");
        int n=ip(br.readLine());
        int price[]=new int[n+1];
        out.println("Enter price of each rod");
        s=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            price[i]=ip(br.readLine());
        }
        int OptimumRevenue[]=ExtendedBottomUpRod(price,n,s);
        for(int i=0;i<=n;i++)
        out.println("Optimum value is: "+OptimumRevenue[i]+" and first piece to cutoff is: "+s[i]);
    }
    
    

       public static int ip(String s){
		return Integer.parseInt(s);
	}

    public static int[] ExtendedBottomUpRod(int[] p, int n,int s[])
    {
    int r[]=new int[n+1];
    r[0]=0;
    for(int j=1;j<=n;j++)
    {
        int q=Integer.MIN_VALUE;
        for(int i=1;i<=j;i++)
        {
           if(q<p[i]+r[j-i])
           {
               q=p[i]+r[j-i];
               s[j]=i;
           }
            
        }
        r[j]=q;
    }
    return r;
    }
}