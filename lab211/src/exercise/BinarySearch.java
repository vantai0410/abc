package exercise;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Array size(positive): ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100);
        }
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        System.out.println("Enter the number to search: ");
        int n = sc.nextInt();

        int index = binarySearch(arr, n);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

    }

    public static int binarySearch(int[] arr, int n) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == n ) {
                return mid;
            }
            if (arr[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
