package com.ssafy.algorithm.d0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SWEA1257_K번째문자열_나요셉 {
	static int N;
	static int idx;
	static String word;
	static int sa[];
	static int LCP[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			idx = Integer.parseInt(br.readLine());
			word = br.readLine();
			
			sa = new int[word.length()]; // suffix array
			LCP = new int[word.length()]; // lcp
			
			for (int i = 0; i < sa.length; i++) sa[i] = i;	// suffix array 초기화
			
			for (int i = 0; i < sa.length; i++) {
				int minIdx = i;
				for (int j = i; j < sa.length; j++) {
					// 시작하는 첫 번째 문자로 suffix array 정렬
					if (word.substring(sa[minIdx]).compareTo(word.substring(sa[j])) > 0) 
						minIdx = j;
				}
				
				// 문자 정렬에 따른 인덱스 변경
				int tmp = sa[minIdx];
				sa[minIdx] = sa[i];
				sa[i] = tmp;
			}
			
			for (int i = 1; i < LCP.length; i++) {
				String s1 = word.substring(sa[i-1]);
				String s2 = word.substring(sa[i]);
				
				// 두 문자열을 비교하여 같은 문자 개수만큼 ++
				while (s1.length() > LCP[i] && s2.length() > LCP[i] && s1.charAt(LCP[i]) == s2.charAt(LCP[i]))
					LCP[i]++;
			}
			
			for (int i = 0; i < word.length(); i++) {
				String str = word.substring(sa[i]); // 현재 인덱스를 시작으로 하는 문자열 추출
				int cnt = str.length() - LCP[i];
				
				// k번째 수가 나올 때까지 넘어감
				if (idx > cnt) idx -= cnt;
				else {
					System.out.println("#" + tc + " " + str.substring(0, LCP[i] + idx)); // 현재 sa로부터 lcp만큼 더하기
					break;
				}
			}
		}
	}
}
