import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA7465_창용마을무리의개수_백동열 {
	
	static int N;
	static int M;
	static boolean visited[];
	static int arr[][];
	static int result_cnt;
	
	static void findRel(int start) {
		
		visited[start] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		result_cnt++;
		
		while(!q.isEmpty()) {
			
			int a = q.poll();
			
			for (int i = 1; i <= N; i++) {
				
				if (arr[a][i] == 1) {
					if (!visited[i]) {
						visited[i] = true;
						q.add(i);
					}
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
			StringTokenizer st;
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			result_cnt = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());

				arr[first][second] = 1;
				arr[second][first] = 1;
			}
			
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					findRel(i);
				}
			}
			
			result[test_case] = result_cnt;
			
		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
	}
}
