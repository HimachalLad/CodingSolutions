package graphs;

import java.io.*;
import java.util.*;
import static java.util.Collections.sort;

public class Kruskal {
    
    private static ArrayList<Edge> ar;
    private static ArrayList<Edge> res;
    private static int id[];
    private static int sz[];
  
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        
        id=new int[n];
        sz=new int[n];
        for(int i=0; i<n; i++)
        {
            id[i]=i;
            sz[i]=1;
        }
        
        ar = new ArrayList<Edge>();
        res = new ArrayList<Edge>();
        
        for(int i=0; i<n; i++)
            Graph(in.nextInt(), in.nextInt(), in.nextInt());
        
        sort(ar);
        
        for(int i=0; i<n; i++)
        {
            int a=ar.get(i).v;
            int b=ar.get(i).w;
            double d=ar.get(i).weight;
            if(!connected(a, b))
            {
                union(a, b);
                res.add(new Edge(a, b, d));
            }
        }
        System.out.println("Spanning Tree created without improvised union-find");
        Iterator it = res.iterator();
        while(it.hasNext())
        {
            Edge e = (Edge)it.next();
            System.out.println(e.v+" "+e.w+" "+e.weight);
        }
        
        w.close();
    }
    
    private static int root(int i)
    {
        while(i!=id[i]) i = id[i];
        return i;
    }
    
    public static boolean connected(int p, int q)
    {
        return root(p)==root(q);
    }
    public static void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        //id[i] = j;
        if(i == j) return;
        if(sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else              { id[j] = i; sz[i] += sz[j]; }
    }
    
    
    public static void Graph(int v, int w, int weight)
    {
        ar.add(new Edge(v, w, weight));
    }
    
    static public class Edge implements Comparable
    {

        private final int v, w;
        private final double weight;
        
        public Edge(int v, int w, double weight)
        {
            this.v=v;
            this.w=w;
            this.weight=weight;
        }
        
        public int either()
        {
            return v;
        }
        public int other(int vertex)
        {
            if(vertex == v) return w;
            else return v;
        }
        
      
        public int compareTo(Object e)
        {
            Edge o = (Edge) e;
            if(this.weight < o.weight) return -1;
            else if(this.weight > o.weight) return +1;
            else return 0;
        }
        
        
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



