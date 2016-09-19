



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf382C {
   
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        boolean isSame = true;
        int d = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(a[i] != a[i-1]) isSame = false;
            int min = a[i] - a[i - 1];
            if(d > min) d = min;
        }
        int dCount = 0;
        if(d != Integer.MAX_VALUE)dCount++;
        for(int i = 1; i < n; i++){
            int diff = a[i] - a[i - 1];
            if(d != diff) dCount++;
        }
        if(n == 1) w.println(-1);
        else if(isSame){
            w.println(1 +"\n"+ a[0]);
        } else if(n == 2){
            if((a[0] + a[1])%2 == 0){
                w.println(3 +"\n"+ (a[0] - d) + " "+ (a[0]+a[1])/2 + " " + (a[1] + d));
            } else{
                w.println(2 + "\n" + (a[0] - d) + " "+ (a[1] + d));
            }
        } else if(dCount == 1){
          w.println(2 + "\n" + (a[0] - d) + " "+ (a[n - 1] + d));  
        } else if(dCount == 2){
            int x = -1;
            for(int i = 0; i <= n; i++){
                x = (a[0] + (i * d));
            }
            if(x == a[n - 1]){
            for(int i = 0; i < n; i++){
                x = (a[0] + (i * d));
                if(x != a[i]) break;
            }
            w.println(1 +"\n"+ x);
            } else w.println(0);
        } else w.println(0);
        
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



