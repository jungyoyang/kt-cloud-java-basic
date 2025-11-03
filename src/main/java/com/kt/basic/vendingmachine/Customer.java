package com.kt.basic.vendingmachine;

import java.util.Scanner;

public class Customer {
	private int money;
//TODO: 여기부터 캡슐화안되있음
	public Customer() {
	}

	void infrontofmachine(VendingMachine machine) {
		machine.vendingview();
	}

	int putmoneyin() {
		System.out.println("돈을 넣어주세요(양수만입력가능)");
		try (Scanner sc = new Scanner(System.in)) {
			money = sc.nextInt();

			/* ⛔ Old version (caused always false bug)
			 *  조건의 순서 때문!
			 */
			//  if (money < 1) {
			//  	System.out.println("다시입력하세요. 양수만 가능합니다");
			//  	return putmoneyin();
			//  }
			//
			//  else if(money == -99){
			//  System.out.println("관리자 모드 ON");
			// }
			if (money == -99){
				System.out.println("관리자 모드 ON");
				return 0;
			} else if (money < 1) {
				System.out.println("다시 입력하세요. 돈을 넣는 행위는 양수만 가능합니다");
				return putmoneyin();
			}
			else {
				VendingMachine.sales += money;
				System.out.println(money +"원 추가");
				return money;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("다시입력하세요. 양수만 가능합니다");
			return putmoneyin();
		} finally {
			System.out.println("돈을 성공적으로 넣었습니다");
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
