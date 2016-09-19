/*
 * CSE 2013, NIT SILCHAR
 */

package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *
 * @author Nikhil Pathania
 */
public class BfsShortestReach {
   static class Pair
   {
   int a,b;
   public Pair(int a,int b)
   {
       this.a=a;
       this.b=b;
   }
   }
    static ArrayList<ArrayList<Pair>> list;
    static Queue<Pair> q=new LinkedList<Pair>();
    static boolean visited[];
    public static void main(String args[]) throws IOException
    {
       InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        
        int N = in.nextInt();
        int M = in.nextInt();
        visited=new boolean[N];
        list=new ArrayList<ArrayList<Pair>>(M);
        for(int i=0;i<N;i++)
        {
            list.add(new ArrayList<Pair>());
        }
        while(M-->0)
        {
            if(in.nextInt() == 1){
            addGraph(in.nextInt(), in.nextInt());    
            } else if(in.nextInt() == 2){
            int a = in.nextInt();
            int b = in.nextInt();
            q.add(new Pair(a, 0));
            System.out.println(bfsShortest(b));
                
            }
            
            
        }
            q.clear();
        


        w.close();
    }
    public static int bfsShortest(int N)
    {
        while(!q.isEmpty())
        {
            
            Pair v=q.poll();
            visited[v.a]=true;
           // System.out.println("Polled:"+v.a);
            if(v.a==N)
            {
                return v.b;
            }
            Iterator it=list.get(v.a).iterator();
            while(it.hasNext())
            {
             Pair vertice=(Pair)it.next();
             
             //System.out.println("Normal"+vertice.a);
             if(visited[vertice.a]==false)
             {
             q.add(vertice);
             vertice.b=v.b+1;
             visited[vertice.a]=true;
             }
             
            if(vertice.a==N)
            {
              //System.out.println(vertice.a);  
                return vertice.b;
            }
            }
            
        }
        return 0;
    }
    public static void addGraph(int a,int b)
    {
        list.get(a).add(new Pair(a,0));
        list.get(a).add(new Pair(b,0));
        list.get(b).add(new Pair(b,0));
        list.get(b).add(new Pair(a,0));
    }
       public static int ip(String s){
		return Integer.parseInt(s);
	}
       
       
       static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}