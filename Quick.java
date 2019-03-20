import java.util.*;
public class Quick {
  public static void main(String[] args) {
    int[] data = {61, 17, 67, 47, 93, 12,	20,	4, 44, 68};
    int[] data2 =  {0,2,5,10,15,23};

    //System.out.println(quickSelect(data2, 0));// would return 0
    //System.out.println(quickSelect(data2, 1));//  would return 2
  //  System.out.println(quickSelect(data2, 2));//  would return 5
  ///  System.out.println(quickSelect(data2, 3));//  would return 10
  //  System.out.println(quickSelect(data2, 4)); // would return 15
  //  System.out.println(quickSelect(data2, 5));//  would return 23
    quicksort(data);
    System.out.println(Arrays.toString(data));
  }
  //Cuts array into two sides around a pivot depending on value.
  public static int partition(int[] data, int start, int end) {
    int pivI = start + (int)(Math.random() * (end - start + 1));
    //System.out.println(pivI);
    //System.out.println(data[pivI]);
    if (start == end) return start;
    swap(data, start, pivI);
    pivI = start;
    start++;
    while (start != end) {
      int same = -1;
      if (data[start] == data[pivI]) same = (int)(Math.random() * 2);
      if (data[pivI] > data[start] || same == 0) {
        start += 1;
      }
      else if (data[start] > data[pivI] || same == 1){
        swap(data, start, end);
        end -= 1;
      }
    }
    if (data[start] < data[pivI]) {
      swap(data, start, pivI);
      return start;
    }
    else {
      swap(data, start - 1, pivI);
      return start - 1;
    }
  }
  //Swaps two elements.
  public static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  //Wrapper
  public static void quicksort(int[] data) {
    quicksort(data, 0, data.length - 1);
  }
  //Worst case is 35:1.
  public static void quicksort(int[] data, int lo, int hi) {
    if (hi - lo <= 100) {
      insertionSort(data, lo, hi);
      return;
    }
    int piv = partition(data, lo, hi);
    quicksort(data, lo, piv - 1);
    quicksort(data, piv + 1, hi);
  }
  //Finds kth largest element.
  public static int quickselect(int[] data, int k) {
    int i = 0;
    int i2 = data.length - 1;
    int pivI = partition(data, i, i2) ;
    while (pivI != k) {
      if (pivI == k) return data[pivI];
      if (pivI > k) pivI = partition(data, i, pivI);
      if (pivI < k) pivI = partition(data, pivI, i2);;
    }
    return data[pivI];
  }
  public static void insertionSort(int[] ary, int lo, int hi) {
    int switcher;
    for (int i = lo + 1; i < hi + 1; i++) {
      switcher = ary[i];
      int i2 = i;
      while ((i2 > 0) && (switcher < ary[i2 - 1])) {
        ary[i2] = ary[i2 - 1];
        i2--;
      }
      ary[i2] = switcher;
    }
  }
}
