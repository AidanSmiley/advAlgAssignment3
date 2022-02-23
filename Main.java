import java.util.*;

public class Main {
    public static void main(String args[]) {

        int[] array100 = new int[100];
        int[] array1000 = new int[1000];
        int[] array10000 = new int[10000];

        randomArr(array100);
        randomArr(array1000);
        randomArr(array10000);

        System.out.println("Running RandomQuicksort on array with 100 elements. . .");
        Long startTime = System.nanoTime();
        RandomQuickSort(array100, 0, array100.length-1);
        Long endTime = System.nanoTime();
        System.out.println("Time is: " + (endTime - startTime) + "ns");

        System.out.println("Running RandomQuicksort on array with 1000 elements. . .");
        startTime = System.nanoTime();
        RandomQuickSort(array1000, 0, array1000.length-1);
        endTime = System.nanoTime();
        System.out.println("Time is: " + (endTime - startTime) + "ns");

        System.out.println("Running RandomQuicksort on array with 10000 elements. . .");
        startTime = System.nanoTime();
        RandomQuickSort(array10000, 0, array10000.length-1);
        endTime = System.nanoTime();
        System.out.println("Time is: " + (endTime - startTime) + "ns");

        System.out.println("best case scenario, already sorted array of 100 elements");
        startTime = System.nanoTime();
        RandomQuickSort(array100, 0, array100.length-1);
        endTime = System.nanoTime();
        System.out.println("Time is: " + (endTime - startTime) + "ns");


        reverseArr(array100);
        System.out.println("worst case scenario, reverse sorted array of 100 elements");
        startTime = System.nanoTime();
        RandomQuickSort(array100, 0, array100.length-1);
        endTime = System.nanoTime();
        System.out.println("Time is: " + (endTime - startTime) + "ns");
        

        
    }

    public static void printArr(int[] a) {
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void randomArr(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
    }

    public static void reverseArr(int[] arr) {
        int j;
        for (int i = 0; i < arr.length/2; i++) {
            j = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = j;
        }
    }

    public static void RandomQuickSort(int[] A, int p, int r) {
        int q;
        if (p < r) {
            q = RandomPartition(A, p, r);   // using the java Random class
            RandomQuickSort(A, p, q-1);
            RandomQuickSort(A, q+1, r);
        }
    }

    public static int RandomPartition(int[] A, int p, int r) {
        int i = randomNum(p, r);

        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;

        return partition(A, p, r);
    }

    public static int partition(int[] A, int p, int r) {
        int pivot = A[r];   // this is the pivot
        int i = p-1;      
        for (int j = p; j < r; j++) {
            if (A[j] <= pivot) {

                i++;
                //swap A[i] and A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        //put pivot between the two partitions
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;

        return i+1;
    }

    public static int randomNum(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max-min)+min;
    }
}
