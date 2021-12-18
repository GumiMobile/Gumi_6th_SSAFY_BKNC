

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 13:35 ~ 13:50

public class BOJ11724_연결요소의개수_나요셉 {
	static int N, M;
	static int arr[][];
	static boolean visited[];
	static int result;
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for (int i = 1; i <= N; i++) {
			if (arr[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		result = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
	}
}
