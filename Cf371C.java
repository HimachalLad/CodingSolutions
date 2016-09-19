



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf371C {
   
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        char[] burger = in.readString().toCharArray();
        int n = burger.length;
        int num[] = new int[4], price[] = new int[4], c[] = new int[4];
        for(int i = 1; i <= 3; i++) num[i] = in.nextInt();
        for(int i = 1; i <= 3; i++) price[i] = in.nextInt();
        long rubles = in.nextLong();
        
        for(int i = 0; i < n; i++){
            if(burger[i] == 'B') c[1]++;
            else if(burger[i] == 'S') c[2]++;
            else c[3]++;
        }
        long l = 0, r = (long)10000000000000L, res = 0;
        
        while(l <= r){
            long mid = (l+r)/2;
            long f = 0;
            for(int i = 1; i <= 3; i++){
                f += Math.max(0, (c[i]*mid - num[i]))*(long)price[i];
            }
            // condition is not f==rubles because it is not neccessary that you
            // will be able to spend all money.
            if(f <= rubles){
                res = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        w.println(res);

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



