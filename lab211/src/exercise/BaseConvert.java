package exercise;

import java.util.Scanner;

public class BaseConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean choice = true;

        while (choice) {
            System.out.println("Choose input base system:");
            System.out.println("1: Binary (2)");
            System.out.println("2: Decimal (10)");
            System.out.println("3: Hexadecimal (16)");
            int inputBase = sc.nextInt();


            System.out.println("Choose output base system:");
            System.out.println("1: Binary (2)");
            System.out.println("2: Decimal (10)");
            System.out.println("3: Hexadecimal (16)");
            int outputBase = sc.nextInt();


            System.out.println("Enter input value:");
            String inputValue = sc.next();


            int decimalValue = 0;
            switch (inputBase) {
                case 1:
                    decimalValue = Integer.parseInt(inputValue, 2);
                    break;
                case 2:
                    decimalValue = Integer.parseInt(inputValue);
                    break;
                case 3:
                    decimalValue = Integer.parseInt(inputValue, 16);
                    break;
                default:
                    System.out.println("Invalid input base choice.");
                    continue;
            }


            switch (outputBase) {
                case 1:
                    System.out.println("Output value: " + Integer.toBinaryString(decimalValue));
                    break;
                case 2:
                    System.out.println("Output value: " + decimalValue);
                    break;
                case 3:
                    System.out.println("Output value: " + Integer.toHexString(decimalValue).toUpperCase());
                    break;
                default:
                    System.out.println("Invalid output base choice.");
            }


            System.out.println("Do you want to convert another number? (yes/no): ");
            String continueChoice = sc.next().toLowerCase();
            if (!continueChoice.equals("yes")) {
                choice= false;
            }
        }


    }
}
