package com.kt.techup;

import java.util.Random;

public class LottoMain{
	public static void main(String[] args){
		//추첨된 공을 담을 그릇
		int[] lotto = new int[6];
		Random random = new Random();

		//공을 여섯개뽑고싶음
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = pick(random, lotto, i);

		}
	}

	// pick으로 아예 중복되지않는 숫자를 건네주고싶음
	public static int pick(Random random, int[] lotto, int i) {
		int number = random.nextInt(6)+1;

		for(int j = 0; j<i; j++){
			if(lotto[j]==number) {
				return pick(random, lotto, i);
			}
		}
		return number;
	}
}

