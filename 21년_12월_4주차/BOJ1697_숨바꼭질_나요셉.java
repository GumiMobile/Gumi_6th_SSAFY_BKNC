package js.pekah.algorithms.d1221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_숨바꼭질_나요셉 {
	static int n, k;
	static int visited[];
	static Queue<Integer> q;
	static int result;
	
	static void bfs(int n) {
		visited[n] = 1;
		
		q.add(n);
		
		while (!q.isEmpty()) {
			int v = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int next;
				
				if (i == 0) {
					next = v + 1;
				} else if (i == 1) {
					next = v - 1;
				} else {
					next = v * 2;
				}
				
				if (next == k) {
					result = visited[v];
					return;
				}
				
				if (next < 0 || next >= visited.length || visited[next] != 0) continue;
				
				q.add(next);
				visited[next] = visited[v] + 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new int[100_001];
		q = new LinkedList<>();
		result = 0;
		
		if (n != k) {
			bfs(n);
		}
		
		System.out.println(result);
	}
}
