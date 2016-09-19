



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf486C {
   
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt() - 1;
        int cursor = in.nextInt() - 1;
        if(cursor > n/2){
            cursor = n - (cursor);
        }
        char str[] = in.readString().toCharArray();
        int ans = 0;
        if((n/2 - cursor) < cursor){
                int last = cursor;
                for(int i = cursor; i <= n/2; i++){
                    if(str[i] != str[n-i]){
                         ans += Math.min(Math.abs(str[i] - str[n-i]), Math.abs(26 - Math.abs(str[i] - str[n-i])));
                         last = i;
                         str[i] = str[n-i];
                    }
                    
                }
                ans += (last - cursor);
                cursor = last;
                for(int i = last; i >=0; i--){
                    if(str[i] != str[n-i]){
                         ans += Math.min(Math.abs(str[i] - str[n-i]), Math.abs(26 - Math.abs(str[i] - str[n-i])));
                         last = i;
                         str[i] = str[n-i];
                    }
                }
                ans += (cursor - last);
                
        } else{
                int last = cursor;
                for(int i = cursor; i >= 0; i--){
                    if(str[i] != str[n-i]){
                         ans += Math.min(Math.abs(str[i] - str[n-i]), Math.abs(26 - Math.abs(str[i] - str[n-i])));
                         last = i;
                         str[i] = str[n-i];
                    }
                }
                ans += (cursor - last);
                cursor = last;
                for(int i = last; i <=n/2; i++){
                    if(str[i] != str[n-i]){
                         ans += Math.min(Math.abs(str[i] - str[n-i]), Math.abs(26 - Math.abs(str[i] - str[n-i])));
                         last = i;
                         str[i] = str[n-i];
                    }
                }
                ans += (last - cursor);
        }
        w.println(ans);
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



