public class SinCos {
  public static void main(String[] args){
    short x = Short.parseShort(args[0]);
    double result = Math.sin(x) * Math.sin(x) + Math.cos(x) * Math.cos(x);
    System.out.println(result);
  }
}
