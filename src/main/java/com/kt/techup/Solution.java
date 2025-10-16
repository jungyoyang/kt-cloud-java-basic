package com.kt.techup;

import java.util.Arrays;
import java.util.Random;

public class Solution {
	public int[] solution(int[] num_list) {
		//return 값이 [짝수의개수, 홀수의개수]여아한다
		//list안을 하나씩 검사하면서, 짝수의 개수와 홀수의 개수를 알아낸다
		//짝수를 알아내는법은 숫자를 %2했을때 ==0인것
		//짝수이면 answer첫번째인덱스 +1
		//홀수를 알아내는것은 숫자를 %2했을때 ==1인것 (else로)
		//홀수이면 answer두번째인덱스 +1
		int[] answer = new int[2];
		answer[0] = 0;
		answer[1] = 0;

		for(int i = 0; i <num_list.length; i++){
			if (num_list[i] % 2 == 0)
				answer[0] = answer [0] + 1;
			else
				answer[1] = answer [1] + 1 ;
		}
		return answer;
	}
}
