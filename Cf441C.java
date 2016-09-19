



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf441C {
   
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int extra = (n*m)%k;
        int val = (n*m)/k;
        if(extra != 0){
            w.print(val+extra + " ");
            int x = val + extra;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                if(i%2 != 0){
                    w.print(i +" "+ j+" ");
                    x--;
                }
                else if(i%2 == 0){
                    w.print(i +" "+ (m-j+1)+" ");
                    x--;
                }
                if(x == 0 && (i!=n || j !=m)) {
                    w.println();
                    w.print(val + " ");
                    x = val;
                }
                }
                
                if(x == 0 && (i!=n)) {
                    w.println();
                    w.print(val + " ");
                    x = val;
                }
            }
            
        } else if(extra == 0){
           w.print(val + " ");
           int x = val;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                if(i%2 != 0){
                    w.print(i +" "+ j+" ");
                    x--;
                }
                else if(i%2 == 0){
                    w.print(i +" "+ (m-j+1)+" ");
                    x--;
                }
                if(x == 0 && (i!=n || j !=m)) {
                    w.println();
                    w.print(val + " ");
                    x = val;
                }
                }
                
                if(x == 0 && (i!=n)) {
                    w.println();
                    w.print(val + " ");
                    x = val;
                }
            }  
        }

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



