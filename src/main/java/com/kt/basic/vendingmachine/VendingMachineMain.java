package com.kt.basic.vendingmachine;

public class VendingMachineMain {

	public static void main(String[] args) {

		//관리자가 자판기앞에선다
		Manager manager1 = new Manager();
		VendingMachine machine1 = new VendingMachine();

		//관리자가 자판기를 켠다
		manager1.turnon();

		//사람이 자판기 앞에선다
		Customer customer1 = new Customer();
		customer1.infrontofmachine();

		//자판기 화면 on
		//모든 action뒤에 vendingveiw나오게 설정
		machine1.vendingview();

		// 돈을 넣는다
		customer1.putmoneyin();

		// 버튼을 누른다
		int pick = customer1.select();
		// 돈이 모자르면 "돈이 부족합니다" 출력
		// 돈이 충분하면 음료수를 주고 잔돈을 출력
		machine1.calculate(pick);
		machine1.takeoutcharge();

		//관리자가 자판기앞에선다
		// 관리자가 앞에서서 -99를 입력하면
		manager1.toadminmode();
		// 자판기의 매출을 출력하도록하고
		machine1.adminsales();
		// 관리자가 회수를 입력하면 매출이 초기화되고
		// 관리자의 장부에 해당 날짜와 매출액이 기록되도록한다.
		manager1.collect();
		manager1.reset();
		String bogo = new
		// 관리자가 보고를 입력 하면 장부에 해당하는 내용들이 쭉 출력되도록한다.



		// 자판기의 온오프버튼이 있어서 이건 관리자만 조작가능하다.
	}
}