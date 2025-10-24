package com.kt.basic.vendingmachine;

import java.util.Scanner;

public class Customer {
	static int money;

	Customer() {

	}

	void infrontofmachine() {

	}

	int putmoneyin() {
		try (Scanner sc = new Scanner(System.in)) {
			money = sc.nextInt();
			System.out.println("돈을 넣어주세요");
			if (money < 1) {
				System.out.println("다시입력하세요. 양수만 가능합니다");
				return putmoneyin();
			}
			return money;
		} catch (IllegalArgumentException e) {
			System.out.println("다시입력하세요. 양수만 가능합니다");
			return putmoneyin();
		} finally {
			System.out.println("입력 종료");
		}
	}

	int select() {
		try (Scanner sc = new Scanner(System.in)) {
			int pick = sc.nextInt();
			if (pick < 1 || pick>3) {
				System.out.println("다시입력하세요. 1~3번만 주문가능합니다");
				return select();
			}
			return pick;
		} catch (IllegalArgumentException e) {
			System.out.println("다시입력하세요. 1~3번만 주문만가능합니다");
			return select();
		}finally {
				System.out.println("음료선택 완료");
			}
	}

		System.out.println(money +"를 넣으셨습니다");
		System.out.println(money);

}
