package Archiving.PROGRAMMERS;

public class 혼자_놀기의_달인 {
  static int max = -1;

  public static int solution(int[] cards) {
    int answer = 0;

    for (int i = 1; i <= cards.length; i++) {
      int[] boxes = new int[cards.length + 1];
      selectBox(cards, i, boxes, 1);

      int count = 0;
      for (int j = 1; j < boxes.length; j++) {
        if (boxes[j] == 0) {
          int[] copyBoxes = copyBox(boxes);
          selectBox(cards, j, copyBoxes, 2);
          getResult(copyBoxes);
        }
      }

      if (count == 0) {
        max = Math.max(max, 0);
        continue;
      }
    }

    return max;
  }

  private static void getResult(int[] copyBoxes) {
    int valueOne = 0;
    int valueTwo = 0;
    for (int i = 0; i < copyBoxes.length; i++) {
      if (copyBoxes[i] == 1) {
        valueOne++;
      } else if (copyBoxes[i] == 2) {
        valueTwo++;
      }
    }

    max = Math.max(valueOne * valueTwo, max);
  }

  private static int[] copyBox(int[] boxes) {
    int[] copyBoxes = new int[boxes.length];
    for (int i = 0; i < boxes.length; i++) {
      copyBoxes[i] = boxes[i];
    }
    return copyBoxes;
  }

  private static void selectBox(int[] cards, int cardNum, int[] boxes, int groupNum) {
    if (boxes[cardNum] != 0) {
      return;
    }

    boxes[cardNum] = groupNum;
    selectBox(cards, cards[cardNum - 1], boxes, groupNum);
  }

  public static void main(String[] args) {
    solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4});
  }
}
