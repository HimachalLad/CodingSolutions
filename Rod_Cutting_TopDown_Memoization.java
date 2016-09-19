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
public class Rod_Cutting_TopDown_Memoization {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter w = new PrintWriter(System.out);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        out.println("Enter the size of rod");
        int n=ip(br.readLine());
        out.println("Enter size of each part");
        int price[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
        price[i]=ip(br.readLine());    
        }
        int OptimumRevenue=MemoizedCutRod(price,n);
        out.println("Optimum Revenue is"+OptimumRevenue);
        //w.close();
    }
    public static  int MemoizedCutRod(int p[],int n)
    {
        int r[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            r[i]=Integer.MIN_VALUE;
        }
        return MemoizedCutRodAux(p,n,r);
    }
    
    public static int MemoizedCutRodAux(int p[],int n,int r[])
    {
        int q;
        if(r[n]>0)
            return r[n];
        if(n==0)
            q=0;
            else
            q=Integer.MIN_VALUE;
        
        for(int i=1;i<=n;i++)
        {
            q=Math.max(q,p[i]+MemoizedCutRodAux(p,n-i,r));
        }
        r[n]=q;
        return r[n];
    }
       public static int ip(String s){
		return Integer.parseInt(s);
	}
}