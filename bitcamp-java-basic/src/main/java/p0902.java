
interface Compare {
  public int compareTo(int a, int b);
}


public class p0902 {

  public static void exec(Compare com) {
    int k = 10;
    int m = 20;
    int value = com.compareTo(k, m);
    System.out.println(value);
  }
  
  public static void main(String[] args) {

    exec((i,j) -> {
      return i+j;
    });
    
    
  }
}
