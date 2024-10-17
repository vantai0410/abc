package exercise;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Array size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        Random rand = new Random();
        System.out.print("Unsorted Array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int choose = chooseMid(arr, left, right);
            quickSort(arr, left, choose - 1);
            quickSort(arr, choose, right);
        }
    }

    public static int chooseMid(int[] arr, int left, int right) {
        int mid = arr[left + (right - left) / 2]; // chọn trục
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < mid) {
                i++;
            }
            while (arr[j] > mid) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
}

