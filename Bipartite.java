package graphs;

import java.io.*;
import java.util.*;



public class Bipartite {
   
    static ArrayList<ArrayList> graph;
    static int vertices;
    static int pairNo = 1;
    static int color[];
    static Queue<Integer> q;
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        graph = new ArrayList();
        vertices = in.nextInt();
        color = new int[vertices];
        q = new LinkedList<>();
        for(int i = 0; i < vertices; i++){
            graph.add(new ArrayList<Integer>());
        }
            
            int edges = in.nextInt();
        
            int a = in.nextInt() - 1;
            q.add(a);
            int b = in.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        
        // Graph Made
        for (int i = 1; i < edges; i++) {
            a = in.nextInt() - 1;
            b = in.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
       
        bfs();
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        boolean isPossible = true;
        for(int i = 0; i < vertices; i++){
            if(color[i] == 1) set1.add(i + 1);
            else if(color[i] == 2) set2.add(i + 1);
            
            if(color[i] == -1) isPossible = false;
        }
        
        if(isPossible){
        System.out.println(set1.size());
        Iterator it1 = set1.iterator();
        while(it1.hasNext()){
            System.out.print(it1.next() + " ");
        }
        System.out.println();
        System.out.println(set2.size());
        Iterator it2 = set2.iterator();
        while(it2.hasNext()){
            System.out.print(it2.next() + " ");
        }
        } else System.out.println(-1);
        
        w.close();
    }

    public static void bfs(){
        
        while(!q.isEmpty()){
            int root = q.peek();
            if(color[root] == 0)
            color[root] = pairNo;
            Iterator<Integer> it = graph.get(root).iterator();
            while(it.hasNext()){
                int child = it.next();
                if(color[root] == 1){
                    if(color[child] == 0)
                    q.add(child);
                    if(color[child] == 0){
                        color[child] = 2;
                    } else if(color[child] == 1){
                        color[child] = -1;
                        return;
                    }
                } else if(color[root] == 2){
                    if(color[child] == 0)
                    q.add(child);
                    if(color[child] == 0){
                        color[child] = 1;
                    } else if(color[child] == 2){
                        color[child] = -1;
                        return;
                    }
                }
                
                
            }
            pairNo = (pairNo == 1) ? 2 : 1;
            q.poll();
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



