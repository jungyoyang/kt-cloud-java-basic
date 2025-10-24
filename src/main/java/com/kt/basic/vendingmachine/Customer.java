package com.kt.basic.vendingmachine;

import java.util.Scanner;

public class Customer {
	static int money=0;

	Customer() {

	}

	void infrontofmachine() {

	}

	int putmoneyin() {
		System.out.println("돈을 얼마나 넣을까요?");
		try (Scanner sc = new Scanner(System.in)) {
			money = sc.nextInt();
			if (money < 1) {
				System.out.println("다시입력하세요. 양수만 가능합니다");
				return putmoneyin();
			}
			else if(money == -99){
				System.out.println("관리자 모드 ON");
			}
			money += money;
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


}
