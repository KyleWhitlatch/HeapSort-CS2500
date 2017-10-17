//Kyle Whitlatch
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HeapSort
{
    private static int N;
    public static void sort(int arr[])
    {
        heapify(arr);
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);
    }
    public static void maxheap(int arr[], int i)
    {
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;

        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) throws IOException
    {
        for(int x = 0; x < 3; x++)
        {
            long time = System.currentTimeMillis();
            Scanner scan = new Scanner(new File("./src/data"+0+".txt"));
            System.out.println("Heap Sort Test\n");
            int n, i;
            n = 500;
            int arr[] = new int[n];
            for (i = 0; i < n; i++)
                arr[i] = scan.nextInt();
            sort(arr);
            System.out.println("\nElements after sorting ");
            for (i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
                if(i%50 == 0)
                    System.out.print("\n");
            }
            System.out.println();
            System.out.println("Time taken:" + (System.currentTimeMillis() - time));
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            scan.close();
            time = 0;
        }
    }
}