/*
 * CSE 2013, NIT SILCHAR
 */
package dynamic_programming;

import java.util.Scanner;


/**
 *
 *  Generates an instance of the 0/1 knapsack problem with N items
 *  and maximum weight W and solves it in time and space proportional
 *  to N * W using dynamic programming.
 *

 * @author Nikhil Pathania
 */
public class Knap_sack {
 
    public static void main(String args[])
    {
        System.out.println("Enter no of elements");
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();  //No of items
        int cap=sc.nextInt();  //Maximum Capacity
        int weight[]=new int[N+1];
        int profit[]=new int[N+1];
        
        System.out.println("Enter weight and profit");
        
        for(int n=1;n<=N;n++)
        {
            weight[n]=sc.nextInt();
            profit[n]=sc.nextInt();
        }
        int table[][]=new int[N+1][cap+1];
        
        for(int n=1;n<=N;n++)
        {
            for(int w=1;w<=cap;w++)
            {
                //dont take item
                int op1=table[n-1][w];
                
                int op2=Integer.MIN_VALUE;
                
                if(w>=weight[n])
                {
                    op2=profit[n]+table[n-1][w-weight[n]];
                }
                System.out.print(op1+" "+op2+" i:"+n+" j:"+w+"  ");
                table[n][w]=Math.max(op1,op2);
            }
            System.out.println();
            
        }
        
        
        
        for (int n = 0; n <= N; n++)
        {
            for (int w = 0; w <= cap; w++)
            {
              System.out.print(table[n][w]+" ");
            }
            System.out.println();
        }
    }
    
}
