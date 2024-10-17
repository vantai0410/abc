package doctor_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoctorManager manager = new DoctorManager();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("========= Doctor Management ==========");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. View All Doctors");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1:
                    manager.addDoctor();
                    break;
                case 2:
                    manager.updateDoctor();
                    break;
                case 3:
                    manager.deleteDoctor();
                    break;
                case 4:
                    manager.viewAllDoctors();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 5);
    }
}
