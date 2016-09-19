



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf217A {
   
    static class Pair implements Comparator<Pair>{
        int x, y;
        Pair(){}
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int compare(Pair p, Pair q){
            if(p.x > q.x) return 1;
            else if(p.x < q.x) return -1;
            else{
            if(p.y > q.y) return 1;
            else if(p.y < q.y) return -1;
            else return 0;        
                }
        }
    }
    static int ans = -1;
    static boolean visx[];
    static boolean visy[];
    static List<Pair> inp;
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        visx = new boolean[1001];
        visy = new boolean[1001];
        inp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            inp.add(new Pair(in.nextInt()-1, in.nextInt()-1));
        }
        
        for(Pair p : inp){
            if(!visx[p.x] && !visy[p.y]) {
                dfs(p);
                ans++;
            }
        }
        w.println(ans);
        w.close();
    }

    public static void dfs(Pair p){
        visx[p.x] = true;
        visy[p.y] = true;
        
        for(Pair q : inp){
            if(!visx[q.x] && !visy[q.y]){
                if ( p.x == q.x || p.y == q.y )
                    dfs(q);
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



