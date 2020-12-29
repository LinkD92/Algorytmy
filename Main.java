import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        int size = 10000000;
        int[] arr = new int[size];
        int n = arr.length;
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
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
        long end = System.nanoTime();

        ob.printArray(arr);

        long execTime = end - begin;
        System.out.println("Nano s: " + execTime );
        System.out.println("Mili s: " + (double)execTime/1000000);
    }
}

class QuickSort {
    int counter = 0;
    int counter2= 0;
    int counter3= 0;
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1 );
        for (int j = low; j < high; j++) {
            counter++;
            if (arr[j] < pivot) {
                counter2++;
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    void sort(int arr[], int low, int high) {

        if (low < high) {
            counter3++;
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    void printArray(int arr[]) {
        try{
            FileWriter writer = new FileWriter("E:\\Coding\\Java\\Projects\\AlgorytmyV\\Testy\\QS.txt");
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
}