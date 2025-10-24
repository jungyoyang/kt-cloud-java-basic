package com.kt.techup;

//for을 통해 1~n의 합을 구한다
public static void main(String[] args) {
	//n이 10이라고 가정
	int n = 10, sum = 0;
	for(int i =1; i <=n; i++){
		sum+=i;
	}
	System.out.println("sum:" +sum);
}