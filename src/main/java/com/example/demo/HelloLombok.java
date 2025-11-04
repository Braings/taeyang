package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class HelloLombok {
	private final String hello;
	private final int lombok;
	
//	public HelloLombok(String hello, int lombok) { 
//        this.hello = hello; 
//        this.lombok = lombok; 
//    }
	
//    public void setHello(String hello) {
//        this.hello = hello;
//    }
//
//    public void setLombok(int lombok) {
//        this.lombok = lombok;
//    }
//
//    public String getHello() {
//        return this.hello;
//    }
//
//    public int getLombok() {
//        return this.lombok;
//    }
    
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("Hello",5);
//		helloLombok.setHello("Hello");
//		helloLombok.setLombok(5);
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
		
	}
}
