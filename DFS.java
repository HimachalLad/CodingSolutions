



package graphs;

import java.io.*;
import java.util.*;


public class DFS {
   
   static ArrayList<ArrayList<Integer>> l;
   static boolean marked[];
   static Stack<Integer> s;
   static int[] id;
   static int count=0;
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        l=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0; i<n; i++)
        {
           l.add(new ArrayList<Integer>());
        }
        marked=new boolean[n];
        System.out.println("Enter the no of edges");
        int edges = in.nextInt();
        for(int i=1; i<edges; i++)
        {
            graph(in.nextInt()-1, in.nextInt()-1 );
        }
        System.out.println("Enter Point about which dfs shoud be applied");
        
        CC(n);
        //dfs(in.nextInt()-1);
            w.println("For connected components: "+Arrays.toString(id));
        
        w.close();
    }

    public static void CC(int n)
    {
        id = new int[n];
        for(int i=0; i<n; i++)
        {
            if(!marked[i])
            {
                dfs(i);
                count++;
            }
        }
    }
    public static void graph(int a, int b)
    {
        l.get(a).add(b);
        l.get(b).add(a);
    }
    
    public static void dfs(int a)
    {
        /*
        *-----------------------------------------------------------------------
        *Code calling dfs function recursively
        *-----------------------------------------------------------------------
        
        marked[a]=true;
        Iterator it = l.get(a).iterator();
         while(it.hasNext())
         {
             int i=(int)it.next();
             if(!marked[i])
             {
             System.out.println(i+1);
             marked[i]=true;
             dfs(i);
             }
         }
        *
        *---------------------------------------------------------------------*/
        
        s=new Stack<Integer>();
        s.push(a);
        
        while(!s.isEmpty())
        {
            int x=s.pop();
            if(!marked[x])
            {
                marked[x]=true;
                id[x]=count;
                System.out.println(x+1);
            }
            Iterator it=l.get(x).iterator();
            while(it.hasNext())
            {
                int push=(int)it.next();
                if(!marked[push])
                {
                    marked[push]=true;
                    id[push]=count;
                    s.push(push);
                    System.out.println(push+1);
                }
                }
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



