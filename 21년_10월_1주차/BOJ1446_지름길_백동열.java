import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1446_지름길_백동열 {
	
	private static int n;
	private static int d;
	private static int dist[];
	private static ArrayList<Way> way_list;
	
	static class Way {
		public int start;
		public int end;
		public int distance;
		
		public Way(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		dist = new int[d + 1];
		way_list = new ArrayList<Way>();
		
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			if (end - start <= distance) {
				continue;
			}
			if (end > d) {
				continue;
			}
			
			way_list.add(new Way(start, end, distance));
		}
		
		Collections.sort(way_list, new Comparator<Way>() {
			public int compare(Way w1, Way w2) {
				if (w1.start == w2.start) {
					return w1.end - w2.end;
				}
				return w1.start - w2.start;
			}
		});
		
		for (int i = 1; i <= d; i++) {
			dist[i] = i;
		}
		
		int idx = 0;
		int move = 0;
		
		while (move < d) {
			if (idx < way_list.size()) {
				Way w = way_list.get(idx);
				if (move == w.start) {
					dist[w.end] = Math.min(dist[move] + w.distance, dist[w.end]);
					idx++;
				} else {
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
				}
			} else {
				dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
				move++;
			}
		}
		
		System.out.println(dist[d]);
		
	}

}



