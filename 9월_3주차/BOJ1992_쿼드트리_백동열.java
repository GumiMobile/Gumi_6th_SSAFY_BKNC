import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992_쿼드트리_백동열 {
	
	static int num;
	static int arr[][];
	static StringBuilder sb;
	
	static void findCube(int x, int y, int size, int cnt) {
		
		if (cnt > 4) {
			return;
		}
		
		if (cnt == 1) {
			sb.append("(");
		}

		if (findRange(x, y, size, arr[x][y])) {
			
			sb.append(String.valueOf(arr[x][y]));
			
		} else {

			if (size / 2 >= 1) {
				int sub_cnt = 0;
				int newLen = size / 2;
				
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						findCube(x + newLen * i, y + newLen * j, newLen, ++sub_cnt);
					}
				}
			}

		}
		
		if (cnt == 4) {
			sb.append(")");
		}
		
		
		
	}
	
	
	static boolean findRange(int x, int y, int size, int value) {
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != value) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Integer.parseInt(br.readLine());
		arr = new int[num][num];
		sb = new StringBuilder();
		
		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			for (int j = 0; j < num; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		findCube(0, 0, num, 0);
		
		
		System.out.println(sb);
		
	}
}
