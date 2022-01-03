

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 14:01 ~ 14:20

public class BOJ1325_효율적인해킹_나요셉 {
	static int N, M;
	static List<Integer> list[];
	static boolean visited[];
	static int count;
	static int result[];
	static int max;
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for (int l : list[start]) {
			if (!visited[l]) {
				result[l]++;
				dfs(l);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		result = new int[N+1];
		max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			dfs(i);
		}
		
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (result[i] == max) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb);
	}
}
