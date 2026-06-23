import java.util.Random;

public class InplaceShuffle {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        // Fisher-Yates Shuffle
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); // 0 ≤ j ≤ i

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Print shuffled array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}