public class Calc {
  public static void main(String[] args){
    double d1 = Double.parseDouble(args[0]), d2 = Double.parseDouble(args[2]);
    double result = Calc.compute(d1, d2, args[1]);
    System.out.println(result);
  }

  private static double compute(double d1, double d2, String operator) {
    double result = 0;
    switch(operator){
      case "+":
        result = d1 + d2;
        break;
      case "-":
        result = d1 - d2;
        break;
      case "ori":
        result = d1 * d2;
        break;
      case "/":
        result = d1 / d2;
        break;
      default:
        System.out.println("Wrong operator!");
    }
    return result;
  }
}
