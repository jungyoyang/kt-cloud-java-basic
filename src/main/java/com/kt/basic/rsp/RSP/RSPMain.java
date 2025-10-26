package com.kt.basic.rsp.RSP;


public class RSPMain {
	public static void main(String[] args) {
		var rps = new String[]{"","가위","바위","보"};
		var winCount = 0;
		var referee = new Referee();

		//룰 설명
		printRule();

		//선수입장
		var player = new Player();
		var computer = new Computer();


		//while문, ~하는동안
		while(true){
			var computerPick = computer.pick();
			var playerHand = player.hand();

			System.out.println("플레이어:" + rps[playerHand]+"를 냈습니다.");
			System.out.println("컴퓨터:" + rps[computerPick]+"를 냈습니다.");

			var result = referee.judge();

		}
	}
	private static void printRule() {
		System.out.println("------------------------");
		System.out.println("가위 바위 보 게임에 오신 것을 환영합니다!");
		System.out.println("규칙은 다음과 같습니다:");
		System.out.println("1: 가위");
		System.out.println("2: 바위");
		System.out.println("3: 보");
		System.out.println("플레이어가 이기면 연승이 증가하고, 지면 게임이 종료됩니다.");
		System.out.println("비기면 다시 시작합니다. 행운을 빕니다!");
		System.out.println("------------------------");
	}
}
