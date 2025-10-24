package com.kt.basic.vendingmachine;

import java.util.Scanner;

public class Manager {
	static int money=0;


	Manager(){

	};

	void turnon(){
		System.out.println("밴딩머신을 시작합니다");

	}
	void turnoff(){
		System.out.println("밴딩머신을 종료합니다");

	}
	int toadminmode() {
		System.out.println("돈을 얼마나 넣을까요?");
		try (Scanner sc = new Scanner(System.in)) {
			money = sc.nextInt();
			if (money < 1) {
				System.out.println("다시입력하세요. 양수만 가능합니다");
				return toadminmode();
			}
			else if(money == -99){
				System.out.println("관리자 모드 ON");
			}
			money += money;
			return money;
		} catch (IllegalArgumentException e) {
			System.out.println("다시입력하세요. 양수만 가능합니다");
			return toadminmode();
		} finally {
			System.out.println("입력 종료");
		}
	}

	void turnadmin() {
		System.out.println("관리자 모드");
	}




}
