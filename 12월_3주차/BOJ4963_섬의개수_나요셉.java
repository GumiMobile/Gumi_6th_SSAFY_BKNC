

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963_섬의개수_나요셉 {
	static int arr[][];
	static boolean visited[][];
	static int h, w;
	
	static int dy[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static int result;
	
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for (int k = 0; k < 8; k++) {
			int yy = i + dy[k];
			int xx = j + dx[k];
			
			if (yy < 0 || yy >= h || xx < 0 || xx >= w || visited[yy][xx] || arr[i][j] == 0) continue;
			
			dfs(yy, xx);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			arr = new int[h][w];
			visited = new boolean[h][w];
			result = 0;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (visited[i][j] || arr[i][j] == 0) continue;
					
					dfs(i, j);
					
					result++;
				}
			}
			sb.append(result+"\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
