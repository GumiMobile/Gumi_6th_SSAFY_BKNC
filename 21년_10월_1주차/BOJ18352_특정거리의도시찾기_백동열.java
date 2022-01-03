import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18352_특정거리의도시찾기_백동열 {
	
	private static int n;
	private static int m;
	private static int k;
	private static int x;
	private static int d[];
	private static ArrayList<GraphPair>[] pair_list;
	
	static class GraphPair implements Comparable<GraphPair> {
		int end;
		int weight;
		
		public GraphPair(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(GraphPair gp) {
			return weight - gp.weight;
		}
		
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<GraphPair> pq = new PriorityQueue<GraphPair>();
		
		d[start] = 0;
		
		pq.offer(new GraphPair(x, 0));
		
		while(!pq.isEmpty()) {
			int end = pq.peek().end;
			int weight = pq.peek().weight;
			
			pq.remove();
			
			if (d[end] < weight) {
				continue;
			}
			
			for (int i = 0; i < pair_list[end].size(); i++) {
				int end2 = pair_list[end].get(i).end;
				int weight2 = pair_list[end].get(i).weight + weight;
				if (d[end2] > weight2) {
					d[end2] = weight2;
					pq.offer(new GraphPair(end2, weight2));
				}
			}
			
		}
	}
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		d = new int[n + 1];
		pair_list = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++) {
			pair_list[i] = new ArrayList<>();
		}
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			pair_list[start].add(new GraphPair(end, 1));
		}
		
		dijkstra(x);
		
		boolean check = false;
		
		for (int i = 0; i <= n; i++) {
			if (d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}
		
		if (!check) {
			System.out.println(-1);
		}
	}
	
}
