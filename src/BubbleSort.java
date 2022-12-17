public class BubbleSort {

    // PARAMETRE OLARAK GIRILEN UNSORTED INT ARRAY I SORTED HALE GETIRIP DONDUREN METHOD
    public int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    return arr;
    }

    // METHODU DENEMEK ICIN YAZDIK
    public static void main(String args[])
    {
        BubbleSort ob = new BubbleSort();
        int arr[] = { 5, 1, 4, 2, 8,10,454,5434,0,-5 };
        int[] ar = ob.bubbleSort(arr);
        System.out.println("Sorted array: ");
        for(int i:ar){
            System.out.print(i+" ");
        }
    }


}
