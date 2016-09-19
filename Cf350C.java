



package MyPractice;

import java.io.*;
import java.util.*;



public class Cf350C {
    static class Pair implements Comparator<Pair>{
        int a,b;
        Pair(){}
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compare(Pair p, Pair q) {
        if(Math.abs(p.a) > Math.abs(q.a)) return 1;
        else if(Math.abs(p.a) < Math.abs(q.a)) return -1;
        else{
            if(Math.abs(p.b) > Math.abs(q.b)) return 1;
            else if(Math.abs(p.b) < Math.abs(q.b)) return -1;
            else return 0;
        }
        }
    }
    static int k = 0;
    static List<String> ans = new ArrayList<>();
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        List<Pair> inp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            inp.add(new Pair(x, y));
        }
        Collections.sort(inp, new Pair());
        for(int i = 0; i < n; i++){
            int x = inp.get(i).a;
            int y = inp.get(i).b;
            k += solve(x, y, true);
            k += solve(-x, -y, false);
            k++;
            ans.add("3");
        }
        w.println(k);
        for(int i = 0; i < ans.size(); i++){
            w.println(ans.get(i));
        }
        w.close();
    }

    public static int solve(int x, int y, boolean rev){
        int k = 0, xmov = 0, ymov = 0;
        if(x > 0){
            k++;
            xmov = x - xmov;
            x = 0;
            ans.add("1 " + xmov + " R");
            if(y == 0 && rev){
                k++;
                ans.add("2");
            }
        }
        if(x < 0){
            k++;
            xmov = Math.abs(x - xmov);
            x = 0;
            ans.add("1 " + xmov + " L");
            if(y == 0 && rev) {
                k++;
                ans.add("2");
            }
        }
        
        if(y > 0){
            k++;
            ymov = y - ymov;
            ans.add("1 " + ymov + " U");
            if(x == 0 && rev) {
                k++;
                ans.add("2");
            }
        }
        if(y < 0){
            k++;
            ymov = Math.abs(y - ymov);
            ans.add("1 " + ymov + " D");
            if(x == 0 && rev) {
                k++;
                ans.add("2");
            }
            }
        
        return k;
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



