import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953_탈주범검거_백동열 {
	
	static int N;
	static int M;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};
	
	static class Nodes {
		 int x;
		 int y;
		 int cnt;
		
		public Nodes(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getCnt() {
			return cnt;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		
	}
	
	
	static int findCount(int r, int c, int time) {
		
		int result_cnt = 1;
		
		Queue<Nodes> q = new LinkedList<>();
		
		visited[r][c] = true;
		q.add(new Nodes(r, c, 1));
		
		while(!q.isEmpty()) {
			
			int x = q.peek().getX();
			int y = q.peek().getY();
			int cnt = q.peek().getCnt();
			
			q.remove();
			
			if (cnt == time) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (arr[nx][ny] != 0) {
						if (!visited[nx][ny]) {
							boolean possible = confirm(x, y, dx[i], dy[i]);
							if (possible) {
								visited[nx][ny] = true;
								q.add(new Nodes(nx, ny, cnt + 1));
								result_cnt++;
							} else {
								continue;
							}
						}
						
					}
				}
				
			}
			
		}
		
		return result_cnt;
		
	}
	
	static boolean confirm(int x, int y, int dnx, int dny) {
		
		boolean check = false;
		
		switch(arr[x][y]) {
		case 1:
			if (dnx == 1 && dny == 0) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 2 || arr[x + dnx][y + dny] == 4 || arr[x + dnx][y + dny] == 7) {
					check = true;
				}
			} else if (dnx == 0 && dny == 1) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 3 || arr[x + dnx][y + dny] == 6 || arr[x + dnx][y + dny] == 7) {
					check = true;
				}
			} else if (dnx == -1 && dny == 0) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 2 || arr[x + dnx][y + dny] == 5 || arr[x + dnx][y + dny] == 6) {
					check = true;
				}
			} else if (dnx == 0 && dny == -1) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 3 || arr[x + dnx][y + dny] == 4 || arr[x + dnx][y + dny] == 5) {
					check = true;
				}
			}
			break;
			
		case 2:
			if (dnx == 1 && dny == 0) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 2 || arr[x + dnx][y + dny] == 4 || arr[x + dnx][y + dny] == 7) {
					check = true;
				}
			} else if (dnx == -1 && dny == 0) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 2 || arr[x + dnx][y + dny] == 5 || arr[x + dnx][y + dny] == 6) {
					check = true;
				}
			}
			break;
			
		case 3:
			if (dnx == 0 && dny == 1) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 3 || arr[x + dnx][y + dny] == 6 || arr[x + dnx][y + dny] == 7) {
					check = true;
				}
			} else if (dnx == 0 && dny == -1) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 3 || arr[x + dnx][y + dny] == 4 || arr[x + dnx][y + dny] == 5) {
					check = true;
				}
			}
			break;
			
		case 4: 
			if (dnx == -1 && dny == 0) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 2 || arr[x + dnx][y + dny] == 5 || arr[x + dnx][y + dny] == 6) {
					check = true;
				}
			} else if (dnx == 0 && dny == 1) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 3 || arr[x + dnx][y + dny] == 6 || arr[x + dnx][y + dny] == 7) {
					check = true;
				}
			}
			break;
			
		case 5:
			if (dnx == 1 && dny == 0) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 2 || arr[x + dnx][y + dny] == 4 || arr[x + dnx][y + dny] == 7) {
					check = true;
				}
			} else if (dnx == 0 && dny == 1) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 3 || arr[x + dnx][y + dny] == 6 || arr[x + dnx][y + dny] == 7) {
					check = true;
				}
			}
			break;
			
		case 6:
			if (dnx == 1 && dny == 0) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 2 || arr[x + dnx][y + dny] == 4 || arr[x + dnx][y + dny] == 7) {
					check = true;
				}
			} else if (dnx == 0 && dny == -1) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 3 || arr[x + dnx][y + dny] == 4 || arr[x + dnx][y + dny] == 5) {
					check = true;
				}
			}
			break;
			
		case 7:
			if (dnx == -1 && dny == 0) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 2 || arr[x + dnx][y + dny] == 5 || arr[x + dnx][y + dny] == 6) {
					check = true;
				}
			} else if (dnx == 0 && dny == -1) {
				if (arr[x + dnx][y + dny] == 1 || arr[x + dnx][y + dny] == 3 || arr[x + dnx][y + dny] == 4 || arr[x + dnx][y + dny] == 5) {
					check = true;
				}
			}
			break;
				
		}
		
		return check;
		
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
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int sum = findCount(R, C, L);
			
			
			result[test_case] = sum;
			
		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
	}

}




