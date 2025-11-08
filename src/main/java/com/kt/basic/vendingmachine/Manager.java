package com.kt.basic.vendingmachine;

import java.time.LocalDate;
import java.util.Scanner;

//TODO : 캡슐화가 안되어있음
public class Manager {
	private int money = 0;

	public void turnon() {
		System.out.println("밴딩머신을 시작합니다");
	}

	public void turnoff() {
		System.out.println("밴딩머신을 종료합니다");
	}

	public int toadminmode(VendingMachine machine, Customer customer) {
		System.out.println("돈을 넣어주세요(양수만입력가능)");

		try (Scanner sc = new Scanner(System.in)) {
			money = sc.nextInt();
			if (money == -99) {
				System.out.println("관리자 모드 ON");
				money = 0;
				return money;
			} else if (money < 1) {
				System.out.println("다시 입력하세요. 돈을 넣는 행위는 양수만 가능합니다");
				return toadminmode(machine, customer);
			} else {
				money += money;
				return money;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("다시입력하세요. 양수만 가능합니다");
			return toadminmode(machine, customer);
		} finally {
			System.out.println("입력 종료");
			machine.vendingview(customer);
		}
	}

	public String collect() {
		LocalDate date = LocalDate.now();
		System.out.println(date + "매출 : " + VendingMachine.sales + "원");
		return date + "매출 : " + VendingMachine.sales + "원";
	}
	public void reset(){
		VendingMachine.sales = 0;
	}
}
