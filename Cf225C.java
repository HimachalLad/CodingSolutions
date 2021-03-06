



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf225C {
    static long dp[][];
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        dp = new long[2][m+1];
        // B == # and W == .
        long prefixB[] = new long[m+1];
        long prefixW[] = new long[m+1];
        
        for(int i = 0; i < n; i++){
            char a[] = in.readString().toCharArray();
            for(int j = 0; j < a.length; j++){
                if(a[j] == '#') prefixB[j+1]++;
                else prefixW[j+1]++;
            }
        }
        
        for(int i = 1; i <= m; i++){
            prefixB[i] += prefixB[i-1];
            prefixW[i] += prefixW[i-1];
        }
        
        for(int j = 1; j <= m; ++j) {
            dp[0][j] = (int)1e9; 
            dp[1][j] = (int)1e9;
        }
        
        for(int j = x; j <= m; j++){
            for(int i = Math.max(1, j-y+1); i <= j-x+1; i++){
                dp[0][j] = Math.min(dp[0][j], dp[1][i-1] + prefixB[j] - prefixB[i-1]);
                dp[1][j] = Math.min(dp[1][j], dp[0][i-1] + prefixW[j] - prefixW[i-1]);
            }
        }
        w.println(Math.min(dp[0][m], dp[1][m]));
        w.close();
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



