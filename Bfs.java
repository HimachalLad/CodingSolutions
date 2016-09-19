/*
 * CSE 2013, NIT SILCHAR
 */

package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *
 * @author Nikhil Pathania
 */
public class Bfs {
   
    static ArrayList<ArrayList<Integer>> a;
    static boolean visited[];
    static Queue q=new LinkedList<Integer>();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        out.println("Enter the vertice and edge");
        StringTokenizer st=new StringTokenizer(br.readLine());
        int vertice,edge;
        
        vertice=ip(st.nextToken());
        edge=ip(st.nextToken());
        a=new ArrayList<ArrayList<Integer>>(vertice);
        for(int i=0;i<vertice;i++)
        {
            out.println(a);
            a.add(new ArrayList<Integer>());
        }
        out.println("Enter all the points X Y");
        int n=vertice;
        while(n-->0)
        {
            st=new StringTokenizer(br.readLine());
            graph(ip(st.nextToken()),ip(st.nextToken()));
            
        }
        visited=new boolean[vertice];
        out.println("Enter any vertice number");
        q.add(ip(br.readLine()));
        bfs();
       // w.println(a);
        w.close();
    }
    
    public static void graph(int p1,int p2)
    {
        a.get(p1).add(p2);
        a.get(p2).add(p1);
    }
    
   public static void bfs(){
  while(!q.isEmpty()){
  int v = (int)q.poll();
  System.out.println(v);
  visited[v]=true;
  Iterator it = a.get(v).iterator();
  while(it.hasNext()){
    int vert = (int)it.next();
    if(!visited[vert]){
        q.add(vert);
        visited[vert]=true;
    }
  } 
 }

    }
       public static int ip(String s){
		return Integer.parseInt(s);
	}
}