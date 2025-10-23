package com.kt.basic.vendingmachine;

import java.util.Scanner;

public class Customer {
	static int money;

	Customer(){

	}

	void infrontofmachine(){

	}



	int putmoneyin(){
		Scanner sc = new Scanner(System.in);
		money = sc.nextInt();
		System.out.println(money +"를 넣으셨습니다");
		System.out.println(money);
		money +=money;
		return money;
	}
	void select(int a){

	}




}
