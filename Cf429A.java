



package MyPractice;

import java.io.*;
import static java.lang.System.out;
import java.util.*;



public class Cf429A {
    static boolean vis[];
    static int init[];
    static int goal[];
    static ArrayList<ArrayList<Integer>> g;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        vis = new boolean[n+1];
        g = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) g.add(new ArrayList<>());
    
        for(int i = 0; i < n-1; i++){
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            g.get(x).add(y);
            g.get(y).add(x);
        }
        init = in.nextIntArray(n);
        goal = in.nextIntArray(n);
        dfs(0, -1, 0, 0, 0);
        w.println(ans.size());
        for(int x : ans) w.println(x+1);
        w.close();
    }

    public static void dfs(int v, int par, int level, int odd, int even) {
        //out.println("current node " + v);
        boolean flip = false;
        if (level % 2 == 1) { // current level is odd
            if (odd % 2 == 1)
                init[v] = 1 - init[v];
        } else { // current level is even
            if (even % 2 == 1)
                init[v] = 1 - init[v];
        }
        if (init[v] != goal[v]) {
            ans.add(v);
            flip = true;
        }
        for (int i = 0; i < g.get(v).size(); i++) {
            int u = g.get(v).get(i);
            if (u != par) {
                if (flip) {
                    if (level % 2 == 0)
                        dfs(u, v, level + 1, odd, even + 1);
                    else
                        dfs(u, v, level + 1, odd + 1, even);
                } else {
                    dfs(u, v, level + 1, odd, even);
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
				a[i] = nextInt()-1;
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



