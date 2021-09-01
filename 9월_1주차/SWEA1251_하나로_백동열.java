import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1251_하나로_백동열 {
	
	static int num;
	static double x[];
	static double y[];
	static double E;
	static int[] root;
	
	static class Way implements Comparable<Way> {
		int node1, node2;
		double cost;
		
		Way(int node1, int node2, double cost) {
			this.node1 = node1;
			this.node2 = node2;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Way o) {
			return (int) (this.cost - o.cost);
		}
		
		
	}
	
	static int find(int x) {
		if (x != root[x]) {
			return find(root[x]);
		}
		return x;
	}
	
	static void union(int x, int y) {
		if (x < y) {
			root[y] = root[x];
		} else {
			root[x] = root[y];
		}
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		long result[] = new long[T + 1];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			num = Integer.parseInt(br.readLine());
			x = new double[num];
			y = new double[num];
			
			StringTokenizer st_x = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++) {
				x[i] = Double.parseDouble(st_x.nextToken());
				
			}
			
			StringTokenizer st_y = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++) {
				y[i] = Double.parseDouble(st_y.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			root = new int[num];
			
			for (int i = 0; i < num; i++) {
				root[i] = i;
			}
			
			PriorityQueue<Way> pq = new PriorityQueue<Way>();
			
			for (int i = 0; i < num - 1; i++) {
				for (int j = i + 1; j < num; j++) {
					double disX = (x[i] - x[j]) * (x[i] - x[j]);
					double disY = (y[i] - y[j]) * (y[i] - y[j]);
					double dis = disX + disY;
					pq.offer(new Way(i, j, dis));
				}
			}
			
			Way w = null;
			double cost = 0;
			while(!pq.isEmpty()) {
				w = pq.poll();
				int x = find(w.node1);
				int y = find(w.node2);
				if (x == y) {
					continue;
				}
				union(x, y);
				cost += E * w.cost;
			}
			
			result[test_case] = Math.round(cost);
			
		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
		
	}
	
}
