



package MyPractice;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Cf490C {
    static long mod;
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        char num[] = in.readString().toCharArray();
        
        long a = in.nextLong();
        long b = in.nextLong();
        mod = b;
        long remA[] = new long[num.length];
        long remB[] = new long[num.length];
        
        remA[0] = (num[0] - '0') % a;
        for(int i = 1; i < num.length; i++){
            remA[i] = (10 * remA[i-1] + (num[i] - '0')) % a;
        }
        long ten = 1;
        remB[num.length - 1] = (num[num.length-1] - '0') % b;
        for(int i = 2; i < num.length; i++){
            ten = (ten * 10)% b;
            remB[num.length - i] = ((ten * (num[num.length - i] - '0'))%b + (remB[num.length - i + 1])) % b;
        }
     
        boolean isNotPossible = true;
        for(int i = 1; i < num.length; i++){
            if(remA[i-1] == 0 && remB[i] == 0 && num[i] != '0'){
                w.println("YES");
                for(int j = 0; j < i; j++){
                    w.print(num[j]);
                } w.println();
                for(int j = i; j < num.length; j++){
                    w.print(num[j]);
                } 
                isNotPossible = false;
                break;
            }
        }
        if(isNotPossible) w.println("NO");
        
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



