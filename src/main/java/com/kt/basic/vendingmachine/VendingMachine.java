package com.kt.basic.vendingmachine;
// 배열로 음료수를 관리
// private String[] drinks = {"콜라", "사이다", "환타"};
// private int[] prices = {1000, 1200, 1300};

import static com.kt.basic.vendingmachine.Customer.*;

// 돈을 넣어
// 버튼을 눌러
// 돈이 모자르면 "돈이 부족합니다" 출력
// 돈이 충분하면 음료수를 주고 잔돈을 출력
public class VendingMachine {
	public class Drink {
		private static String[] drinks = {"","콜라", "사이다", "환타"};
		//TODO 숫자배열 0을 1로만들기
		private static int[] prices = {1000, 1200, 1300};
	}

	//TODO
	void calculate(int pick) {
		if (Drink.prices[pick]<money)
			System.out.println("돈이 부족합니다");
			else
			System.out.println(Drink.drinks[pick]+"이 자판기에서 나왔습니다");
		System.out.println("남은돈" money-prices[pick]);
	}

	void adminview(int) {

	}

	void vendingview() {
		System.out.println(Drink.drinks);
		System.out.println(Drink.prices);
		System.out.println("돈을 넣고 원하시는 음료를 눌러주세요");
	}

}
