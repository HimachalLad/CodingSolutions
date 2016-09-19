package MyPractice;

import java.io.*;
import java.util.*;



public class Cf427C {
    
    public static void fillOrder(int v, boolean vis[]){
        vis[v] = true;
        for(int x : graph.get(v)){
            if(!vis[x]){
                fillOrder(x, vis);
            }
        }
        stack.push(v);
    }
    
    public static List<ArrayList<Integer>> getReverse(){
        List<ArrayList<Integer>> graphRev = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graphRev.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i <= n; i++){
            for(int x : graph.get(i)){
                graphRev.get(x).add(i);
            }
        }
        
        return graphRev;
    }
    
    public static void dfs(int v, boolean vis[],int num){
        vis[v] = true;
        sCC.get(num).add(v);
        for(int x : graphRev.get(v)){
            if(!vis[x]) {
                dfs(x, vis, num);
            }
        }
        
    }
    
    public static void getSCC(){
        sCC = new ArrayList<>();
        stack = new Stack();
        //For first dfs
        boolean vis[] = new boolean[n+1];
        
        for(int i = 1; i <= n; i++){
            if(!vis[i]) fillOrder(i, vis);
        }
        graphRev = getReverse();
        Arrays.fill(vis, false);
        int num = 0;
        while(!stack.isEmpty()){
            int v = stack.pop();
            if(!vis[v]){
                sCC.add(new ArrayList<Integer>());
                dfs(v, vis, num);
                num++;
            }
        }
    }
    static Stack<Integer> stack;
    static List<ArrayList<Integer>> sCC;
    static List<ArrayList<Integer>> graph;
    static List<ArrayList<Integer>> graphRev;
    static int cost[];
    static int n, m;
    static int mod = (int)1e9 + 7;
    public static void main(String[] args)
    {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    n = in.nextInt();
    cost = new int[n+1];
    for(int i = 1; i <= n; i++){
        cost[i] = in.nextInt();
    }
    graph = new ArrayList<>(n+1);
    
    for(int i = 0; i <= n; i++){
        graph.add(new ArrayList<Integer>());
    }
    
    m = in.nextInt();
    for(int i = 0; i < m; i++){
        graph.get(in.nextInt()).add(in.nextInt());
    }
    getSCC();
    solve();
    }    

    public static void solve(){
        long noOfPosts = 1, moneyReq = 0;
        for(int i = 0; i < sCC.size(); i++){
            int min = Integer.MAX_VALUE, count = 0;
            
            for(int x : sCC.get(i)){
                if(cost[x] < min){
                    min = cost[x];
                    count = 1;
                } else if(cost[x] == min) count++;
            }
            moneyReq += min;
            noOfPosts = (noOfPosts%mod * count%mod)%mod;
        }
        System.out.println(moneyReq + " " + noOfPosts);
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



