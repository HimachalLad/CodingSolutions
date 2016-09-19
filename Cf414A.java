



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf414A {
   
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        int k = in.nextInt();
        
        if(n >= 2*k){
            int a = 1;
            ArrayList<String> ans = new ArrayList<>(); 
            while(k-- > 0 && (n-2) >= 0){
                ans.add(a +" "+(++a));
                a++;
                n -= 2;
            }
            if(n > 1) w.println("-1");
            else{
                for(String x : ans) w.print(x+" ");
                if(n == 1) w.println(a);  
            }
        } else{
            int a = 1;
            int x = -100;
            ArrayList<String> ans = new ArrayList<>(); 
            
            if(2*k > n && (n-2) >= 0){
                x = k - (n/2) + 1;
                ans.add(x +" " + 2*x + " ");
                k -= x;
                n -= 2;
            }
           // w.println(n +" "+ k);
            while((n-2) >= 0 && k > 0){
                if(a != x && a!= (x-1) && a!= (2*x-1) && a != 2*x)
                {
                    ans.add(a +" "+(++a) + " ");
                    a++;
                    n -= 2;
                    k--;
                } else{
                    a++;
                }
            }
            if(!ans.isEmpty()){
            for(String y : ans) w.print(y);
            while(a == x || a == (x-1) || a == (2*x-1) || a == 2*x)
            {
                ++a;
            }           
            if(n == 1) w.println(a);
            }
            else{
                w.println("-1");
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



