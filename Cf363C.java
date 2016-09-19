



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf363C {
   
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        char str[] = in.readString().toCharArray();
        StringBuffer buff = new StringBuffer();
        int preCal = 1;
        for(int i = 0; i < str.length-1; i++){
            if(str[i] != str[i + 1]){
                buff.append(str[i]);
                preCal = 1;
            }
            if(str[i] == str[i+1]){
            if(preCal == 1){
                buff.append(str[i+1]);
                buff.append(str[i]);
                int j = i;
                while(i < (str.length) && str[j] == str[i]){
                    i++;
                }
                i--;
                preCal++;
            } else if(preCal > 1){
                buff.append(str[i+1]);
                int j = i;
                while(i < (str.length) && str[j] == str[i]){
                    i++;
                }
                i--;
                preCal = 1;
            }
        }
        }
        if(str.length == 1) buff.append(str[str.length - 1]);
        else if(buff.charAt(buff.length()-1) != str[str.length-1]){
            buff.append(str[str.length-1]);
        }
        w.println(buff);
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



