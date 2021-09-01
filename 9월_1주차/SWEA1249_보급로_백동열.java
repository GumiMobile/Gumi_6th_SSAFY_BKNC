import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class SWEA1249_보급로_백동열 {
	
	static int n;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};
	static int result_cnt;
	static int ans[][];
	
	static void dfs(int a, int b) {
		
		Stack<Route> stack = new Stack<Route>();
		stack.push(new Route(a, b));
		
		visited[a][b] = true;
		while(!stack.isEmpty()) {
			
			Route route = stack.pop();
			
			int x = route.x;
			int y = route.y;
			
			
			if (x == n - 1 && y == n - 1) {
				if (result_cnt > ans[n - 1][n - 1]) {
					result_cnt = ans[n - 1][n - 1];
				}
			}
			if (result_cnt <= ans[x][y]) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if (!visited[nx][ny] || ans[nx][ny] > ans[x][y] + arr[nx][ny]) {
					visited[nx][ny] = true;
					ans[nx][ny] = ans[x][y] + arr[nx][ny];
					stack.push(new Route(nx, ny));
				}
				
				
			}
			
		}
		
	}


	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int result[] = new int[T + 1];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visited = new boolean[n][n];
			ans = new int[n][n];
			result_cnt = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			ans[0][0] = 0;
			
			dfs(0, 0);
			
			
			result[test_case] = result_cnt;

		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
		
	}
}



class Route {
	
	int x;
	int y;
	
	public Route(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
