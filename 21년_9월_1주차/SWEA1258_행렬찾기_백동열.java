import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1258_행렬찾기_백동열 {
	
	static int num;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};
	
	static void findBox(int a, int b, int cnt) {
		
		Queue<Pairs> q = new LinkedList<Pairs>();
		
		visited[a][b] = true;
		arr[a][b] = cnt;
		q.add(new Pairs(a, b));
		
		while(!q.isEmpty()) {
			
			int x = q.peek().getX();
			int y = q.peek().getY();
			
			q.remove();
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				
				if (nx >= 0 && nx < num && ny >= 0 && ny < num) {
					
					if (!visited[nx][ny]) {
						if (arr[nx][ny] == 0) {
							continue;
						} else {
							visited[nx][ny] = true;
							arr[nx][ny] = cnt;
							q.add(new Pairs(nx, ny));
						}
						
					}
					
				}
			}
			
			
		}
		
		
	}
	
	static int findRow(int a, int b, int cnt) {
		
		int result_cnt = 1;
		
		Queue<Pairs> q = new LinkedList<Pairs>();
		
		q.add(new Pairs(a, b));
		
		while(!q.isEmpty()) {
			
			int x = q.peek().getX();
			int y = q.peek().getY();
			
			q.remove();
			
			if (x + 1 < num) {
				if (arr[x + 1][y] == cnt) {
					result_cnt++;
					q.add(new Pairs(x + 1, y));
				} else {
					break;
				}
			}
			
		}
		
		return result_cnt;
		
	}
	
	static int findCol(int a, int b, int cnt) {
		
		int result_cnt = 1;
		
		Queue<Pairs> q = new LinkedList<Pairs>();
		
		q.add(new Pairs(a, b));
		
		while(!q.isEmpty()) {
			
			int x = q.peek().getX();
			int y = q.peek().getY();
			
			q.remove();
			
			if (y + 1 < num) {
				if (arr[x][y + 1] == cnt) {
					result_cnt++;
					q.add(new Pairs(x, y + 1));
				} else {
					break;
				}
			}
			
		}
		
		return result_cnt;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String result[] = new String[T + 1];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			num = Integer.parseInt(br.readLine());
			arr = new int[num][num];
			visited = new boolean[num][num];
			
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < num; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int number = 0;
			
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					if (arr[i][j] != 0 && !visited[i][j]) {
						findBox(i, j, ++number);
					}
				}
			}
			
			
			int start = 1;
			
			ArrayList<Pairs> result_list = new ArrayList<Pairs>();
			
			ArrayList<Pairs> num_list = new ArrayList<Pairs>();
			ArrayList<Integer> size_list = new ArrayList<Integer>();
			
			while(start <= number) {
				
				boolean check = false;
				
				for (int i = 0; i < num; i++) {
					for (int j = 0; j < num; j++) {
						if (arr[i][j] == start && !check) {
							int row = findRow(i, j, start);
							int col = findCol(i, j, start);
							
							num_list.add(new Pairs(row, col));
							size_list.add(row * col);
							
							check = true;
						}
					}
				}
				
				start++;
				
			}
			
			
			size_list.sort(null);
			
			
			for (int i = 0; i < size_list.size(); i++) {
				
				if (i - 1 >= 0) {
					if (Math.round(size_list.get(i)) == Math.round(size_list.get(i - 1))) {
						continue;
					}
				}
				
				ArrayList<Integer> sel_list = new ArrayList<Integer>();
				
				for (int j = 0; j < num_list.size(); j++) {
					
					if (size_list.get(i) == (num_list.get(j).getX() * num_list.get(j).getY())) {
						sel_list.add(num_list.get(j).getX());
					}
					
				}
				
				sel_list.sort(null);
				
				
				for (int j = 0; j < sel_list.size(); j++) {
					
					for (int k = 0; k < num_list.size(); k++) {
						if (sel_list.get(j) == num_list.get(k).getX() && size_list.get(i) == (num_list.get(k).getX() * num_list.get(k).getY())) {
							result_list.add(new Pairs(num_list.get(k).getX(), num_list.get(k).getY()));
						}
					}
					
				}
				
				
			}
			
			
			String result_str = "" + result_list.size() + " ";
			
			for (int i = 0; i < result_list.size(); i++) {
				result_str += result_list.get(i).getX() + " " + result_list.get(i).getY() + " ";
			}
			
			result[test_case] = result_str;
			

		}
		
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
	}

}
