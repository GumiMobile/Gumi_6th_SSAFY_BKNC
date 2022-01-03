import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753_최단경로_백동열 {
	
	private static int v;
	private static int e;
	private static ArrayList<Way> arr[];
	private static int d[];
	private static boolean visited[];
	
	static class Way implements Comparable<Way> {
		int dest;
		int weight;
		
		public Way(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Way w) {
			return weight - w.weight;
		}
		
	}
	
	private static void dijkstra(int start) {
		
		PriorityQueue<Way> pq = new PriorityQueue<Way>();
		
		pq.offer(new Way(start, 0));
		
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Way current = pq.poll();
			
			if (!visited[current.dest]) {
				visited[current.dest] = true;
				
				for (Way next : arr[current.dest]) {
					if (d[next.dest] == -1 || d[next.dest] > d[current.dest] + next.weight) {
						d[next.dest] = d[current.dest] + next.weight;
						pq.offer(new Way(next.dest, d[next.dest]));
					}
				}
			}
			
		}
		
		return;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		arr = new ArrayList[v + 1];
		d = new int[v + 1];
		visited = new boolean[v + 1];
		
		for (int i = 1; i <= v; i++) {
			arr[i] = new ArrayList<>();
		}
		
		Arrays.fill(d, -1);
		
		int start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			arr[s].add(new Way(e, count));
		}
		
		dijkstra(start);
		
		for (int i = 1; i <= v; i++) {
			if (d[i] == -1) {
				System.out.println("INF");
			} else {
				System.out.println(d[i]);
			}
			
		}
		
	}

}
