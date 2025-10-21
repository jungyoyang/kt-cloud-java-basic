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
// 손님이 병원에입장하고
// 간호사(이미출근) 가 키를 물어보고
// 키 물어보고 이런 작업 => 간호사
// 몸무게 물어보고
// 성별 물어보고
// 이름 물어보고
// 의사(이미출근)한테 전달
// 의사가 bmi 계산하고
// 등급 매기고
// 간호사한테 결과 전달
// 간호사가 손님한테 결과 전달

//입력관련 메서드
// 키는 10 ~ 250cm 이하로만 입력가능
// 몸무게는 2 ~ 300kg 이하로만 입력가능
// 성별은 남자, 여자만 입력가능
// 이름은 공백없는 문자열 2자이상만 10자리이하 입력가능
// 잘못 입력 하면 다시입력하세요(위의조건)을 출력하고 다시 입력받기


//SRP => 하나의 클래스는 하나의 책임만 가져야한다.
//클래스에만 해당이 될까? -> 메서드에도 적용하면 아주 좋은 원칙
import java.util.Scanner;

public class BMIMain {
	public static void main(String[] args) {
		//병원 존재
		Doctor doctor = new Doctor();
		Nurse nurse = new Nurse();
		Hospital hospital = new Hospital(doctor, nurse);

		//환자 입장
		Patient patient1 = new Patient();
		patient1.enter();

		//간호사
		//환자 신체검사
		nurse.collectPatientInfo(patient1);
		//의사에게 전달
		nurse.sendToDoctor(doctor, patient1);

		//의사
		//계산후 결과 전달
		String result = doctor.examinePatient(patient1);

		//간호사, 결과 발표
		nurse.receiveResult(patient1, result);
	}

	public static class InputUtil {
		public static double inputHeight() {
			//try resource 문법
			//try(리소스선언) 사용이 끝나면 자동으로 close()호출
			// inputstream, outputstream, scanner, bufferreader 등등
			//io 관련된 클래스들은 거의다 리소스라고 생각하면 됨
			try {
				//정상적인 로직을 작성하는곳
				Scanner scanner = new Scanner(System.in);
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
			try {
				Scanner scanner = new Scanner(System.in);
				double weight = scanner.nextDouble();
				System.out.println("몸무게를 입력하시오 (kg 단위):");
				if (weight < 2 || weight > 300) {
					System.out.println("다시입력하세요. 몸무게는 2 ~ 300kg 이하로만 입력가능");

					return inputWeight();
				}
				return weight;
			} catch (IllegalArgumentException e) {
				System.out.println("다시입력하세요. 몸무게는 2 ~ 300kg 이하로만 입력가능");
				return inputWeight();
			} finally {
				System.out.println("몸무게 입력 종료");
			}
		}

		public static String inputGender() {
			try {
				Scanner scanner = new Scanner(System.in);
				String gender = scanner.nextLine();
				System.out.println("성별을 입력하시오:");

				if (!gender.equals("남자") && !gender.equals("여자")) {
					System.out.println("다시입력하세요. 성별은 남자와 여자만 입력가능합니다");
					return inputGender();
				}
				return gender;
			} catch (IllegalArgumentException e) {
				System.out.println("다시입력하세요. 성별은 남자와 여자만 입력가능합니다");
				return inputGender();
			} finally {
				System.out.println("성별 입력 종료");
			}
		}

		public static String inputName() {
			try {
				Scanner scanner = new Scanner(System.in);
				String name = scanner.nextLine();
				System.out.println("이름을 입력하시오:");

				if (name.contains(" ") || name.length() < 2 || name.length() > 10) {
					System.out.println("다시입력하세요. 이름은 공백 없이 2자 이상 10자 이하로 입력해야 합니다");
					return inputName();
				}
				return name;
			} catch (IllegalArgumentException e) {
				System.out.println("다시입력하세요. 이름은 공백 없이 2자 이상 10자 이하로 입력해야 합니다");
				return inputName();
			} finally {
				System.out.println("이름 입력 종료");
			}
		}
	}




	// public static void printResult(String name, String gender, double height, double weight) {
	// 	System.out.println("이름 : " + name);
	// 	System.out.println("성별 : " + gender);
	// 	System.out.println("키 : " + height + " cm");
	// 	System.out.println("몸무게 : " + weight + " kg");
	//
	// 	double bmi = CalculateBmi(height, weight);
	//
	// 	System.out.println("BMI지수 : " + bmi);
	//
	// 	String grade = Grade(bmi);
	//
	// 	System.out.println("결과 : " + grade);
	//
	// }

	static class Hospital {
		private final Doctor doctor;
		private final Nurse nurse;

		Hospital(Doctor doctor, Nurse nurse) {
			this.doctor = doctor;
			this.nurse = nurse;
		}
	}

	static class Patient {
		private double height;
		private double weight;
		private String gender;
		private String name;

		public Patient() {
			this.height = 0;
			this.weight = 0;
			this.gender = "NULL";
			this.name = "NULL";
		}

		public void setInfo(double height, double weight, String gender, String name) {
			this.height = height;
			this.weight = weight;
			this.gender = gender;
			this.name = name;
		}

		public void enter() {
			System.out.println(name + "님 들어오세요");
		}

	}

	static class Nurse {
		//TODO scanner의 위치가 어디여야할까? 여기있어도 되지않을까?
		private final Scanner scanner = new Scanner(System.in);

		private String name;
		private String gender;
		private double height;
		private double weight;
		private double bmi;
		private String grade;

		public void collectPatientInfo(Patient patient) {
			String name = InputUtil.inputName();
			String gender = InputUtil.inputGender();
			double height = InputUtil.inputHeight();
			double weight = InputUtil.inputWeight();

			patient.setInfo(height, weight, gender, name);
		}

		public String sendToDoctor(Doctor doctor, Patient patient) {
			System.out.println("👩‍⚕️ 간호사: 의사에게 환자 정보를 전달합니다.");
			return doctor.receivePatientInfo(patient);
		}

		public void receiveResult(Patient patient, String result) {
			System.out.println("\n👤 환자: " + name + " 님에게 진단 결과를 전달합니다.");
			System.out.printf(
				"이름: %s | 성별: %s | 키: %.1fcm | 몸무게: %.1fkg | BMI: %.1f (%s)",
				name, gender, height, weight, bmi, grade
			);
		}
	}

	static class Doctor {
		public void receivePatientInfo(Patient patient) {
			System.out.println("👨‍⚕️ 의사: 환자 정보를 받았습니다.");
			this.patient = patient;
		}

		public String examinePatient(Patient patient){
			//TODO name과 gender까지 의사가 알필요없다. BMI와 GRADE를 계산해주는거만 의사가하고나머지는 넘겨서 간호사에게 맡기자
			double height = patient.height;
			double weight = patient.weight;
			// String name = patient.name;
			// String gender = patient.gender;

			double bmi = calculateBmi(height, weight);
			String grade = grade(bmi);

			// BMI 결과 객체를 반환
			return String.format("BMI: %.1f (%s)", bmi, grade);

		}
			private static double calculateBmi(double height, double weight) {
				double bmi = weight / height * height;
				return Math.floor(bmi * 10) / 10.0;
			}

			private static String grade(double truncatedBmi) {
				if (truncatedBmi < 18.5)
					return "저체중";
				else if (truncatedBmi <= 22.9)
					return "정상";
				else if (truncatedBmi <= 24.9)
					return "비만전단계";
				else if (truncatedBmi <= 29.9)
					return "1단계비만";
				else if (truncatedBmi <= 34.9)
					return "2단계비만";
				else
					return "3단계비만";
			}
		}
	}

