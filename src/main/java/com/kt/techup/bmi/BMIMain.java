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

//SRP => 하나의 클래스는 하나의 책임만 가져야한다.
//클래스에만 해당이 될까? -> 메서드에도 적용하면 아주 좋은 원칙
import java.util.Scanner;

public class BMIMain {
	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		double height = inputHeight(scanner);
		double weight = inputWeight(scanner);
		String gender = inputGender(scanner);
		String name = inputName(scanner);

		//최종적으로 계산한 값을 리턴하고싶다.
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);
		System.out.println("키 : " + height +" cm");
		System.out.println("몸무게 : " + weight + " kg");

		double bmi = CalculateBmi(height, weight);

		System.out.println("BMI지수 : " + bmi);

		String grade = Grade(bmi);

		System.out.println("결과 : " + grade);

	}

	//입력관련 메서드
	// 키는 10 ~ 250cm 이하로만 입력가능
	// 몸무게는 2 ~ 300kg 이하로만 입력가능
	// 성별은 남자, 여자만 입력가능
	// 이름은 공백없는 문자열 2자이상만 10자리이하 입력가능
	// 잘못 입력 하면 다시입력하세요(위의조건)을 출력하고 다시 입력받기
	public static double inputHeight() {

		Scanner scanner = new Scanner(System.in);
		double height = scanner.nextDouble();
		System.out.println("키를 입력하시오 (cm 단위):");
		if(height<10 || height>250) {
			System.out.println("다시입력하세요. 키는 10 ~ 250cm 이하로만 입력가능\n"
				+ "\t// 몸무게는 2 ~ 300kg 이하로만 입력가능\n"
				+ "\t// 성별은 남자, 여자만 입력가능\n"
				+ "\t// 이름은 공백없는 문자열 2자이상만 10자리이하 입력가능"); = -1;
			return inputHeight();
		}
				else
		return height;
	}

	public static double inputWeight() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("몸무게를 입력하시오 (kg 단위):");
		return scanner.nextDouble();
	}

	public static String inputGender(Scanner scanner) {
		System.out.println("성별을 입력하시오:");
		scanner.nextLine(); // 🔸 nextDouble() 후에 남은 개행문자 제거
		return scanner.nextLine();
	}

	public static String inputName(Scanner scanner) {
		System.out.println("이름을 입력하시오:");
		return scanner.nextLine();
	}

	public static double CalculateBmi(double height, double weight){
		double bmi;
		bmi = weight / height * height;
		double truncatedBmi = Math.floor(bmi * 10) / 10.0;
		return truncatedBmi;
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