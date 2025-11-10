package com.kt.basic.vendingmachine;

import java.time.LocalDate;
import java.util.Scanner;

// 배열로 음료수를 관리
// private String[] drinks = {"콜라", "사이다", "환타"};
// private int[] prices = {1000, 1200, 1300};

import static com.kt.basic.vendingmachine.Customer.*;

// 돈을 넣는다
// 버튼을 눌러
// 돈이 모자르면 "돈이 부족합니다" 출력
// 돈이 충분하면 음료수를 주고 잔돈을 출력
//TODO : 캡슐화가 안되어있음
public class VendingMachine {
	static int sales;
	private int change;

	public class Drink {
		private static String[] drinks = {"", "콜라", "사이다", "환타"};
		//TODO 숫자배열 0을 1로만들기
		private static int[] prices = {0, 1000, 1200, 1300};
	}
	//TODO: money를 클래스로만들고, 계산이될때마다? NEW로 만들기?

	void calculate(int pick, Customer customer) {
		if (customer.getMoney() < Drink.prices[pick]) {
			System.out.println("돈이 부족합니다");
		} else {
			change = customer.getMoney() - Drink.prices[pick];
			sales += Drink.prices[pick];

			System.out.println(Drink.drinks[pick] + "이 자판기에서 나왔습니다");
			System.out.println("남은돈은" + change + "입니다");
		}
		vendingview(customer);
	}

	//TODO:change를 재할당하는 구조말고, 새롭게 new로만드는 법을 찾아보자
	void takeoutcharge(Customer customer) {
		System.out.println("잔돈" + change + "을 반환합니다");
		change = 0;
		vendingview(customer);
	}

	public void vendingview(Customer customer) {
		System.out.println("-----------------");
		System.out.println(Drink.drinks);
		System.out.println(Drink.prices);
		System.out.println("-----------------");
		System.out.println("콜라(1), 사이다(2), 환타(3)");
		System.out.println("돈을 넣고 원하시는 음료의 번호를 입력해주세요");
		System.out.println("현재잔액" + customer.getMoney());

	}

	public void adminview() {
		System.out.println("-----------------");
		System.out.println("회수를 입력하면 매출이 초기화됩니다");
		System.out.println("보고를 입력하면 장부에 해당하는 내용들이 쭉 출력됩니다");
		System.out.println("-----------------");
		try (Scanner sc = new Scanner(System.in)) {
			String mode = sc.next(); //nextLine을 안쓴이유는 오히려 단어를 담기위해
			if (mode == "회수") {
				System.out.println("매출이 초기화됩니다");
				sales = 0;
			} else if (mode == "보고") {
				//TODO:보고부분해야함
			}

			//지피티는 else부분에 예외를 두고 catch부분에는 정말 프로그래밍적으로 예외를 두라고한다.
		} catch (IllegalArgumentException e) {
			System.out.println("다시입력하세요. 보고,회수 만 입력가능합니다");
		} finally {
			System.out.println("입력 종료");
		}
	}

	void adminsales() {
		System.out.println("지금 까지의 매출은" + sales + "원 입니다");
	}

	//TODO: 저장되는 개념을 어떻게 넣을수있을까
	void cog() {
	}

}