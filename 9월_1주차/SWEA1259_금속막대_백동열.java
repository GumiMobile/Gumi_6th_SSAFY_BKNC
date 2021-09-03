import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1259_금속막대_백동열 {
	
	static int n;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String result[] = new String[T + 1];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			n = Integer.parseInt(br.readLine());
			
			ArrayList<Pairs> arr_list = new ArrayList<Pairs>();
			ArrayList<Pairs> result_list = new ArrayList<Pairs>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr_list.add(new Pairs(a, b));
			}
			
			visited = new boolean[n];
			
			
			for (int i = 0; i < n; i++) {
				
				if (!visited[i]) {
					boolean check = false;
					
					for (int j = 0; j < n; j++) {
						if (arr_list.get(i).getX() == arr_list.get(j).getY()) {
							check = true;
							break;
						}
					}
					
					if (!check) {
						if (!visited[i]) {
							visited[i] = true;
							result_list.add(new Pairs(arr_list.get(i).getX(), arr_list.get(i).getY()));
							i = -1;
						} else {
							continue;
						}
					} else {
						
						if (result_list.size() > 0) {
							if (result_list.get(result_list.size() - 1).getY() == arr_list.get(i).getX()) {
								
								boolean pass = false;
								
								for (int j = 0; j < n; j++) {
									if (arr_list.get(i).getY() == arr_list.get(j).getX() && !visited[j]) {
										pass = true;
									}
								}
								
								if (pass) {
									if (!visited[i]) {
										visited[i] = true;
										result_list.add(new Pairs(arr_list.get(i).getX(), arr_list.get(i).getY()));
										i = -1;
									} 
								} else {
									if (!visited[i]) {
										visited[i] = true;
										result_list.add(new Pairs(arr_list.get(i).getX(), arr_list.get(i).getY()));
									}
								}
								
							}
						}
						
						
						
					}
				} else {
					continue;
				}
				
			}
			
			String str = "";
			
			for (int i = 0; i < result_list.size(); i++) {
				str += result_list.get(i).getX() + " " + result_list.get(i).getY() + " ";
			}
			
			result[test_case] = str;

		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
		
	}
}
