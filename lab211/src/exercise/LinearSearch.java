package exercise;

import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println("Generated array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();

        System.out.println("Enter the number to search: ");
        int n= sc.nextInt();

        int index = linearSearch(arr,n);
        if(index != -1){
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
    public static int linearSearch(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
