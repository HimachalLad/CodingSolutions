



package datastructures;

import java.io.*;
import java.util.*;



public class SegmentTree {
    public static void updateMinTree(int node, int start, int end, int idx, int val)
    {
    if(start == end)
    {
        // Leaf node
        inp[idx] = Math.min(val, inp[idx]);
        segTree[node] = Math.min(val, inp[idx]);
    }
    else
    {
        int mid = (start + end) / 2;
        if(start <= idx && idx <= mid){
            // If idx is in the left child, recurse on the left child
            updateMinTree(2*node, start, mid, idx, val);
        }
        else
        {
            // if idx is in the right child, recurse on the right child
            updateMinTree(2*node+1, mid+1, end, idx, val);
        }
        // Internal node will have the sum of both of its children
        segTree[node] = Math.min(segTree[2*node], segTree[2*node+1]);
    }
    }
    
    public static void constructRangeMinTree(int start, int end, int node){
        if(start == end){
            segTree[node] = inp[start];
            return;
        }
        int mid = (start + end)/2;
        constructRangeMinTree(start, mid, 2*node+1);
        constructRangeMinTree(mid + 1, end, 2*node+2);
        segTree[node] = Math.max(segTree[2*node+1], segTree[2*node+2]);    
    }
    
    public static void constructSumTree(int start, int end, int node){
        if(start == end){
            segTree[node] = inp[start];
            return;
        }
        int mid = (start + end)/2;
        constructSumTree(start, mid, 2*node+1);
        constructSumTree(mid+1, end, 2*node+2);
        segTree[node] = segTree[2*node+1] + segTree[2*node+2];
    }
    
    public static int rangeMinQuery(int qlow, int qhigh, int low, int high, int node){
        // Total overlap
        if(qlow <= low && qhigh >= high){
            return segTree[node];
        }
        // No overlap
        if(qlow > high || qhigh < low){
            return Integer.MAX_VALUE;
        }
        // Partial overlap
        int mid = (low + high)/2;
        return Math.min(rangeMinQuery(qlow, qhigh, low, mid, 2*node+1),
                rangeMinQuery(qlow, qhigh, mid+1, high, 2*node+2));
    }
    
    static int segTree[], inp[];
    public static void main(String args[]) throws IOException
    {
        InputReader in = new InputReader(System.in);
	PrintWriter w = new PrintWriter(System.out);
        int n = in.nextInt();
        inp = in.nextIntArray(n);
        segTree = segTreeCons(n);
        constructRangeMinTree(0, n-1, 0);
        //constructSumTree(0, n-1, 0);
        w.println(Arrays.toString(segTree));
        int m = in.nextInt();
        for(int i = 0 ; i < m; i++){
            int qlow = in.nextInt()-1;
            int qhigh = in.nextInt()-1;
            w.println(rangeMinQuery(qlow, qhigh, 0, n-1, 0));
        }
        
        w.close();
    }
    
    static int[] segTreeCons(int n){
        int x = 4*n;
        int a[] = new int[x];
        for(int i = 0; i < x; i++){
            a[i] = Integer.MAX_VALUE;
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



