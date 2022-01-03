import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504_특정한최단경로_백동열 {
	
	private static int n;
	private static int e;
	private static ArrayList<Pair> way_list[];
	
	static class Pair {
		public int dest;
		public long weight;
		
		public Pair(int dest, long weight) {
			this.dest = dest;
			this.weight = weight;
		}

		public long getDest() {
			return dest;
		}

		public void setDest(int dest) {
			this.dest = dest;
		}

		public long getWeight() {
			return weight;
		}

		public void setWeight(long weight) {
			this.weight = weight;
		}
		
		
	}
	
	private static long dijkstra(int s, int e) {
		
		boolean visited[] = new boolean[n + 1];
		long d[] = new long[n + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getWeight, Long::compareTo));
		
		d[s] = 0;
		
		pq.offer(new Pair(s, d[s]));
		
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if (visited[p.dest]) {
				continue;
			}
			visited[p.dest] = true;
			for (Pair next : way_list[p.dest]) {
				if (d[next.dest] > d[p.dest] + next.weight) {
					d[next.dest] = d[p.dest] + next.weight;
					pq.offer(new Pair(next.dest, d[next.dest]));
				}
			}
		}
		
		return d[e];
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		way_list = new ArrayList[n + 1];
		
		for (int i = 0; i <= n; i++) {
			way_list[i] = new ArrayList<Pair>();
		}
		
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			way_list[start].add(new Pair(end, weight));
			way_list[end].add(new Pair(start, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		
		long result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
		long result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
		
		if (result1 >= Integer.MAX_VALUE && result2 >= Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(result1, result2));
		}
		
		
	}
}
