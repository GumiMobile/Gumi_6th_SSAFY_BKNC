import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적경로 {
	
	static int cust_num;
	static int min;
	
	
	static void findWay(int map[][], int result_num[], boolean visited[], int num) {
		
		
		if (num == cust_num + 1) {
			int sum = 0;
			
			for (int i = 0; i < cust_num + 1; i++) {
				sum += Math.abs(map[result_num[i]][0] - map[result_num[i + 1]][0]) + Math.abs(map[result_num[i]][1] - map[result_num[i + 1]][1]);
			}
			
			if (min > sum) {
				min = sum;
			}
			return;
		}
		
		result_num[0] = 0;
		visited[0] = true;
		
		result_num[cust_num + 1] = cust_num + 1;
		visited[cust_num + 1] = true;
		
		for (int i = 1; i < cust_num + 1; i++) {
			if (visited[i]) {
				continue;
			}
			result_num[num] = i;
			visited[i] = true;
			findWay(map, result_num, visited, num + 1);
			visited[i] = false;
		}
		
		
	}
	
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int result[] = new int[T + 1];
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			cust_num = Integer.parseInt(br.readLine());
			int map[][] = new int[cust_num + 2][2];
			boolean visited[] = new boolean[cust_num + 2];
			int result_num[] = new int[cust_num + 2];
			
			min = Integer.MAX_VALUE;
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			map[0][0] = Integer.parseInt(st.nextToken());
			map[0][1] = Integer.parseInt(st.nextToken());
			map[cust_num + 1][0] = Integer.parseInt(st.nextToken());
			map[cust_num + 1][1] = Integer.parseInt(st.nextToken());
			
			
			for (int i = 1; i <= cust_num; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			findWay(map, result_num, visited, 1);
			
			result[test_case] = min;
		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
		
	}
	
}
