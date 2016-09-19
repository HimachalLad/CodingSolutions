



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf339C {
    
    static class Tuple{
        int currWeight, currDiff, stepNo;
        Tuple(int i, int j, int k){
            this.currWeight = i;
            this.currDiff = j;
            this.stepNo = k;
        }
    }
    
    static int n = 0;
    static List<Integer> l;
    static List<Integer> ans = new ArrayList<>();
    static boolean entered = false;
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        char a[] = in.readString().toCharArray();
        n = in.nextInt();
        l = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if(a[i] == '1') l.add(i+1);
        }
        
        dfs(new Tuple(0, 0, 0));
        if(!entered) w.println("NO");
        else{
            w.println("YES");
            for(int i = ans.size() - 2; i >= 0; i--){
            w.print(ans.get(i)+" ");
            }
        }
        w.close();
    }

    public static void dfs(Tuple t){
        
        if(t.stepNo == n){
            entered = true;
            ans.add(t.currWeight);
            return;
        }
        
        for(int i = 0; i < l.size(); i++){
            if(t.currWeight != l.get(i) && t.currDiff < l.get(i)){
                if(!entered)
                dfs(new Tuple(l.get(i), l.get(i)- t.currDiff, t.stepNo+1));
               }
        }
        
        if(entered) ans.add(t.currWeight);
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



