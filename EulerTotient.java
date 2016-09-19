package PowerGCD;

import java.io.*;
import java.util.*;

/*
* Euler’s Totient function Φ(n) for an input n is count of numbers in
* {1, 2, 3, …, n} that are relatively prime to n, i.e., the numbers whose
* GCD (Greatest Common Divisor) with n is 1.
* phi(n) = n*(1 - 1/p1) * (1 - 1/p2) * (1 - 1/p3) ... * (1 - 1/pn)
* where p1, p2, p3 ..., pn are the prime divisors of n and phi(n) is euler
* totient function of n.
*/

public class EulerTotient {
   
    public static void preComputeTotient(){
        int n = 1000000;
        //Initialisation
        for(int i = 1; i <= n; i++) phi[i] = i;
        
        for(int i = 2; i <= n; i++){
            if(phi[i] == i){
                // Setting phi for prime no as p-1
                phi[i] = i-1;
                
                for(int j = i+i; j <= n; j += i){
                    // for all factors of prime number p
                    // multiply by (1 - 1/p)
                    // Here prime number is i
                    phi[j] = (phi[j] - phi[j]/i); 
                }
                
            }
        }
    }
    
    static long phi[] = new long[1000005];
    static int mod = (int) 1e9+7;
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
    	PrintWriter w = new PrintWriter(System.out);
        preComputeTotient();
        for(int i = 1; i <= 1000; i++) w.println(phi[i]);
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



