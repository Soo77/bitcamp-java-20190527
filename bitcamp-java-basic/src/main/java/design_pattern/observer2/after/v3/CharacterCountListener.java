package design_pattern.observer2.after.v3;

public class CharacterCountListener implements CharacterListener {

  int count = 0;
  
  @Override
  public void readed(int ch) {
    
    if (ch != -1)
      count++;
  }

  @Override
  public void displayResult() {
    System.out.printf("총 문자개수: %d\n", count);
  }

}
