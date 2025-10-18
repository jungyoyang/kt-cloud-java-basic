package com.kt.techup.bmi;
//1. 키와 몸무게, 성별, 이름을 입력받음
//2. BMI 지수를 계산하고
//3. BMI 지수에 따른 결과를 출력하는 프로그램을 작성

/*출력예시
이름 : 홍길동
성별 : 남자
키 : 175.5 cm
몸무게 : 70.2 kg
BMI 지수 : 22.8
결과 : 정상
 */

// 손님
// main => 병원
// 키 물어보고 이런 작업 => 간호사
// 손님이 병원에입장하고
// 간호사(이미출근) 가 키를 물어보고
// 몸무게 물어보고
// 성별 물어보고
// 이름 물어보고
// 의사(이미출근)한테 전달
// 의사가 bmi 계산하고
// 등급 매기고
// 간호사한테 결과 전달
// 간호사가 손님한테 결과 전달


//SRP => 하나의 클래스는 하나의 책임만 가져야한다.
//클래스에만 해당이 될까? -> 메서드에도 적용하면 아주 좋은 원칙
import java.util.Scanner;

public class BMIMain {
	public static void main(String[] args) {

		//값들을 입력받는다
		double height = inputHeight();
		double weight = inputWeight();
		String gender = inputGender();
		String name = inputName();
		double bmi = CalculateBmi(height, weight);
		String grade = Grade(bmi);

		//최종적으로 계산한 값을 리턴하고싶다.

	}

	//입력관련 메서드
	// 키는 10 ~ 250cm 이하로만 입력가능
	// 몸무게는 2 ~ 300kg 이하로만 입력가능
	// 성별은 남자, 여자만 입력가능
	// 이름은 공백없는 문자열 2자이상만 10자리이하 입력가능
	// 잘못 입력 하면 다시입력하세요(위의조건)을 출력하고 다시 입력받기

	//자바에서 오류를 핸들링하는방법은 두가지가있다
	//1. try -catch문 <- 문법
	//2. 조건문으로 걸러내기

	// spring에서는 몇가지 방법이 더있음

	public static double inputHeight() {
		//try resource 문법
		//try(리소스선언) 사용이 끝나면 자동으로 close()호출
		// inputstream, outputstream, scanner, bufferreader 등등
		//io 관련된 클래스들은 거의다 리소스라고 생각하면 됨
		try {
			//정상적인 로직을 작성하는곳
			Scanner scanner = new Scanner(System.in)
			double height = scanner.nextDouble();
			System.out.println("키를 입력하시오 (cm 단위):");
			if (height < 10 || height > 250) {
				System.out.println("다시입력하세요. 키는 10 ~ 250cm 이하로만 입력가능");
				return inputHeight();
			}
			return height;
		} catch (IllegalArgumentException e) {
			//cath(exception의 종류)
			//에러나면 처리하는 곳
			System.out.println("다시입력하세요. 키는 10 ~ 250cm 이하로만 입력가능");
			return inputHeight();
		} finally {
			//finally는 선택사항
			// 에러가 나든 안나든 무조건 실행되는구문
			//리소스를 close할때 주로 사용
			System.out.println("키 입력 종료");
		}
	}


	public static double inputWeight() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("몸무게를 입력하시오 (kg 단위):");
		return scanner.nextDouble();
	}

	public static String inputGender() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("성별을 입력하시오:");
		scanner.nextLine(); // 🔸 nextDouble() 후에 남은 개행문자 제거
		return scanner.nextLine();
	}

	public static String inputName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력하시오:");
		return scanner.nextLine();
	}

	public static double CalculateBmi(double height, double weight){
		double bmi;
		bmi = weight / height * height;
		return Math.floor(bmi * 10) / 10.0;
	}

	public static String Grade(double truncatedBmi){
		if(truncatedBmi<18.5)
			return "저체중";
		else if(truncatedBmi<=22.9)
			return "정상";
		else if(truncatedBmi<=24.9)
			return "비만전단계";
		else if(truncatedBmi<=29.9)
			return "1단계비만";
		else if(truncatedBmi<=34.9)
			return "2단계비만";
		else
			return "3단계비만";
	}

	public static void printResult(String name, String gender, double height, double weight ) {
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);
		System.out.println("키 : " + height +" cm");
		System.out.println("몸무게 : " + weight + " kg");

		double bmi = CalculateBmi(height, weight);

		System.out.println("BMI지수 : " + bmi);

		String grade = Grade(bmi);

		System.out.println("결과 : " + grade);

	}

}

//BMI : Body Mass Index
//체질량 지수
// 몸무게(kg) / 키(m) * 키(m))
// 저체중
// <18.5 kg/㎡
//
// 정상
// 18.5~22.9 kg/㎡
//
// 비만전단계
// 23~24.9 kg/㎡
//
// 1단계 비만
// 25~29.9 kg/㎡
//
// 2단계 비만
// 30~34.9 kg/㎡
//
// 3단계 비만
// ≥35 kg/㎡