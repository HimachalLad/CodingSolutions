



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf231C {
    static long pre[];
    static long a[];
    static int n, k;
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        n = in.nextInt();
        k = in.nextInt();
        a = in.nextLongArray(n);
        pre = new long[n+1];
        
        Arrays.sort(a);
        for(int i = 1; i <= n; i++) pre[i] = (pre[i-1] + a[i-1]);
        long max = -1;
        int point = -1;
        for(int j = n-1; j >= 0; j--){
            int x = findOptimal(0, j);
            if(x >= max){
                max = x;
                point = j;
            }
        }
        
        w.println(max +" "+ a[point]);
        w.close();
    }
    // return max value of number that can be changed
    public static int findOptimal(int s, int e){
        int end = e, ans = 1;
        while(s < e){
            int mid = (s+e)/2;
            if(((end - mid)*a[end] - sum(mid, end-1)) <= k){
                ans = end - mid + 1;
                e = mid;
            } else{
                s = mid+1;
            }
        }
        return ans;
    }
    public static long sum(int s, int e){
        e++;
        return (pre[e] - pre[s]);
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

		public long[] nextLongArray(int n) {
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
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



