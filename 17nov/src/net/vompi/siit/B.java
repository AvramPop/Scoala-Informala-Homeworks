package net.vompi.siit;

public class B extends A{
	private String street;
	
	public B() {
		street = "Cosbuc";
		
		System.out.println("Constructor B:" + toString());
	}

	@Override
	public String toString() {
		return super.toString() + ", [street = " + street + "]";
	}
}
