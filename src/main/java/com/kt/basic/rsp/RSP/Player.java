package com.kt.basic.rsp.RSP;

import java.util.Scanner;

public class Player {
	public int hand() {
		System.out.println("가위(1), 바위(2), 보(3) 중 하나를 선택하세요:");
		try {
			var hand = new Scanner(System.in).nextInt();

			if (hand < 1 || hand > 3) {
				System.out.println("잘못된 입력입니다. 숫자(1~3)만 입력해주세요.");
				return hand();
			}
			return hand;
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다. 숫자(1~3)만 입력해주세요.");
			return hand();
		}
	}
}
