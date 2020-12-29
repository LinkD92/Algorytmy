import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MergeSort
{

    void merge(int arr[], int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
        {
            L[i] = arr[l + i];

        }
        for (int j = 0; j < n2; ++j)
        {

            R[j] = arr[m + 1 + j];

        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;

            }
            k++;
        }

        while (i < n1) {

            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {

            arr[k] = R[j];
            j++;
            k++;
        }

    }

    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);


        }
    }

    static void printArray(int arr[])
    {
        try{
            FileWriter writer = new FileWriter("E:\\Coding\\Java\\Projects\\AlgorytmyV\\Testy\\MS.txt");
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                writer.write(arr[i] + "\n");
            }
            writer.close();

        }catch (IOException e)
        {
            e.getMessage();
        }

    }

    public static void main(String args[])
    {


        int size = 10000000;
        int[] arr = new int[size];
        try{
            Scanner scanner = new Scanner( new File("E:\\Coding\\Java\\Projects\\AlgorytmyV\\Testy\\rng.txt"));


            int i =0;
            while(scanner.hasNextInt())
            {
                arr[i++]= scanner.nextInt();
            }
        }catch(FileNotFoundException e)
        {
            e.getMessage();
            System.out.println("No file detected");
        }

        long begin = System.nanoTime();
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        long end = System.nanoTime();

        printArray(arr);

        long execTime = end - begin;
        System.out.println("Nano s: " + execTime );
        System.out.println("Mili s: " + (double)execTime/1000000);
    }
}