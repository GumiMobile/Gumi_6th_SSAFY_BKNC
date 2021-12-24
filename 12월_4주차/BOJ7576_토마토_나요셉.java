package js.pekah.algorithms.d1220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 17:15 ~ 17:29

public class BOJ7576_토마토_나요셉 {
	static int n, m;
	static int arr[][];
	static boolean visited[][];
	static Queue<Point> q;
	static int result;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static class Point {
		int x;
		int y;
		int count;
		
		Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void bfs() {
		
		while (!q.isEmpty()) {
			Point v = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int xx = v.x + dx[i];
				int yy = v.y + dy[i];
				
				if (xx < 0 || xx >= n || yy < 0 || yy >= m || visited[xx][yy]) continue;
				
				if (arr[xx][yy] == 0) {
					arr[xx][yy] = 1;
					visited[xx][yy] = true;
					q.add(new Point(xx, yy, v.count + 1));
				}
			}
			
			result = Math.max(result, v.count);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		result = 0;
		q = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					q.add(new Point(i, j, 0));
				}
			}
		}

		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					result = -1;
				}
			}
		}
		
		System.out.println(result);
	}
}
