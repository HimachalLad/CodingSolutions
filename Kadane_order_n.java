/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Nikhil Pathania
 */
public class Kadane_order_n {
    public static void main(String args[]) throws IOException
    {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
       
       for(int i=0;i<t;i++)
       {
           int max_curr=0,max_con_final=0,max_noncon=0,flag=0;
       int n=Integer.parseInt(br.readLine());
       int arr[]=new int[n];
       String val[]=br.readLine().split(" ");
       for(int j=0;j<n;j++)
       {
          arr[j]=Integer.parseInt(val[j]);
          if(arr[j]>0)
          {
              flag=1;
              max_noncon+=arr[j];
          }
          
       }
       
       if(flag==0)
       {
           int maxi=arr[0];
           for(int l=1;l<n;l++)
           {
               if(maxi<arr[l])
               {
                   maxi=arr[l];
               }
           }
           max_noncon=maxi;
       }
       max_curr=arr[0];
       max_con_final=arr[0];
       int l = 0, r = 0 ,e = 0;
       for(int k=1;k<n;k++)
       {
           if(max_curr<0)
           {
               max_curr=arr[k];
               if(max_curr > 0 && e == 0)e = 0;
               if(max_con_final<max_curr)
               {
                   //System.out.println(max_curr+" "+max_con_final);
                   max_con_final=max_curr;
                   l = k;
               }
           }
           else
           {
               
               max_curr+=arr[k];
               if(e == 0){
                   e = 1;
                   l = k - 1;
               }
               if(max_con_final<max_curr)
               {
                   max_con_final=max_curr;
                   r = k;
               }
           }
          
       }

       System.out.println(l + " "+ r);
       System.out.println(max_con_final+" "+max_noncon);
       }
    }
}

