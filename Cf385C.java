



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf385C {
   
    static int count[] = new int[(int)1e7+1];
    static boolean prime[] = new boolean[(int)1e7+1];
    static int f[] = new int[(int)1e7+1];;
    static int pre[] = new int[(int)1e7+1];
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        int x[] = in.nextIntArray(n);
        count(x);
        seive();
        calcF();
        int m = in.nextInt();
        while(m-- > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            if(l > (int)1e7) l = (int)1e7;
            if(r > (int)1e7) r = (int)1e7;
            w.println(pre[r] - pre[l-1]);
        }
        
         w.close();
       
    }
    
    public static void count(int x[]){
    for(int i = 0; i < x.length; i++){
        count[x[i]]++;
    }
    }
    public static void seive(){
        prime[0] = prime[1] = true;
        
        int n = (int)Math.sqrt(prime.length);
        for(int i = 0; i < n; i++){
            if(!prime[i]){
            for(int j = i + i; j < prime.length; j += i){
            prime[j] = true;
            }    
            }
        }
    }
    
    public static void calcF(){
        for(int i = 0; i < prime.length; i++){
            if(!prime[i])
            for(int j = i; j < prime.length; j += i){
                f[i] += count[j];
            }
        }
        
        pre[0] = f[0];
        for(int i = 1; i < prime.length; i++){
            pre[i] += pre[i-1] + f[i];
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



