package js.pekah.algorithms.d1221;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 16:12 ~ 16:29

public class BOJ1926_그림_나요셉 {
	static int n, m;
	static int arr[][];
	static boolean visited[][];
	static List<Integer> result;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static Queue<Point> q;
	static int count;
	
	public static void bfs(int i, int j) {
		visited[i][j] = true;
		count = 1;
		
		q.add(new Point(i, j));
		
		while (!q.isEmpty()) {
			Point v = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int xx = v.x + dx[k];
				int yy = v.y + dy[k];
				
				if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
				
				if (arr[xx][yy] == 1 && !visited[xx][yy]) {
					visited[xx][yy] = true;
					q.add(new Point(xx, yy));
					count++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		result = new ArrayList<>();
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
					bfs(i, j);
					result.add(count);
				}
			}
		}
		
		System.out.println(result.size());
		
		Collections.sort(result, Collections.reverseOrder());
		
		if (result.size() == 0) {
			System.out.println(0);
		} else {
			System.out.println(result.get(0));
		}
	}
}
