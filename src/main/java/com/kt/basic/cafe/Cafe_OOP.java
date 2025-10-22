// package com.kt.techup.cafe;
//
// //역할, 책임, 협력
//
// //역할 정리
// // 카페 - 주문 흐름 제어
// // 캐셔 - 주문받기, 음료 제공
// // 바리스타 - 음료 제조
// // 고객 - 주문, 수령
//
// import java.awt.*;
//
// public class Cafe_OOP {
// 	// 고객
// 	// 역할 : 주문하고 음료를 받음
// 	//todo 왜 static을 붙여야할까? 이유는 손님(Customer)은 카페(Cafe_OOP) 파일 안에 정의돼 있지만,
// 	// 실제로는 카페가 문을 열지 않아도 세상 어딘가에 존재할 수 있기때문
//
// 	static class Customer {
// 		private final String name;
//
// 		public Customer(String name) {
// 			this.name = name;
// 		}
//
// 		// 	//주문
// 		// 	public void order(Cafe cafe, Menu menu,Size size) {
// 		// 		System.out.println("[Customer" + name + ": I'd like to order a" + size + " " + menu + ".");
// 		// 		cafe.acceptOrder(this, menu, size);
// 		// 	}
// 		// }
//
// 		//수령
// 		public void receive(String drinkName) {
// 			System.out.println("[Customer]" + name + " :Received" + drinkName + ". Thanks!");
// 		}
//
// 	}
//
// 	//캐셔
// 	// 주문 받기, 음료 제공
// 	static class Cashier {
// 		/*
// 		Cashier는 혼자서는 일을 못 해요 캐셔가 일하려면
// 		어떤 카페에 속해 있는지(cafe)
// 		어떤 바리스타가 있는지(barista)
// 		이 두 가지 정보가 반드시 있어야 정상 작동할 수 있어요.
// 		이걸 “의존성(dependency)”이라고 해요.
// 		 */
//
// 		private final Cafe cafe;
// 		private final Barista barista;
//
// 		public Cashier(Cafe cafe, Barista barista) {
// 			this.cafe = cafe;
// 			this.barista = barista;
// 		}
//
// 		// public void takeOrder(Customer customer, Menu menu, Size size) {
// 		// 	//가격 책정(메뉴에게 가격 요청)
// 		// 	int price = menu.price();
// 		// 	System.out.println("[Cashier]" + cafe.name() + "The price for a " + size + " " + menu + "is " + price + "won.");
// 		//
// 		// 	//제조 요청
// 		// 	String drinkName = barista.prepare(menu, size);
// 		// 	System.out.println("[Cashier]" + cafe.name() + "Youre " + drinkName + "is ready!");
// 		//
// 		// 	//음료 제공 (고객에게 음료 제공)
// 		// 	customer.receive(drinkName);
//
// 		}
// 	}
//
// 	//바리스타
// 	//음료제조
// 	static class Barista {
// 		//음료 제조
// 		public void prepare() {
//
// 		}
//
// 	}
//
// 	//카페
// 	static class Cafe {
// 		private final String name;
// 		private final Barista barista;
// 		private final Cashier cashier;
//
// 		public Cafe(String name) {
// 			this.name = name; //todo :이것도 참조인가? 참조의뜻이뭘까
// 			//“참조”는 행동이 아니라 관계
// 			// “참조한다”는 건 단지 “어떤 변수가 힙에 있는 객체의 주소값을 가지고 있다”는 뜻이에요.
// 			// 그 주소값은 스택 변수든, 힙 안의 필드든 어디에 있든 상관없어요.
// 			// 핵심은 “그 값이 객체의 위치(주소)를 가리키느냐”예요.
// 			this.barista = new barista();
// 			this.cashier = new Cashier(this,barista);
// 		}
//
// 		//주문 접수
// 		//고객정보, 메뉴, 사이즈 , 가격
// 		public void acceptOrder(){
// 			//
// 		}
//
// 	}
// }
//
