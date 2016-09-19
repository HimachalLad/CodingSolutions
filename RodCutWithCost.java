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
public class RodCutWithCost {
static long startTime = System.currentTimeMillis();    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        out.println("Enter the size of the rod");
        int n=ip(br.readLine());
        out.println("Enter value of cutting cost");
        int c=ip(br.readLine());
        int price[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            price[i]=ip(br.readLine());
        }
        int OptimumValue=CutRodWithCost(price,n,c);
        out.println("Optimum value is: "+OptimumValue);
        w.close();
long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
//System.out.println(totalTime); 
    }

    public static int CutRodWithCost(int p[],int n,int c)
    {
        int r[]=new int[n+1];
        r[0]=0;
        
        for(int j=1;j<=n;j++)
        {
            int q=p[j];
            for(int i=1;i<=j-1;i++)    
        {
            q=Math.max(q,p[i]+r[j-i]-c);
        }
            r[j]=q;
        }
        return r[n];
    }
    
       public static int ip(String s){
		return Integer.parseInt(s);
	}
}