package com.kt.basic.rsp.RSP;

import java.util.Random;

public class Computer {
	public int pick(){
		return new Random().nextInt(3) +1 ;
	}
}
