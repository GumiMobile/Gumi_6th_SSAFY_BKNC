import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA4311_오래된스마트폰_백동열 {
	
	private static int best[];
	private static int used[];
	private static int nums[];
	private static char opers[];
	private static int targetNum;
	
	private static int combi[];
	private static int combCnt;
	private static int combNumCnt[];
	private static int combiUsed[];
	
	private static int N;
	private static int O;
	private static int M;
	
	private static void init() {
		
		for (int i = 0; i < 1000; i++) {
			best[i] = 99;
			used[i] = 0;
		}
		
		for (int i = 0; i < combCnt; i++) {
			int num = combi[i];
			best[num] = combNumCnt[i];
		}
		
	}
	
	private static int getCalResult(int a, char oper, int b) {
		if (oper == '*') {
			return a * b;
		}
		if (oper == '-') {
			return a - b;
		}
		if (oper == '/') {
			return a / b;
		}
		return a + b;
	}
	
	private static void getMinTouchCnt(int touchCnt, int now) {
		for (int x = 0; x < O; x++) {
			for (int i = 0; i < combCnt; i++) {
				int num = combi[i];
				int nextCnt = touchCnt + combNumCnt[i] + 1;
				
				if (nextCnt > M - 1) {
					break;
				}
				if (opers[x] == '/' && num == 0) {
					continue;
				}
				
				int next = getCalResult(now, opers[x], num);
				
				if (opers[x] == '+' && next > 999) {
					break;
				}
				if (opers[x] == '-' && next < 0) {
					break;
				}
				if (opers[x] == '*' && next > 999) {
					break;
				}
				if (used[next] == 1) {
					continue;
				}
				if (best[next] <= nextCnt) {
					continue;
				}
				
				best[next] = nextCnt;
				used[next] = 1;
				getMinTouchCnt(nextCnt, next);
				used[next] = 0;
			}
		}
	}
	
	private static void getCombiDFS(int lev, int sum) {
		for (int i = 0; i < N; i++) {
			int next = sum * 10 + nums[i];
			if (next > 999) {
				continue;
			}
			if (combiUsed[next] == 1) {
				continue;
			}
			combiUsed[next] = 1;
			getCombiDFS(lev + 1, next);
		}
	}
	
	private static void getCombi() {
		for (int i = 0; i < 1000; i++) {
			combi[i] = 0;
			combiUsed[i] = 0;
			combNumCnt[i] = 0;
		}
		
		combCnt = 0;
		getCombiDFS(0, 0);
		
		for (int i = 0; i < 1000; i++) {
			if (combiUsed[i] == 0) {
				continue;
			}
			combi[combCnt] = i;
			
			if (i < 10) {
				combNumCnt[combCnt] = 1;
			} else if (i < 100) {
				combNumCnt[combCnt] = 2;
			} else if (i < 1000) {
				combNumCnt[combCnt] = 3;
			}
			
			combCnt++;
		}
		
	}
	
	

	public static void main(String[] args) throws Exception {
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			best = new int[1000];
			used = new int[1000];
			nums = new int[11];
			opers = new char[5];
			targetNum = 0;
			
			combi = new int[1000];
			combCnt = 0;
			combNumCnt = new int[1000];
			combiUsed = new int[1000];
			
			N =  sc.nextInt();
			O =  sc.nextInt();
			M =  sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			
			for (int i = 0; i < O; i++) {
				int oper = sc.nextInt();
				if (oper == 1) opers[i] = '+';
				if (oper == 2) opers[i] = '-';
				if (oper == 3) opers[i] = '*';
				if (oper == 4) opers[i] = '/';
			}
			
			targetNum = sc.nextInt();

			getCombi();
			init();
			
			int ret = 0;
			if (best[targetNum] != 99) ret = best[targetNum];
			else {
				for (int i = 0; i < combCnt; i++) {
					getMinTouchCnt(combNumCnt[i], combi[i]);
				}
				ret = best[targetNum] + 1;
			}
			
			if (best[targetNum] == 99) ret = -1;
			
			System.out.print("#" + test_case + " " + ret);
			System.out.println();
			
			
		}
		
	}
	
}
