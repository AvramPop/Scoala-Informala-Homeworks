public class Operatori {
  public static void main(String[] args){
    int a = 10, b = 5, c = 16;
    int d = (a >> 2 - 100) > 0 ? 1 : 0;
    int e = ++a - b * 2 + 4 / c << 3 - 1;
    int f = a >>> 2 - b-- % 4;
    boolean g = true || (100 + 4 / 4 - 100 << 4 > 0);
    System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " +  g + " ");
  }
}
