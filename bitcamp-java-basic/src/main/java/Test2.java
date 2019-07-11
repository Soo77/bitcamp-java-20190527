import java.util.Scanner;

public class Test2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
//    String str = "abc,defABC";
//    char[] arr = str.toCharArray();
//    
//    for (char c : arr) {
//      if (c >= 'a' && c <= 'z')
//        System.out.println((char)(c - ('a' - 'A')));
//      else if (c == ',') 
//        System.out.println("#");
//      else
//        System.out.println(c);
//    }
    int num = 5;
    String[] arr = new String[num];
    for(int i=0; i<num; i++) {
      arr[i] = Integer.toString((i+1));
    }
    for(String s : arr) {
      System.out.println(s);
    }
    
    boolean run = true;
    while (run) {
      System.out.println("=================영화관==================");
      System.out.println("1. 예매 하기 2. 예매 취소 3. 예매 내역 조회 4. 종료 ");
      String strKey = sc.nextLine();
      while(checking(strKey, 5)) {
        System.out.println("다시 입력해주세요.");
        strKey = sc.nextLine();
      }
      int mainKey = Integer.parseInt(strKey);

      switch (mainKey) {
        case 1:
          // 1번 예약하기
          System.out.println("1번입니다.");
          break;
        case 2:
          // 2번 예매 취소
          System.out.println("2번입니다.");
          break;
        case 3:
          // 3번 예매 내역 조회
          System.out.println("3번입니다.");
          break;
        case 4:
          System.out.println("종료합니다!");
          run = false;
          break;
        default:
          System.out.println("다시 입력해주세요.");
          break;

      }
    }
    


  }
  private static boolean checking(String str, int num) {
    String[] arr = new String[num];
    for (int i=0; i<num; i++) {
      arr[i] = Integer.toString((i+1));
    }
    int i=0;
    for (; i<num; i++) {
      if (str.equals(arr[i])) {
        return false;
      }
      if (i == (num-1)) {
        return true;
      }
    }
    return false;
  }
}
