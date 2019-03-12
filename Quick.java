import java.util.*;
public class Quick {
  public static void main(String[] args) {
    int[] data = {17, 61, 67, 47, 93,12,	20,	4, 44,	68};
    System.out.println(partition(data, 1, 5));
    for (int i:data) System.out.println(i);
  }
  public static int partition(int[] data, int start, int end) {
    int pivI = start + (int)(Math.random() * (end - start + 1));
    System.out.println(pivI);
    swap(data, start, pivI);
    while (start != end) {
      if (data[pivI] > data[start]) {
        start++;
      }
      else {
        swap(data, pivI, start);
        end--;
      }
    }
    return pivI;
  }
  public static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
}
