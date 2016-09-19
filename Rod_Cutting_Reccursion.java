/*
 * CSE 2013, NIT SILCHAR
 */

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
public class Rod_Cutting_Reccursion {
   
        
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter w = new PrintWriter(System.out);
        System.out.println("Enter size of rod");
        int n=ip(br.readLine());
        int price[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            price[i]=ip(br.readLine());
        }
        
        int OptimumRevenue=CutRod(price,n);
        System.out.print("Optimum Revenue is: "+OptimumRevenue);
        //w.close();

    }
    
    public static int CutRod(int p[],int n)
    {
        
        if(n==0)
            return 0;
        int q=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            q=Math.max(q, p[i]+CutRod(p,n-i));
        }
        
        return q;
    }
       public static int ip(String s){
		return Integer.parseInt(s);
	}
}