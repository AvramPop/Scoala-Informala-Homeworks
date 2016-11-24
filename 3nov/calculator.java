 class Calculator {
	public static void main(String args[]) {
	  Operator o = new Multiply();
    System.out.println(o.calculate(2, 8));
    o = new Divide();
    System.out.println(o.calculate(2, 8));
	}

}

abstract class Operator{
  public abstract double calculate(double n1, double n2);
}

class Addition extends Operator{
  public double calculate(double n1, double n2){
    return n1 + n2;
  }
}

class Reduce extends Operator{
  public double calculate(double n1, double n2){
    return n1 - n2;
  }
}

class Multiply extends Operator{
  public double calculate(double n1, double n2){
    return n1 * n2;
  }
}

class Divide extends Operator{
  public double calculate(double n1, double n2){
    return n1 / n2;
  }
}
