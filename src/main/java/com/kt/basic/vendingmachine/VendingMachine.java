package com.kt.basic.vendingmachine;
// 배열로 음료수를 관리
// private String[] drinks = {"콜라", "사이다", "환타"};
// private int[] prices = {1000, 1200, 1300};

import static com.kt.basic.vendingmachine.Customer.*;

// 돈을 넣는다
// 버튼을 눌러
// 돈이 모자르면 "돈이 부족합니다" 출력
// 돈이 충분하면 음료수를 주고 잔돈을 출력
public class VendingMachine {

	VendingMachine(Manager a){};
	VendingMachine(Customer b){};

	static int restmoney;
	public class Drink {
		private static String[] drinks = {"","콜라", "사이다", "환타"};
		//TODO 숫자배열 0을 1로만들기
		private static int[] prices = {0, 1000, 1200, 1300};
	}

	int calculate(int pick) {
		if (Drink.prices[pick]<money) {
			System.out.println("돈이 부족합니다");
			VendingMachine.vendingview();
			return restmoney;
		}
		else{
			restmoney =  money - Drink.prices[pick];
			System.out.println(Drink.drinks[pick]+"이 자판기에서 나왔습니다");
			System.out.println("남은돈은" + restmoney + "입니다");
			VendingMachine.vendingview();
			return restmoney;
		}
	}

void takeoutcharge(int money){
	money = restmoney;
	System.out.println("잔돈" + calculate(money) + "을 반환합니다");
	restmoney=0;
}


	static void vendingview() {
		System.out.println("-----------------");
		System.out.println(Drink.drinks);
		System.out.println(Drink.prices);
		System.out.println("-----------------");
		System.out.println("콜라(1), 사이다(2), 환타(3)");
		System.out.println("돈을 넣고 원하시는 음료의 번호를 입력해주세요");
		System.out.println("현재잔액" + money);


	}
	void adminview(int) {

	}
}
