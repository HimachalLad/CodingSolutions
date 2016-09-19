package MyPractice;

import java.io.*;
import java.util.*;



public class Cf279C {
   
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int a[] = in.nextIntArray(n);
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        
        int l = 0, r = 0;
        for(l = 0; l < n; l++){
            while(r < (n-1) && a[r+1] >= a[r]){
                r++;
            }
            prefix[l] = r;
            
            if(l == r) {
                r++;
            }
        }
        //w.println(Arrays.toString(prefix));
        a = reverse(a);
       // w.println(Arrays.toString(a));
        l = 0;
        r = 0;
        for(l = 0; l < n; l++){
            while(r < (n-1) && a[r+1] >= a[r]){
                r++;
            }
            suffix[l] = r;
            
            if(l == r) {
                r++;
            }
        }
        for(int i = 0 ; i < suffix.length; i++){
            suffix[i] = (n - suffix[i] - 1);
        }
        suffix = reverse(suffix);
       // w.println(Arrays.toString(suffix));
        while(m-- > 0){
            int i = in.nextInt() - 1;
            int j = in.nextInt() - 1;
            int x = prefix[i];
            int y = suffix[j];
            if(x < y) w.println("No");
            else w.println("Yes");
        }
        w.close();
    }

    public static int[] reverse(int a[]){
        int n = a.length;
        for(int i = 0; i < n/2; i++){
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
        return a;
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



