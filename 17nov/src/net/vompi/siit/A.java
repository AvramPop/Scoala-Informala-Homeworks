package net.vompi.siit;

public class A {
	static int value = 20;
	static {
		value = 30;
		System.out.println("Value: " + value);
	}
	
	private int age = 10;
	private String name;
	
	public A() {
		name = "test";
		//this.age = age;
		System.out.println("Constructor A: " + this);
	}

	@Override
	public String toString() {
		return "A [age=" + age + ", name=" + name + "]";
	}
	
	
}
