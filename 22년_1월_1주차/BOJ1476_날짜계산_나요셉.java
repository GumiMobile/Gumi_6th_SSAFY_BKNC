package js.pekah.algorithms.d220115;

import java.util.Scanner;

public class BOJ1476_날짜계산_나요셉 {
	static int e, s, m;
	static int temp_e, temp_s, temp_m;
	static int year;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		e = sc.nextInt();
		s = sc.nextInt();
		m = sc.nextInt();
		
		while (true) {
			if (e == temp_e && s == temp_s && m == temp_m) {
				break;
			}
			
			if (temp_e >= 15) {
				temp_e = 0;
			}
			if (temp_s >= 28) {
				temp_s = 0;
			}
			if (temp_m >= 19) {
				temp_m = 0;
			}
			
			year++;
			temp_e++;
			temp_s++;
			temp_m++;
		}
		
		System.out.println(year);
	}
}
