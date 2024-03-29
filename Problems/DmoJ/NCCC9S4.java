package Problems.DmoJ;

import java.util.*;
import java.io.*;
class NCCC9S4 {

	static final int MN = 30005, MQ = 200005, SQRT = 100;
	static int n, q, ans, l, r;
	static int[] freq = new int[1000005];
	static int[] a = new int[MN];
	static int[] out = new int[MQ];

    public static class Query {
        int l, r, i;
        public Query(int a, int b, int c) {
            l = a;
            r = b;
            i = c;
        }
    }
    public static class Comp implements Comparator<Query> {
        public int compare(Query q1, Query q2) {
          if (q1.l / SQRT != q2.l / SQRT) {
              return q1.l / SQRT - q2.l / SQRT;
          } else {
              return q1.r - q2.r;
          }
        }
    }

  public static void main(String[] args) throws IOException {
	Reader in = new Reader();
	n = in.nextInt();

	for (int i = 1; i <= n; i++){
        a[i] = in.nextInt();
    }

	q = in.nextInt();

	ArrayList<Query> queries = new ArrayList<>();

	for (int i = 1; i <= q; i++) {
		l = in.nextInt();
		r = in.nextInt();
		queries.add(new Query(l, r, i));
	}

	Collections.sort(queries, new Comp());

	l = 1; r = 0;
	for (Query Q : queries) {
        int maxFreq = 0;
        int maxFreqIndex = -1;
		while (r < Q.r) {
			r++;
			freq[a[r]]++;
			if (freq[a[r]] == 0) ans++;
		}
		while (l > Q.l) {
			l--;
			if (freq[a[l]] == 0) ans++;
			freq[a[l]]++;
		}
		while (r > Q.r) {
			freq[a[r]]--;
			if (freq[a[r]] == 0) ans--;
			r--;
		}
		while (l < Q.l) {
			freq[a[l]]--;
			if (freq[a[l]] == 0) ans--;
			l++;
		}
		out[Q.i] = ans;
	}
	for (int i = 1; i <= q; i++){
        System.out.println(out[i]);
    }
  }
  
  static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}