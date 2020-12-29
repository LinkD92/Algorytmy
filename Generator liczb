import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int amount = 10000000;
        int arr[] = new int[amount];
        double max = 500000000;
        double min = 0;

        for(int i = 0; i<amount; i++)
        {
            double random_double = Math.random() * (max - min + 1) + min;
            int myRand = (int)random_double;
            arr[i]=myRand;
        }



        try{
            FileWriter writer = new FileWriter("E:\\Coding\\Java\\Projects\\AlgorytmyV\\Testy\\rng.txt");
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
