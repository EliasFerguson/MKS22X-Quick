import java.util.*;
public class Quick {
  public static void main(String[] args) {
    int[] data = {17, 61, 67, 47, 93, 12,	20,	4, 44,	68};
    int[] data2 =  {0,2,5,10,15,23};
    System.out.println(quickSelect(data2, 0));// would return 0
    System.out.println(quickSelect(data2, 0));//  would return 2
    System.out.println(quickSelect(data2, 0));//  would return 5
    System.out.println(quickSelect(data2, 0));//  would return 10
    System.out.println(quickSelect(data2, 0)); // would return 15
    System.out.println(quickSelect(data2, 0));//  would return 23
    //quickSort(data, 0, 9);
    //for (int i:data) System.out.print(i + " ");
  }
  public static int partition(int[] data, int start, int end) {
    int pivI = start + (int)(Math.random() * (end - start + 1));
    int piv = data[pivI];
    System.out.println(pivI);
    System.out.println(data[pivI]);
    swap(data, start, pivI);
    int i = start + 1;
    int i2 = end;
    while (i != i2) {
      if (piv > data[i]) {
        i += 1;
      }
      else if (data[i] >= piv){
        swap(data, i, i2);
        i2 -= 1;
      }
    }
    if (data[i] < piv) {
      swap(data, start, i);
      return i;
    }
    else {
      swap(data, start, i - 1);
      return i - 1;
    }
  }
  public static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  public static void quickSort(int[] data, int lo, int hi) {
    if (hi <= lo) return;
    int piv = partition(data, lo, hi);
    quickSort(data, lo, piv - 1);
    quickSort(data, piv + 1, hi);
  }
  public static int quickSelect(int[] data, int k) {
    int i = 0;
    int i2 = data.length;
    int pivI = partition(data, 0, data.length) ;
    if (pivI == k) return data[pivI];
    while (pivI != i) {
      pivI = partition(data, i, i2);
      if (pivI == k) return data[pivI];
      if (pivI > k) i2 = pivI - 1;
      if (pivI < k) i =  pivI + 1;
    }
    return data[pivI];
  }
}
