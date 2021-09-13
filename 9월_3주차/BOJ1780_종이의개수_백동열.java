import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780_종이의개수_백동열 {
	
	static int num;
	static int arr[][];
	static int cnt[];
	
	static void findRange(int x, int y, int size) {
		
		if (correctArr(x, y, size)) {
			cnt[arr[x][y]] += 1;
		} else {
			
			int nextLen = size / 3;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					findRange(x + nextLen * i, y + nextLen * j, nextLen);
				}
			}
			
		}
	}
	
	
	static boolean correctArr(int x, int y, int len) {
		
		int check = arr[x][y];
		
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (check != arr[i][j]) {
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
		cnt = new int[3];
		
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < num; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
		
		findRange(0, 0, num);
		
		
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);
		
	}

}
