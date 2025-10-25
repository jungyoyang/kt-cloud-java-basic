package com.kt.basic.vendingmachine;
import java.time.LocalDate;

// 배열로 음료수를 관리
// private String[] drinks = {"콜라", "사이다", "환타"};
// private int[] prices = {1000, 1200, 1300};

import static com.kt.basic.vendingmachine.Customer.*;

// 돈을 넣는다
// 버튼을 눌러
// 돈이 모자르면 "돈이 부족합니다" 출력
// 돈이 충분하면 음료수를 주고 잔돈을 출력
public class VendingMachine {
	static int sales;
	static int change;


	public class Drink {
		private static String[] drinks = {"","콜라", "사이다", "환타"};
		//TODO 숫자배열 0을 1로만들기
		private static int[] prices = {0, 1000, 1200, 1300};
	}

	void calculate(int pick) {
		if (Drink.prices[pick]<money) {
			System.out.println("돈이 부족합니다");
			VendingMachine.vendingview();
		}
		else{
			change =  money - Drink.prices[pick];
			sales += Drink.prices[pick];

			System.out.println(Drink.drinks[pick]+"이 자판기에서 나왔습니다");
			System.out.println("남은돈은" + change + "입니다");
			VendingMachine.vendingview();

		}
	}

void takeoutcharge(){
	System.out.println("잔돈" + money + "을 반환합니다");
	change=0;
	VendingMachine.vendingview();
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
	void adminsales() {
		System.out.println("지금 까지의 매출은" + sales + "원 입니다");
	}
	void salsereset(){
		VendingMachine.sales=0;
	}
//TODO : 함수가 되지않는이유?
	String recorddailysales(){
		LocalDate date = LocalDate.now();
		System.out.println(date+"매출 : "+sales +"원");
		return date+"매출 : "+sales +"원";
	}

	//TODO: 저장되는 개념을 어떻게 넣을수있을까
	void cog(){
		VendingMachine.recorddailysales
	}


}