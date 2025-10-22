package com.kt.basic.rsp;

import java.util.Scanner;

//플레이어는 1~3 사이의 숫자를 입력
//1: 가위, 2:바위, 3: 보
// 다른거 입력하면 다시입력하게

// 컴퓨터는 랜덤으로 1~3사이의 숫자를 생성

//입력이 끝나고 컴퓨터도 숫자생성이 끝나면
//누가이겼는지 판정
//나 : 가위
//컴퓨터 :보

//플레이어가 이겼습니다.
//컴퓨터가 이겼습니다.

//비기면 다시 게임시작 연승횟수는 유지
//내가 이기면 연승 +1 하고 다시 게임시작
//내가 지면 게임종료 최종 연승 출력

public class RSPMain {


	static int winningstreak = 0;

	public static void main(String[] args) {

		//플레이어
		//컴퓨터
		Player player1 = new Player();
		Computer computer1 = new Computer();
		System.out.println("가위바위보 게임에 입장하셨습니다");
		player1.playRSP();
		computer1.computerturn();
		judging(player1.playRSP(),computer1.computerturn());


	}

	static class Player {
		Player() {

		}

		static int playRSP(){
			//TODO try resource로 종료하는거 써보기
			try(Scanner sc = new Scanner(System.in)) {
			int rsp= sc.nextInt();
			System.out.println("1~3 사이의 숫자를 입력해주세요");
			System.out.println("1: 가위, 2:바위, 3: 보");
				if (rsp !=1 && rsp !=2 && rsp !=3) {
					System.out.println("다시입력하세요. 키는 10 ~ 250cm 이하로만 입력가능");
					return playRSP();
				}
			return rsp;
			} catch (IllegalArgumentException e) {

				System.out.println("다시입력하세요. 1,2,3 만 입력가능");
				return playRSP();
			}
			finally{
				System.out.println("입력 종료");
			}
		}
	}

	static class Computer {
		Computer() {

		}

		static int computerturn() {
			double randNum = Math.random();
			int num = (int)(randNum * 3) + 1; // 1 ~ 3 사이의 숫자를 뽑아냄

			return num;
		}
	}
//1:가위 2:바위 3:보
	static void judging(int a, int b){
		if(a==1){
			if(b==1){
				System.out.println("컴퓨터와 비겼습니다..");
				Player.playRSP();
				Computer.computerturn();
				regame();
			}
			else if(b==2) {
				System.out.println("당신은 컴퓨터에게 졌습니다");
				System.out.println("당신은" +winningstreak+ "연승 했습니다");
			}
			else {
				System.out.println("당신은 이겼습니다!");
				winningstreak++;
				regame();
			}
		}
		if(a==2){
			if(b==2){
				System.out.println("컴퓨터와 비겼습니다..");
				Player.playRSP();
				Computer.computerturn();
				regame();
			}
			else if(b==3) {
				System.out.println("당신은 컴퓨터에게 졌습니다");
				System.out.println("당신은" +winningstreak+ "연승 했습니다");
			}
			else {
				System.out.println("당신은 이겼습니다!");
				winningstreak++;
				regame();
			}
		}
		if(a==3){
			if(b==3){
				System.out.println("컴퓨터와 비겼습니다..");
				Player.playRSP();
				Computer.computerturn();
				regame();
			}
			else if(b== 1) {
				System.out.println("당신은 컴퓨터에게 졌습니다");
				System.out.println("당신은" +winningstreak+ "연승 했습니다");
			}
			else {
				System.out.println("당신은 이겼습니다!");
				winningstreak++;
				regame();
			}
		}

	}

	static void regame(){
		Player.playRSP();
		Computer.computerturn();
	}
}


