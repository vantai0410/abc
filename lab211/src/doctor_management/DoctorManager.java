package doctor_management;

import java.util.Scanner;

public class DoctorManager {
    private DoctorList doctorList = new DoctorList();
    private Scanner sc = new Scanner(System.in);

    public void addDoctor() {
        System.out.println("Enter code: ");
        String code = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter specialization: ");
        String specialization = sc.nextLine();
        System.out.println("Enter availability: ");
        int availability = sc.nextInt();
        sc.nextLine();

        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        doctorList.addDoctor(newDoctor);
    }

    public void updateDoctor() {
        System.out.println("Enter code: ");
        String code = sc.nextLine();
        System.out.println("Enter name (press enter to skip): ");
        String name = sc.nextLine();
        System.out.println("Enter specialization (press enter to skip): ");
        String specialization = sc.nextLine();
        System.out.println("Enter availability (press enter to skip): ");
        String availability = sc.nextLine();

        doctorList.updateDoctor(code, name, specialization, availability);
    }

    public void deleteDoctor() {
        System.out.println("Enter code: ");
        String code = sc.nextLine();
        doctorList.deleteDoctor(code);
    }

    public void viewAllDoctors() {
        doctorList.viewAllDoctors();
    }
}
